package com.mark.chain.eg;

/**
 * @author Mark
 * @date 2020/5/19 19:22
 */
public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());

        builder.build().doHandle(new Member(loginName, loginPass));
    }

    // public void login(String loginName, String loginPass) {
    //     Handler validateHandler = new ValidateHandler();
    //     Handler loginHandler = new LoginHandler();
    //     Handler authHandler = new AuthHandler();
    //
    //     validateHandler.next(loginHandler);
    //     loginHandler.next(authHandler);
    //
    //     validateHandler.doHandle(new Member(loginName, loginPass));
    // }

    // public void login(String loginName, String loginPass) {
    //     if (null == loginName || loginName.trim().equals("")) {
    //         return;
    //     }
    //     if (null == loginPass || loginPass.trim().equals("")) {
    //         return;
    //     }
    //     Member member = checkExists(loginName, loginPass);
    //     if (member == null) {
    //         System.out.println("用户不存在~~~");
    //         return;
    //     }
    //     if (!"管理员".equals(member.getRoleName())) {
    //         System.out.println("您不是管理员，没有操作权限~");
    //         return;
    //     }
    //     System.out.println("允许操作");
    // }

    private Member checkExists(String loginName, String loginPass) {
        Member member = new Member(loginName, loginPass);
        member.setRoleName("管理员");
        return member;
    }

    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("mark", "666888");
    }

}
