package com.app.post.service;

import com.app.commonexception.BaseException;
import com.app.login.dto.UserInfo;
import com.app.post.dto.PostDTO;

public interface PostService {

	public PostDTO createPost(UserInfo userInfo, PostDTO postDTO) throws BaseException;

	public PostDTO loadMyAllPost(UserInfo userInfo) throws BaseException;

}
