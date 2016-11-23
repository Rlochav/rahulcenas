package com.app.mvc.merchant;

import static org.springframework.util.StringUtils.isEmpty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.CityDTO;
import com.app.getcitydealz.dto.DealzRateDTO;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.mvc.util.GlobalTimeHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.FileUtils;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

@Controller
public class MerchantDealController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210341328455146637L;

	@Autowired
	private GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;
	private DealzDTO dealzDTO;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DocumentDTO documentDTO;
	private DealzRateDTO rateDTO;

	@RequestMapping(value = "/postDealz")
	public ModelAndView displayPosDealz(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			return new ModelAndView("../../WelcomePage");
		}
		ModelAndView mav = null;

		com.app.mvc.merchant.DealzDTO dealzDTO = new com.app.mvc.merchant.DealzDTO();
		try {

			Map<Integer, String> canPostMap = merchantService.checkUserCanPost(userInfo);
			if (getRequestParam("dealId") == null && getRequestParam("dealType").equals("1") && canPostMap != null && canPostMap.containsKey(1)) {
				mav = new ModelAndView("redirect:/allHotDealz?dealType=" + getRequestParam("dealType"));
				mav.addObject("error", canPostMap.get(1));
				return mav;
			} else {
				mav = new ModelAndView("merchant/postDealz");
			}

			modelMap.put("dealId", getRequestParam("dealId"));
			modelMap.put("dealType", getRequestParam("dealType"));
			mav.addObject("message", getRequestParam("message"));

			Map<String, String> timeZoneMap = getCityDealz.getTimeZones();
			modelMap.put("timeZoneMap", timeZoneMap);
			CityDTO cityDtos = getCityDealz.getCityDetails(userInfo.getCity());

			dealzDTO.setTimeZoneId(cityDtos.getTimeZoneId());

			if (getRequestParam("dealType").equals("1")) {
				modelMap.put("innerTitle", "Create Your Deal");
			} else {
				modelMap.put("innerTitle", "Buy a Hot Deal");
			}

			Map<String, String> cityMap = getCityDealz.getCityMap(userInfo);
			Map<String, String> categoryMap = merchantService.getCategory(userInfo);
			mav.addObject("categoryMap", categoryMap);
			mav.addObject("cityMap", cityMap);

			DealzDTO dto = merchantService.getDealzDetailById(userInfo, getRequestParam("dealId"), getRequestParam("dealType"));
			if (dto != null) {
				Map<String, String> subCategoryMap = merchantService.getSubCategoryMap("", dto.getCategory());
				mav.addObject("subCategoryMap", subCategoryMap);
			}

			if (getRequestParam("dealId") != null && !getRequestParam("dealId").trim().isEmpty())
				modelMap.put("dealzDTO", dto);
			mav.addObject("uploadForm", dealzDTO);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mav;
	}

	@RequestMapping(value = "/postDealFrame", method = RequestMethod.GET)
	public String postDealFrame(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		modelMap.put("dealId", getRequestParam("dealId"));
		modelMap.put("dealType", getRequestParam("dealType"));
		try {
			if (getRequestParam("dealId") != null && !getRequestParam("dealId").trim().isEmpty())
				modelMap.put("dealzDTO", merchantService.getDealzDetailById(userInfo, getRequestParam("dealId"), getRequestParam("dealType")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/postDealContent";
	}

	@RequestMapping(value = "/jsonValidateDealCode")
	@ResponseBody
	public String isDealCodeUniqe() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		String msg = "";
		try {

			msg = getCityDealz.isDealCodeUniqe(userInfo, getRequestParam("dealId"), getRequestParam("dealCode"));
		} catch (Exception e) {
			if (e instanceof BaseException) {
				e.printStackTrace();
				msg = ((BaseException) e).getMsgCode();
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				msg = ((BusinessException) e).getMessage();
			} else {
				e.printStackTrace();
				msg = "Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator";
			}
		}
		return msg;
	}

	@RequestMapping(value = "/saveMerchantDealz")
	public String saveMerchantDealz(@ModelAttribute("uploadForm") com.app.mvc.merchant.DealzDTO uploadForm, ModelMap map) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			DealzDTO dealDTO = new DealzDTO();
			if (uploadForm.getTitle() != null && !uploadForm.getTitle().trim().isEmpty())
				dealDTO.setTitle(uploadForm.getTitle());
			if (uploadForm.getCity() != null && !uploadForm.getCity().trim().isEmpty())
				dealDTO.setCity(uploadForm.getCity());

			if (uploadForm.getLatitude() != null && !uploadForm.getLatitude().trim().isEmpty())
				dealDTO.setLatitude(uploadForm.getLatitude());

			if (uploadForm.getLongitude() != null && !uploadForm.getLongitude().trim().isEmpty())
				dealDTO.setLongitude(uploadForm.getLongitude());

			if (uploadForm.getCategory() != null && !uploadForm.getCategory().trim().isEmpty())
				dealDTO.setCategory(uploadForm.getCategory());

			if (uploadForm.getSubCategory() != null && !uploadForm.getSubCategory().trim().isEmpty())
				dealDTO.setSubCategory(uploadForm.getSubCategory());

			dealDTO.setMerchantId(userInfo.getUserIndex() + "");
			if (uploadForm.isUseLogo() || uploadForm.getFiles().get(0).getSize() == 0)
				dealDTO.setUseLogo("1");
			if (!uploadForm.isUseLogo())
				dealDTO.setUseLogo("0");

			if (uploadForm.getRestriction() != null && !uploadForm.getRestriction().trim().isEmpty())
				dealDTO.setRestriction(uploadForm.getRestriction());
			if (uploadForm.getStartDate() != null && !uploadForm.getStartDate().trim().isEmpty())
				dealDTO.setStartDate(uploadForm.getStartDate());
			if (uploadForm.getEndDate() != null && !uploadForm.getEndDate().trim().isEmpty())
				dealDTO.setEndDate(uploadForm.getEndDate());
			if (uploadForm.getAmountSaved() != null && !uploadForm.getAmountSaved().trim().isEmpty())
				dealDTO.setAmountSaved(uploadForm.getAmountSaved());

			if (uploadForm.getDealCode() != null && !uploadForm.getDealCode().trim().isEmpty())
				dealDTO.setDealCode(uploadForm.getDealCode());
			if (uploadForm.getWebsite() != null && !uploadForm.getWebsite().trim().isEmpty())
				dealDTO.setWebsite(uploadForm.getWebsite());

			if (uploadForm.getDescription() != null && !uploadForm.getDescription().trim().isEmpty())
				dealDTO.setDescription(uploadForm.getDescription());

			if (uploadForm.getDealType() != null && !uploadForm.getDealType().trim().isEmpty())
				dealDTO.setDealType(uploadForm.getDealType());

			if (uploadForm.getDealId() != null && !uploadForm.getDealId().trim().isEmpty())
				dealDTO.setDealId(uploadForm.getDealId());

			if (!isEmpty(uploadForm.getLocalTimeZoneName()))
				dealDTO.setLocalTimeZoneName(uploadForm.getLocalTimeZoneName());

			if (!isEmpty(uploadForm.getTimeZoneId()))
				dealDTO.setTimeZoneId(uploadForm.getTimeZoneId());

			dealDTO.setLocalTimeZoneUtc(GlobalTimeHandler.getTimeZoneUtcTime(uploadForm.getLocalTimeZoneName()));

			dealzDTO = getCityDealz.saveMerchantDealz(userInfo, dealDTO);
			if (documentDTO == null)
				documentDTO = new DocumentDTO();
			documentDTO.setDealzId(dealzDTO.getDealId());
			documentDTO.setMerchantId(dealzDTO.getMerchantId());
			documentDTO.setLogoId(dealDTO.getImagePath());
			uploadFile(userInfo, uploadForm, documentDTO);
		} catch (Exception e) {
			dealzDTO = new DealzDTO();
			if (e instanceof BaseException) {
				e.printStackTrace();
				dealzDTO.setJsonMessage(((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				dealzDTO.setJsonMessage(((BusinessException) e).getMessage());
			} else {
				e.printStackTrace();
				dealzDTO.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
			return "redirect:/postDealz?dealType=" + uploadForm.getDealType() + "&message=" + dealzDTO.getJsonMessage();
		}
		return "redirect:/isDealOk?dealType=" + uploadForm.getDealType() + "&dealzId=" + dealzDTO.getDealId();
	}

	public void uploadFile(UserInfo userInfo, com.app.mvc.merchant.DealzDTO uploadForm, DocumentDTO documentDTO) {
		List<MultipartFile> files = uploadForm.getFiles();
		List<String> fileNames = null;
		if (null != files && files.size() > 0) {
			fileNames = new ArrayList<String>();
			for (MultipartFile multipartFile : files) {
				try {
					if (multipartFile.getSize() > 0) {
						String fileName = multipartFile.getOriginalFilename();
						fileName = "dailydeals" + FileUtils.getFileExtension(fileName);
						fileNames.add(fileName);
						inputStream = multipartFile.getInputStream();

						documentDTO.setOrignalFileName(fileName);
						documentDTO.setContentType(multipartFile.getContentType());
						documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location", "01"));
						documentDTO.setDocType("0");
						documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + fileName);
						documentDTO.setOrignalFileName(fileName);
						documentDTO = getCityDealz.saveDocumentDetails(userInfo, documentDTO);

						File dir = new File(AppPropertyBuilder.getProperty("DMS.location", "01"));
						if (!dir.exists())
							dir.mkdir();
						File newFile = new File(dir, documentDTO.getFileSavedAs());
						if (!newFile.exists()) {
							newFile.createNewFile();
						}
						outputStream = new FileOutputStream(newFile);
						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
					}

					if (dealzDTO != null) {
						Map<String, Object> holderMap = new HashMap<String, Object>();
						String emails = dealzDTO.getEmails();

						holderMap.put("ImageUrl", documentDTO.getFileSavedAs());
						holderMap.put("MerchantName", dealzDTO.getMerchantName());
						holderMap.put("MerchantUrl",
								((dealzDTO.getMerchantName()).replaceAll("[^a-zA-Z0-9]", "-")).replaceAll(" ", "-") + "-" + dealzDTO.getMerchantId());
						holderMap.put("Title", dealzDTO.getTitle());
						holderMap.put("TitleUrl", ((dealzDTO.getTitle()).replaceAll("[^a-zA-Z0-9 ]", "-")).replaceAll(" ", "-") + "-" + dealzDTO.getDealId());
						holderMap.put("DealStart", dealzDTO.getStartDate());
						holderMap.put("DealEnd", dealzDTO.getEndDate());
						holderMap.put("HowMuchSaved", dealzDTO.getAmountSaved());
						holderMap.put("DealCode", dealzDTO.getDealCode());
						holderMap.put("Description", dealzDTO.getDescription());
					}
				} catch (Exception e) {
					if (outputStream != null)
						try {
							outputStream.flush();
							outputStream.close();
							inputStream.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					e.printStackTrace();
				}
			}
		}
	}

	@RequestMapping(value = "/rateDealz")
	@ResponseBody
	public DealzRateDTO setRatingOnDeal() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			String rateByIp = getClientIpAddr(getRequest());
			DealzRateDTO dealzRateDTO = new DealzRateDTO();
			if (getRequestParam("dealzId") != null && !getRequestParam("dealzId").trim().isEmpty())
				dealzRateDTO.setDealId(getRequestParam("dealzId"));

			if (getRequestParam("rate") != null && !getRequestParam("rate").trim().isEmpty() && getRequestParam("rate").equals("1")) {
				dealzRateDTO.setStart1(getRequestParam("rate"));
				dealzRateDTO.setRatedBy1(rateByIp);
			}

			if (getRequestParam("rate") != null && !getRequestParam("rate").trim().isEmpty() && getRequestParam("rate").equals("2")) {
				dealzRateDTO.setStart2(getRequestParam("rate"));
				dealzRateDTO.setRatedBy2(rateByIp);
			}

			if (getRequestParam("rate") != null && !getRequestParam("rate").trim().isEmpty() && getRequestParam("rate").equals("3")) {
				dealzRateDTO.setStart3(getRequestParam("rate"));
				dealzRateDTO.setRatedBy3(rateByIp);
			}

			if (getRequestParam("rate") != null && !getRequestParam("rate").trim().isEmpty() && getRequestParam("rate").equals("4")) {
				dealzRateDTO.setStart4(getRequestParam("rate"));
				dealzRateDTO.setRatedBy4(rateByIp);
			}

			if (getRequestParam("rate") != null && !getRequestParam("rate").trim().isEmpty() && getRequestParam("rate").equals("5")) {
				dealzRateDTO.setStart5(getRequestParam("rate"));
				dealzRateDTO.setRatedBy5(rateByIp);
			}

			rateDTO = getCityDealz.rateDealz(userInfo, dealzRateDTO);
		} catch (Exception e) {
			rateDTO = new DealzRateDTO();
			if (e instanceof BaseException) {
				e.printStackTrace();
				rateDTO.setJsonMessage(((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				rateDTO.setJsonMessage(((BusinessException) e).getMessage());
			} else {
				e.printStackTrace();
				rateDTO.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return rateDTO;
	}

	@RequestMapping(value = "/isDealOk")
	public ModelAndView isDealOk(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("merchant/dealReadOnly");
		try {
			DealzDTO dealzDTO = merchantService.getDealzDetailById(userInfo, getRequestParam("dealzId"), getRequestParam("dealType"));
			modelMap.put("dealzDTO", dealzDTO);
			modelMap.put("dealzId", getRequestParam("dealzId"));
			modelMap.put("dealType", getRequestParam("dealType"));
			modelMap.put("innerTitle", "Confirm Your Deal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/jsonConfirmDeal")
	@ResponseBody
	public ModelMap doActiveDeal(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			DealzDTO dealzDTO = merchantService.getDealzDetailById(userInfo, getRequestParam("dealzId"), getRequestParam("dealType"));
			boolean b = merchantService.updateDealz(userInfo, getRequestParam("dealzId"), dealzDTO.getCity());
			modelMap.put("status", b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelMap;
	}

	/**
	 * @return the rateDTO
	 */
	public DealzRateDTO getRateDTO() {
		return rateDTO;
	}

	/**
	 * @param rateDTO
	 *            the rateDTO to set
	 */
	public void setRateDTO(DealzRateDTO rateDTO) {
		this.rateDTO = rateDTO;
	}

	/**
	 * @return the dealzDTO
	 */
	public DealzDTO getDealzDTO() {
		return dealzDTO;
	}

	/**
	 * @param dealzDTO
	 *            the dealzDTO to set
	 */
	public void setDealzDTO(DealzDTO dealzDTO) {
		this.dealzDTO = dealzDTO;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream
	 *            the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return the outputStream
	 */
	public OutputStream getOutputStream() {
		return outputStream;
	}

	/**
	 * @param outputStream
	 *            the outputStream to set
	 */
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	private static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip + (request.getRemoteHost() == null ? "" : "/" + request.getRemoteHost());
	}

	public void postOnFb(UserInfo userInfo, String imageUrl, String name, String title, String desc) {
		try {
			ConfigurationBuilder confBuilder = new ConfigurationBuilder();
			confBuilder.setDebugEnabled(true);
			String accessToken = merchantService.getMyAccessToken(userInfo);

			confBuilder.setOAuthAppId(AppPropertyBuilder.getProperty("fb.appId", "01"));
			confBuilder.setOAuthAppSecret(AppPropertyBuilder.getProperty("fb.appSecret", "01"));

			confBuilder.setUseSSL(true);
			confBuilder.setJSONStoreEnabled(true);
			Configuration configuration = confBuilder.build();
			FacebookFactory facebookFactory = new FacebookFactory(configuration);
			Facebook facebookClient = facebookFactory.getInstance();
			facebookClient.setOAuthAccessToken(new AccessToken(accessToken));
			PostUpdate post = new PostUpdate(new URL("http://facebook4j.org"))
					.picture(new URL(AppPropertyBuilder.getProperty("app.image.url", "01") + imageUrl)).name(name).caption("http://facebook4j.org")
					.description(desc);
			facebookClient.postFeed(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
