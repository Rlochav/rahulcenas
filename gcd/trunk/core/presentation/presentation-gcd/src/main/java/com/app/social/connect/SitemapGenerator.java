package com.app.social.connect;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.dto.XmlUrl;
import com.app.common.dto.XmlUrlSet;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.StringUtil;

@Controller
public class SitemapGenerator extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8420289059005903365L;

	@RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
	@ResponseBody
	public XmlUrlSet main() throws IOException {
		XmlUrlSet xmlUrlSet = new XmlUrlSet();
		String urlx = StringUtil.getStartFromIndex(getRequest().getRequestURL().toString());
		// String urlx = "http://getcitydealz.com";
		create(xmlUrlSet, urlx, XmlUrl.Priority.HIGH, XmlUrl.ChangeFrequency.ALWAYS);
		Document doc = Jsoup.connect(urlx + "/index").get();
		Elements questions = doc.select("a[href]");
		for (Element link : questions) {
			if (link.attr("href").contains("merchant") && validate(link)) {
				create(xmlUrlSet, link.attr("abs:href"), XmlUrl.Priority.MEDIUM, XmlUrl.ChangeFrequency.WEEKLY);
			} else if (link.attr("href").contains("deal") && validate(link)) {
				create(xmlUrlSet, link.attr("abs:href"), XmlUrl.Priority.MEDIUM, XmlUrl.ChangeFrequency.DAILY);
				try {
					Document doc1 = Jsoup.connect(link.attr("abs:href")).get();
					Elements questions1 = doc1.select("a[href]");
					for (Element link1 : questions1) {
						if (validate(link1))
							create(xmlUrlSet, link1.attr("abs:href"), XmlUrl.Priority.MEDIUM, XmlUrl.ChangeFrequency.DAILY);
					}
				} catch (Exception e) {
					System.err.println("No Issue.....");
				}
			} else if (link.attr("href").contains("dealsbycategory") && validate(link)) {
				create(xmlUrlSet, link.attr("abs:href"), XmlUrl.Priority.MEDIUM, XmlUrl.ChangeFrequency.DAILY);

			} else if (!link.attr("href").contains("merchant") && !link.attr("href").contains("deal") && validate(link)) {
				create(xmlUrlSet, link.attr("abs:href"), XmlUrl.Priority.LOW, XmlUrl.ChangeFrequency.HOURLY);

				try {
					Document doc1 = Jsoup.connect(link.attr("abs:href")).get();
					Elements questions1 = doc1.select("a[href]");
					for (Element link1 : questions1) {
						if (validate(link1))
							create(xmlUrlSet, link1.attr("abs:href"), XmlUrl.Priority.MEDIUM, XmlUrl.ChangeFrequency.HOURLY);
					}
				} catch (Exception e) {
					System.err.println("No Issue.....");
				}
			}
		}

		// create(xmlUrlSet, "/index", XmlUrl.Priority.MEDIUM);

		return xmlUrlSet;
	}

	public boolean validate(Element link) {

		if (!link.attr("href").contains("pinterest") && !link.attr("href").contains("facebook") && !link.attr("href").contains("linkedin")
				&& !link.attr("href").contains("gmail") && !link.attr("href").contains("google") && !link.attr("href").contains("twitter")
				&& !link.attr("href").contains("youtube") && !link.attr("href").contains("alexaglobalsofttech") && !link.attr("href").contains("instagram")
				&& !link.attr("href").contains("mailto") && link.attr("href").contains("getcitydealz")) {
			return true;

		}

		return false;
	}

	private void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority, XmlUrl.ChangeFrequency changeFrequency) {
		xmlUrlSet.addUrl(new XmlUrl(link, priority, changeFrequency));
	}
}
