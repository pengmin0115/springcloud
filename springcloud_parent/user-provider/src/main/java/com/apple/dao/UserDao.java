package com.apple.dao;

import com.apple.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pengmin
 * @date 2020/10/29 17:21
 */

public interface UserDao  extends JpaRepository<User,Integer> {
}
