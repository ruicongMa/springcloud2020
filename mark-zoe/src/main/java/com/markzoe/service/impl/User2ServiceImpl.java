package com.markzoe.service.impl;

import com.markzoe.dao.User2Dao;
import com.markzoe.entities.User2;
import com.markzoe.service.User2Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Mark
 * @date 2020/4/27 17:00
 */
@Service
public class User2ServiceImpl implements User2Service {

    @Resource
    private User2Dao user2Dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User2 user2) {
        user2Dao.insert(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredException(User2 user2) {
        user2Dao.insert(user2);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User2 user2) {
        user2Dao.insert(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNewException(User2 user2) {
        user2Dao.insert(user2);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User2 user2) {
        user2Dao.insert(user2);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNestedException(User2 user2) {
        user2Dao.insert(user2);
        throw new RuntimeException();
    }
}
