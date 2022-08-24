package algoritms_basis;

public class Algoritm_IsPolidrome {

    public static void main(String[] args) {

        String text01 = "MERREM";
        String text02 = "MERKREM";
        String text03 = "MLRREM";

        System.out.println("Text 01: " + (isPalidrome(text01) ? "YES" : "NO"));
        System.out.println("Text 02: " + (isPalidrome(text02) ? "YES" : "NO"));
        System.out.println("Text 03: " + (isPalidrome(text03) ? "YES" : "NO"));
    }


    private static boolean isPalidrome(String message) {
        if (message.length() == 1 || message.length() == 0) return true;

        if (message.charAt(0) == message.charAt(message.length()-1)) {
            return isPalidrome(message.substring(1, message.length()-1));
        }
        return false;
    }

}
