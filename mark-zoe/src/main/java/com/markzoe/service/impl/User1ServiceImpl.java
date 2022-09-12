package com.markzoe.service.impl;

import com.markzoe.dao.User1Dao;
import com.markzoe.entities.User1;
import com.markzoe.service.User1Service;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Mark
 * @date 2020/4/27 17:00
 */
@Service
public class User1ServiceImpl implements User1Service {

    @Resource
    private User1Dao user1Dao;

    @Autowired
    private User1Service user1Service;

    @Override
    // @Transactional
    public void test(User1 user1) {
        // 直接掉addRequired，事物会不会回滚，执行addRequired方法时，前置通知会不会执行
        // User1Service user1Service = (User1Service) AopContext.currentProxy();
        user1Service.addRequired(user1);
    }

    @Override
    @Transactional
    public void addRequired(User1 user1) {
        user1Dao.insert(user1);
        throw new NullPointerException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User1 user1) {
        user1Dao.insert(user1);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User1 user1) {
        user1Dao.insert(user1);
    }

}
