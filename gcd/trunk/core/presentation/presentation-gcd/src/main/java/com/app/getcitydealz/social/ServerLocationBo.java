package com.app.getcitydealz.social;

import com.app.social.dto.ServerLocation;

public interface ServerLocationBo {
	ServerLocation getLocation(String ipAddress);
}
