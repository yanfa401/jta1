package com.xielei.jta1.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xielei.jta1.entity2.Prod;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/29
 */

@Repository
public interface ProdRepository extends JpaRepository<Prod, Integer> {
}
