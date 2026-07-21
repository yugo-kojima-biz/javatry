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

import java.math.BigDecimal;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author yugo-kojima-biz
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? => mystic8null:mai(o)
        // MTGの時にチラッと見えてnullがそのまま文字列になるという知見を得た
        // done kojima ああ、見えちゃった苦笑。ごめんなさい by jflute (2026/07/16)
        // 以下java初学者用備忘録
        // ①関数？メソッド？
        // このページ中のこれ以降のメソッドについてStep01VariableTestクラスの中にあると言える。
        // なのでこのtest_variable_initial()は**method(メソッド)**である。(この関数の構成はなんだ？と思ったがそういえばclass(クラス)の中にあるので..
        // "static"がついている(ex: public static void main())とスタティックメソッドと呼ぶ
        // 今回は"ない"のでこれは**インスタンスメソッド**である
        // public...：外から呼び出し可能の意
        // done kojima [ふぉろー] 一応Java的には、オブジェクト指向の「振る舞い」をメソッドという言葉で表現しています by jflute (2026/07/16)
        // でもまあ、関数とメソッドという言葉は、昨今入り乱れてる印象ですね。ぼくも入り乱れます(^^。
        // #1on1: 一方で、関数というと、純粋に引数と戻り値だけの世界の振る舞いのことを指すこともある。 (2026/07/21)
        // 言語によって、その厳密性が変わってくる可能性はあります。
        //
        // Javaの世界の中で、純粋な関数に近いのが staticメソッドと言えるかも。
        // (C言語の名残、手続き型プログラミングの感覚を文法として残した)
        // (Kotlinでは、staticメソッドはない。代わりにCompanionObjectがある)
        //
        //
        // ②"... extends PlainTestCase"とは...
        // pythonにもあるクラス継承(あまり使ったことがない...)
        // ../../unit/PlainTestCaseにある"PlainTestCase"の一種であるというキーワード
        // 簡単に...すでにあるクラスの機能を使って新しいクラスを作ること
        // 今回だと...**log()**メソッドの呼び出し？
        // 特徴：
        // ・単一継承→一個まで(pythonは複数継承可能)
        // TODO done kojima Javaが単一継承なのはDiamond Problemが起こらないようにするためです。（興味あれば以下のWiki参考になると思います） by noniwa
        //   https://ja.wikipedia.org/wiki/%E8%8F%B1%E5%BD%A2%E7%B6%99%E6%89%BF%E5%95%8F%E9%A1%8C (AIに聞いた方がわかりやすいかも)
        //   PythonはC3 Linearizationというアルゴリズムを使って以上の問題を解決しているみたいですね。（JavaとPythonの思想の違いが出ていて面白い）
        // ・実装自体の再利用→オーバライド(上書き)可能
        // ・共通の振る舞いや状態の共有
        //
        // ③PlainTestCase自体の定義について
        // "public abstract class PlainTestCase extends TestCase {"
        // public...：外から呼び出し可能の意
        // abstract class...：抽象クラスであるということ
        // ...extends TestCase：また継承している
        //
        // TestCaseについて
        // ・JUnit (Java) や PHPUnit (PHP) などのフレームワークにおいて、テストクラスを作成する際の最も一般的な構文
        // ・"import junit.framework.TestCase;"で使用可能
        // ④→書き途中です
        // done kojima [いいね] 仕組みのところまで追求してるの素晴らしい(^^ by jflute (2026/07/16)
        // 1on1のときに気になったところあれば聞いてくれればお話ししますー。
        // #1on1: オブジェクト指向の話は、ちょうどstep6でがっつりやりますのでお楽しみに。 (2026/07/21)

        // #1on1: nullが文字列連携されたときに、"null"ってなるのか空文字になるのか？ (2026/07/21)
        // 言語の決めの問題。Javaが "null" って表現するって決めただけ、C#は空文字になる。
        // 一応メリデメ:
        // Javaの場合、画面やメール文言に "null" で表示されやすい問題がある。
        // 一方で、画面やログとかで "null" って出てくるので、開発時は不具合を見つけやすい。
        // どっちもどっち。
        // 些細なことだけど、こうやってメリデメを考える習慣自体が大事。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic"; // "mystic"インスタンスがnewされて、アドレスがseaに (1丁目1番地)
        String land = "oneman"; // "oneman"インスタンスがnewされて、アドレスがlandに (2丁目2番地)
        sea = land; // seaの1丁目1番地の紙を破棄して、landの2丁目2番地の紙をコピーする
        // この瞬間、seaとlandが同じインスタンスを指し示すことになる。
        land = land + "'s dreams"; // "'s dreams"で3丁目3番地、"oneman's dreams"で4丁目4番地
        // "'s dreams"は変数で受け取ってないので、中間成果物インスタンスみたいなイメージ。
        log(sea); // your answer? => oneman(o)
        // 代入の感覚で

        // #1on1: インスタンスとは？ (2026/07/21)
        // 学生時代、インスタンスという言葉、使っていたはず... by こじまさん
        // ここでは、4つのStringインスタンスがnewされて存在している。
        // インスタンスに注目してプログラムを見ていってほしい。

        // #1on1: 変数とは？変数のインスタンスの関係性 (2026/07/21)
        // "代入の感覚で" は sea = land; のところだった。
        // 1行1行辿ってみた。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415(o)
        // 値が独立していると判断
        // done kojima [いいね] プリミティブ型は値そのものが変数の中に入ってると考えて良いです by jflute (2026/07/16)
        // 言語によっては、intもオブジェクトだったりするので、ここはJavaならでは (2026/07/21)
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94);
        BigDecimal land = new BigDecimal(415);
        sea = land;
        sea = land.add(new BigDecimal(1));
        sea.add(new BigDecimal(1));
        log(sea); // your answer? => 417(x)
        // int は値そのもの
        // BigDecimal はオブジェクト
        // land.add(new BigDecimal(1)) は、
        // land に 1 を足した結果を作る
        // かつBigDecimal は immutable（不変）
        //
        // sea.add(new BigDecimal(1)) は、
        // sea に 1 を足した結果の新しい BigDecimal を返す
        // でも、その返り値をどこにも代入していない
        // TODO done kojima immutableという概念がでてきたの素晴らしいと思います！ by noniwa
        //   Primitive型とObject型は変数で保持しているものが違うので注意ですね。
        //   https://qiita.com/pike3/items/4401f4f652871546cedd

        // done kojima [いいね] 分析しっかりできています by jflute (2026/07/16)

        // TODO jflute 1on1にてimmutableじっくりフォロー予定、add()のコードも読みたい (2026/07/16)
        // ↑これはくぼ用の備忘録とぅどぅなのでそのままでOKです
        // #1on1: immutableという言葉が聞いたことあるか？ (2026/07/21)
        // プログラミング以外で immutable は聞いたことある。課題とかでimmutableが出てきたような...
        // まあ次回じっくりimmutableのお話をしますね。
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => instanceBroadway(x)
        // String piari = null;
        // みたいになると思った
        // private String instanceBroadway;
        // という宣言？が上にあって暗黙的に？nullがデフォルトで入っている？
        // TODO kojima 合ってます！変数を宣言したけど、初期化していないのでどのメモリアドレスも参照していない状態、つまりnullになっています。 by noniwa
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => 
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => 
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => 
    }

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    public void test_variable_writing() {
        // define variables here
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_variable_yourExercise() {
        // write your code here
    }
}
