package com.imooc.ad.service;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdUnitDistrictRequest;
import com.imooc.ad.vo.AdUnitDistrictResponse;
import com.imooc.ad.vo.AdUnitItRequest;
import com.imooc.ad.vo.AdUnitItResponse;
import com.imooc.ad.vo.AdUnitKeywordRequest;
import com.imooc.ad.vo.AdUnitKeywordResponse;
import com.imooc.ad.vo.AdUnitRequest;
import com.imooc.ad.vo.AdUnitResponse;
import com.imooc.ad.vo.CreativeUnitRequest;
import com.imooc.ad.vo.CreativeUnitResponse;

/**
 * Created by Qinyi.
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request)
        throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request)
        throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request)
        throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request)
        throws AdException;
}
