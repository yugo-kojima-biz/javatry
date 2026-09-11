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

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of method. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author yugo-kojima-biz
 */
public class Step04MethodTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Method Call
    //                                                                         ===========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_method_call_basic() {
        String sea = supplySomething();
        log(sea); // your answer? =>
        // in supply: over
        // mystic
        // (o)
        //
        // ==================================================================
        // logの中身：
        // while (strMsg != null && strMsg.contains("{}")) { 　　　======> **msgs内に{} がある時に特殊な動き**
        //                    if (arrayLength <= nextIndex) {
        //                        break;
        //                    }
        //                    final Object nextObj = msgs[nextIndex];
        //                    final String replacement;
        //                    if (nextObj != null) {
        //                        // escape two special characters of replaceFirst() to avoid illegal group reference
        //                        replacement = Srl.replace(Srl.replace(nextObj.toString(), "\\", "\\\\"), "$", "\\$");
        //                    } else {
        //                        replacement = "null";
        //                    }
        //                    strMsg = strMsg.replaceFirst("\\{\\}", replacement); ==> **"{}" → "<replacement>"**
        //
        // ↓↓↓
        // public String replaceFirst(String regex, String replacement) {
        //        return Pattern.compile(regex).matcher(this).replaceFirst(replacement);
        //    }
        // ↓↓↓
        // replacefirstの説明
        //
        // Given the regular expression dog, the input "zzzdogzzzdogzzz",
        // and the replacement string "cat",
        // an invocation of this method on a matcher for that expression would yield the string "zzzcatzzzdogzzz".
        //
        // @Contract(mutates = "this")
        //public String replaceFirst(
        //    @NotNull   String replacement
        //)
        //
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_call_many() {
        String sea = functionSomething("mystic"); // mystic → mysmys(reutrn) log１回目
        consumeSomething(supplySomething()); // log2回目 → consumeSomething(over(return)){overをmysticに変えてlog3回目}
        runnableSomething(); // log4回目
        log(sea); // your answer? =>
        // in function mysmys
        // in supply over
        // in consume mystic
        // in runnable outofshadow
        // mysmys
        // (o)
    }

    private String functionSomething(String name) {
        String replaced = name.replace("tic", "mys");
        log("in function: {}", replaced);
        return replaced;
    }

    private String supplySomething() {
        String sea = "over";
        log("in supply: {}", sea);
        return sea;
    }

    private void consumeSomething(String sea) {
        log("in consume: {}", sea.replace("over", "mystic"));
    }

    private void runnableSomething() {
        String sea = "outofshadow";
        log("in runnable: {}", sea);
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_object() {
        St4MutableStage mutable = new St4MutableStage();
        int sea = 904;
        boolean land = false;
        helloMutable(sea - 4, land, mutable); // 904のまま(なはず！) mutable(定義した瞬間にstageNameに？→"x",定義してるタイミングがないなら"null")って名前がmysticに？
        if (!land) {
            sea = sea + mutable.getStageName().length(); // landもfalseのままだから904+6("mysitc")
        }
        log(sea); // your answer? => 910(o)
    }

    private int helloMutable(int sea, Boolean land, St4MutableStage piari) {
        sea++;
        land = true;
        piari.setStageName("mystic");
        return sea;
    }

    private static class St4MutableStage {

        private String stageName;

        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private int inParkCount;
    private boolean hasAnnualPassport;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_instanceVariable() {
        hasAnnualPassport = true;
        int sea = inParkCount;
        offAnnualPassport(hasAnnualPassport);
        for (int i = 0; i < 100; i++) {
            goToPark();
        }
        ++sea;
        sea = inParkCount;
        log(sea); // your answer? =>　0(x) // インスタンス変数!!1!!(小慣れて確認を怠るフェーズに入っている...)
    }

    private void offAnnualPassport(boolean hasAnnualPassport) {
        hasAnnualPassport = false;
    }

    private void goToPark() {
        if (hasAnnualPassport) {
            ++inParkCount;
        }
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    // write instance variables here
    /**
     * Make private methods as followings, and comment out caller program in test method:
     * <pre>
     * o replaceAwithB(): has one argument as String, returns argument replaced "A" with "B" as String 
     * o replaceCwithB(): has one argument as String, returns argument replaced "C" with "B" as String 
     * o quote(): has two arguments as String, returns first argument quoted by second argument (quotation) 
     * o isAvailableLogging(): no argument, returns private instance variable "availableLogging" initialized as true (also make it separately)  
     * o showSea(): has one argument as String argument, no return, show argument by log()
     * </pre>
     * (privateメソッドを以下のように定義して、テストメソッド内の呼び出しプログラムをコメントアウトしましょう):
     * <pre>
     * o replaceAwithB(): 一つのString引数、引数の "A" を "B" に置き換えたStringを戻す 
     * o replaceCwithB(): 一つのString引数、引数の "C" を "B" に置き換えたStringを戻す 
     * o quote(): 二つのString引数、第一引数を第二引数(引用符)で囲ったものを戻す 
     * o isAvailableLogging(): 引数なし、privateのインスタンス変数 "availableLogging" (初期値:true) を戻す (それも別途作る)  
     * o showSea(): 一つのString引数、戻り値なし、引数をlog()で表示する
     * </pre>
     */
    public void test_method_making() {
        // use after making these methods
        String replaced = replaceCwithB(replaceAwithB("ABC"));
        String sea = quote(replaced, "'");
        if (isAvailableLogging()) {
            showSea(sea);
        }
    }

    // write methods here
    private String replaceAwithB(String str) {return str.replace("A","B");}
    private String replaceCwithB(String str) {return str.replace("C","B");}
    private String quote(String str, String quotation) {return (quotation+str+quotation);}
    private boolean availableLogging = true;
    private boolean isAvailableLogging() {return availableLogging;}
    private void showSea(String sea) {log(sea);}
//    private String replaceAwithB(String str) {log(str.replace("A","B"));return str.replace("A","B");}
//    private String replaceCwithB(String str) {log(str.replace("C","B")); return str.replace("C","B");}
//    private String quote(String str1, String str2) {log((str2+str1+str2)); return (str2+str1+str2);}
//    private boolean availableLogging = true;
//    private boolean isAvailableLogging() {log(availableLogging); return availableLogging;}


}
