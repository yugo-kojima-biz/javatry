/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

// TODO kojima javadoc, author追加お願いします by jflute (2026/11/24)
// (他も見直してみてください)
/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;
    private static final int FOUR_DAY_PRICE = 22400;
    private static final int NIGHT_ONLY_TWO_DAY_PRICE = 7400;
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds; // null allowed: until first purchase
//    private Integer change;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }



    //    // back up
    //    // 在庫の量を一個減らしてhandedMoneyを売上？として計上する →お金足りなくても在庫あげちゃう？
    //    public void buyOneDayPassport(Integer handedMoney) {
    //        if (quantity <= 0) {
    //            throw new TicketSoldOutException("Sold out");
    //        }
    //        --quantity;
    //        if (handedMoney < ONE_DAY_PRICE) {
    //            throw new TicketShortMoneyException("Short money: " + handedMoney);
    //        }
    //        if (salesProceeds != null) { // second or more purchase
    //            salesProceeds = salesProceeds + handedMoney; // 釣り銭見てる？
    //        } else { // first purchase
    //            salesProceeds = handedMoney;
    //        }
    //    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    // you can rewrite comments for your own language by jflute
    // e.g. Japanese
    // /**
    // * 1Dayパスポートを買う、パークゲスト用のメソッド。
    // * @param handedMoney パークゲストから手渡しされたお金(金額) (NotNull, NotMinus)
    // * @throws TicketSoldOutException ブース内のチケットが売り切れだったら
    // * @throws TicketShortMoneyException 買うのに金額が足りなかったら
    // */
    // 在庫の量を一個減らしてhandedMoneyを売上？として計上する →お金足りなくても在庫あげちゃう？
    // ① test_class_letsFix_ticketQuantityReduction()
//    public void buyOneDayPassport(Integer handedMoney) {
//        if (quantity <= 0) {
//            throw new TicketSoldOutException("Sold out");
//        }
////        --quantity; // ①の修正
//        if (handedMoney < ONE_DAY_PRICE) {
//            throw new TicketShortMoneyException("Short money: " + handedMoney);
//        }
//        if (salesProceeds != null) { // second or more purchase
//            salesProceeds = salesProceeds + handedMoney; // 釣り銭見てる？
//            --quantity; // ①の修正
//        } else { // first purchase
//            salesProceeds = handedMoney;
//            --quantity; // ①の修正
//        }
//    }

    // ②test_class_letsFix_salesProceedsIncrease()
//    public void buyOneDayPassport(Integer handedMoney) {
//        if (quantity <= 0) {
//            throw new TicketSoldOutException("Sold out");
//        }
//        //        --quantity; // ①の修正
//        if (handedMoney < ONE_DAY_PRICE) {
//            throw new TicketShortMoneyException("Short money: " + handedMoney);
//        }
//        change = handedMoney - ONE_DAY_PRICE;
//        if (salesProceeds != null) { // second or more purchase
//            salesProceeds = salesProceeds + ONE_DAY_PRICE; // 釣り銭見てる？
//            --quantity; // ①の修正
//        } else { // first purchase
//            salesProceeds = ONE_DAY_PRICE;
//            --quantity; // ①の修正
//        }
//    }
//
//    public int buyTwoDayPassport(Integer handedMoney) {
//        if (quantity <= 0) {
//            throw new TicketSoldOutException("Sold out");
//        }
//        //        --quantity; // ①の修正
//        if (handedMoney < TWO_DAY_PRICE) {
//            throw new TicketShortMoneyException("Short money: " + handedMoney);
//        }
//        change = handedMoney - TWO_DAY_PRICE;
//        if (salesProceeds != null) { // second or more purchase
//            salesProceeds = salesProceeds + TWO_DAY_PRICE; // 釣り銭見てる？
//            --quantity; // ①の修正
//        } else { // first purchase
//            salesProceeds = TWO_DAY_PRICE;
//            --quantity; // ①の修正
//        }
//        return  change;
//    }


    // ③ test_class_letsFix_refactor_recycle()
