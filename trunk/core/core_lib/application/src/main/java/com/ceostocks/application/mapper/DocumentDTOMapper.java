package com.ceostocks.application.mapper;

import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.model.document.Document;

public class DocumentDTOMapper {

	public static DocumentDTO mapper(Document document) {
		return new DocumentDTO(document.getId().toString(), document.getOriginalFileName(), document.getFileSavedAs().replace('.', '|'), null, document
				.getStatus().toString(), document.getContentType(), document.getFileSize(), document.getFileType().toString(), document.getFileLocation());
	}

}
