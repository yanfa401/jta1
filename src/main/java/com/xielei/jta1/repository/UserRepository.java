package com.xielei.jta1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xielei.jta1.entity.User;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/28
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
