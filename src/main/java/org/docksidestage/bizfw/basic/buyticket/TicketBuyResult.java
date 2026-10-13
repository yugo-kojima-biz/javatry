package org.docksidestage.bizfw.basic.buyticket;


public class TicketBuyResult {

    public int price;
    public int change;
    public int remain; // test_class_moreFix_whetherTicketType()

    public Ticket getTicket()
    {
        return new Ticket(price);
    }
    public int getChange(){
        return change;
    }
}
