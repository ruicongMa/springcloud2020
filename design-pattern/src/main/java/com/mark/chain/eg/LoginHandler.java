package com.mark.chain.eg;

/**
 * @author Mark
 * @date 2020/5/19 19:50
 */
public class LoginHandler extends Handler<Member> {
    @Override
    public void doHandle(Member member) {
        System.out.println("登录成功");
        member.setRoleName("管理员");
        chain.doHandle(member);
    }
}
