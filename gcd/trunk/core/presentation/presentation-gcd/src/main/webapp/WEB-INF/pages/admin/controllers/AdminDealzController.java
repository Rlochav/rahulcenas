package com.app.admin.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.merchant.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.IntUtil;

@Controller
public class AdminDealzController extends AppWebHandler {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DocumentDTO documentDTO;
	private DealzDTO dealzDTO;

	@RequestMapping(value = "/component/alldailydeals")
	public ModelAndView displayAllDailyDeals(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/mMgmtAllDailyDeals");
		try {
			String start = getRequestParam("start");
			String page = null;
			if (start == null) {
				start = "0";
			}
			page = ((IntUtil.getInteger(start) / 20) + 1) + "";
			mav.addObject("page", page);
			mav.addObject("start", start);

			String dealType = getRequestParam("dealType");
			DealzDTO dealzDTO = getCityDealz.getAllDealzs(userInfo, dealType, start);
			if (dealzDTO != null) {
				mav.addObject("dealzDTO", dealzDTO.getDealzDTOs());
				mav.addObject("count", dealzDTO.getCounts());
			}
			mav.addObject("dealType", getRequestParam("dealType"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/hotdealz")
	public ModelAndView displayAllHotDealz(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/mMgmtHotDealz");
		try {
			String start = getRequestParam("start");
			String page = null;
			if (start == null) {
				start = "0";
			}
			page = ((IntUtil.getInteger(start) / 20) + 1) + "";
			mav.addObject("page", page);
			mav.addObject("start", start);

			String dealType = getRequestParam("dealType");
			DealzDTO dealzDTO = getCityDealz.getAllDealzs(userInfo, dealType, start);
			if (dealzDTO != null) {
				mav.addObject("dealzDTO", dealzDTO.getDealzDTOs());
				mav.addObject("count", dealzDTO.getCounts());
			}
			mav.addObject("dealType", getRequestParam("dealType"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/editdailydeals")
	public ModelAndView editModeDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/editDealzContent");
		com.app.mvc.merchant.DealzDTO formDTO = new com.app.mvc.merchant.DealzDTO();
		try {
			Map<String, String> categoryMap = getCityDealz.getCategoryMapByMerchant(userInfo, getRequestParam("merchantId"));
			Map<String, String> subCategoryMap = getCityDealz.getSubCategoryMapByMerchant(userInfo, getRequestParam("merchantId"));
			Map<String, String> cityMap = getCityDealz.getCityMapByMerchant(userInfo, getRequestParam("merchantId"));
			mav.addObject("categoryMap", categoryMap);
			mav.addObject("subCategoryMap", subCategoryMap);
			mav.addObject("cityMap", cityMap);
			if (getRequestParam("dealzId") != null && !getRequestParam("dealzId").trim().isEmpty()) {
				DealzDTO dealzDTO = merchantService.getDealzDetailById(userInfo, getRequestParam("dealzId"));
				mav.addObject("dealzDTO", dealzDTO);
				mav.addObject("dealType", getRequestParam("dealType"));
				mav.addObject("merchantDealzForm", formDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/deleteMerchantDealz")
	@ResponseBody
	public DealzDTO deleteDealById() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		DealzDTO dealzDTO = new DealzDTO();
		try {
			if (getRequestParam("dealzId") != null && !getRequestParam("dealzId").trim().isEmpty())
				dealzDTO.setDealId(getRequestParam("dealzId"));
			if (getRequestParam("merchantId") != null && !getRequestParam("merchantId").trim().isEmpty())
				dealzDTO.setMerchantId(getRequestParam("merchantId"));

			dealzDTO = getCityDealz.deleteDealById(userInfo, dealzDTO);
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
		}
		return dealzDTO;
	}

	@RequestMapping(value = "/component/saveEditMerchantDealz")
	public String saveMerchantDealz(@ModelAttribute("uploadForm") com.app.mvc.merchant.DealzDTO uploadForm, ModelMap map) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		DealzDTO dealDTO = null;
		try {
			if (dealDTO == null)
				dealDTO = new DealzDTO();
			if (uploadForm.getTitle() != null && !uploadForm.getTitle().trim().isEmpty())
				dealDTO.setTitle(uploadForm.getTitle());

			dealDTO.setCity(userInfo.getCityId());
			if (uploadForm.getCategory() != null && !uploadForm.getCategory().trim().isEmpty())
				dealDTO.setCategory(uploadForm.getCategory());
			if (uploadForm.getSubCategory() != null && !uploadForm.getSubCategory().trim().isEmpty())
				dealDTO.setSubCategory(uploadForm.getSubCategory());
			if (uploadForm.getMerchantId() != null && !uploadForm.getMerchantId().trim().isEmpty())
				dealDTO.setMerchantId(uploadForm.getMerchantId());
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

			dealzDTO = getCityDealz.saveMerchantDealz(userInfo, dealDTO);
			if (documentDTO == null)
				documentDTO = new DocumentDTO();
			documentDTO.setDealzId(dealzDTO.getDealId());
			documentDTO.setMerchantId(dealzDTO.getMerchantId());
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
		}
		if (uploadForm.getDealType().equals("2"))
			return "redirect:/component/hotdealz?dealType=2";
		if (uploadForm.getDealType().equals("1"))
			return "redirect:/component/alldailydeals?dealType=1";
		return null;
	}

	public void uploadFile(UserInfo userInfo, com.app.mvc.merchant.DealzDTO uploadForm, DocumentDTO documentDTO) {
		List<MultipartFile> files = uploadForm.getFiles();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				try {
					if (multipartFile.getSize() > 0) {
						String fileName = multipartFile.getOriginalFilename();
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
				} catch (Exception e) {
					if (e instanceof BaseException) {
						e.printStackTrace();
					} else if (e instanceof BusinessException) {
						e.printStackTrace();
					} else {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
