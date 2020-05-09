package com.mark.flyweight;

/**
 * @author Mark
 * @date 2020/5/8 11:52
 */
public class Test {

    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("临汾西", "北京西");
        ticket.showInfo("动车");
        ticket = TicketFactory.queryTicket("临汾西", "北京西");
        ticket.showInfo("动车");
        ticket = TicketFactory.queryTicket("临汾西", "北京西");
        ticket.showInfo("动车");
    }
}
