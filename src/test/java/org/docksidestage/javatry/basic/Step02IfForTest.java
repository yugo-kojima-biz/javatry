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

import java.util.ArrayList;
import java.util.List;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of if-for. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step02IfForTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        if Statement
    //                                                                        ============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_if_basic() { // example, so begin from the next method
        int sea = 904;
        if (sea >= 904) {
            sea = 2001;
        }
        log(sea); // your answer? => 2001
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_else_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else {
            sea = 7;
        }
        log(sea); // your answer? => 7(o)
        // 等号が抜けたからif条件は満たさない　→　elseを見る
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (sea >= 904) {
            sea = 7;
        } else if (sea >= 903) {
            sea = 8;
        } else {
            sea = 9;
        }
        log(sea); // your answer? => 7(o)
        // elseで結合している条件式だから各条件は並列
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_nested() {
        boolean land = false;
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
            sea = sea++ * 2;
            // #1on1: ↓のelse if, もっと読み飛ばし実感するために、難しくした方が良いと思います(by こじまさん) (2026/08/17)
        } else if (land && sea >= 904) {
            sea = 7;
            sea = ++sea * 2;
        } else if (sea >= 903 || land) {
            if (sea % 2 == 0) {
                sea = sea++ * 2;
            }
            if (!land) {
                land = true; // ここを通ればseaは10である
            } else if (sea <= 903) {
                sea++;
            }
            if (sea < 1810) {
                sea = 8;
            }
        } else if (sea == 8) {
            sea++;
            land = false;
        } else {
            sea = 9;
        }
        if (sea >= 9 || (sea > 7 && sea < 9)) {
            sea--;
            if (sea % 2 == 1) {
                sea++;
            }
        }
        if (land) {
            sea = 10;
        }
        log(sea); // your answer? => 10(o)
        // 愚直に上から読んでた...
        // landが真ならという条件を先に読んでおけば読む時間を短くできた...
        // TODO kojima [いいね] そういうことを考えることができるのは素晴らしい。 by jflute (2026/08/17)
        // エクササイズとしては上から読んで目のトレーニングになりましたから、全然気にしないでOKです。

        // #1on1: 漠然読み (2026/08/17)
        // o 漠然読みで構造を把握する (全体像を見る)
        //  → 当たりが見えていくる (ギャンブルポイント)
        // o フォーカス読みで逆さ読み
        //  → この場合だと、landにフォーカスを当てて逆さ読みして、ギャンブルに勝つ
        //
        // もちろん、ギャンブルに負けることもある。(land結局falseだった)
        // でも、損はない。構造把握して、局所的に中身を追ったことで、改めて上から読んでも、
        // 前より早く正確に読めるようになっているはず。
        //
        // また、次のギャンブルポイントが見つかることもある。
        // 何回か負けても、０から読むよりは速い、ってことの方が多い。
        //
        // Q. $もっと構造が複雑なコードのケースの漠然読みのコツは？ (2026/08/17)
        // A. 構造をもうちょいマクロな視点に持っていって、
        // クラス構造、クラスの役割、クラス間のコラボレーション、を漠然読みして構造把握。
        // (このエクササイズの構造は、一つのメソッドないのプログラムのレイヤーだったけど)
        // Q. $ クラスの役割は？
        // A. Controller, Model, Service, ... などわりと世界的に汎用的な役割があったりするので、
        // そこから学んで入っていけば。ある程度現場独自の役割もあったりするけど、そこは先輩に聞いたり。
        // ぜひ step5 で感覚鍛えていきましょう。(クラス間のコラボレーションたっぷりやる) 
        //
        // 仮説思考みたいな考え方のコードの読み方。
        // TODO kojima [読み物課題] My Favorite Book: 仮説思考  by jflute (2026/08/17)
        // https://jflute.hatenadiary.jp/entry/20150111/kasetsu
    }

    // ===================================================================================
    //                                                                       for Statement
    //                                                                       =============
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_inti_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (int i = 0; i < stageList.size(); i++) {
            String stage = stageList.get(i);
            if (i == 1) {
                sea = stage;
            }
        }
        log(sea); // your answer? => dockside(o)
        // i番目のリストの要素を取得する関数だと解釈
        // 0からスタートのインデックスなら1に対応する要素を代入
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            sea = stage;
        }
        log(sea); // your answer? => magiclamp(o)
        // 最後まで代入し続けてループ終了　→ 一番最後の要素が入ったままだと推測
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_continueBreak() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
        log(sea); // your answer? => hangar(o)
        // continueで次のループにスキップ, hangarでループ終了
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_listforeach_basic() {
        List<String> stageList = prepareStageList();
        StringBuilder sb = new StringBuilder();
        stageList.forEach(stage -> {
            if (sb.length() > 0) {
                return;
            }
            if (stage.contains("i")) {
                sb.append(stage);
            }
        });
        String sea = sb.toString();
        log(sea); // your answer? => dockside(o)
        // docksideが条件を満たしてappend
        // 次のループ？でreturn(>0だから) → ループ終了と推測
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make list containing "a" from list of prepareStageList() and show it as log by loop. (without Stream API) <br>
     * (prepareStageList()のリストから "a" が含まれているものだけのリストを作成して、それをループで回してログに表示しましょう。(Stream APIなしで))
     */
    public void test_iffor_making() {
        // write if-for here
        List<String> stageList = prepareStageList();
        List<String> sb = new ArrayList<>();
        for (String stage : stageList) {
            if (stage.contains("a")) {
                sb.add(stage);
            }
        }
        for (String s : sb) {
            log(s);
        }
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Change foreach statement to List's forEach() (keep result after fix) <br>
     * (foreach文をforEach()メソッドへの置き換えてみましょう (修正前と修正後で実行結果が同じになるように))
     */
    public void test_iffor_refactor_foreach_to_forEach() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
        log(sea); // should be same as before-fix
    }

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        // write your code here
    }

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private List<String> prepareStageList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("broadway");
        stageList.add("dockside");
        stageList.add("hangar");
        stageList.add("magiclamp");
        return stageList;
    }
}
