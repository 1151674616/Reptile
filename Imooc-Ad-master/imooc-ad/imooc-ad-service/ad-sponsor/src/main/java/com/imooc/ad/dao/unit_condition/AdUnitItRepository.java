package com.imooc.ad.dao.unit_condition;

import com.imooc.ad.entity.unit_condition.AdUnitIt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Qinyi.
 */
@Repository
public interface AdUnitItRepository
        extends JpaRepository<AdUnitIt, Long> {
}
