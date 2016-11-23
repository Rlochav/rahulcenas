package com.app.scheduler.manager;

import static com.app.mvc.util.UrlSortnerUtil.getSortUrl;
import static com.app.utility.common.AppPropertyBuilder.getProperty;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import com.app.commonexception.BaseException;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.manager.MerchantManager;
import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.citiesnstate.Cities;
import com.app.model.getcitydealz.CategoryDealzLink;
import com.app.model.getcitydealz.CategoryDealzLinkPK;
import com.app.model.getcitydealz.MerchantDealz;
import com.app.model.getcitydealz.MerchantDealzPK;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.model.getcitydealz.NeighborhoodDealzLink;
import com.app.model.getcitydealz.NeighborhoodDealzLinkPK;
import com.app.model.socialconnections.AdminFBAccessToken;
import com.app.model.socialconnections.AdminTwitterOAuth;
import com.app.model.socialconnections.TwitterOAuth;
import com.app.model.subscriber.SubscriberCategoryLink;
import com.app.model.subscriber.SubscriberNeighborhoodsLink;
import com.app.model.subscriber.Subscribers;
import com.app.model.task.GcdScheduledTask;
import com.app.model.user.GCDtransaction;
import com.app.model.user.GCDtransactionPK;
import com.app.persistence.exception.DAOException;
import com.app.persistence.factory.JPADAOFactory;
import com.app.scheduler.dao.SchedulerDAO;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.EmailUtility;
import com.app.utility.common.IntUtil;
import com.app.utility.common.StringUtil;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

@Repository
public class SchedulerManager {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private MerchantManager merchantManager;

	@SuppressWarnings("unchecked")
	public SchedulerDAO<Base<Serializable>, Serializable> loadDAO() throws BaseException {
		SchedulerDAO<Base<Serializable>, Serializable> loginDAO = null;
		try {
			loginDAO = (SchedulerDAO<Base<Serializable>, Serializable>) JPADAOFactory.getDAOFactory(JPADAOFactory.DEFAULT).getDAO(SchedulerDAO.class);
			loginDAO.setEntityManager(entityManager);
		} catch (BaseException e) {
			throw e;
		}
		return loginDAO;
	}

	public boolean sendEmailWhenNewCreated() throws Exception {
		UserInfo userInfo = new UserInfo();
		SchedulerDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<Subscribers> subscribers = dao.getSubscriberWithCategories(1);
		if (subscribers != null && subscribers.size() > 0) {
			for (Subscribers s : subscribers) {
				// Send Mail By Category Start***************************
				Set<Integer> subscriberDealzMap = new HashSet<Integer>();
				List<SubscriberCategoryLink> links = s.getSubscriberCategoryLinks();
				if (links != null && links.size() > 0) {
					for (SubscriberCategoryLink slink : links) {
						List<Object[]> dealzs = dao.getDealzListByCategoryToSend(slink.getCategoryId());
						if (dealzs != null && dealzs.size() > 0) {
							for (Object[] o : dealzs) {

								if (!subscriberDealzMap.add((Integer) o[8]))
									continue;

								Map<String, Object> holderMap = new HashMap<String, Object>();
								emailDataForNewDeal(userInfo, s, o, holderMap);

								List<String> rec = Arrays.asList(s.getEmailId());
								List<String> cc = Arrays.asList(AppPropertyBuilder.getProperty("mail.default.to", "01").split(","));

								GCDtransaction gTrx = entityManager.find(GCDtransaction.class, new GCDtransactionPK((Integer) o[8], s.getSubscriberId()));
								if (gTrx == null) {
									boolean f = EmailUtility.postMailType2("01", rec, null, null, "New Deal Alert on Get City Deals", "newDealGetDreated.vm",
											holderMap, 1);
									gTrx = new GCDtransaction();
									gTrx.setDtransactionPK(new GCDtransactionPK((Integer) o[8], s.getSubscriberId()));
									gTrx.setDealStartTime((Date) o[2]);
									gTrx.setEmailTriggerTime(new Date());

									if (f) {
										CategoryDealzLink link = entityManager.find(CategoryDealzLink.class,
												new CategoryDealzLinkPK((Integer) o[8], slink.getCategoryId(), (Integer) o[7]));
										if (link != null)
											link.setProcessed(1);
										entityManager.merge(link);
										gTrx.setDeliveryStatus(1);
									} else {
										gTrx.setDeliveryStatus(0);
									}
									entityManager.merge(gTrx);
								}
								System.out.println("Already Sent Mail.....to this category");
							}
						}
					}
				}
				// Send Mail By Category End***************************
			}
		}
		return false;
	}

