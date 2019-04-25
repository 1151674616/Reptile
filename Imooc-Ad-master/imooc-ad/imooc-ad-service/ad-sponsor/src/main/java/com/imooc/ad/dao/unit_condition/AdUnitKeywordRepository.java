package com.imooc.ad.dao.unit_condition;

import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Qinyi.
 */
@Repository
public interface AdUnitKeywordRepository extends
        JpaRepository<AdUnitKeyword, Long> {
}
