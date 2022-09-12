package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mark
 * @date 2021/9/16 18:12
 */
public class BaseService<O, S> {

    @Autowired
    public O o;

    @Autowired
    protected S s;
}
