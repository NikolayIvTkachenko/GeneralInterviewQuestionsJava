package Algoritms_Sample;

/*
Есть строка, в ней записаны слова через пробел: "abc de f"
Нужно in-place без использования дополнительной памяти изменить строку
Допускается добавлять несколько переменных
Проверка -> ["a", "b", " ", "f"] -> ["f", " ", "a", "b"]

Решение:
1 - сначала проходим по массиву символов и разворачиваем его
2 - проходим по массиву символов, определяем пробел как разделеитель и как границу слова
3 - разворачиваем слово в отдельном цикле, и переходим к следующему слову
*/


import java.util.Arrays;

public class AppTasks005_Change_String_In_place {

    public static void main(String[] args) {

        String strInput = "abc de f";
        strHandleRevertWords(strInput);

    }

    static void strHandleRevertWords(String str){
        char[] listChars = str.toCharArray();
        int start = 0;
        int end = listChars.length-1;
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println("before listChars = " + Arrays.toString(listChars));

        while(start<end){
            listChars = swapSymbol(start, end, listChars);
            start +=1;
            end -=1;
        }
        System.out.println("after listChars = " + Arrays.toString(listChars));

        start = 0;
        end = 0;
        int divider = end;
        while (start < listChars.length){
            while((end+1 < listChars.length) && (listChars[end+1] != ' ')){
                end += 1;
            }
            divider = end;
            System.out.println("end word -> end = " + end);
            while (start < end) {
                listChars = swapSymbol(start, end, listChars);
                start += 1;
                end -= 1;
            }
            start = end = divider + 2;
        }
        System.out.println("after N2 listChars = " + Arrays.toString(listChars));
    }


    static char[] swapSymbol(int i1, int i2, char[] chars){
        char cm = chars[i1];
        chars[i1] = chars[i2];
        chars[i2] = cm;
        return chars;
    }

}
