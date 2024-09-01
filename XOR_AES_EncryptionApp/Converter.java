import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Converter extends JFrame 
{
    private JTextField keyField;
    private JButton encryptBtn;
    private JButton decryptBtn;
    private JTextArea encryptedTextArea;
    private JTextArea decryptedTextArea;
    private JLabel plaintextLabel;
    private JLabel encryptedTextLabel;
    private JLabel keyLabel;
    private Font font;

    public Converter() 
    {
    
        font = new Font(null, Font.PLAIN, 20);
        
        setLayout(new BorderLayout());
        JPanel keyPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel textPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(2, 1));
        labelPanel.setLayout(new GridLayout(1, 2));
        textPanel.setLayout(new GridLayout(1, 2));
        
        keyLabel =new JLabel("Key:");
        keyLabel.setFont(font);
        keyField = new JTextField(30);
        keyField.setFont(font);
        keyPanel.add(keyLabel);
        keyPanel.setFont(font);
        keyPanel.add(keyField);
        
        
        encryptBtn = new JButton("Encrypt");
        encryptBtn.setFont(font);
        decryptBtn = new JButton("Decrypt");
        decryptBtn.setFont(font);
        keyPanel.add(encryptBtn);
        keyPanel.add(decryptBtn);
        add(keyPanel, BorderLayout.NORTH);
        
        encryptedTextLabel =new JLabel("Plaintext:");
        encryptedTextLabel.setFont(font);
        plaintextLabel =new JLabel("Encrypted text:");
        plaintextLabel.setFont(font);
        labelPanel.add(plaintextLabel);
        labelPanel.add(encryptedTextLabel);
        add(labelPanel, BorderLayout.CENTER);
        
        
        encryptedTextArea = new JTextArea(20, 40);
        encryptedTextArea.setFont(font); 
        decryptedTextArea = new JTextArea(20, 40);
        decryptedTextArea.setFont(font); 
        textPanel.add(new JScrollPane(encryptedTextArea));
        textPanel.add(new JScrollPane(decryptedTextArea));
        add(textPanel, BorderLayout.SOUTH);

        
        encryptBtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String plaintext = decryptedTextArea.getText();
                String key = keyField.getText();
                char xorKey = key.charAt(0);
                String encryptedText=CipherManager.encrypt(plaintext, key, xorKey);
                encryptedTextArea.setText(encryptedText);
            }
        });

        decryptBtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                String encryptedText = encryptedTextArea.getText();
                String key = keyField.getText();
                char xorKey = key.charAt(0);
                String decryptedText=CipherManager.decrypt(encryptedText, key, xorKey);
                decryptedTextArea.setText(decryptedText);
            }
        });

        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
   
}
