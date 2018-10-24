import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

class DigitalEncryptionStandard {
    Cipher ecipher;
    Cipher dcipher;
    
    DigitalEncryptionStandard (SecretKey key) throws Exception
    {
        ecipher = Cipher.getInstance("DES");
        dcipher = Cipher.getInstance("DES"); 
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }
    
    public String encrypt(String str) throws Exception
    {
        byte[] utf8 = str.getBytes("UTF-8");
        byte[] enc = ecipher.doFinal(utf8);
        
        return new sun.misc.BASE64Encoder().encode(enc);
    }
    
    public String decrypt(String str) throws Exception
    {
        byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
        byte[] utf8 = dcipher.doFinal(dec);
        return new String(utf8, "UTF-8");
    }
}

public class DES
{
    public static void main(String[] argv) throws Exception {
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        DigitalEncryptionStandard encrypter = new DigitalEncryptionStandard(key);
        Scanner sc = new Scanner(System.in);
        System.out.println("PLAINTEXT : ");
        String pt = sc.nextLine();
        String encrypted = encrypter.encrypt(pt);
        String decrypted = encrypter.decrypt(encrypted);
        System.out.println("ENCRYPTED TEXT : ");
        System.out.println(encrypted);
        System.out.println("DECRYPTED TEXT : ");
        System.out.println(decrypted);
    }
}