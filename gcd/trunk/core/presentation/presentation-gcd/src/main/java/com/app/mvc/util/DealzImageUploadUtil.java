package com.app.mvc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.getcitydealz.dto.DocumentDTO;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;

public class DealzImageUploadUtil {

	public static DocumentDTO upladDealzImage(List<MultipartFile> files, DocumentDTO documentDTO, InputStream inputStream, OutputStream outputStream) {
		List<String> fileNames = null;
		if (null != files && files.size() > 0) {
			fileNames = new ArrayList<String>();
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
		return documentDTO;
	}
}
