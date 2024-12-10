import java.util.Scanner;
import java.io.*;

public class Main {
    @SuppressWarnings({ "resource", "deprecation" })
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
                    String[] fullQuote = line.split(splitBy);    // use tab as separator
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
        String scrambledQuote = test.scramble();
        System.out.println("Author: " + author);
        Scanner scan = new Scanner(System.in);
        String guess = "";
        Character first = new Character(' ');
        Character second = new Character(' ');
        char[] quoteArr = scrambledQuote.toCharArray();
        char[] scramblebet = test.getScramblebet();
        char[] alphabet = test.getAlphabet();
        boolean control = true;
        while (!guess.equals(quote) && control)
        {
            System.out.println("Scrambled quote: " + new String(quoteArr));
            System.out.print("Guess: ");
            guess = scan.nextLine();
            try {
                if (guess.indexOf("=") == 1)
                {
                    char[] guessArr = guess.toCharArray();
                    first = guessArr[0];
                    second = guessArr[2];
                    if(Cipher.sequentialSearch(scramblebet, first) == Cipher.sequentialSearch(alphabet, second))
                    {
                        for (int i = 0; i < quoteArr.length; i++)
                        {
                            if(quoteArr[i] == first)
                            {
                                quoteArr[i] = Character.toUpperCase(second);
                            }
                        }
                    }
                }
                if(quote.toUpperCase().equals(new String(quoteArr)))
                {
                    control = false;
                    System.out.println("Quote: " + new String(quoteArr));
                }
                if(guess.equals("give up"))
                {
                    control = false;
                    System.out.println("Quote: " + quote);
                }
            } catch (Exception e) {}
        }
        System.out.println("You got it!");
    }
}
