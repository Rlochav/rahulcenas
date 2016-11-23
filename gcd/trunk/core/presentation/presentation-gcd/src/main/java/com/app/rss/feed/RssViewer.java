package com.app.rss.feed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;

public class RssViewer extends AbstractRssFeedView {
	@Autowired
	private MerchantService merchantService;

	protected void buildFeedMetadata(Map<String, Object> model, com.rometools.rome.feed.rss.Channel feed,
			HttpServletRequest request) {
		try {
			String requestedPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			int indexOfIdentifier = requestedPath.lastIndexOf("-");

			MerchantDTO merchantDTO = merchantService.getMerchantDetailById(
					requestedPath.substring(indexOfIdentifier + 1, requestedPath.length()), null);
			feed.setTitle(merchantDTO.getMerchantName());
			feed.setDescription("Get City dealz Rss Feeds");
			feed.setLink("http://www.obcasio.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.buildFeedMetadata(model, feed, request);
	}

	@SuppressWarnings("unchecked")
	protected List<com.rometools.rome.feed.rss.Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<RssContent> listContent = (List<RssContent>) model.get("feedContent");
		List<Item> items = new ArrayList<Item>(listContent.size());

		for (RssContent tempContent : listContent) {
			Item item = new Item();
			Content content = new Content();
			content.setValue(tempContent.getDescription());

			Description description = new Description();
			description.setValue(tempContent.getDescription());
			item.setDescription(description);
			item.setTitle(tempContent.getTitle());
			item.setLink(tempContent.getLink());
			item.setPubDate(tempContent.getPubDate());
			items.add(item);
		}

		return items;
	}
}
