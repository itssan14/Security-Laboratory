import java.util.Scanner;

public class Railfence {
    public static void main(String[] args)
    {
        int i=0,j=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Plaintext : ");
        String pt = sc.nextLine();
        
        StringBuffer res = new StringBuffer();
        StringBuffer result = new StringBuffer();
        
        // Encryption
        for(i=0, j=1; j<pt.length(); i=i+2, j=j+2 )
        {
            result.append(pt.charAt(i));
            res.append(pt.charAt(j));
        }
        
        result.append(res);
        System.out.println("Encrypted Text : " + result);
        
        // Decryption
        int a = pt.length()/2;
        StringBuffer dec = new StringBuffer();
        for(i=0, j=a; j<pt.length(); i++,j++)
        {
            dec.append(result.charAt(i));
            dec.append(result.charAt(j));
        }
        
        System.out.println("Decrypted Text : " + dec);
    }
}
