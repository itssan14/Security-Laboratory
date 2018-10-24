import java.security.*;
import java.util.Scanner;

class SHA {
   public static void main(String[] a) {
      try {
         MessageDigest md = MessageDigest.getInstance("SHA1");

         Scanner sc = new Scanner(System.in);
         System.out.print("Enter plain text : ");
         String input = sc.nextLine();
         md.update(input.getBytes()); 
         byte[] output = md.digest();
         System.out.print("SHA1(\""+input+"\") = ");
         System.out.println(bytesToHex(output));
      } catch (Exception e) {
         System.out.println("Exception: "+e);
      }
   }
   
   public static String bytesToHex(byte[] b) {
      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
      StringBuffer buf = new StringBuffer();
      for (int j=0; j<b.length; j++) {
         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
         buf.append(hexDigit[b[j] & 0x0f]);
      }
      return buf.toString();
   }
}
