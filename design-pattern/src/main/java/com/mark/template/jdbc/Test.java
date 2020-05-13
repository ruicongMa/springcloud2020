package com.mark.template.jdbc;

import java.util.List;

/**
 * @author Mark
 * @date 2020/5/13 15:10
 */
public class Test {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
