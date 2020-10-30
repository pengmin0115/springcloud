package com.apple.service;

import com.apple.pojo.User;

/**
 * @author pengmin
 * @date 2020/10/29 17:25
 */

public interface UserService {
    /**
     * 根据ID查找用户;
     * @param id
     * @return
     */
    User findByUserId(Integer id);
}
