import java.util.Scanner;

public class Caesar {
	public static StringBuffer encrypt(String text, int s)
	{
		StringBuffer result= new StringBuffer();

		for (int i=0; i<text.length(); i++)
		{  
			if (Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
				result.append(ch);
			}
			else
			{
				char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
				result.append(ch);
			}
		}
		return result;
      }
	
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext: ");
        String message = new String();
        StringBuffer temp1 = new StringBuffer();
        String temp2 = new String();
        message = sc.next();
        System.out.println("Enter Key: ");
        int s = sc.nextInt();     
        System.out.println("ENCRYPTION");
		temp1 = encrypt(message, s);
		System.out.println("Ciphertext: " + temp1);
		System.out.println("DECRYPTION");               
        temp2=temp1.toString();
		System.out.println("Plaintext: " + encrypt(temp2, 26-s));
    }
}
