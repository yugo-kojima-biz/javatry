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
    private static final int buyNightOnlyTwoDay_PRICE = 7400;
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds; // null allowed: until first purchase
    private Integer change;

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
    /**
     * Buy one-day passport, method for park guest.
     * @param handedMoney The money (amount) handed over from park guest. (NotNull, NotMinus)
     * @throws TicketSoldOutException When ticket in booth is sold out.
     * @throws TicketShortMoneyException When the specified money is short for purchase.
     */
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

    // TODO kojima 戻り値の不統一をどうにかしていきましょう by jflute (2026/10/19)
    // #1on1: $戻り値の不統一、思いながら60分過ぎた (2026/10/19)
    // "要件が曖昧なところがあれば、適切だと思われる仕様を決めても良いです"
    // とあるので、統一しちゃって多いです。
    
    // ④ test_class_moreFix_return_ticket()
    public Ticket buyOneDayPassport(Integer handedMoney) {
        buyPassport(handedMoney,ONE_DAY_PRICE);
        return new Ticket(ONE_DAY_PRICE, 1);
    }

    public TicketBuyResult buyTwoDayPassport(Integer handedMoney) {
        TicketBuyResult result = new TicketBuyResult();
        int change = buyPassport(handedMoney,TWO_DAY_PRICE);
        result.price = TWO_DAY_PRICE;
        result.change = change;

        return result;
    }

    // test_class_moreFix_usePluralDays()用
//    public Ticket buyTwoDayPassport(Integer handedMoney) {
//        buyPassport(handedMoney,TWO_DAY_PRICE);
//        return new Ticket(TWO_DAY_PRICE,2);
//    }

    public Ticket buyFourDayPassport(Integer handedMoney) {
        buyPassport(handedMoney,FOUR_DAY_PRICE);
        return new Ticket(FOUR_DAY_PRICE,4);
    }

    public Ticket buyNightOnlyTwoDayPassport(Integer handedMoney) {
        buyPassport(handedMoney,buyNightOnlyTwoDay_PRICE);
        return new Ticket(buyNightOnlyTwoDay_PRICE,2,true);
    }

    // TODO kojima 引数変数の名前は、基本小文字キャメルケース by jflute (2026/10/19)
    // $何かの補完に引きづられたかも
    // $JavaとかKotlinとかのキャメルケースのムードにまだ慣れてない
    // キャメルケース: seaLand               // 通じる
    // スネークケース: sea_land or SEA_LAND  // 通じにくい (アンスコつなぎ)
    // ケバブケース: sea-land or SEA-LAND    // ほぼ通じない (ハイフンつなぎ)
    //
    // プログラムでは、キャメルケースが使われることが多い。
    // ただ、スネークケースも局所的に使われたり、言語によってはメインで使われたり。
    // DBのカラム名とかもスネークケースが多い。
    //
    // TODO kojima 内部処理なので、publicじゃなくてOK, privateで by jflute (2026/10/19)
    // $油断した...
    // #1on1: publicのbuyとprivateのbuyの先頭文字を変えて区別するテクニック (2026/10/19)
    // メソッド一覧で紛れるってのと、会話上「buyメソッド」と読んだ時に紛れるので...
    // e.g. doBuyPassport(実処理をしてる感), internalBuyPassport
    // TODO kojima ↑にならって、メソッド名を変えてみてください by jflute (2026/10/19)
    // 先に名前で区別を意識したら、public/private間違えなくなるかも
    public int buyPassport(Integer handedMoney, Integer PRICE){
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        //--quantity; // ①の修正
        if (handedMoney < PRICE) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        change = handedMoney - PRICE;

        // #1on1: 在庫を減らすのは、売上計上と同時が業務的には良いとの話Good (2026/10/19)
        // TODO kojima --quantityは、分岐してもどっちも同じなので...ifの外(後ろ)に by jflute (2026/10/19)
        // (tips: 空行を空けて、salesProceedsとquantityがセットの処理だよ感を出す)
        if (salesProceeds != null) { // second or more purchase
            salesProceeds = salesProceeds + PRICE; // 釣り銭見てる？
            --quantity; // ①の修正
        } else { // first purchase
            salesProceeds = PRICE;
            --quantity; // ①の修正
        }

        return  change;
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

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
