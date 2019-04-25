package com.imooc.ad.dao;

import com.imooc.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Qinyi.
 */
@Repository
public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
