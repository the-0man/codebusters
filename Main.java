import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "helloworld";
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