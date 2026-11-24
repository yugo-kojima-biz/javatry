package org.docksidestage.bizfw.basic.buyticket;

// TODO kojima javadoc, author追加お願いします by jflute (2026/11/24)
// ここは新しいクラスで概念もわかりにくいので、1行概要こめんとも入れておきましょう

// #1on1: Resultという言葉、入れ物クラス感が強い (役所の青いトレー) (2026/10/19)
// もしTicketCreatorとかだったら、中でTicketを発行(new)しても違和感がない。
public final class TicketBuyResult {

    private final Ticket ticket;
    // TODO kojima このprice変数は使ってないので削除でOK (しかもpublic) by jflute (2026/11/24)
    public int price;
    private final int change;

    public TicketBuyResult(Ticket ticket, int change){
        if (ticket == null){
            throw new NullPointerException("ticket");
        }
        this.ticket = ticket;
        this.change = change;
    }

    // TODO kojima 括弧を統一 by jflute (2026/11/24)
    public Ticket getTicket()
    {
        return ticket;
    }
    public int getChange(){
        return change;
    }
}
