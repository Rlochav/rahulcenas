package com.ceostocks.services.document;

import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.model.document.Document;

public interface DocumentService {
	public Document saveDocument(DocumentDTO documentDTO);

	public Document documentGetByName(String fileSavedAs);
}
