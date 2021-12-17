import java.math.BigInteger;
import java.util.*;
        
/**
 * Lab15 - Zecc
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-08
 */

public class Zeckendorf
{
    
    public static BigInteger nearestSmallerEqFib(BigInteger n){ 
                
        BigInteger ZERO = BigInteger.valueOf(0);
        BigInteger ONE = BigInteger.valueOf(1);
        if(n.compareTo(ZERO)==0||n.compareTo(ONE)==0){
            return n;
        }
        BigInteger f1 = BigInteger.valueOf(0);
        BigInteger f2 = BigInteger.valueOf(1);
        BigInteger f3 = BigInteger.valueOf(1);
                
        while((f3.compareTo(n)==-1)||(f3.compareTo(n)==0)){
            f1 = f2;
            f2 = f3;
            f3 = f1.add(f2);
        } 
        return f2; 
    }
        
    public static List<BigInteger> getFibRep(BigInteger n){
        ArrayList<BigInteger> ans= new ArrayList<BigInteger>();
        BigInteger ZERO = BigInteger.valueOf(0);
        while(n.compareTo(ZERO)==1){
            BigInteger f = nearestSmallerEqFib(n);
            ans.add(f);
            n = n.subtract(f);
        }
            
        ArrayList<BigInteger> rans = new ArrayList<BigInteger>();
            for(int i = ans.size()-1; i>=0;i--){
                rans.add(ans.get(i));
            }
        return rans;   
        }
        
    public static String encode(List<BigInteger> items){
        String mans = "";
        BigInteger ZERO = BigInteger.valueOf(0);
            
        for(int i = 0; i<items.size();i++){
                
            List<BigInteger> ans=new ArrayList<BigInteger>();
            BigInteger xx=items.get(i);
            ans=getFibRep(xx);
            BigInteger ocf = BigInteger.valueOf(1);
            BigInteger cf = BigInteger.valueOf(1);
                
            while(ans.size()>0){
                    
                if(cf.intValue()==ans.get(0).intValue()){
                        
                     mans = mans+"1";
                     ans.remove(0);
                        
                }
                    
                    else{
                        mans=mans+"0";
                        
                    }
                 
                BigInteger temp = ocf.add(cf);
                ocf=cf;
                cf=temp; 
            }
             mans=mans+"1";

        }
        return mans;
    }
    
    
    public static List<BigInteger> decode(String zits){
    
        List<BigInteger> ls=new ArrayList<BigInteger>();
        
        int i = 0;
        BigInteger value = BigInteger.valueOf(0);
        BigInteger cf = BigInteger.valueOf(1);
        BigInteger ocf = BigInteger.valueOf(1);
    
        while(i<zits.length()){
            if(i>0 && zits.charAt(i-1)==zits.charAt(i) && zits.charAt(i)=='1'){
                ls.add(new BigInteger(""+value+""));
                value=BigInteger.valueOf(0);
                ocf = BigInteger.valueOf(1);
                cf = BigInteger.valueOf(1);
                i+=1;
                
                if(i>=zits.length()){
                    break;
                }
            }
        
            if(zits.charAt(i)=='1'){
                value=value.add(cf);
            }
        
            BigInteger temp = ocf.add(cf);
            ocf=cf;
            cf=temp;
            i+=1;
        }
        return ls;
    }
    
    /**public static void main(){
        BigInteger input = BigInteger.valueOf(167);
        List<BigInteger> test = new ArrayList<BigInteger>();
        test.add(BigInteger.valueOf(69));
        test.add(BigInteger.valueOf(99));
        test.add(BigInteger.valueOf(127));
        test.add(new BigInteger("2149805219"));

        String encoded = encode(test);
        
        /*
        for(BigInteger entry:test){
            System.out.println(entry);
        }
        
        System.out.println(encoded);
        
        List<BigInteger> decoded = decode(encoded);
        System.out.println(decoded);
    }*/
}