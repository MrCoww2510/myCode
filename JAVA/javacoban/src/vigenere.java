import java.util.Scanner;

public class vigenere {
    public String encrypt(String plainText, int key[]) {
        String cipherText = "";
        plainText = plainText.toUpperCase(); 

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch == ' ') {
                cipherText += ' ';
            } else {
                int x = ((ch - 'A') + key[i % key.length]) % 26; 
                x += 'A'; 
                cipherText += (char) x;
            }
        }
        return cipherText;
    }

    public String decrypt(String cipherText, int key[]) {
        String plainText = "";
        cipherText = cipherText.toUpperCase(); 

        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch == ' ') {
                plainText += ' ';
            } else {
                int x = ((ch - 'A') - key[i % key.length] + 26) % 26; 
                x += 'A'; 
                plainText += (char) x;
            }
        }
        return plainText;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int a[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = (int) (Math.random() * 26); 
        }

        String plainText = "HOW ARE YOU";
        vigenere obj = new vigenere();
        String cipherText = obj.encrypt(plainText, a);
        System.out.println("Cipher Text: " + cipherText);
        String decryptedText = obj.decrypt(cipherText, a);
        System.out.println("Decrypted Text: " + decryptedText);
        sc.close();
    }
}