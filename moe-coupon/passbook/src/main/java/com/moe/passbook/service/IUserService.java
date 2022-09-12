package com.moe.passbook.service;


import com.moe.passbook.vo.Response;
import com.moe.passbook.vo.User;

/**
 * <h1>用户服务: 创建 User 服务</h1>
 * Created by Qinyi.
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     *
     * @param user {@link User}
     * @return {@link Response}
     */
    Response createUser(User user) throws Exception;
}
