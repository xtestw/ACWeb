import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by admin on 2015/11/21.
 */
public class Main
{

    static Scanner c=new Scanner(System.in);
    static BigInteger f(String s)
    {
        BigInteger t=BigInteger.valueOf(1);
        BigInteger res=BigInteger.valueOf(0);
        for(int i=s.length()-1;i>=0;--i)
        {
            int y=0;
            char u=s.charAt(i);
            if(u>='a'&&u<='z')
            {
                y=10+u-'a';
            }
            else
            if(u>='A'&&u<='Z')
            {
                y=10+u-'A';
            }
            else y=u-'0';
            res=res.add(BigInteger.valueOf(y).multiply(t));
            t=t.multiply(BigInteger.valueOf(16));
        }
        return res;
    }
    public static void main(String args[]) throws IOException
    {
        Set<String> p;
        String x,y;
        ArrayList<BigInteger> a;
        BigInteger dp[][]=new BigInteger[200][200];
        while(c.hasNext())
        {
            int n,k;
            n=c.nextInt();
            k=c.nextInt();p=new HashSet<String>();
            a=new ArrayList<BigInteger>();
            for(int i=0;i<n;i++){
                String tmp=c.next();
                    a.add(new BigInteger(tmp));
            }
            for(int i=0;i<a.size();i++) dp[i][1]=new BigInteger("1");
            for(int i=0;i<a.size();i++){
                for(int j=2;j<=k;j++)
                    dp[i][j]=new BigInteger("0");
            }
            for(int i=0;i<a.size();i++){
                    for(int kk=2;kk<=k;kk++){
                        for(int j=0;j<i;j++){
                          // System.out.println("i, j , k: "+ i+" "+j+" "+ " "+k+ " " +a.get(i)+" "+a.get(j));
                            if(a.get(i).compareTo(a.get(j))<=0) continue;
                           // System.out.println(dp[i][kk].toString()+" "+dp[j][kk-1].toString());
                            dp[i][kk]=dp[i][kk].add(dp[j][kk-1]);
                           // System.out.println(dp[i][kk].toString()+" "+dp[j][kk-1].toString());
                    }
                }
            }
            BigInteger ans=new BigInteger("0");
            for(int i=0;i<a.size();i++) ans=ans.add(dp[i][k]);
            System.out.println(ans.toString());
        }
    }
}