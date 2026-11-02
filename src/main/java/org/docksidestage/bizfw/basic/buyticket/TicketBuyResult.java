package org.docksidestage.bizfw.basic.buyticket;

// #1on1: Resultという言葉、入れ物クラス感が強い (役所の青いトレー) (2026/10/19)
// もしTicketCreatorとかだったら、中でTicketを発行(new)しても違和感がない。
public final class TicketBuyResult {

    private final Ticket ticket;
    public int price;
    private final int change;

    public TicketBuyResult(Ticket ticket, int change){
        if (ticket == null){
            throw new NullPointerException("ticket");
        }
        this.ticket = ticket;
        this.change = change;
    }


    public Ticket getTicket()
    {
        return ticket;
    }
    public int getChange(){
        return change;
    }
}
