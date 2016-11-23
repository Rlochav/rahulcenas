package com.app.post.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.blog.GcdPost;
import com.app.persistence.DefaultKeyGenerator;
import com.app.persistence.factory.JPADAOFactory;
import com.app.post.dao.PostDAO;
import com.app.post.dto.PostDTO;
import com.app.utility.common.DateUtil;
import com.app.utility.common.IntUtil;

@Repository
public class PostManager {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public PostDAO<Base<Serializable>, Serializable> loadDAO() throws BaseException {
		PostDAO<Base<Serializable>, Serializable> postDAO = null;
		try {
			postDAO = (PostDAO<Base<Serializable>, Serializable>) JPADAOFactory.getDAOFactory(JPADAOFactory.DEFAULT).getDAO(PostDAO.class);
			postDAO.setEntityManager(entityManager);
		} catch (BaseException e) {
			throw e;
		}
		return postDAO;
	}

	public PostDTO createPost(UserInfo userInfo, PostDTO postDTO) throws BaseException {
		GcdPost gcdPost = null;
		Integer postId = IntUtil.getInteger(postDTO.getPostId());
		if (postId != null) {
			gcdPost = entityManager.find(GcdPost.class, postId);
		}
		if (gcdPost == null) {
			gcdPost = new GcdPost();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("postId", entityManager);
			postDTO.setPostId(nextKey);
			gcdPost.setPostId(IntUtil.getInteger(nextKey));
			gcdPost.setCreatedBy(userInfo.getUserIndex());
			gcdPost.setCreatedDate(new Date());
		}
		gcdPost.setMerchantId(userInfo.getUserIndex() + "");
		gcdPost.setTitle(postDTO.getPostTitle());
		gcdPost.setPost(postDTO.getPostText());
		gcdPost.setUpdatedBy(userInfo.getUserIndex());
		gcdPost.setUpdatedDate(new Date());
		entityManager.merge(gcdPost);
		return postDTO;
	}

	public PostDTO loadMyAllPost(UserInfo userInfo) throws BaseException {
		PostDAO<Base<Serializable>, Serializable> dao = loadDAO();
		PostDTO postDTO = new PostDTO();
		List<GcdPost> gcdPosts = dao.getMyAllPost(userInfo);
		if (gcdPosts != null) {
			for (GcdPost post : gcdPosts) {
				PostDTO dto = new PostDTO();
				dto.setPostId(post.getPostId() + "");
				dto.setTitle(post.getTitle());
				dto.setPostDate(DateUtil.parseDateToString(post.getCreatedDate(), userInfo.getDateFormat()));
				if (postDTO.getPostDTOs() == null)
					postDTO.setPostDTOs(new ArrayList<PostDTO>());
				postDTO.getPostDTOs().add(dto);
			}
		}

		return postDTO;
	}

	public PostDTO getPostDetailsById(UserInfo userInfo, String postId) throws BaseException {
		PostDTO postDTO = null;
		Integer iPostID = IntUtil.getInteger(postId);
		if (iPostID != null) {
			GcdPost gcdPost = entityManager.find(GcdPost.class, iPostID);
			if (gcdPost != null) {
				postDTO = new PostDTO();
				postDTO.setPostId(gcdPost.getPostId() + "");
				postDTO.setPostTitle(gcdPost.getTitle());
				postDTO.setPostText(gcdPost.getPost());
			}
		}
		return postDTO;
	}

	public PostDTO deletePost(UserInfo userInfo, PostDTO dto) throws BaseException {
		Integer iPostID = IntUtil.getInteger(dto.getPostId());
		if (iPostID != null) {
			GcdPost gcdPost = entityManager.find(GcdPost.class, iPostID);
			if (gcdPost != null) {
				entityManager.remove(gcdPost);
			} else {
				throw new BusinessException("Invalid operation performed", BusinessException.BUSSINESS_TYP);
			}
		}
		return dto;
	}
}
