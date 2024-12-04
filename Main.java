public class Main {
    public static void main(String[] args) {
        Cipher test = new Cipher("helloworld");
        System.out.println("Before scramble: " + test.getPlaintext());
        System.out.println("After scramble: " + test.scramble());
    }
}