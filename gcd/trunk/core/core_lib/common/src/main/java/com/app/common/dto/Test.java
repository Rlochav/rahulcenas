package com.app.common.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Test {
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		String s = null;
		URL url = new URL("http://gonola.bz/yourls-api.php?timestamp=1414863261&signature=8dbdd5cc2f4e20d2bb4994c71a2b4f54&action=shorturl&url=neworleans.gcddev.com/Li-s-Test-Company/deal/Saturday-Time-Zone-Test-640");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String strTemp = "";
		while (null != (strTemp = br.readLine())) {
			s = strTemp;
		}
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource src = new InputSource();
		src.setCharacterStream(new StringReader(s));
		Document doc = builder.parse(src);
		String age = doc.getElementsByTagName("shorturl").item(0).getTextContent();
		System.out.println(age);
	}
}
