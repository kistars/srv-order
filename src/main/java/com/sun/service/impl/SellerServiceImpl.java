package com.sun.service.impl;

import com.sun.dataobject.SellerInfo;
import com.sun.repository.SellerInfoRepository;
import com.sun.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SqMax on 2018/4/1.
 */
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
