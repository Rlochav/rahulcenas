package com.app.doc.controller;

import static com.app.utility.common.AppPropertyBuilder.getProperty;
import static org.springframework.util.StringUtils.isEmpty;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.app.commonexception.BaseException;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.FileUtils;
import com.app.utility.common.IntUtil;

@Controller
public class DocumentController extends AppWebHandler {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3552184139471537998L;
	private InputStream inputStream;
	private OutputStream outputStream;
	private String dealzIds;

	@Autowired
	private GetCityDealz getCityDealz;
	private DocumentDTO documentDTO;

	@RequestMapping(value = "/displayDocumentManager")
	public String display(ModelMap modelMap) {
		modelMap.put("dealzId", getRequestParam("dealId"));
		modelMap.put("docType", "0");
		return "documentManagement";
	}

	@RequestMapping(value = "/upload")
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model map) throws BaseException {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		List<MultipartFile> files = uploadForm.getFiles();
		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {
				try {
					if (multipartFile.getSize() > 0) {
						String fileName = multipartFile.getOriginalFilename();
						fileNames.add(fileName);
						if (documentDTO == null)
							documentDTO = new DocumentDTO();
						documentDTO.setLogoId(userInfo.getLogoId());
						documentDTO.setOrignalFileName(fileName);
						documentDTO.setMerchantId(userInfo.getUserIndex() + "");
						documentDTO.setContentType(multipartFile.getContentType());
						documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location", "01"));
						documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + fileName);
						documentDTO.setDocType(uploadForm.getDocType());
						documentDTO.setOrignalFileName(fileName);
						documentDTO.setDealzId(getRequestParam("dealzId"));
						documentDTO = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
						inputStream = multipartFile.getInputStream();
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
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		map.addAttribute("files", fileNames);
		return "success";
	}

	// image Display dynamically
	@RequestMapping(value = "/displayImage")
	public void displayImage(HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedOutputStream output = null;
		BufferedInputStream bis = null;
		try {
			String fileName = getRequest().getParameter("image");
			String folder = getRequest().getParameter("docType");

			String folderLocation = "DMS.location";
			if (!isEmpty(folder) && folder.equals("10")) {
				folderLocation = "DMS.location.blog";
			}
			File file = new File(AppPropertyBuilder.getProperty(folderLocation, "01"), fileName);
			if (!file.exists() || fileName.isEmpty() || fileName.indexOf(".") == -1)
				file = new File(AppPropertyBuilder.getProperty("image.not.available", "01"), "images.jpg");
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			output = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("image/" + FileUtils.getFileExtension(fileName).substring(1));
			response.setContentLength(new byte[(int) file.length()].length);
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			for (int data; (data = bis.read()) > -1;) {
				output.write(data);
			}
		} catch (IOException e) {

		} finally {
			try {
				if (output != null) {
					output.flush();
					output.close();
				}
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/displayImage1/{imageUrl}")
	public void displayImage1(@PathVariable String imageUrl, HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedOutputStream output = null;
		BufferedInputStream bis = null;
		try {
			String fileName = imageUrl.replace("_do_custom_separator_", ".");
			String folder = getRequest().getParameter("docType");

			String folderLocation = "DMS.location";
			if (!isEmpty(folder) && folder.equals("10")) {
				folderLocation = "DMS.location.blog";
			}
			if (!isEmpty(folder) && folder.equals("11")) {
				folderLocation = "DMS.location.accessibilityIcon";
			}
			if (!isEmpty(folder) && folder.equals("12")) {
				folderLocation = "DMS.location.navs";
			}
			File file = new File(AppPropertyBuilder.getProperty(folderLocation, "01"), fileName);
			if (!file.exists() || fileName.isEmpty() || fileName.indexOf(".") == -1)
				file = new File(AppPropertyBuilder.getProperty("image.not.available", "01"), "images.jpg");
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			output = new BufferedOutputStream(response.getOutputStream());
			for (int data; (data = bis.read()) > -1;) {
				output.write(data);
			}
		} catch (IOException e) {

		} finally {
			try {
				if (output != null) {
					output.flush();
					output.close();
				}
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/gcdblogs/images/{imageUrl}")
	public void blogImageDisplay(@PathVariable String imageUrl, HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedOutputStream output = null;
		BufferedInputStream bis = null;
		try {
			String fileName = imageUrl;

			File file = null;
			String[] filePermissions = getProperty("filePermission.blog", "01").split(",");
			for (String extention : filePermissions) {
				file = new File(getProperty("DMS.location.blog", "01"), fileName + "." + extention);
				if (file.exists()) {
					break;
				}
			}
			// File file = new
			// File(AppPropertyBuilder.getProperty("DMS.location.blog", "01"),
			// fileName);
			if ((file != null && !file.exists()))
				file = new File(AppPropertyBuilder.getProperty("image.not.available", "01"), "images.jpg");
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			output = new BufferedOutputStream(response.getOutputStream());
			for (int data; (data = bis.read()) > -1;) {
				output.write(data);
			}
		} catch (IOException e) {

		} finally {
			try {
				if (output != null) {
					output.flush();
					output.close();
				}
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/downloadDocument")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;

		FileInputStream fileInputStream = null;

		byte[] byteArr = null;
		int length = 0;
		ServletOutputStream op = null;

		try {
			DocumentDTO docDTO = null;
			String tmpDocIndex = getRequestParam("dId");
			String merchantId = getRequestParam("mId");
			if (tmpDocIndex != null && IntUtil.isInteger(tmpDocIndex.trim())) {
				List<DocumentDTO> docDTOList = getCityDealz.getDocumentData(userInfo, IntUtil.getInteger(tmpDocIndex.trim()), merchantId);
				if (docDTOList != null && docDTOList.size() == 1) {
					docDTO = docDTOList.get(0);
					op = response.getOutputStream();
					String strRepoBase = AppPropertyBuilder.getProperty("DMS.location", "01");

					File fileObj = new File(strRepoBase + File.separator + File.separator + docDTO.getFileSavedAs());
					byteArr = new byte[(int) fileObj.length()];
					
					
					byteArr = new byte[(int) fileObj.length()];
					fileInputStream = new FileInputStream(fileObj);
		            fileInputStream.read(byteArr);
					length = byteArr.length;
					
					response.setContentType(docDTO.getContentType());
					response.setContentLength(length);
					response.setHeader("Content-Disposition", "inline; filename=\"" + docDTO.getOrignalFileName() + "\"");
					op.write(byteArr, 0, length);
					
					/*fileInputStream = new FileInputStream(fileObj);

					BufferedInputStream bis = new BufferedInputStream(fileInputStream);
					BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());

					response.setContentType(docDTO.getContentType());
					response.setContentLength(byteArr.length);
					response.setHeader("Content-Disposition", "inline; filename=\"" + docDTO.getOrignalFileName() + "\"");
					for (int data; (data = bis.read()) > -1;) {
						output.write(data);
					}
					op.write(byteArr, 0, byteArr.length);*/
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			documentDTO = new DocumentDTO();
			if (e != null && e instanceof BaseException) {
				documentDTO.setJsonMessage(((BaseException) e).getMsgCode());
			} else if (e.getCause() != null && e.getCause() instanceof BaseException) {
				documentDTO.setJsonMessage(((BaseException) e.getCause()).getMsgCode());
			} else {
				documentDTO.setJsonMessage("Error");
			}
		} finally {
			try {
				if (op != null)
					op.flush();
				if (fileInputStream != null)
					fileInputStream.close();
				if (op != null)
					op.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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

	/**
	 * @return the documentDTO
	 */
	public DocumentDTO getDocumentDTO() {
		return documentDTO;
	}

	/**
	 * @param documentDTO
	 *            the documentDTO to set
	 */
	public void setDocumentDTO(DocumentDTO documentDTO) {
		this.documentDTO = documentDTO;
	}

	/**
	 * @return the dealzIds
	 */
	public String getDealzIds() {
		return dealzIds;
	}

	/**
	 * @param dealzIds
	 *            the dealzIds to set
	 */
	public void setDealzIds(String dealzIds) {
		this.dealzIds = dealzIds;
	}
}
