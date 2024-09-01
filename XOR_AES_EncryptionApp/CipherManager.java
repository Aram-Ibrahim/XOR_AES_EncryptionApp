import CryptographyManagers.XOR_manager;
import CryptographyManagers.AES_manager;

public class CipherManager 
{
    
    public static String encrypt(String plaintext, String key, char xorKey)
    {
        String text=XOR_manager.encrypt(plaintext,xorKey);
        text=AES_manager.encrypt(text,key);
        return text;
    }
    
    public static String decrypt(String ciphertext, String key, char xorKey)
    {
        String text=AES_manager.decrypt(ciphertext,key);
        text=XOR_manager.decrypt(text,xorKey);
        return text;
    }
}
