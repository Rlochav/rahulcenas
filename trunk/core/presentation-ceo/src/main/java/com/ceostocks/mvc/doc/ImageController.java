package com.ceostocks.mvc.doc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ceostocks.application.document.DocumentApplication;
import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.common.enums.ImageType;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.common.util.CeoStocksConfigProperty;
import com.ceostocks.common.util.IntUtil;

/**
 * 
 * @author Arun
 *
 */
@Controller
@RequestMapping("/component/")
public class ImageController extends CeoStocksWebHandler {

	private static final long serialVersionUID = -4682398329008213966L;

	@Autowired
	private DocumentApplication documentApplication;

	/*
	 * @RequestMapping(value = "/upload", method = RequestMethod.GET) public
	 * 
	 * @ResponseBody Map list() { // log.debug("uploadGet called"); List<Image>
	 * list = imageDao.list(); for (Image image : list) {
	 * image.setUrl("picture/" + image.getId());
	 * image.setThumbnailUrl("thumbnail/" + image.getId());
	 * image.setDeleteUrl("delete/" + image.getId());
	 * image.setDeleteType("DELETE"); } Map<String, Object> files = new
	 * HashMap<>(); files.put("files", list); // log.debug("Returning: {}",
	 * files); return files; }
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody DocumentDTO upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;
		List<Image> list = new LinkedList<>();
		DocumentDTO doc = new DocumentDTO();

		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());

			String newFilenameBase = UUID.randomUUID().toString();
			String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
			String newFilename = newFilenameBase + originalFileExtension;
			String storageDirectory = CeoStocksConfigProperty.getProperty("DMS.location.user.post.image", "01");
			File postImageDir = new File(storageDirectory);

			String contentType = mpf.getContentType();

			try {
				if (!postImageDir.exists())
					postImageDir.mkdirs();
				File newFile = new File(postImageDir, newFilename);
				mpf.transferTo(newFile);

				BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 290);
				String thumbnailFilename = newFilenameBase + "-thumbnail.png";
				File thumbnailFile = new File(storageDirectory + "/" + thumbnailFilename);
				ImageIO.write(thumbnail, "png", thumbnailFile);

				doc = new DocumentDTO(null, mpf.getOriginalFilename(), newFilename, thumbnailFilename, "1", contentType, mpf.getSize() + "",
						ImageType.PROFILE_PIC.getImageCode().toString(), storageDirectory);

				doc = documentApplication.saveDocument(doc);

				/*
				 * image.setUrl("picture/" + image.getId());
				 * image.setThumbnailUrl("thumbnail/" + image.getId());
				 * image.setDeleteUrl("delete/" + image.getId());
				 * image.setDeleteType("DELETE");
				 * 
				 * list.add(image);
				 */

			} catch (IOException e) {
				e.printStackTrace();
				// log.error("Could not upload file " +
				// mpf.getOriginalFilename(), e);
			}

		}

		Map<String, Object> files = new HashMap<>();
		files.put("files", list);
		return doc;
	}

	@RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
	public void picture(HttpServletResponse response, @PathVariable String id) {

		DocumentDTO documentDTO = documentApplication.documentGetByName(id.replace("|", "."));
		File imageFile = new File(CeoStocksConfigProperty.getProperty("DMS.location.user.post.image", "01"), documentDTO.getFileSavedAs().replace("|", "."));
		response.setContentType(documentDTO.getContentType());
		response.setContentLength(IntUtil.getInteger(documentDTO.getFileSize()));
		try {
			InputStream is = new FileInputStream(imageFile);
			IOUtils.copy(is, response.getOutputStream());
		} catch (IOException e) { //
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/thumbnail/{id}", method = RequestMethod.GET)
	public void thumbnail(HttpServletResponse response, @PathVariable Long id) {
		/*
		 * Image image = imageDao.get(id); File imageFile = new
		 * File(fileUploadDirectory + "/" + image.getThumbnailFilename());
		 * response.setContentType(image.getContentType());
		 * response.setContentLength(image.getThumbnailSize().intValue()); try {
		 * InputStream is = new FileInputStream(imageFile); IOUtils.copy(is,
		 * response.getOutputStream()); } catch (IOException e) { //
		 * log.error("Could not show thumbnail " + id, e); }
		 */
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List delete(@PathVariable Long id) {
		/*
		 * Image image = imageDao.get(id); File imageFile = new
		 * File(fileUploadDirectory + "/" + image.getNewFilename());
		 * imageFile.delete(); File thumbnailFile = new File(fileUploadDirectory
		 * + "/" + image.getThumbnailFilename()); thumbnailFile.delete();
		 * imageDao.delete(image); List<Map<String, Object>> results = new
		 * ArrayList<>(); Map<String, Object> success = new HashMap<>();
		 * success.put("success", true); results.add(success);
		 */
		return null;
	}
}