	private void emailDataForNewDeal(UserInfo userInfo, Subscribers s, Object[] o, Map<String, Object> holderMap) throws DAOException, BaseException {
		String imagePath = "";
		if (o[9] != null && ((Integer) o[9]) == 1) {
			imagePath = loadDAO().getLogoInfo((Integer) o[7]);
		} else {
			String fileName = (String) loadDAO().getDocument((Integer) o[8] + "");
			if (fileName != null)
				imagePath = fileName;
		}

		holderMap.put("SubscriberName", s.getFirstName());
		holderMap.put("EmailId", s.getEmailId());
		holderMap.put("ImageUrl", imagePath);
		holderMap.put("MerchantName", ((String) o[0]));
		holderMap.put("MerchantUrl", ((String) o[11]));
		holderMap.put("Title", o[1]);
		holderMap.put("TitleUrl", (((String) o[1]).replaceAll("[^a-zA-Z0-9 ]", "-")).replaceAll(" ", "-") + "-" + o[8]);
		holderMap.put("DealStart", DateUtil.parseDateToString((Date) o[2], userInfo.getDateFormat()));
		holderMap.put("DealEnd", DateUtil.parseDateToString((Date) o[3], userInfo.getDateFormat()));
		holderMap.put("HowMuchSaved", o[4]);
		holderMap.put("DealCode", o[5]);
		holderMap.put("Description", o[6]);
		holderMap.put("DealRestrictions", o[10]);

		holderMap.put("SubscriptionId", s.getEmailId());
	}

	public void sendDealNeighborhood() throws Exception {
		// Send Mail By Neighborhood Start*************************
		UserInfo userInfo = new UserInfo();
		List<Subscribers> subscribers = loadDAO().getSubscriberWithCategories(1);
		if (subscribers != null && subscribers.size() > 0) {
			for (Subscribers s : subscribers) {
				Set<Integer> subscriberDealzMap = new HashSet<Integer>();
				List<SubscriberNeighborhoodsLink> nLinks = s.getNeighborhoodsLinks();
				if (nLinks != null && nLinks.size() > 0) {
					for (SubscriberNeighborhoodsLink nLink : nLinks) {
						List<Object[]> dealzs = loadDAO().getDealzListByNhoodToSend(nLink.getNeighborhoodId());
						if (dealzs == null || dealzs.size() == 0)
							continue;
						if (dealzs != null && dealzs.size() > 0) {
							for (Object[] o : dealzs) {
								if (!subscriberDealzMap.add((Integer) o[8]))
									continue;
								Map<String, Object> holderMap = new HashMap<String, Object>();

								emailDataForNewDeal(userInfo, s, o, holderMap);

								List<String> rec = Arrays.asList(s.getEmailId());
								List<String> cc = Arrays.asList(AppPropertyBuilder.getProperty("mail.default.to", "01").split(","));

								GCDtransaction gTrx = entityManager.find(GCDtransaction.class, new GCDtransactionPK((Integer) o[8], s.getSubscriberId()));
								if (gTrx == null) {
									boolean f = EmailUtility.postMailType2("01", rec, null, null, "New Deal Alert on Get City Deals", "newDealGetDreated.vm",
											holderMap, 1);
									gTrx = new GCDtransaction();
									gTrx.setDtransactionPK(new GCDtransactionPK((Integer) o[8], s.getSubscriberId()));
									gTrx.setDealStartTime((Date) o[2]);
									gTrx.setEmailTriggerTime(new Date());
									if (f) {
										NeighborhoodDealzLink link = entityManager.find(NeighborhoodDealzLink.class, new NeighborhoodDealzLinkPK(
												(Integer) o[8], nLink.getNeighborhoodId(), (Integer) o[7]));
										if (link != null)
											link.setProcessed(1);
										entityManager.merge(link);
										gTrx.setDeliveryStatus(1);
									} else {
										gTrx.setDeliveryStatus(0);
									}
									entityManager.merge(gTrx);
								}
								System.out.println("Already Sent Mail.....to this Neighborhood");
							}
						}
					}
				}
			}
		}
		// Send Mail By Neighborhood End*************************
	}

