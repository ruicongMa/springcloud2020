package com.mark.chain.eg;

/**
 * @author Mark
 * @date 2020/5/19 19:45
 */
public class ValidateHandler extends Handler<Member> {
    @Override
    public void doHandle(Member member) {
        if (null == member.getLoginName() || member.getLoginName().trim().equals("")) {
            return;
        }
        if (null == member.getLoginPass() || member.getLoginPass().equals("")) {
            return;
        }
        System.out.println("用户名和密码校验成功，可以往下执行");
        chain.doHandle(member);
    }
}
