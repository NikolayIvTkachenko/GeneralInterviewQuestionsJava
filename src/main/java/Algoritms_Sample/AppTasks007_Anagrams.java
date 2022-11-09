package Algoritms_Sample;

/*
...
Проверить, являются ли они анаграммами
abc bac
def fea
abcc bac
...
//анаграмма - литературный приём, состоящий в перестановке букв или звуков определённого слова (или словосочетания), ->
// -> что в результате даёт другое слово или словосочетание
*/

import java.util.ArrayList;

public class AppTasks007_Anagrams {

    public static void main(String[] args) {
        String left01 = "abc";
        String right01 = "bac";
        System.out.println("== TEST 01 ====");
        System.out.println("left01 = " + left01);
        System.out.println("right01 = " + right01);
        if (is_anagram(left01, right01).size() > 0){
            System.out.println("Is not anagrama");
        }else{
            System.out.println("Is anagrama");
        }

        String left02 = "def";
        String right02 = "fea";
        System.out.println("== TEST 02 ====");
        System.out.println("left02 = " + left02);
        System.out.println("right02 = " + right02);
        if (is_anagram(left02, right02).size() > 0){
            System.out.println("Is not anagrama");
        }else{
            System.out.println("Is anagrama");
        }

        String left03 = "abcc";
        String right03 = "bac";
        System.out.println("== TEST 03 ====");
        System.out.println("left03 = " + left03);
        System.out.println("right03 = " + right03);
        if (is_anagram(left03, right03).size() > 0){
            System.out.println("Is not anagrama");
        }else{
            System.out.println("Is anagrama");
        }
    }

    private static ArrayList<Character> is_anagram(String left, String right){
        System.out.println("is_anagram");
        ArrayList<Character> counters = new ArrayList<Character>();
        System.out.println("init counters = " + counters);
        for (Character c: left.toCharArray()){
            counters.add(c);
        }
        System.out.println("before counters = " + counters);

        for (Character c: right.toCharArray()){
            counters.remove(c);
        }
        System.out.println("after counters = " + counters);

        return counters;
    }

}
