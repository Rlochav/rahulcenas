package com.app.rss.feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;

@Controller
public class RssController {
	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping(value = "/rss/rssfeed/{merchantName}-{merchantId}", method = RequestMethod.GET)
	public ModelAndView getFeedInRss(@PathVariable String merchantId) {
		List<RssContent> items = new ArrayList<RssContent>();
		try {
			UserInfo userInfo = new UserInfo();
			List<DealzDTO> dealzDTOs = getCityDealz.getDealzByMerchantId(userInfo, merchantId,0,0);

			for (DealzDTO dto : dealzDTOs) {
				RssContent content = new RssContent();
				content.setTitle(dto.getTitle());
				content.setDescription(dto.getDescription());
				content.setPubDate(new Date());
				items.add(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("rssViewer");
		mav.addObject("feedContent", items);
		return mav;

	}
}
