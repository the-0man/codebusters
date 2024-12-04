import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String str = "hello world";
        Cipher test = new Cipher(str);
        System.out.println("Scrambled word: " + test.scramble());
        Scanner scan = new Scanner(System.in);
        String guess = "";
        while (!guess.equals(str))
        {
            System.out.print("Guess: ");
            guess = scan.nextLine();
        }
        System.out.println("You got it!");
    }
}