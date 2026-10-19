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
    private final int displayPrice; // written on ticket, park guest can watch this
    private boolean alreadyIn; // true means this ticket is unavailable
    private int availableCount; // 追加
    private boolean nightOnly; // 追加

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    // TODO kojima OneDayのとき、availableCountが最後-1で終わるのが不統一 by jflute (2026/10/19)
    // そもそも availableCount の初期値が OneDay だと 0 になるのがズレの原因。
    // $TwoDayがこれを使ってるのを知らないで書いてたかも...
    // BuyResultクラスのgetterの中でnewしてしまっているから、そこがわかりにくくなってる。
    // あまりResultのような入れ物クラスの中でオブジェクトを作り出すってのはやらないので、
    // 素直にBuyResultクラスを使う時も、Ticketのnewは、TicketBoothの中で良いかなと。
    public Ticket(int displayPrice) { // for OneDay, TwoDay
        this.displayPrice = displayPrice;
    }
    // コンストラクタをオーバーロード(小声)...
    // 引数の型や数が違うと使える...?
    // 戻り値の型を変えただけではできない..?
    public Ticket(int displayPrice, int availableCount) { // for FourDay
        this.displayPrice = displayPrice;
        this.availableCount = availableCount;
    }

     // #1on1: nightOnly専用のコンストラクター
    public Ticket(int displayPrice, int availableCount, boolean nightOnly) { // for NightOnly
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

    public void doInPark(boolean isNight) {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        if (nightOnly && !isNight) {
            throw new IllegalStateException("This ticket can only be used at night");
        }
        if (availableCount <= 1){
            alreadyIn = true;
        }
        availableCount --;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
