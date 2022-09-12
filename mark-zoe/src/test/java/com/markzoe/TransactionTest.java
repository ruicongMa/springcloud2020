package com.markzoe;

import com.markzoe.entities.User1;
import com.markzoe.properties.PersonProperty;
import com.markzoe.service.User1Service;
import com.markzoe.service.User2Service;
import com.markzoe.service.UserService;
import com.markzoe.service.UserTransactionTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Mark
 * @date 2020/4/27 17:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarkZoeMain666888.class)
public class TransactionTest {


    @Autowired
    private User2Service user2Service;

    @Autowired
    private UserTransactionTestService userTransactionTestService;

    @Autowired
    private PersonProperty personProperty;

    @Resource(name = "service1")
    private UserService userService;

    @Test
    public void test1() {
        System.out.println(userService);
    }

    @Autowired
    private User1Service user1Service;

    @Test
    public void testTrans() {
        System.out.println(user1Service.getClass());
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.test(user1);
    }

    @Test
    public void test() {
        System.out.println(personProperty);
    }

    @Test
    public void transaction_nested_nested_exception_try() {
        userTransactionTestService.transaction_nested_nested_exception_try();
    }

    @Test
    public void transaction_nested_nested_exception() {
        userTransactionTestService.transaction_nested_nested_exception();
    }

    @Test
    public void transaction_exception_nested_nested() {
        userTransactionTestService.transaction_exception_nested_nested();
    }

    @Test
    public void notransaction_nested_nested_exception() {
        userTransactionTestService.notransaction_nested_nested_exception();
    }

    @Test
    public void notransaction_exception_nested_nested() {
        userTransactionTestService.notransaction_exception_nested_nested();
    }

    @Test
    public void transaction_required_requiresNew_requiresNew_exception_try() {
        userTransactionTestService.transaction_required_requiresNew_requiresNew_exception_try();
    }

    @Test
    public void transaction_required_requiresNew_requiresNew_exception() {
        userTransactionTestService.transaction_required_requiresNew_requiresNew_exception();
    }

    @Test
    public void transaction_exception_required_requiresNew_requiresNew() {
        userTransactionTestService.transaction_exception_required_requiresNew_requiresNew();
    }

    @Test
    public void notransaction_requiresNew_requiresNew_exception() {
        userTransactionTestService.notransaction_requiresNew_requiresNew_exception();
    }

    @Test
    public void notransaction_exception_requiresNew_requiresNew() {
        userTransactionTestService.notransaction_exception_requiresNew_requiresNew();
    }

    @Test
    public void transaction_required_required_exception_try() {
        userTransactionTestService.transaction_required_required_exception_try();
    }

    @Test
    public void transaction_required_required_exception() {
        userTransactionTestService.transaction_required_required_exception();
    }

    @Test
    public void transaction_exception_required_required() {
        userTransactionTestService.transaction_exception_required_required();
    }

    @Test
    public void notransaction_exception_required_required() {
        userTransactionTestService.notransaction_exception_required_required();
    }

    @Test
    public void notransaction_required_required_exception() {
        userTransactionTestService.notransaction_required_required_exception();
    }
}
