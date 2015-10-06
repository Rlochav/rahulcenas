package com.ceostocks.mvc.doc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ceostocks.application.user.UserApplication;
import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.enums.ImageType;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.common.util.CeoStocksConfigProperty;
import com.ceostocks.common.util.DateUtil;
import com.ceostocks.common.util.FileUtils;

@Controller
public class UploadUserProfilePicController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2435710524416478865L;

	@Autowired
	private UserApplication userApplication;

	@RequestMapping("/component/uploadUserProfilePic")
	public String uploadUserProfilePic(@RequestParam("file") MultipartFile multipartFile) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			if (!multipartFile.isEmpty()) {
				String imageFolderPath = CeoStocksConfigProperty.getProperty("DMS.location.user.profile.image", "01");

				DocumentDTO documentDTO = documentMapper(multipartFile, imageFolderPath);
				File dir = new File(imageFolderPath);
				if (!dir.exists())
					dir.mkdirs();
				File newFile = new File(dir, documentDTO.getFileSavedAs());
				if (!newFile.exists()) {
					newFile.createNewFile();
				}
				inputStream = multipartFile.getInputStream();
				outputStream = new FileOutputStream(newFile);
				int read = 0;
				byte[] bytes = new byte[1024];
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}

				saveUserProfilePic(documentDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null && outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/component/home";
	}

	private DocumentDTO documentMapper(MultipartFile multipartFile, String imageFolderPath) {
		DocumentDTO documentDTO = new DocumentDTO(null, multipartFile.getOriginalFilename(), DateUtil.getTimeStampAsStr() + "_"
				+ multipartFile.getOriginalFilename(), null, null, multipartFile.getContentType(), null, ImageType.PROFILE_PIC.getImageCode().toString(),
				imageFolderPath);
		return documentDTO;
	}

	public UserInfo saveUserProfilePic(DocumentDTO documentDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		userInfo = userApplication.saveUserProfilePic(userInfo, documentDTO);
		getSession().setAttribute(USER_INFO_SESSION, userInfo);
		return userInfo;
	}

	// image Display dynamically
	@RequestMapping(value = "/component/profileImage")
	public void displayImage(HttpServletResponse response, HttpServletRequest request) {
		FileInputStream fis = null;
		BufferedOutputStream output = null;
		BufferedInputStream bis = null;
		try {
			String fileName = request.getParameter("image");

			File file = new File(CeoStocksConfigProperty.getProperty("DMS.location.user.profile.image", "01"), fileName);
			if (!file.exists() || fileName.isEmpty()) {
				fileName = "noimage.jpg";
				file = new File(CeoStocksConfigProperty.getProperty("image.not.available", "01"), fileName);
			}
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
}
