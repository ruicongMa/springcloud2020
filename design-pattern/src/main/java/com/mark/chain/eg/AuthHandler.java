package com.mark.chain.eg;

/**
 * @author Mark
 * @date 2020/5/19 19:52
 */
public class AuthHandler extends Handler {
    @Override
    public void doHandle(Member member) {
        if (!"管理员".equals(member.getRoleName())) {
            System.out.println("您不是管理员，没有操作权限~");
            return;
        }
        System.out.println("您是管理员，允许操作");
    }
}
