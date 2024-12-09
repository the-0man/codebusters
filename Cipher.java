public class Cipher {

    public char[] plaintext;
    public char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public char[] scramblebet;

    public Cipher (String plaintext) {
        this.plaintext = plaintext.toCharArray();
        scramblebet = new char[alphabet.length];
    }

    @SuppressWarnings("deprecation")
    public String scramble() {
        int[] random = new int[26];
        int i = 0;
        while (i < 25)
        {
            int rand = (int) (Math.random() * 26);
            if (Cipher.sequentialSearch(random, rand) == -1)
            {
                random[i] = rand;
                i++;
            }
        }
        for (int j = 0; j < 26; j++)
        {
            scramblebet[j] = alphabet[random[j]];
        }
        for (int j = 0; j < plaintext.length; j++)
        {
            Character current = new Character(plaintext[j]);
            if (Cipher.sequentialSearch(alphabet, current) != -1)
            {
            int index = Cipher.sequentialSearch(alphabet, plaintext[j]);
            plaintext[j] = scramblebet[index];
            }
        }
        String scrambledString = new String(plaintext);
        return scrambledString;
    }

    public static int sequentialSearch(int[] elements, int target)
    {
        for (int j = 0; j < elements.length; j++)
        {
            if (elements[j] == target)
            {
                return j;
            }
        }
        return -1;
    }

    @SuppressWarnings("deprecation")
    public static int sequentialSearch(char[] elements, char target)
    {
        Character tar = new Character(target);
        for (int j = 0; j < elements.length; j++)
        {
            Character current = new Character(elements[j]);
            if (current.equals(tar))
            {
                return j;
            }
        }
        return -1;
    }

    public String getPlaintext(){
        String str = new String(this.plaintext);
        return str;
    }

    public char[] getScramblebet(){
        return scramblebet;
    }

    public char[] getAlphabet(){
        return alphabet;
    }
}