	public void sendEmailDailyDigest() throws Exception {
		UserInfo userInfo = new UserInfo();
		SchedulerDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<Subscribers> subscribers = dao.getSubscriberWithCategories(2);
		Map<String, Object> allMailMap = new HashMap<String, Object>();
		if (subscribers != null && subscribers.size() > 0) {
			for (Subscribers s : subscribers) {
				// Send Mail By Category Start***************************
				List<SubscriberCategoryLink> links = s.getSubscriberCategoryLinks();
				if (links != null && links.size() > 0) {
					for (SubscriberCategoryLink slink : links) {
						List<Object[]> dealzs = dao.getDealzListByCategoryToSend1(slink.getCategoryId());
						for (Object[] o : dealzs) {
							Map<String, Object> holderMap = new HashMap<String, Object>();
							String imagePath = "";
							if (o[9] != null && ((Integer) o[9]) == 1) {
								imagePath = loadDAO().getLogoInfo((Integer) o[7]);
							} else {
								String fileName = (String) loadDAO().getDocument((Integer) o[8] + "");
								if (fileName != null)
									imagePath = fileName;
							}
							holderMap.put("EmailId", s.getEmailId());
							holderMap.put("ImageUrl", imagePath);
							holderMap.put("MerchantName", ((String) o[0]));
							holderMap.put("MerchantUrl", ((String) o[10]));
							holderMap.put("Title", o[1]);
							holderMap.put("TitleUrl", (((String) o[1]).replaceAll("[^a-zA-Z0-9 ]", "-")).replaceAll(" ", "-") + "-" + o[8]);
							holderMap.put("DealStart", DateUtil.parseDateToString((Date) o[2], userInfo.getDateFormat()));
							holderMap.put("DealEnd", DateUtil.parseDateToString((Date) o[3], userInfo.getDateFormat()));
							holderMap.put("HowMuchSaved", o[4]);
							holderMap.put("DealCode", o[5]);
							holderMap.put("Description", o[6]);

							allMailMap.put("" + o[8], holderMap);

							CategoryDealzLink link = entityManager.find(CategoryDealzLink.class, new CategoryDealzLinkPK((Integer) o[8], slink.getCategoryId(),
									(Integer) o[7]));
							if (link != null) {
								link.setProcessed1(1);
								entityManager.merge(link);
							}
						}
					}
				}

				// Send Mail By Category End***************************

				// Send Mail By Neighborhood Start*************************
				List<SubscriberNeighborhoodsLink> nLinks = s.getNeighborhoodsLinks();
				if (nLinks != null && nLinks.size() > 0) {
					for (SubscriberNeighborhoodsLink nLink : nLinks) {
						List<Object[]> dealzs = dao.getDealzListByNhoodToSend1(nLink.getNeighborhoodId());
						if (dealzs != null && dealzs.size() > 0) {
							for (Object[] o : dealzs) {
								Map<String, Object> holderMap = new HashMap<String, Object>();

								String imagePath = "";
								if (o[9] != null && ((Integer) o[9]) == 1) {
									imagePath = loadDAO().getLogoInfo((Integer) o[7]);
								} else {
									String fileName = (String) loadDAO().getDocument((Integer) o[8] + "");
									if (fileName != null)
										imagePath = fileName;
								}
								holderMap.put("EmailId", s.getEmailId());
								holderMap.put("ImageUrl", imagePath);
								holderMap.put("MerchantName", ((String) o[0]));
								holderMap.put("MerchantUrl", ((String) o[10]));
								holderMap.put("Title", o[1]);
								holderMap.put("TitleUrl", (((String) o[1]).replaceAll("[^a-zA-Z0-9 ]", "-")).replaceAll(" ", "-") + "-" + o[8]);
								holderMap.put("DealStart", DateUtil.parseDateToString((Date) o[2], userInfo.getDateFormat()));
								holderMap.put("DealEnd", DateUtil.parseDateToString((Date) o[3], userInfo.getDateFormat()));
								holderMap.put("HowMuchSaved", o[4]);
								holderMap.put("DealCode", o[5]);
								holderMap.put("Description", o[6]);
								holderMap.put("SubscriptionId", s.getEmailId());

								allMailMap.put("" + o[8], holderMap);

								NeighborhoodDealzLink link = entityManager.find(NeighborhoodDealzLink.class,
										new NeighborhoodDealzLinkPK((Integer) o[8], nLink.getNeighborhoodId(), (Integer) o[7]));
								if (link != null) {
									link.setProcessed1(1);
									entityManager.merge(link);
								}
							}
						}
					}
				}
				// Send Mail By Neighborhood End*************************
				Map<String, Object> tempMap = new HashMap<String, Object>();
				if (allMailMap != null && allMailMap.size() > 0) {
					tempMap.put("abcd", allMailMap);
					tempMap.put("SubscriptionId", s.getEmailId());
				}

				if (tempMap.size() > 0) {
					List<String> rec = Arrays.asList(s.getEmailId());
					boolean f = EmailUtility.postMailType2("01", rec, null, null, "Get City Dealz", "dailyDigestEmail.vm", tempMap, 1);
				}
			}
		}
	}

