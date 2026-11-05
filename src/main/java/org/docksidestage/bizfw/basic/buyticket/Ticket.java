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

// #1on1: 時間が空いても、続きの作業をスムーズにできるようにするのもトレーニング (2026/10/19)
/**
 * @author jflute
 */
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // TODO kojima nightOnlyは、状態じゃなくて固定データ、finalを付けてもいいかなと by jflute (2026/11/05)
    // インスタンス変数には大きく、固定データ(マスター)と状態データがある。
    private final int displayPrice; // written on ticket, park guest can watch this
    private boolean alreadyIn; // true means this ticket is unavailable
    private int availableCount; // 追加
    private boolean nightOnly; // 追加

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    // done kojima OneDayのとき、availableCountが最後-1で終わるのが不統一 by jflute (2026/10/19)
    // そもそも availableCount の初期値が OneDay だと 0 になるのがズレの原因。
    // $TwoDayがこれを使ってるのを知らないで書いてたかも...
    // BuyResultクラスのgetterの中でnewしてしまっているから、そこがわかりにくくなってる。
    // あまりResultのような入れ物クラスの中でオブジェクトを作り出すってのはやらないので、
    // 素直にBuyResultクラスを使う時も、Ticketのnewは、TicketBoothの中で良いかなと。
//    public Ticket(int displayPrice) { // for OneDay, TwoDay
//        this.displayPrice = displayPrice;
//    }
    // コンストラクタをオーバーロード(小声)...
    // 引数の型や数が違うと使える...?
    // 戻り値の型を変えただけではできない..?
//    public Ticket(int displayPrice, int availableCount) { // for FourDay
//        this.displayPrice = displayPrice;
//        this.availableCount = availableCount;
//    }

    // ↓↓↓↓↓こっちにまとめる↓↓↓↓↓

    public Ticket(int displayPrice, int availableCount, boolean nightOnly) {
        this.displayPrice = displayPrice;
        this.availableCount = availableCount;
        this.nightOnly = nightOnly;
    }


    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        if (availableCount <= 1){
            alreadyIn = true;
        }
        availableCount --;
    }

    // TODO kojima 修行++: isNightを引数で受け取らず、現在夜かどうかはメソッド内で解決しましょう by jflute (2026/11/05)
    // isNightはisNightNowというニュアンス、現在夜かどうか？という判定。
    // これは、呼び出し側がつど指定する必要性が本来ないはず。
    // 現在夜かどうか？は使う人によって変わるものじゃない。
    // し、使う人が細工していいものではない。
    // って考えると、現在夜かどうか？は doInPark() の中で閉じて解決したいところ。
    // だけど、そうすると UnitTest で確認がしづらくなりますので、そこをどうにか。
    // (UnitTest の実行時間によらず、夜呼び出しと昼呼び出しの動作確認をできるようにしたい)
    
    // TODO kojima どうせNightのときにしか使わないメソッド by jflute (2026/11/05)
    // Nightチケットで夜だったら入れて、昼だったら入れないを表現するメソッド。
    // doInParkNightOnly(isNight) という感じで夜チケット専用のメソッドって明示したほうがわかりやすいかも。
    public void doInPark(boolean isNight) {
        // TODO kojima  || availableCount <= 0 は現状 "念のため" チェックになっている by jflute (2026/11/05)
        // 入れてもいいけどなくてもいい。doInPark()とdoInPark(isNight)で統一しましょう。
        // availableCountの判定を残すなら、コメントで「availableCountの判定は念のため」って欲しい。
        if (alreadyIn || availableCount <= 0) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        if (nightOnly && !isNight) {
            throw new IllegalStateException("This ticket can only be used at night");
        }
        // TODO kojima doInPark()と結果は同じだけど処理の仕方が違うの不統一なので統一しましょう by jflute (2026/11/05)
        availableCount --;
        if (availableCount == 0){
            alreadyIn = true;
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    // #1on1: いいね、alreadyInの概念をしっかりキープしている (2026/11/05)
    // $決めちゃえばいいかなと、動き変だなと思ったらそのとき考えればいいかなと
    // $いやコメント読んでた (コメント見て思い出した)
    // OneDayのみ時代とTwoDayで複数日数対応した時代で、概念を細かく分けないといけなくなる話。
    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
