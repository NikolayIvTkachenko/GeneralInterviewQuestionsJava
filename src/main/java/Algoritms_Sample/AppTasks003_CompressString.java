package Algoritms_Sample;

/*
Дана строка (возможно пустая ), содержащая только в верхнем регистре буквы A-Z
AAAABBBCCXYZDDDDEEEEFFFFFAAAAAAABBBBBBBBBBBBBBBBBBNNNNNN
Нужно записать строку вида
A4B3C2XYZD4E4F5A7B18N6
Выдавать ошибку , если на ввод приходит недопустимая строка
- Если символ встречается один раз, он остаетс неизменным
- Если символ встречается более одногь раза, к нему добавляется число повторнеий
 */


import java.util.Arrays;

public class AppTasks003_CompressString {

    public static void main(String[] args) {

        String strInput = "AAAABBBCCXYZDDDDEEEEFFFFFAAAAAAABBBBBBBBBBBBBBBBBBNNNNNN";

        handleCompressString(strInput);

        handleCompressStringV2(strInput);

        strInput = "AAB";
        handleCompressStringV3(strInput);

    }

    static void handleCompressStringV3(String str) {
        System.out.println("handleCompressStringV3");
        StringBuilder stringBuilder = new StringBuilder();
        char valueChar = ' ';
        int counter = 0;
        char[] charStr = str.toCharArray();
        for (char c: charStr){
            if(c != valueChar){
                stringBuilder.append(valueChar);
                if(counter>1) stringBuilder.append(counter);
                valueChar = c;
                counter = 0;
                counter+=1;
            } else {
                counter+=1;
            }
        }
        stringBuilder.append(valueChar);
        if(counter>1) stringBuilder.append(counter);

        System.out.println("stringBuilder = " + stringBuilder);
    }


    //Работает корректно, оптимизировать
    static void handleCompressStringV2(String str) {
        System.out.println("handleCompressStringV2");
        StringBuilder stringBuilder = new StringBuilder();
        char valueChar = ' ';
        int counter = 0;
        char[] charStr = str.toCharArray();
        System.out.println("charStr = " + Arrays.toString(charStr));
        for(int i = 0; i<charStr.length; i++){
            if(i == 0) {
                valueChar = charStr[i];
                counter+=1;
            } else if (i == charStr.length-1) {
                if(valueChar != charStr[i]){
                    stringBuilder.append(valueChar);
                }else{
                    counter+=1;
                    stringBuilder.append(valueChar);
                    if(counter>1) stringBuilder.append(counter);
                }
            }else {
                if(valueChar != charStr[i]){
                    stringBuilder.append(valueChar);
                    if(counter>1) stringBuilder.append(counter);
                    counter = 0;
                    valueChar = charStr[i];
                    counter+=1;
                } else{
                    counter+=1;
                }
            }
        }

        System.out.println("stringBuilder = " + stringBuilder);
    }


    //handleCompressString
    //stringBuilder = A4B3C2XYZD4E4F5A7B18
    //не отрабатывает последний символ
    static void handleCompressString(String str){
        System.out.println("handleCompressString");
        StringBuilder stringBuilder = new StringBuilder();
        char valueChar = ' ';
        int counter = 0;
        for (char c: str.toCharArray()){
            if (valueChar != c){
                if(valueChar != ' '){
                    stringBuilder.append(valueChar);
                    if(counter>1){
                        stringBuilder.append(counter);
                    }
                }
                counter = 0;
            }
            valueChar = c;
            counter += 1;

        }
        System.out.println("stringBuilder = " + stringBuilder);
    }

}
