package Algoritms_Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class AppTasks004_AnagrammaV2 {

    static ArrayList<String> listAnogramm = new ArrayList<>();

    public static void main(String[] args) {

        String input = "test";
        int size = input.length();

        System.out.println("Word = " + input + ", size = " + size);

        //Значение анограм равно значению факториала от количества букв в сдове
        //определеяем количесвто букв в коде
        int countWord = countAnogramms(input.length());
        System.out.println("countWord = " + countWord);

        HashSet<String> anorgams = getAnogram(input);
        System.out.println("anorgams = " + anorgams);
        System.out.println("anorgams.size = " + anorgams.size());

        System.out.println("listAnogramm = " + listAnogramm);
        System.out.println("listAnogramm.size = " + listAnogramm.size());

    }


    //Попытка решения не рекурсивным способом
    static HashSet<String> getAnogram(String str) {
        HashSet<String> anorgams = new HashSet<>();

        if (str.length() == 0) {
            return anorgams;
        } else if (str.length() == 1) {
            anorgams.add(str);
        } else {

            String temp = str;
            for(int i = 0; i< str.length(); i++){
                String iterableTemp="";
                iterableTemp = temp.substring(i) + temp.substring(0, i);
                anorgams.add(iterableTemp);
                listAnogramm.add(iterableTemp);
                for(int j = i+1; j< iterableTemp.length(); j++){
                    String firstPart = iterableTemp.substring(0, j);

                    String secondPart = iterableTemp.substring(j);
                    String result = secondPart + firstPart;
                    anorgams.add(result);
                    listAnogramm.add(result);
                }
            }
        }
        return anorgams;
    }





    static int countAnogramms(int n){
        if(n==0)
            return 1;
        else
            return (n * countAnogramms(n-1) );
    }

}
