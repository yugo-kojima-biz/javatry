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
package org.docksidestage.javatry.basic;

import org.docksidestage.bizfw.basic.buyticket.TicketBooth;
import org.docksidestage.bizfw.basic.buyticket.TicketBooth.TicketShortMoneyException;
import org.docksidestage.bizfw.basic.buyticket.Ticket; // 勝手にimportしていいものと判断しました
import org.docksidestage.bizfw.basic.buyticket.TicketBuyResult; // 勝手にimportしていいものと判断しました
import org.docksidestage.unit.PlainTestCase;
import java.time.LocalTime;

// 今回とっ散らかっています...

/**
 * The test of class. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう) <br>
 * 
 * If ambiguous requirement exists, you can determine specification that seems appropriate. <br>
 * (要件が曖昧なところがあれば、適切だと思われる仕様を決めても良いです)
 * 
 * @author jflute
 * @author yugo-kojima-biz
 */
public class Step05ClassTest extends PlainTestCase {

    // ===================================================================================
    //                                                                          How to Use
    //                                                                          ==========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_class_howToUse_basic() {
        // #1on1: 戻るの大事(^^。ぼくも command+option+← はよく使う (2026/10/05)
        // ちら見から戻るのにとても使える。今の時代、より一層読むためのショートカット重要と言える。
        TicketBooth booth = new TicketBooth(); // command+クリック→定義しているところまで飛べるが、command+option+←で前の場所に戻れるのを知った。というかredo undo?
        booth.buyOneDayPassport(7400);
        int sea = booth.getQuantity();
        log(sea); // your answer? => 9(o)
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_class_howToUse_overpay() {
        TicketBooth booth = new TicketBooth();
        booth.buyOneDayPassport(10000);
        Integer sea = booth.getSalesProceeds();
        log(sea); // your answer? => 10000(o) // 釣り銭見ていない設計、言い値？
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_class_howToUse_nosales() {
        TicketBooth booth = new TicketBooth();
        Integer sea = booth.getSalesProceeds();
        log(sea); // your answer? => null(o)
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_class_howToUse_wrongQuantity() {
        Integer sea = doTest_class_ticket_wrongQuantity();
        log(sea); // your answer? =>
        // always exception but none //こいついらん
        // Failed to buy one-day passport: money=7399
        // Short money: 7399
        // 9(x)
        //
        // exceptionを扱おうとした経験が少ない
        // 付け焼き刃...
        // fail()単体で実行するとどうなる
        // → なんか抽象バージョンみたいなのが書いてあった
        // → シンプルに同じ構造
        //
        //
        // ※throwとexceptionについて
        // 個人でやる時にはtailやlogとかprintで誤魔化しまくっていたので理解度がモザイク...
        //
        // ・throwについて
        // イメージ：returnとかbreakの兄弟みたいな...
        // #1on1: イメージGood, 途中中断を示すものということで近いと思います (2026/10/05)
        // o returnは戻り値で何かを戻す。
        // o throwは戻り値じゃない枠組みで何かを戻す(投げる)。
        // (戻り値以外のoutputが用意されている)
        //
        // continue：今回のループ処理を抜けて次のループに行く
        // break：loopとかswitch自体を抜けてloop/switchブロックの後ろに行く
        // return：今いるメソッドを抜けて呼び出し元に行く
        // ※ throw：処理自体抜けて対応するcatchに？
        // 下のfail()のみの場合はrunTest()のcatchまで遡った？
        // #1on1: TestCaseやPlainTestCaseなどのcatchを経由している。 (2026/10/05)
        // ただ、IDEのUnitTest実行の処理まで異常を伝えるために、再throwしている。
        // javatryではJUnitというUnitTestフレームワークを使っている。
        // それを拡張したUTFlute(jflute作)というフレームワークも使っている。
        // (JUnitとUTFluteがマージされたものみたいな感じ)
        //
        // catchがなかったら？
        // #1on1: Java自身がcatchをしてログを出したりするけど... (2026/10/05)
        // デフォルトの挙動だと実際のアプリでのデバッグでは使いづらいので、大抵アプリでしっかりcatchする。
        //
        // ・exceptionについて
        // throwable
        //  ├─ error?
        //  └─ exception?
        // ここで終了...
        // 
        /*
                           +-----------------+
                           |                 |
                  +------------------+       |
                  |     Throwable    | <>----+
                  +------------------+
                           △ 
                           ｜
            +------------------------------+
            |                              |
   +--------------------+        +-------------------+
   |       Error        |        |    Exception      |
   +--------------------+        +-------------------+
     NoSuchMethodError                    △ 
     OutOfMemoryError                     ｜
                           +------------------------------+
                           |                              |
                 +--------------------+        +-------------------+
                 |  RuntimeException  |        |    XxxException   |
                 +--------------------+        +-------------------+
                           △                 IOException, SQLException
                           ｜
                   NullPointerException            
                   IllegalStateException
         */
        // Throwable: Javaの文法的に投げることができるもの (事務的なクラス)
        // (Throwableを継承していないものはthrowできない)
        //
        // Exceptionという言葉とは？使ったことある？
        // $pythonでちょっと見かけた
        // 一般用語だけど、しょうっちゅう使う言葉じゃない。
        // 日本語としての "例外" という言葉を使うことはあっただろう。
        //
        // Errorという言葉とは？使ったことある？
        // $普通にある
        // 一般的にすでによく使われている言葉。
        //
        // ExceptionとErrorの概念的な違いは？
        // $目の前にカードが置いてあって...!? 400は例外？500はエラー？
        //
        // 例外ってダメなこと(状況)ですか？ $文脈によるかも
        // エラーってダメなこと(状況)ですか？ $勘弁してよ → ダメ
        //
        // 例外は正常ではないけど、ダメとも言えない(まだわからない)。
        // 良し悪しの判定をしていないレアケース。
        //
        // throwする側は、あくまで例外、どう呼ばれてるかわかんないから。
        // catch側(呼び出し)が、その例外を、「ああ、エラーでした」or「いやそのまま例外です」。
        // なので、例外の中にエラーも包含されているようなイメージ。
        // なのでなので、Javaとしては、例外という言葉を使ってthrowするようになっている。
        //
        // じゃあErrorクラスは？
        // throwする瞬間からエラーであることがわかりきってる状況。
        // o OutOfMemoryError, NoSuchMethodError
        // 続きは、step7にて。言語によって使う用語が違う話。(でも概念は同じ話)
    }

    //    public void test_class_howToUse_wrongQuantity(){
    //        fail("always exception but none");
    //        // => junit.framework.AssertionFailedError: always exception but none
    //        // ふむ...
    //        // ...
    //        //
    //        // 多分これでthrowableがalways exception but noneとして実行↓
    //        // postTestは名前の通りテスト後→テストが正常終了した時にのみ実行される
    //        // → 今回のfailが動かなかった時のそのままの説明
    //        //    protected void runTest() throws Throwable {
    //        //        try {
    //        //            super.runTest();
    //        //            postTest();
    //        //        } catch (Throwable e) { // to record in application log
    //        //            log("Failed to finish the test: " + xgetCaseDisp(), e);
    //        //            throw e;
    //        //        }
    //        //    }
    //    }

    private Integer doTest_class_ticket_wrongQuantity() {
        TicketBooth booth = new TicketBooth();
        int handedMoney = 7399;
        try {
            booth.buyOneDayPassport(handedMoney);
            fail("always exception but none");
        } catch (TicketShortMoneyException continued) {
            log("Failed to buy one-day passport: money=" + handedMoney, continued);
        }
        return booth.getQuantity();
    }

//    // backup
//    private Integer doTest_class_ticket_wrongQuantity() {
//        TicketBooth booth = new TicketBooth();
//        int handedMoney = 7399;
//        try {
//            booth.buyOneDayPassport(handedMoney);
//            fail("always exception but none");
//        } catch (TicketShortMoneyException continued) {
//            log("Failed to buy one-day passport: money=" + handedMoney, continued);
//        }
//        return booth.getQuantity();
//    }

    // ===================================================================================
    //                                                                           Let's fix
    //                                                                           =========
    /**
     * Fix the problem of ticket quantity reduction when short money. (Don't forget to fix also previous exercise answers) <br>
     * (お金不足でもチケットが減る問題をクラスを修正して解決しましょう (以前のエクササイズのanswerの修正を忘れずに))
     */
    public void test_class_letsFix_ticketQuantityReduction() {
        Integer sea = doTest_class_ticket_wrongQuantity();
        log(sea); // should be max quantity, visual check here
    }

    /**
     * Fix the problem of sales proceeds increased by handed money. (Don't forget to fix also previous exercise answers) <br>
     * (受け取ったお金の分だけ売上が増えていく問題をクラスを修正して解決しましょう (以前のエクササイズのanswerの修正を忘れずに))
     */
    public void test_class_letsFix_salesProceedsIncrease() {
        TicketBooth booth = new TicketBooth();
        booth.buyOneDayPassport(10000);
        Integer sea = booth.getSalesProceeds();
        log(sea); // should be same as one-day price, visual check here
    }

    /**
     * Make method for buying two-day passport (price is 13200). (which can return change as method return value)
     * (TwoDayPassport (金額は13200) も買うメソッドを作りましょう (戻り値でお釣りをちゃんと返すように))
     */
//    public void test_class_letsFix_makeMethod_twoday() {
//        // uncomment after making the method
//        TicketBooth booth = new TicketBooth();
//        int money = 14000;
//        int change = booth.buyTwoDayPassport(money);
//        Integer sea = booth.getSalesProceeds() + change;
////        Integer sea = change;
//        log(sea); // should be same as money
//
//        // and show two-day passport quantity here
//        log(booth.getQuantity());
//    }

    /**
     * Recycle duplicate logics between one-day and two-day by e.g. private method in class. (And confirm result of both before and after) <br>
     * (OneDayとTwoDayで冗長なロジックがあったら、クラス内のprivateメソッドなどで再利用しましょう (修正前と修正後の実行結果を確認))
     */
    public void test_class_letsFix_refactor_recycle() {
        TicketBooth booth = new TicketBooth();
        booth.buyOneDayPassport(10000);
        log(booth.getQuantity(), booth.getSalesProceeds()); // should be same as before-fix before:(9, 7400) → after:(9,7400)
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Now you cannot get ticket if you buy one-day passport, so return Ticket class and do in-park. <br>
     * (OneDayPassportを買ってもチケットをもらえませんでした。戻り値でTicketクラスを戻すようにしてインしましょう)
     */
    public void test_class_moreFix_return_ticket() {
        // uncomment out after modifying the method
        // 単語で選択するショートカットがintellijだと"control+G"...vscodeだと"command+d"だから慣れない...
//        TicketBooth booth = new TicketBooth();
//        Ticket oneDayPassport = booth.buyOneDayPassport(10000);
//        log(oneDayPassport.getDisplayPrice()); // should be same as one-day price
//        log(oneDayPassport.isAlreadyIn()); // should be false
//        oneDayPassport.doInPark();
//        log(oneDayPassport.isAlreadyIn()); // should be true
    }

    /**
     * Now also you cannot get ticket if two-day passport, so return class that has ticket and change. <br>
     * (TwoDayPassportもチケットをもらえませんでした。チケットとお釣りを戻すクラスを作って戻すようにしましょう)
     */
    public void test_class_moreFix_return_whole() {
        // uncomment after modifying the method
//        TicketBooth booth = new TicketBooth();
//        int handedMoney = 20000;
//        TicketBuyResult buyResult = booth.buyTwoDayPassport(handedMoney);
//        Ticket twoDayPassport = buyResult.getTicket();
//        int change = buyResult.getChange();
//        log(twoDayPassport.getDisplayPrice() + change); // should be same as money → 20000
    }

    /**
     * Now you can use only one in spite of two-day passport, so fix Ticket to be able to handle plural days. <br>
     * (TwoDayPassportなのに一回しか利用できません。複数日数に対応できるようにTicketを修正しましょう)
     */
    public void test_class_moreFix_usePluralDays() {
        // your confirmation code here
//        TicketBooth booth = new TicketBooth();
//        Ticket twoDayPassport = booth.buyTwoDayPassport(20000);
//        log(twoDayPassport.getDisplayPrice()); // should be same as one-day price
//        log(twoDayPassport.isAlreadyIn()); // should be false
//        twoDayPassport.doInPark();
//        log(twoDayPassport.isAlreadyIn()); // should be false
//        twoDayPassport.doInPark();
//        log(twoDayPassport.isAlreadyIn()); // should be true

    }

    /**
     * Accurately determine whether type of bought ticket is two-day passport or not by if-statement. (fix Ticket classes if needed) <br>
     * (買ったチケットの種別がTwoDayPassportなのかどうかをif文で正確に判定してみましょう。(必要ならTicketクラスたちを修正))
     */
    public void test_class_moreFix_whetherTicketType() {
        // uncomment when you implement this exercise
//        TicketBooth booth = new TicketBooth();
////        Ticket oneDayPassport = booth.buyOneDayPassport(10000);
////        showTicketIfNeeds(oneDayPassport);
//        TicketBuyResult buyResult = booth.buyTwoDayPassport(10000);
////        TicketBuyResult buyResult = booth.buyTwoDayPassport(20000); // 買えればちゃんと識別してる
//        Ticket twoDayPassport = buyResult.getTicket();
//        showTicketIfNeeds(twoDayPassport);
    }

    // uncomment when you implement this exercise
    private void showTicketIfNeeds(Ticket ticket) {
        if (ticket.getDisplayPrice() == 13200) { // write determination for two-day passport
            log("two-day passport");
        } else {
            log("other");
        }
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Fix it to be able to buy four-day passport (price is 22400). <br>
     * (FourDayPassport (金額は22400) のチケットも買えるようにしましょう)
     */
    public void test_class_moreFix_wonder_four() {
        // your confirmation code here
        TicketBooth booth = new TicketBooth();
        Ticket fourDayPassport = booth.buyFourDayPassport(25000);
        for (int i=0; i<5; i++){
            log(fourDayPassport.isAlreadyIn()); // should be false
            fourDayPassport.doInPark();
        }
    }

    /**
     * Fix it to be able to buy night-only two-day passport (price is 7400), which can be used at only night. <br>
     * (NightOnlyTwoDayPassport (金額は7400) のチケットも買えるようにしましょう。夜しか使えないようにしましょう)
     */
    public void test_class_moreFix_wonder_night() {
        // your confirmation code here
        TicketBooth booth = new TicketBooth();
        Ticket NightOnlyTwoDayPassport = booth.buyNightOnlyTwoDayPassport(25000);
        NightOnlyTwoDayPassport.doInPark(true); // isNight = true
        log(NightOnlyTwoDayPassport.isAlreadyIn());
//        NightOnlyTwoDayPassport.doInPark(false); // isNight = false
//        log(NightOnlyTwoDayPassport.isAlreadyIn());
//        NightOnlyTwoDayPassport.doInPark(isNightNow()); // isNight = ...今は？
//        log(NightOnlyTwoDayPassport.isAlreadyIn());
    }

    // 確認用
    private boolean isNightNow(){
        LocalTime now = LocalTime.now();
        LocalTime nightBegining = LocalTime.of(18, 0);
        LocalTime nightEnd = LocalTime.of(4, 0);
        return !now.isBefore(nightBegining) || now.isBefore(nightEnd); // isAfterはその時間を含まない？(よりも大きい">"?)
    }

    // ===================================================================================
    //                                                                         Bonus Stage
    //                                                                         ===========
    /**
     * Refactor the code to the best readable code you can think of. <br>
     * (自分の中で思う最高に可読性の高いコードにリファクタリングしてみましょう)
     */
    // 設問の意図を確認しておきたい...!
    public void test_class_moreFix_yourRefactoring() {
        // your confirmation code here
    }

    /**
     * Write intelligent JavaDoc comments seriously on the public classes/constructors/methods of the Ticket class. <br>
     * (Ticketクラスのpublicなクラス/コンストラクター/メソッドに、気の利いたJavaDocコメントを本気で書いてみましょう) <br>
     * <br>
     * Seriously → With the intention that the Ticket class (for example) becomes open source and is used by hundreds of people. <br>
     * (本気で → Ticketクラスが(例えば)オープンソースになって何百人の人から利用される想定のつもりで。)
     */
    public void test_class_moreFix_yourSuperJavaDoc() {
        // your confirmation code here
    }

    // ===================================================================================
    //                                                                         Devil Stage
    //                                                                         ===========
    /**
     * If your specification is to share inventory (quantity) between OneDay/TwoDay/...,
     * change the specification to separate inventory for each OneDay/TwoDay/.... <br>
     * (もし、OneDay/TwoDay/...で在庫(quantity)を共有する仕様になってたら、
     * OneDay/TwoDay/...ごとに在庫を分ける仕様に変えてみましょう)
     */
    public void test_class_moreFix_zonedQuantity() {
        // your confirmation code here
    }
}
