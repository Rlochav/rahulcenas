package com.ceostocks.model.document;

import java.math.BigDecimal;

import com.ceostocks.common.base.BaseDao;

public interface DocumentRepository extends BaseDao<Document, BigDecimal> {

	Document getByFileSavedAs(String fileSavedAs);

}
