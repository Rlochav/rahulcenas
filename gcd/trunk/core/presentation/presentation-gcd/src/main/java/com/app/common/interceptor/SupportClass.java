package com.app.common.interceptor;

import static com.app.utility.common.AppPropertyBuilder.getProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.app.getcitydealz.dto.CityDTO;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.IntUtil;

@Repository
public class SupportClass extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityDTO getCityDTO(String cityId) {
		Connection connection = DBUtility.getConnection();
		CityDTO cityDTO = null;
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT CityId,CityCode,CityName FROM gcdcities WHERE CityId=?");
			ps.setInt(1, IntUtil.getInteger(cityId));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cityDTO = new CityDTO();
				cityDTO.setCityCode((String) rs.getString("CityCode"));
				cityDTO.setCityId(rs.getInt("CityId") + "");
				cityDTO.setCityName(rs.getString("CityName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityDTO;
	}

	public String getCityId(String urlPath) {
		Connection connection = DBUtility.getConnection();
		String cityId = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT CityId,CityCode,CityName FROM gcdcities");
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					CityDTO cityDTO = new CityDTO();
					cityDTO.setCityCode((String) rs.getString("CityCode"));
					cityDTO.setCityId(rs.getInt("CityId") + "");
					cityDTO.setCityName(rs.getString("CityName"));

					if (urlPath.indexOf(cityDTO.getCityCode()) > 0) {
						cityId = cityDTO.getCityId();
						break;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityId;
	}

	public static class DBUtility {
		static Connection connection = null;

		public static Connection getConnection() {
			try {
				if (connection == null) {
					Class.forName(getProperty("gcd.database.driverclassname", "01"));
					connection = DriverManager.getConnection(getProperty("gcd.database.connectionurl", "01"),
							getProperty("gcd.database.username", "01"), getProperty("gcd.database.password", "01"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
	}

}
