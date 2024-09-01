package CryptographyManagers;

import javax.swing.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AES_manager 
{

    private static Boolean checkKeyLength(String key)
    {
        if (key.length() != 16 && key.length() != 24 && key.length() != 32) 
        {
            JOptionPane.showMessageDialog(null, "Key Error: Invalid length. Key length must be 16, 24, or 32 characters.");
            return false;
        }
        return true;
    }
    
    public static String encrypt(String plaintext, String key) 
    {
        try {
            if (checkKeyLength(key))
            {
                Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, aesKey);
                byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
                return Base64.getEncoder().encodeToString(encryptedBytes);
            }
            else
            {
                return "";
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return "";
        }
    }

    public static String decrypt(String encryptedText, String key) 
    {
        try {
            if (checkKeyLength(key))
            {
                Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, aesKey);
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
                return new String(decryptedBytes);
            }
            else
            {
                return "";
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return "";
        }
    }
}
