package com.app.post.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.commonexception.BaseException;
import com.app.login.dto.UserInfo;
import com.app.post.dto.PostDTO;
import com.app.post.manager.PostManager;
import com.app.posts.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostManager postManager;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public PostDTO createPost(UserInfo userInfo, PostDTO postDTO) throws BaseException {
		PostDTO retDto = null;
		try {
			retDto = postManager.createPost(userInfo, postDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public PostDTO loadMyAllPost(UserInfo userInfo) throws BaseException {
		PostDTO retDto = null;
		try {
			retDto = postManager.loadMyAllPost(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public PostDTO getPostDetailsById(UserInfo userInfo, String postId) throws BaseException {
		PostDTO retDto = null;
		try {
			retDto = postManager.getPostDetailsById(userInfo, postId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public PostDTO deletePost(UserInfo userInfo, PostDTO postDTO) throws BaseException {
		PostDTO retDto = null;
		try {
			retDto = postManager.deletePost(userInfo, postDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

}
