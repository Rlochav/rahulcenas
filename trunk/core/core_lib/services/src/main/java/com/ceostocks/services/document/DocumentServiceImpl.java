package com.ceostocks.services.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.common.util.IntUtil;
import com.ceostocks.model.document.Document;
import com.ceostocks.model.document.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public Document saveDocument(DocumentDTO documentDTO) {
		Document document = new Document(documentDTO.getOrignalFileName(), documentDTO.getFileSavedAs(), documentDTO.getFileSavedAsThumbnail(),
				IntUtil.getInteger(documentDTO.getStatus()), documentDTO.getContentType(), documentDTO.getFileSize(), IntUtil.getInteger(documentDTO
						.getFileType()), documentDTO.getFileLocation());
		documentRepository.save(document);
		return document;
	}

	@Override
	public Document documentGetByName(String fileSavedAs) {
		// TODO Auto-generated method stub
		return documentRepository.getByFileSavedAs(fileSavedAs);
	}
}
