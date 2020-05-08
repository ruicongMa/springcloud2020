package com.mark.decorator.v2;

/**
 * @author Mark
 * @date 2020/5/7 15:15
 */
public class BatterCakeTest {

    public static void main(String[] args) {
        BatterCake batterCake;
        //路边摊买一个煎饼
        batterCake = new BaseBatterCake();
        //煎饼有点少，想再加一个鸡蛋
        batterCake = new EggDecorator(batterCake);
        //再加一个鸡蛋
        batterCake = new EggDecorator(batterCake);
        //不行，还是觉得有些少，再加根香肠
        batterCake = new SausageDecorator(batterCake);

        //装饰器更多考虑是扩展
        System.out.println(batterCake.getMsg() + "，总价：" + batterCake.getPrice());
    }
}
