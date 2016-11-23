package com.app.admin.controllers;

import static org.springframework.util.StringUtils.isEmpty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.dto.IconsDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;

@Controller
public class AccessibiltyIconsController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public GetCityDealz getCityDealz;

	private InputStream inputStream;
	private OutputStream outputStream;

	@RequestMapping(value = "/component/icons")
	public ModelAndView display() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/accessibiltyIcons");
		try {
			IconsDTO iconsDTO = getCityDealz.getAllIconsDetails(userInfo);
			if (iconsDTO != null)
				mav.addObject("icons", iconsDTO.getIconsDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/editicons")
	public ModelAndView editModedisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/editaccessibiltyIcons");
		IconFeilds iconFeilds = new IconFeilds();
		String btnName = "Add New";
		try {
			if (getRequestParam("iconId") != null && !getRequestParam("iconId").trim().isEmpty()) {
				IconsDTO iconsDTO = getCityDealz.getIconsDetailsById(userInfo, getRequestParam("iconId"));
				btnName = "Update";
				if (iconsDTO != null)
					mav.addObject("icons", iconsDTO);
			}
			mav.addObject("btnName", btnName);
			mav.addObject("iconFeilds", iconFeilds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/saveIconDetails")
	public String saveIconDetails(@ModelAttribute("iconFeilds") IconFeilds iconFeilds, BindingResult bindingResult, ModelMap modelMap,
			RedirectAttributes redirectAttributes) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		IconsDTO iconsDTO = new IconsDTO();
		try {
			if (!isEmpty(iconFeilds.getIconId()))
				iconsDTO.setIconId(iconFeilds.getIconId());
			if (!isEmpty(iconFeilds.getIconName()))
				iconsDTO.setIconName(iconFeilds.getIconName());

			iconsDTO = getCityDealz.saveIconsDetails(userInfo, iconsDTO);

			if(iconFeilds.getIconImage()!=null&&!iconFeilds.getIconImage().isEmpty()){
				DocumentDTO documentDTO = new DocumentDTO();
				documentDTO.setMerchantId(iconsDTO.getIconId() + "");
				documentDTO.setDocType("11");
				documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + iconFeilds.getIconImage().getOriginalFilename());
				documentDTO.setOrignalFileName(iconFeilds.getIconImage().getOriginalFilename());
				documentDTO.setContentType(iconFeilds.getIconImage().getContentType());
				documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location.accessibilityIcon", "01"));
				DocumentDTO dto = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
				uploadFiles(userInfo, iconFeilds.getIconImage(), dto.getFileSavedAs());
			}
			redirectAttributes.addFlashAttribute("message", "Icon Saved Successfully.");
		} catch (Exception e) {
			iconsDTO = new IconsDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				iconsDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				iconsDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				iconsDTO.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return "redirect:/component/editicons?iconId=" + iconsDTO.getIconId();
	}

	public boolean uploadFiles(UserInfo userInfo, MultipartFile multipartFile, String saveAsFileName) throws IOException {
		File fileObj = null;
		File dirObj = null;

		boolean booSuccessFg;
		try {
			dirObj = new File(AppPropertyBuilder.getProperty("DMS.location.accessibilityIcon", "01"));
			if (!(dirObj.exists())) {
				dirObj.mkdirs();
			}

			if (dirObj.exists() && dirObj.isDirectory()) {
				fileObj = new File(dirObj.getAbsolutePath() + File.separator + saveAsFileName);
			}
			if (!fileObj.exists()) {
				fileObj.createNewFile();
			}
			inputStream = multipartFile.getInputStream();
			outputStream = new FileOutputStream(fileObj);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			booSuccessFg = true;
		} catch (Exception e) {
			booSuccessFg = false;
			try {
				fileObj.delete();
			} catch (Exception e1) {
				try {
					fileObj.deleteOnExit();
				} catch (Exception ex) {
				}
			}
			fileObj = null;
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		}
		return booSuccessFg;
	}
}
