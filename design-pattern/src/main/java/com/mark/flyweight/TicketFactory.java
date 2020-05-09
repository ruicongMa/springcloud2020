package com.mark.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mark
 * @date 2020/5/8 11:50
 */
public class TicketFactory {

    private static Map<String, ITicket> ticketPool = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (ticketPool.containsKey(key)) {
            System.out.println("使用缓存：" + key);
            return ticketPool.get(key);
        }
        System.out.println("首次查询，创建对象：" + key);
        ITicket ticket = new TrainTicket(from, to);
        ticketPool.put(key, ticket);
        return ticket;
    }
}
