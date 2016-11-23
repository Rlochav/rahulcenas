package com.app.social.connect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONObject;

public class InstagramUtil {

	public static String getFeeds(String instagramAcc) {
		String s = null;
		if (instagramAcc != null) {
			int index = instagramAcc.lastIndexOf("/");
			String instgrm = instagramAcc.substring(index + 1, instagramAcc.length());
			try {
				URL url = new URL("https://api.instagram.com/v1/users/search?q=gcdnola&client_id=48dd8e18af7445e4b8d2cb8a60757ed9&max_id=1&count=1");
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				String strTemp = "";
				while (null != (strTemp = br.readLine())) {
					s = strTemp;
				}
				System.out.println(s);
				JSONObject obj = new JSONObject(s);
				JSONArray arr = obj.getJSONArray("data");
				for (int i = 0; i < arr.length(); i++)				{
				    String post_id = arr.getJSONObject(i).getString("id");
				   return post_id;
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		getFeeds("instagramAcc");
	}
}