	public synchronized void postSocialPosts() throws BaseException {
		try {
			List<MerchantDealz> merchantDealzs = loadDAO().getAllDealz();
			if (merchantDealzs != null && merchantDealzs.size() > 0) {
				for (MerchantDealz dealz : merchantDealzs) {

					Integer dealzId = dealz.getMerchantDealzPK().getDealzId();
					Integer merchantId = dealz.getMerchantDealzPK().getMerchantId();

					Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());

					MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class, merchantId);
					String titlez = StringUtil.getWithoutSpecial(dealz.getTitle());

					String fbUrl = getSortUrl(
							cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
									+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
							"campaign=MerchantSocialPost%26medium=FBShare%26content=" + titlez);
					String twitUrl = getSortUrl(cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
							+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
							"campaign=MerchantSocialPost%26medium=Twitter%26content=" + titlez);

					SocialConnectionsDTO dto = merchantManager.getMySocialConnections(dealz.getMerchantDealzPK().getMerchantId() + "");
					if (dto == null)
						continue;
					String imageUrl = "";
					if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
						imageUrl = loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId());
					} else {
						imageUrl = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
					}

					if (dto.getTwitterScreenName() != null) {
						try {
							TwitterOAuth twitterOAuth = entityManager.find(TwitterOAuth.class, IntUtil.getInteger(dto.getMerchantId()));
							postOnTwitter(twitterOAuth, dealz.getTitle() + " " + twitUrl, imageUrl);
						} catch (Exception e) {
							System.out.println("Twitter Api Failed To Twittzz: " + e.getMessage());
						}
					}

