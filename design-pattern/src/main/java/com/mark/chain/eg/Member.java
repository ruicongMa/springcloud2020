package com.mark.chain.eg;

import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/19 19:21
 */
@Data
public class Member {

    private String loginName;
    private String loginPass;
    private String roleName;

    public Member(String loginName, String loginPass) {
        this.loginName = loginName;
        this.loginPass = loginPass;
    }
}
