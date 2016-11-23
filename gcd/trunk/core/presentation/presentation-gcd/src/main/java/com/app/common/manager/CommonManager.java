package com.app.common.manager;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.common.dao.CommonDAO;
import com.app.common.dto.CacheDTO;
import com.app.commonexception.BaseException;
import com.app.model.base.Base;
import com.app.persistence.factory.JPADAOFactory;

@Repository
public class CommonManager {
	public static Map<String, CacheDTO> cacheDTOMap = new HashMap<String, CacheDTO>();
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public CommonDAO<Base<Serializable>, Serializable> loadDAO() throws BaseException {
		CommonDAO<Base<Serializable>, Serializable> commonDAO = null;
		try {
			commonDAO = (CommonDAO<Base<Serializable>, Serializable>) JPADAOFactory.getDAOFactory(JPADAOFactory.DEFAULT).getDAO(CommonDAO.class);
			commonDAO.setEntityManager(entityManager);
		} catch (BaseException e) {
			throw e;
		}
		return commonDAO;
	}

	public CacheDTO getCacheDTO() throws BaseException {
		CacheDTO dto = new CacheDTO();
		CommonDAO<Base<Serializable>, Serializable> commonDAO = loadDAO();

		List<Object[]> codeLkupKeyList = commonDAO.getAllCodeLookUpKeyList();
		dto.setCodeLkupKey1Map(new HashMap<String, Map<String, String>>());
		dto.setCodeLkupKey2Map(new HashMap<String, Map<String, String>>());
		dto.setCodeLkupKey3Map(new HashMap<String, Map<String, String>>());
		if (codeLkupKeyList != null) {
			for (Object[] key : codeLkupKeyList) {
				if (!dto.getCodeLkupKey1Map().containsKey(key[0])) {
					dto.getCodeLkupKey1Map().put((String) key[0], new LinkedHashMap<String, String>());
					dto.getCodeLkupKey2Map().put((String) key[0], new LinkedHashMap<String, String>());
					dto.getCodeLkupKey3Map().put((String) key[0], new LinkedHashMap<String, String>());
				}
				dto.getCodeLkupKey1Map().get(key[0]).put((String) key[1], (String) key[2]);
				if (key[3] != null) {
					dto.getCodeLkupKey2Map().get(key[0]).put((String) key[1], (String) key[3]);
				}
				if (key[4] != null) {
					dto.getCodeLkupKey3Map().get(key[0]).put((String) key[1], (String) key[4]);
				}
			}
		}
		dto.setCacheUpdatedAt((new Date()).getTime());
		cacheDTOMap.put("1", dto);
		return dto;
	}

	/**
	 * @return the cacheDTOMap
	 */
	public static Map<String, CacheDTO> getCacheDTOMap() {
		return cacheDTOMap;
	}

	/**
	 * @param cacheDTOMap
	 *            the cacheDTOMap to set
	 */
	public static void setCacheDTOMap(Map<String, CacheDTO> cacheDTOMap) {
		CommonManager.cacheDTOMap = cacheDTOMap;
	}

}
