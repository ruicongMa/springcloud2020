package com.mark.delegate.eg;

/**
 * @author Mark
 * @date 2020/5/12 11:19
 */
public class Boss {
    public void command(String task, Leader leader) {
        leader.doing(task);
    }
}