//    public void buyOneDayPassport(Integer handedMoney) {
//        buyPassport(handedMoney,ONE_DAY_PRICE);
//    }

//    public int buyTwoDayPassport(Integer handedMoney) {
//        int change = buyPassport(handedMoney,TWO_DAY_PRICE);
//        return change;
//    }
//
//    public int buyPassport(Integer handedMoney, Integer PRICE){
//        if (quantity <= 0) {
//            throw new TicketSoldOutException("Sold out");
//        }
//        //        --quantity; // ①の修正
//        if (handedMoney < PRICE) {
//            throw new TicketShortMoneyException("Short money: " + handedMoney);
//        }
//        change = handedMoney - PRICE;
//        if (salesProceeds != null) { // second or more purchase
//            salesProceeds = salesProceeds + PRICE; // 釣り銭見てる？
//            --quantity; // ①の修正
//        } else { // first purchase
//            salesProceeds = PRICE;
//            --quantity; // ①の修正
//        }
//        return  change;
//    }

//    // *******:ここから**********
//
//    // done kojima 戻り値の不統一をどうにかしていきましょう by jflute (2026/10/19)
//    // #1on1: $戻り値の不統一、思いながら60分過ぎた (2026/10/19)
//    // "要件が曖昧なところがあれば、適切だと思われる仕様を決めても良いです"
//    // とあるので、統一しちゃって多いです。
//
//    // ④ test_class_moreFix_return_ticket()
//    public Ticket buyOneDayPassport(Integer handedMoney) {
//        buyPassport(handedMoney,ONE_DAY_PRICE);
//        return new Ticket(ONE_DAY_PRICE, 1);
//    }
//
//    public TicketBuyResult buyTwoDayPassport(Integer handedMoney) {
//        TicketBuyResult result = new TicketBuyResult();
//        int change = buyPassport(handedMoney,TWO_DAY_PRICE);
//        result.price = TWO_DAY_PRICE;
//        result.change = change;
//
//        return result;
//    }
//
//    // test_class_moreFix_usePluralDays()用
////    public Ticket buyTwoDayPassport(Integer handedMoney) {
////        buyPassport(handedMoney,TWO_DAY_PRICE);
////        return new Ticket(TWO_DAY_PRICE,2);
////    }
//
//    public Ticket buyFourDayPassport(Integer handedMoney) {
//        buyPassport(handedMoney,FOUR_DAY_PRICE);
//        return new Ticket(FOUR_DAY_PRICE,4);
//    }
//
//    public Ticket buyNightOnlyTwoDayPassport(Integer handedMoney) {
//        buyPassport(handedMoney,buyNightOnlyTwoDay_PRICE);
//        return new Ticket(buyNightOnlyTwoDay_PRICE,2,true);
//    }
//
//    // done kojima 引数変数の名前は、基本小文字キャメルケース by jflute (2026/10/19)
//    // $何かの補完に引きづられたかも
//    // $JavaとかKotlinとかのキャメルケースのムードにまだ慣れてない
//    // キャメルケース: seaLand               // 通じる
//    // スネークケース: sea_land or SEA_LAND  // 通じにくい (アンスコつなぎ)
//    // ケバブケース: sea-land or SEA-LAND    // ほぼ通じない (ハイフンつなぎ)
//    //
//    // プログラムでは、キャメルケースが使われることが多い。
//    // ただ、スネークケースも局所的に使われたり、言語によってはメインで使われたり。
//    // DBのカラム名とかもスネークケースが多い。
//    //
//    // done kojima 内部処理なので、publicじゃなくてOK, privateで by jflute (2026/10/19)
//    // $油断した...
//    // #1on1: publicのbuyとprivateのbuyの先頭文字を変えて区別するテクニック (2026/10/19)
//    // メソッド一覧で紛れるってのと、会話上「buyメソッド」と読んだ時に紛れるので...
//    // e.g. doBuyPassport(実処理をしてる感), internalBuyPassport
//    // done kojima ↑にならって、メソッド名を変えてみてください by jflute (2026/10/19)
//    // 先に名前で区別を意識したら、public/private間違えなくなるかも
//    public int buyPassport(Integer handedMoney, Integer PRICE){
//        if (quantity <= 0) {
//            throw new TicketSoldOutException("Sold out");
//        }
//        //--quantity; // ①の修正
//        if (handedMoney < PRICE) {
//            throw new TicketShortMoneyException("Short money: " + handedMoney);
//        }
//        change = handedMoney - PRICE;
//
//        // #1on1: 在庫を減らすのは、売上計上と同時が業務的には良いとの話Good (2026/10/19)
//        // done kojima --quantityは、分岐してもどっちも同じなので...ifの外(後ろ)に by jflute (2026/10/19)
//        // (tips: 空行を空けて、salesProceedsとquantityがセットの処理だよ感を出す)
//        if (salesProceeds != null) { // second or more purchase
//            salesProceeds = salesProceeds + PRICE; // 釣り銭見てる？
//            --quantity; // ①の修正
//        } else { // first purchase
//            salesProceeds = PRICE;
//            --quantity; // ①の修正
//        }
//
//        return  change;
//    }
//
//    // *******:ここまで書き直します↓**********

    // TODO kojima JavaDoc, 戻り値を追加したので、@returnを追加してみましょう by jflute (2026/11/24)
    /**
     * Buy one-day passport, method for park guest.
     * @param handedMoney The money (amount) handed over from park guest. (NotNull, NotMinus)
     * @throws TicketSoldOutException When ticket in booth is sold out.
     * @throws TicketShortMoneyException When the specified money is short for purchase.
     */
    public TicketBuyResult buyOneDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, ONE_DAY_PRICE, 1, false, Ticket.TicketType.ONE_DAY); // doの文脈...内部処理だからという記憶...
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, TWO_DAY_PRICE, 2, false, Ticket.TicketType.TWO_DAY); // doの文脈...内部処理だからという記憶...
    }

    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, FOUR_DAY_PRICE, 4, false, Ticket.TicketType.FOUR_DAY); // doの文脈...内部処理だからという記憶...
    }

    public TicketBuyResult buyNightOnlyTwoDayPassport(int handedMoney) {
        return doBuyPassport(handedMoney, NIGHT_ONLY_TWO_DAY_PRICE, 2, true, Ticket.TicketType.NIGHT_ONLY_TWO_DAY); // doの文脈...内部処理だからという記憶...
    }

    private TicketBuyResult doBuyPassport(int handedMoney, int price, int availableCount, boolean nightOnly, Ticket.TicketType type){ //内部処理→private!!!!!
        // done kojima インデントが変なので直しましょう by jflute (2026/11/05)
        // $なんで気づかなかったんだろう、AIに任せてるから意識が薄れてるかも
        // 自動フォーマッターが導入されていれば同じく意識は薄れたりするかも
        // 書いてる時のコード意識と、読んでる時のコード意識ってちょっと違うもの。
        // 出来上がった直後に、数秒でも読んでる時のコード意識になって見直す。
        // gitの差分をパッと見るのも手。(jfluteの場合はすぐできるようにショートカット設定してる)
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        // done kojima 変数のスコープはできるだけ短く by jflute (2026/11/05)
        // changeがupdatedSalesProceedsの計算で使えちゃったりするので間違いやすい。
        // また、updatedSalesProceedsで使ってるのかな？って少し思ってしまう。
        // キリがない話で０にすることはできないんだけど、
        // TicketとかTicketBuyResultがスコープ長いほうがマシ。
        // 間違って指定したときでもたいていコンパイルエラーになる。
        // intとかStringとかがスコープ長いと間違いやすい。
        //
        // さらにアドバンス: メソッド小分けしてさらにスコープノイズを減らすやり方。
        // メソッド名で業務処理を表現して、引数で必要な値を表現する。
        // メソッド小分けで変数のスコープをコントロールする。
        //
        // #1on1: updatedSalesProceedsはあってもいいけど、なくてもいい (2026/11/24)
        // というか変数を作らなくて良いなら作らないほうが良い。(もちろん見栄えのために作ってもいいんだけど)
        //int updatedSalesProceeds;
        //if (salesProceeds == null) {
        //    updatedSalesProceeds = price;
        //} else {
        //    updatedSalesProceeds = salesProceeds + price;
        //}
        //salesProceeds = updatedSalesProceeds;
        // ↓↓↓
        if (salesProceeds == null) {
            salesProceeds = price;
        } else {
            salesProceeds = salesProceeds + price;
        }
        // #1on1: $三項演算子を使って実装できるのか？ (2026/11/24)
        // e.g.
        // A. salesProceeds = salesProceeds == null ? price : salesProceeds + price;
        // B. salesProceeds = (salesProceeds == null ? 0 : salesProceeds) + price;
        // $三項演算子をよむのちょっとドキドキする
        // $5月の研修で初めて三項演算子を知った
        // あくまで個人の自由の許容範囲内ではあるけれども...
        // jfluteの感覚だと、このケースだとどちらかというと、三項演算子の方が少し込み入ってるので避けるかも。
        // まあ要は、三項演算子で書けるからといって必ず書くわけじゃない。見やすさを配慮して使ったり使わなかったり。
        // $足し算が入ってるから...
        // そうそうそうそうそうそうそう曹操。素晴らしい。そのとおり計算が入っているので込み入りやすい。
        // ただ選ぶだけの分岐なら三項演算子でもシンプルになるが計算が入ってるとちょっとややしくなりやすい。
        // なので以下みたいに分離して、足す値だけを導出するのに三項演算子を使うというのもありかも。
        //
        // B':
        // int addedProceeds = (salesProceeds == null ? 0 : salesProceeds);
        // salesProceeds = addedProceeds + price;
        //
        // でもまあ、そんなに積極的に三項演算子は使わなくても良いと思う。(みもふたもない)

        // #1on1: チケット発行して在庫を減らす、と考えたらこの二つが近しい仲 (2026/11/24)
        // $心が二つある(^^
        // $質問: createBuyResult()の中で --quantity できるか？
        // 文法的に可能。チケットの発行と在庫を減らしをもっと近しくするならそういう考え方もあり
        TicketBuyResult result = createBuyResult(handedMoney, price, availableCount, nightOnly, type);
        // #1on1: createBuyResult() のチケット発行と同時にやることにした (2026/11/24)
        //--quantity;

        return result;
    }

    private TicketBuyResult createBuyResult(int handedMoney, int price, int availableCount, boolean nightOnly, Ticket.TicketType type) {
        int change = calculateChange(handedMoney, price);
        Ticket ticket = issueTicket(price, availableCount, nightOnly, type);
        return new TicketBuyResult(ticket, change);
    }

    private int calculateChange(int handedMoney, int price) {
        return handedMoney - price;
    }

    private Ticket issueTicket(int price, int availableCount, boolean nightOnly, Ticket.TicketType type) {
        // #1on1: チケットの発行と在庫を減らしをもっと近しくする考え方をベースに一緒に実装 (2026/11/24)
        Ticket ticket = new Ticket(price, availableCount, nightOnly, type);
        --quantity;
        return ticket;
    }

// TODO kojima まだインデントが変なところあり by jflute (2026/11/24)
//ここから↓
        public static class TicketSoldOutException extends RuntimeException {

            private static final long serialVersionUID = 1L;

            public TicketSoldOutException(String msg) {
                super(msg);
            }
        }

        public static class TicketShortMoneyException extends RuntimeException {
// ここまで↑
        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
