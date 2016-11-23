package com.app.doc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;

public class FileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4963651318684461693L;

	@Autowired
	private GetCityDealz getCityDealz;

	private InputStream inputStream;
	private OutputStream outputStream;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DocumentDTO documentDTO = new DocumentDTO();
		try {
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute(AppWebConstant.SESSION_ATTR_USER_INFO);

			Part filePart = request.getPart("upload");
			String filename = getFilename(filePart);

			documentDTO.setMerchantId(userInfo.getUserIndex() + "");
			documentDTO.setDocType("10");

			documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + filename);
			documentDTO.setOrignalFileName(filename);
			documentDTO.setContentType(filePart.getContentType());
			documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location.blog", "01"));
			DocumentDTO docDto = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
			uploadFiles(userInfo, filePart, docDto.getFileSavedAs());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/displayImage?image=" + documentDTO.getFileSavedAs());
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean uploadFiles(UserInfo userInfo, Part filePart, String saveAsFileName) {
		File fileObj = null;
		File dirObj = null;

		boolean booSuccessFg;
		try {
			dirObj = new File(AppPropertyBuilder.getProperty("DMS.location.blog", "01"));
			if (!(dirObj.exists())) {
				dirObj.mkdirs();
			}

			if (dirObj.exists() && dirObj.isDirectory()) {
				fileObj = new File(dirObj.getAbsolutePath() + File.separator + saveAsFileName);
			}
			if (!fileObj.exists()) {
				fileObj.createNewFile();
			}
			inputStream = filePart.getInputStream();
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
		}
		return booSuccessFg;
	}

	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}
}
