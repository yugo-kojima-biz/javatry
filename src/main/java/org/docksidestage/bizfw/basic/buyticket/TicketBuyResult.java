package org.docksidestage.bizfw.basic.buyticket;

// #1on1: Resultという言葉、入れ物クラス感が強い (役所の青いトレー) (2026/10/19)
// もしTicketCreatorとかだったら、中でTicketを発行(new)しても違和感がない。
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
