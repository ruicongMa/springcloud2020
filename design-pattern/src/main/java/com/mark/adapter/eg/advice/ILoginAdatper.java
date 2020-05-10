package com.mark.adapter.eg.advice;

import com.mark.adapter.eg.ResultMsg;

/**
 * @author Mark
 * @date 2020/5/10 16:00
 */
public interface ILoginAdatper {
    boolean support(Object object);

    ResultMsg login(String id, Object adapter);
}
