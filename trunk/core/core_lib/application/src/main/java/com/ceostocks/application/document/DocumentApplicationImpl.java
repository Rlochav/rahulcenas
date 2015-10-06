package com.ceostocks.application.document;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.application.mapper.DocumentDTOMapper;
import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.common.annotation.CeoStocksReqNewTxn;
import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.model.document.Document;
import com.ceostocks.services.document.DocumentService;

public class DocumentApplicationImpl implements DocumentApplication {

	@Autowired
	private DocumentService documentService;

	@Override
	public List<DocumentDTO> getDocById(BigDecimal docId) {

		return null;
	}

	@CeoStocksReqNewTxn
	@Override
	public DocumentDTO saveDocument(DocumentDTO documentDTO) {
		Document document = documentService.saveDocument(documentDTO);
		return DocumentDTOMapper.mapper(document);
	}

	@Override
	public DocumentDTO deleteDocument(BigDecimal docId) {

		return null;
	}

	@CeoStocksReadOnlyTxn
	@Override
	public DocumentDTO documentGetByName(String fileSavedAs) {
		Document document = documentService.documentGetByName(fileSavedAs);
		return DocumentDTOMapper.mapper(document);
	}

}
