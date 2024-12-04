public class Cipher {

    private String[] plaintext;

    public Cipher (String plaintext) {
        this.plaintext = new String[plaintext.length()];
        for (int i = 0; i < plaintext.length(); i++)
        {
            this.plaintext[i] = plaintext.substring(i, i + 1);
        }
    }
}