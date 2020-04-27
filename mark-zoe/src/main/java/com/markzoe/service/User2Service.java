package com.markzoe.service;

import com.markzoe.entities.User2;

/**
 * @author Mark
 * @date 2020/4/27 16:59
 */
public interface User2Service {

    void addRequired(User2 user2);

    void addRequiredException(User2 user2);

    void addRequiresNew(User2 user2);

    void addRequiresNewException(User2 user2);

    void addNested(User2 user2);

    void addNestedException(User2 user2);
}
