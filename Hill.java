import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hill {
    
	static int modInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        int k[][]=new int[3][3];
        int p[]=new int[300];
        int det=0;
        int adj[][]=new int[3][3];
        int[][] inverse=new int[3][3];
        int[][] plaintext=new int[200][200];
        int[][] plain=new int[200][200];
        int[][] cipher=new int[20][20];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("PLAINTEXT : ");
        String plain1=br.readLine();
        String str=plain1.replaceAll(" ","");
        if(str.length()%3==1)
            str=str+"xx";
        else if(str.length()%3==2)
            str=str+'x';

        int row=str.length()/3;
        System.out.println("KEY : ");
        for (int i = 0; i < 3; i++) 
        {
           for (int j = 0; j < 3; j++)
           {
            k[i][j] = scanner.nextInt();
           }
        }

        for(int i=0;i<str.length();i++)
        {
            int c1=str.charAt(i);
            p[i]=(c1)-97;
        }

        int inc=0;
        for(int i=0;i<row;i++)
        {
        	for(int j=0;j<3;j++)
        	{
                plaintext[i][j]=p[inc];
                inc++;
             }
        }

        System.out.println("Encrypted Text : ");
        for(int i = 0; i < row; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                for (int l = 0; l < 3; l++) 
                {
                    cipher[i][j] += plaintext[i][l] * k[l][j];
                }
            }
        }

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print((char)((cipher[i][j]%26)+97));
            }
        }

        for(int i = 0; i < 3; i++)
            det = det + (k[0][i] * (k[1][(i+1)%3] * k[2][(i+2)%3] - k[1][(i+2)%3] * k[2][(i+1)%3]))%26;

                if(det<0)
                    det+=26;

        int inverse_det = modInverse(det,26);
        for(int i=0;i<3;i++)
        {
        	for(int j=0;j<3;j++)
        	{
    			adj[i][j]=(((k[(j+1)%3][(i+1)%3] * k[(j+2)%3][(i+2)%3]) - (k[(j+1)%3][(i+2)%3] * k[(j+2)%3][(i+1)%3])));
        	}
        }

        for(int i=0; i<3; i++)
        {
            for(int j=0;j<3;j++)
            {
                inverse[i][j]=(adj[i][j]*inverse_det)%26;
                if(inverse[i][j]<0)
                    inverse[i][j]+=26;
            }
        }
 
        for(int i = 0; i < row; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                for (int l = 0; l < 3; l++) 
                {
                    plain[i][j] += cipher[i][l] * inverse[l][j];
                }
            }
        }
        System.out.println();
        System.out.println("Decrypted Text : ");
        for(int i=0;i<row;i++)
        {
          for(int j=0;j<3;j++)
          {
              System.out.print((char)(plain[i][j]%26 +97));
          }
        }


    }
    }
