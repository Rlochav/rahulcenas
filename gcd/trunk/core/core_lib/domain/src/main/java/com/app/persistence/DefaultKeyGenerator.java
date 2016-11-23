package com.app.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityManager;

import com.app.model.ncounter.KeyHelper;
import com.app.model.ncounter.KeyManagerEntity;
import com.app.model.ncounter.NcounterPK;
import com.app.model.param.SysparamPK;
import com.app.model.param.SystemParam;

/**
 * This class is used to generate the primary key for the entities.
 * 
 * @author Piyush Pratap Singh
 * @version 1.0
 */
public class DefaultKeyGenerator {

	/**
	 * This method is used to get the current object of Key Manager Entity
	 * 
	 * @param category
	 * @param entityManager
	 * @return {@link KeyManagerEntity}
	 */
	@SuppressWarnings("unchecked")
	private static KeyManagerEntity<Serializable> getKeyManagerEntity(String keyName, EntityManager entityManager) {
		SystemParam param = entityManager.find(SystemParam.class, new SysparamPK(KeyHelper.paramCode, keyName));
		KeyHelper keyHelper = new KeyHelper(keyName, param);
		KeyManagerEntity<Serializable> kme = null;
		NcounterPK ncounterPK = new NcounterPK(keyName);
		kme = (KeyManagerEntity<Serializable>) entityManager.find(KeyManagerEntity.class, ncounterPK);
		if (kme == null) {
			kme = new KeyManagerEntity<Serializable>();
			kme.setNcounterPK(ncounterPK);
			// key5 contains the start number for the keytN
			int startNo = 1;
			if (param != null && param.getKey5() != null && !param.getKey5().isEmpty())
				startNo = Integer.parseInt(param.getKey5());
			kme.setStartNo(startNo);
			kme.setNextNo(startNo);
			kme.setCreatedBy(0);
			kme.setCreatedDate(new Date());
			kme.setUpdatedBy(0);
			kme.setUpdatedDate(new Date());
			entityManager.persist(kme);
		}
		kme.setKeyHelper(keyHelper);
		return kme;
	}

	/**
	 * This method is used to create the next id for the key manager entity for
	 * the particular Category
	 * 
	 * @param kme
	 * @param entityManager
	 * @return {@link Integer}
	 */
	private static Integer getNextID(KeyManagerEntity<Serializable> kme, EntityManager entityManager) {
		Integer returnVal = kme.getNextNo();
		kme.setNextNo(new Integer(returnVal.intValue() + 1));
		kme.setUpdatedBy(0);
		kme.setUpdatedDate(new Date());
		entityManager.merge(kme);
		return returnVal;
	}

	/**
	 * This method is used to get the next available key to persist the Entity
	 * object
	 * 
	 * @param category
	 * @param entityManager
	 * @return {@link Integer}
	 */
	public static String getNextGeneratedKey(String keyName, EntityManager entityManager) {
		if (keyName != null && keyName != "") {
			KeyManagerEntity<Serializable> kme = getKeyManagerEntity(keyName, entityManager);
			SystemParam systemParam = kme.getKeyHelper().getSystemParam();
			StringBuffer generateKey = new StringBuffer();
			if (systemParam != null) {
				// if prefix is required than it will append the prefix
				if (systemParam.getKey1() != null && !systemParam.getKey1().isEmpty())
					generateKey = generateKey.append(systemParam.getKey1());
				// if padding required than it will append padding
				if (systemParam.getKey2() != null && !systemParam.getKey2().isEmpty() && systemParam.getKey4() != null && !systemParam.getKey4().isEmpty()) {
					if (Boolean.parseBoolean(systemParam.getKey2()))
						generateKey = generateKey.append(String.format("%0" + systemParam.getKey4() + "d", getNextID(kme, entityManager)));
				} else {
					generateKey.append(getNextID(kme, entityManager));
				}

				if (systemParam.getKey3() != null && !systemParam.getKey3().isEmpty())
					generateKey = generateKey.append(systemParam.getKey3());

			} else {
				generateKey.append(getNextID(kme, entityManager));
			}

			return generateKey.toString();
		}
		return null;
	}
}