					String accessToken = merchantManager.getMyAccessToken(dealz.getMerchantDealzPK().getMerchantId());
					MerchantDealz deal = entityManager.find(MerchantDealz.class, new MerchantDealzPK(dealz.getMerchantDealzPK().getDealzId(), dealz
							.getMerchantDealzPK().getMerchantId(), dealz.getMerchantDealzPK().getCitySectionId()));
					boolean isPosted = false;
					if (accessToken != null) {
						isPosted = postOnFb(imageUrl, merchantMaster.getMerchantName(), dealz.getTitle(), dealz.getDescription(), accessToken, fbUrl);
						if (isPosted)
							deal.setProcessed(1);
						else
							deal.setProcessed(666);
					} else {
						deal.setProcessed(0);
					}
					entityManager.merge(deal);
				}
			}
		} catch (BaseException e) {
			e.printStackTrace();
		}
	}

	public boolean postOnFb(String imageUrl, String name, String title, String desc, String accessToken, String postLink) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthAppId(AppPropertyBuilder.getProperty("fb.appId", "01"))
					.setOAuthAppSecret(AppPropertyBuilder.getProperty("fb.appSecret", "01"))
					.setOAuthPermissions("offline_access, publish_stream,user_photos, publish_checkins, photo_upload,email");
			FacebookFactory facebookFactory = new FacebookFactory(cb.build());

			Facebook facebookClient = facebookFactory.getInstance();
			facebookClient.setOAuthAccessToken(new AccessToken(accessToken));
			PostUpdate post = new PostUpdate(new URL(postLink)).picture(new URL(AppPropertyBuilder.getProperty("app.image.url", "01") + imageUrl)).name(title)
					.caption(postLink).description(desc);
			facebookClient.postFeed(post);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void postOnTwitter(TwitterOAuth twitterOAuth, String title, String imageUrl) throws Exception {
		if (twitterOAuth != null) {
			StatusUpdate statusUpdate = new StatusUpdate(title);
			File imageFile = new File(AppPropertyBuilder.getProperty("DMS.location", "01") + File.separator + imageUrl);
			statusUpdate.setMedia(imageFile);
			twitter4j.conf.ConfigurationBuilder cb = new twitter4j.conf.ConfigurationBuilder();

			cb.setOAuthConsumerKey("sEnMc6fEEAMkvGxO6tuDw26VL");
			cb.setOAuthConsumerSecret("350zr8GZlTn03FCrz9kxPYAaA7RRdHl3BxA40mMhhpSnIn0WTJ");
			cb.setOAuthAccessToken(twitterOAuth.getAccessToken());
			cb.setOAuthAccessTokenSecret(twitterOAuth.getAccessTokenSecret());

			Twitter twitter = new TwitterFactory(cb.build()).getInstance();
			twitter.updateStatus(statusUpdate);

		}
	}

	public void doPostOnGcdPages() {
		try {
			List<MerchantDealz> merchantDealzs = loadDAO().getDealToPostOnGcdpage();
			if (merchantDealzs != null && merchantDealzs.size() > 0) {
				for (MerchantDealz dealz : merchantDealzs) {

					Integer dealzId = dealz.getMerchantDealzPK().getDealzId();
					Integer merchantId = dealz.getMerchantDealzPK().getMerchantId();

					MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class, merchantId);
					String titlez = StringUtil.getWithoutSpecial(dealz.getTitle());

					Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());

					String fbUrl = getSortUrl(
							cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
									+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
							"campaign=GCDSocialPost%26medium=FBShare%26content=" + titlez);
					String twitUrl = getSortUrl(cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
							+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
							"campaign=GCDSocialPost%26medium=Twitter%26content=" + titlez);

					String imageUrl = "";
					if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
						imageUrl = loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId());
					} else {
						imageUrl = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
					}
					boolean isTwitterPosted = false;
					List<AdminTwitterOAuth> adminTwitterOAuths = loadDAO().getAdminTwitterTokens();
					if (!isEmpty(adminTwitterOAuths)) {
						for (AdminTwitterOAuth oAuth : adminTwitterOAuths) {
							try {
								TwitterOAuth twitterOAuth = new TwitterOAuth();
								twitterOAuth.setAccessToken(oAuth.getAccessToken());
								twitterOAuth.setAccessTokenSecret(oAuth.getAccessTokenSecret());
								postOnTwitterGcdPages(twitterOAuth, dealz.getTitle() + " " + twitUrl, imageUrl);
								isTwitterPosted = true;
							} catch (Exception e) {
								System.err.println("Twitter Api Failed To Twittzzz..............: " + e.getMessage());
							}
						}
					}

					boolean isFBPosted = false;
					List<AdminFBAccessToken> adminFBAccessTokens = loadDAO().getAdminFBTokens();
					if (!isEmpty(adminFBAccessTokens)) {
						for (AdminFBAccessToken token : adminFBAccessTokens) {
							isFBPosted = postOnFbGcdPages(imageUrl, merchantMaster.getMerchantName(), dealz.getTitle(), dealz.getDescription(),
									token.getAccessToken(), fbUrl);
						}
					}

					MerchantDealz deal = entityManager.find(MerchantDealz.class, new MerchantDealzPK(dealz.getMerchantDealzPK().getDealzId(), dealz
							.getMerchantDealzPK().getMerchantId(), dealz.getMerchantDealzPK().getCitySectionId()));
					if (isFBPosted || isTwitterPosted) {
						deal.setAdminSocialPostedStatus(1);

					} else {
						deal.setAdminSocialPostedStatus(666);
					}

					if (isEmpty(adminFBAccessTokens) && isEmpty(adminTwitterOAuths)) {
						deal.setAdminSocialPostedStatus(0);
					}
					entityManager.merge(deal);
				}
			}
		} catch (BaseException e) {
			e.printStackTrace();
		}
	}

	public boolean postOnFbGcdPages(String imageUrl, String name, String title, String desc, String accessToken, String postLink) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthAppId(AppPropertyBuilder.getProperty("fb.admin.appId", "01"))
					.setOAuthAppSecret(AppPropertyBuilder.getProperty("fb.admin.appSecret", "01"))
					.setOAuthPermissions("email, public_profile,user_friends");
			FacebookFactory facebookFactory = new FacebookFactory(cb.build());

			Facebook facebookClient = facebookFactory.getInstance();
			facebookClient.setOAuthAccessToken(new AccessToken(accessToken));
			PostUpdate post = new PostUpdate(new URL(postLink)).picture(new URL(AppPropertyBuilder.getProperty("app.image.url", "01") + imageUrl)).name(title)
					.caption(postLink).description(desc);
			facebookClient.postFeed(post);
			return true;
		} catch (Exception e) {
			System.out.println(".......................Admin Gcd Page Facebook.......................");
			System.out.println(e.getMessage());
			System.out.println(".......................Admin Gcd Page Facebook.......................");
			return false;
		}
	}

	public void postOnTwitterGcdPages(TwitterOAuth twitterOAuth, String title, String imageUrl) throws Exception {
		if (twitterOAuth != null) {
			StatusUpdate statusUpdate = new StatusUpdate(title);
			File imageFile = new File(AppPropertyBuilder.getProperty("DMS.location", "01") + File.separator + imageUrl);
			statusUpdate.setMedia(imageFile);
			twitter4j.conf.ConfigurationBuilder cb = new twitter4j.conf.ConfigurationBuilder();

			cb.setOAuthConsumerKey(getProperty("twitter.admin.consumerKey", "01"));
			cb.setOAuthConsumerSecret(getProperty("twitter.admin.consumerSecret", "01"));
			cb.setOAuthAccessToken(twitterOAuth.getAccessToken());
			cb.setOAuthAccessTokenSecret(twitterOAuth.getAccessTokenSecret());

			Twitter twitter = new TwitterFactory(cb.build()).getInstance();
			twitter.updateStatus(statusUpdate);

		}
	}

	public void updateAllDealz() throws BaseException {
		List<MerchantDealz> dealzs = loadDAO().getTempAllDealz();
		if (!isEmpty(dealzs)) {
			for (MerchantDealz m : dealzs) {
				Integer dealzId = m.getMerchantDealzPK().getDealzId();
				boolean b = false;
				MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class, m.getMerchantDealzPK().getMerchantId());
				String titlez = StringUtil.getWithoutSpecial(m.getTitle());

				Cities cities = entityManager.find(Cities.class, m.getMerchantDealzPK().getCitySectionId());

				b = true;
				m.setFbSortUrl(getSortUrl(
						cities.getCityCode() + getProperty("app.domain.name", "01") + "/" + merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-")
								+ "/deal/" + titlez + "--" + dealzId, "campaign=VisitorSharing%26medium=FBShare%26content=" + titlez));

				b = true;
				m.setTwitSortUrl(getSortUrl(
						cities.getCityCode() + getProperty("app.domain.name", "01") + "/" + merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-")
								+ "/deal/" + titlez + "--" + dealzId, "campaign=VisitorSharing%26medium=TwitterShare%26content=" + titlez));

				b = true;
				m.setPinSortUrl(getSortUrl(
						cities.getCityCode() + getProperty("app.domain.name", "01") + "/" + merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-")
								+ "/deal/" + titlez + "--" + dealzId, "campaign=VisitorSharing%26medium=PinterestShare%26content=" + titlez));

				b = true;
				m.setgPSortUrl(getSortUrl(
						cities.getCityCode() + getProperty("app.domain.name", "01") + "/" + merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-")
								+ "/deal/" + titlez + "--" + dealzId, "campaign=VisitorSharing%26medium=GPlusShare%26content=" + titlez));

				b = true;
				m.setLinkSortUrl(getSortUrl(
						cities.getCityCode() + getProperty("app.domain.name", "01") + "/" + merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-")
								+ "/deal/" + titlez + "--" + dealzId, "campaign=VisitorSharing%26medium=LIShare%26content=" + titlez));

				entityManager.merge(m);
			}
		}
	}

	public void manageTask() {
		// Its for Daily Digest
		GcdScheduledTask gcdScheduledTask = entityManager.find(GcdScheduledTask.class, 1);
		if (gcdScheduledTask != null) {
			System.out.println("@@@@@@@@@ Task Name: " + gcdScheduledTask.getTaskName());
			System.out.println("@@@@@@@@@ Status: " + gcdScheduledTask.getStatus());
			System.out.println("@@@@@@@@@ Scheduled at: " + DateUtil.parseDateToString(gcdScheduledTask.getScheduledTime(), "MM/dd/yyyy hh:mm:ss a"));
			System.out.println("@@@@@@@@@ Current Time: " + new Date());
			if (gcdScheduledTask.getScheduledTime() == null || gcdScheduledTask.getScheduledTime().compareTo(new Date()) < 0) {
				gcdScheduledTask.setScheduledTime(getNextExecutionTime(gcdScheduledTask.getExecutionTime()));
				entityManager.merge(gcdScheduledTask);
				System.out.println("%%%%%%% Will be execute at: " + gcdScheduledTask.getScheduledTime());
				try {
					sendEmailDailyDigest();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String[] getTimeInArray(String time) {
		return time.split(":");
	}

	public Date getNextExecutionTime(String exeTime) {
		Date d1 = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(d1);
		System.out.println("today is " + d1.toString());
		String[] timzArr = getTimeInArray(exeTime);
		cl.add(Calendar.HOUR, IntUtil.getInteger(timzArr[0]));
		// System.out.println("date after a month will be " +
		// cl.getTime().toString());
		cl.add(Calendar.MINUTE, IntUtil.getInteger(timzArr[1]));
		// System.out.println("date after 7 hrs will be " +
		// cl.getTime().toString());
		cl.add(Calendar.SECOND, IntUtil.getInteger(timzArr[2]));
		// System.out.println("date after 3 years will be " +
		// cl.getTime().toString());
		return cl.getTime();
	}

	public static void main(String[] args) throws Exception {
		Date d1 = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(d1);
		System.out.println("today is " + d1.toString());
		cl.add(Calendar.MONTH, 1);
		System.out.println("date after a month will be " + cl.getTime().toString());
		cl.add(Calendar.HOUR, 70);
		System.out.println("date after 7 hrs will be " + cl.getTime().toString());
		cl.add(Calendar.YEAR, 3);
		System.out.println("date after 3 years will be " + cl.getTime().toString());
	}
}
