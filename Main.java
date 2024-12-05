import java.util.Scanner;
import java.io.*;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String line = "";
        String splitBy = "\t";
        String author = null;
        String quote = null;
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("English_Quotes.tsv"));
            int rand = ((int) (Math.random() * 1733) + 2);
            for (int i = 1; i < 1734; i++)
            {
                line = br.readLine();
                if (i == rand)   //returns a Boolean value
                {
                    String[] fullQuote = line.split(splitBy);    // use comma as separator
                    author = fullQuote[0];
                    quote = fullQuote[1];
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        quote = quote.toLowerCase();
        Cipher test = new Cipher(quote);
        System.out.println("Author: " + author);
        System.out.println(quote);
        System.out.println("Scrambled quote: " + test.scramble());
        Scanner scan = new Scanner(System.in);
        String guess = "";
        while (!guess.equals(quote))
        {
            System.out.print("Guess: ");
            guess = scan.nextLine();
        }
        System.out.println("You got it!");
    }
}
