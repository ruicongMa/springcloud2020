package com.markzoe.service;

import com.markzoe.entities.User1;

/**
 * @author Mark
 * @date 2020/4/27 16:59
 */
public interface User1Service {

    void addRequired(User1 user1);

    void addRequiresNew(User1 user1);

    void addNested(User1 user1);
}
