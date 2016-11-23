package com.app.mvc.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.util.DigestUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class UrlSortnerUtil {

	public synchronized static String getSortUrl(String urlx, String paramz) {
		String shorturl = null;
		try {
			for (;;) {
				String s = "gcddev.com";

				String timestamp = (System.nanoTime() / 1000) + "";

				/*String urlParameters = "timestamp=" + timestamp + "&signature="
						+ DigestUtils.appendMd5DigestAsHex(timestamp.getBytes(), new StringBuilder("'f50fc2cae7' ")) + "&action=shorturl&url=" + urlx + "?"
						+ paramz;*/
				String urlParameters = "username=alexasoft&password=GCD2014!!&action=shorturl&url=" + urlx + "?"
						+ paramz;
				URL url = new URL("http://gonola.bz/yourls-api.php");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setInstanceFollowRedirects(false);
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				connection.setRequestProperty("charset", "utf-8");
				connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
				connection.setUseCaches(false);
				connection.setConnectTimeout(1000000);
				connection.setReadTimeout(1000000);
				connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
				connection.disconnect();
				if (connection.getResponseCode() != 200)
					continue;
				InputStreamReader reader = new InputStreamReader(connection.getInputStream());
				BufferedReader br = new BufferedReader(reader);
				String strTemp = "";
				while (null != (strTemp = br.readLine())) {
					s = strTemp;
				}
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				InputSource src = new InputSource();
				src.setCharacterStream(new StringReader(s));
				Document doc = builder.parse(src);
				shorturl = doc.getElementsByTagName("shorturl").item(0).getTextContent();
				System.out.println(shorturl);

				br.close();
				reader.close();
				return shorturl;
			}
		} catch (Exception e) {
			System.out.println("@@@@@@@Failed To Get Sort Url@@@@@@@@" + e.getMessage());
		}
		return shorturl;
	}
}
