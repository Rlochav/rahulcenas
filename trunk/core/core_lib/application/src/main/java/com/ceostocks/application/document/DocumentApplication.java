package com.ceostocks.application.document;

import java.math.BigDecimal;
import java.util.List;

import com.ceostocks.common.dto.DocumentDTO;

public interface DocumentApplication {

	public List<DocumentDTO> getDocById(BigDecimal docId);

	public DocumentDTO saveDocument(DocumentDTO documentDTO);

	public DocumentDTO deleteDocument(BigDecimal docId);

	public DocumentDTO documentGetByName(String id);
}
