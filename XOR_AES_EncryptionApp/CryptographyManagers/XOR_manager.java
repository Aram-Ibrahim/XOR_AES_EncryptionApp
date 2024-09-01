package CryptographyManagers;

public class XOR_manager 
{
    public static String encrypt(String plaintext, char key) 
    {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : plaintext.toCharArray()) 
        {
            encryptedText.append((char) (c ^ key));
        }
        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, char key) 
    {
        return encrypt(encryptedText, key);
    }

}
