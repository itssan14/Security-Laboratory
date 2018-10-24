import java.util.Scanner;

public class DSS {
    static int modInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int p, q, a, g , r, s, m , k, x , y, A, temp, B, temp1;
        double v;
        
        System.out.println("Enter 1st prime number p");
        p=sc.nextInt();
        System.out.println("Enter 2nd prime number q");
        q=sc.nextInt();
        System.out.println("Enter the primitive root a");
        a=sc.nextInt();
        System.out.println("Enter the user's private key");
        A=sc.nextInt();
        
        temp=(p-1)/q;
        g=(int) ((Math.pow(a,temp))%p);
        B=(int) ((Math.pow(g,A))%p);

        System.out.println(" \n Simulation of Digital Signature Algorithm \n");
        System.out.println(" \n global public key components are:");
        System.out.println("\np is: " + p);
        System.out.println("\nq is: " + q);
        System.out.println("\ng is: " + g);
        System.out.println("\nB is: " + B);
        System.out.println(" \n SIGNING THE MESSAGE\n");
        
        System.out.println("\nEnter the random number k");
        k=sc.nextInt();
        System.out.println("\nEnter the message m");
        m=sc.nextInt();
        
        temp=(int) ((Math.pow(g,k))%p);
        r = (int) (temp % p);
        temp=modInverse(k,q);
        temp1=modInverse((m+(A*r)), q);
        s=temp*temp1;
        
        System.out.println("\n The Signature is: ");
        System.out.println("\nm is: " + m);
        System.out.println("\ns is: " + s);
        System.out.println("\nr is: " + r);
        System.out.println(" \n VERIFYING THE MESSAGE");
        
        temp=modInverse(s,q);
        temp1=modInverse(m, q);
        x=temp*temp1;
        temp=modInverse(s,q);
        temp1=modInverse(r, q);
        y=temp*temp1;
        temp=(int) ((Math.pow(g, x) % p) * (Math.pow(B,y)%p));
        v=temp%q;
        
        System.out.println("\nr is: " + r);
        System.out.println("\nv is: " + v);
        
        if(v==r)
            System.out.println(" \n MESSAGE IS VERIFIED");
        else
            System.out.println(" \n MESSAGE IS NOT VERIFIED");
    }
}