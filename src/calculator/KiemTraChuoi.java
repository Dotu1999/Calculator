package calculator;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KiemTraChuoi {
	public boolean isOperator1(char c){  
	    char operator[] = { '+', '-', '*', '/' };
	    Arrays.sort(operator);
	    if (Arrays.binarySearch(operator, c) > -1)
	        return true;
	    else return false;
	}
	public boolean KiemTraKyTu(String KyTu) {
		Pattern pattern = Pattern.compile("^[0-9\\+\\*\\-/()\\s]{1,}$");
		Matcher matcher = pattern.matcher(KyTu);
		boolean match = matcher.matches();
		if(match==false) {
	        // throw new ArithmeticException("Ký tự nhập vào không đúng"); 
	        	 System.out.println("Ký tự nhập vào không đúng");
	      }
		return match;
	}
	public boolean KiemTraToanTu(String KyTu) {
		boolean match=true;
		for(int i = 0;i < KyTu.length() ; i++)
		{
			int lenght=KyTu.length();
			if(isOperator1(KyTu.charAt(lenght-1))==true)
			{
				match=false;
				System.out.println("Nhập thừa 1 toán tử");
				break;
			}
			char ch=KyTu.charAt(i);
			if(isOperator1(ch)==true)
			{
				char ch1=KyTu.charAt(i+1);
				if(isOperator1(ch1)==true||isOperator1(KyTu.charAt(0))==true)
				{ 
					match= false;
					System.out.println("Nhập thừa 1 toán tử");
					break;
				}
			}	
		}
//		boolean t=KyTu.contains("++");
//		boolean t1=KyTu.contains("--");
//		boolean t2=KyTu.contains("**");
//		boolean t3=KyTu.contains("//");
//		if(t==true ||t1==true||t2==true||t3==true)
//		{
//			match=false;
//			throw new ArithmeticException("Nhập thừa 1 toán tử nào đó"); 
//		}
//		else {match=true;}
		return match;
	}
	public  boolean KiemTraDauNgoac(String KyTu) {
		boolean c;
		boolean e;
		boolean e1=true;
		boolean e2=true;
		boolean c1=true;
		boolean c2=true;
		char kytu1='(';
		int count1=0;
		for (int i = 0; i < KyTu.length(); i++)
		{
			if(KyTu.charAt(i)==kytu1)
			{
				if(isOperator1(KyTu.charAt(i+1))==true)
				{
					e1=false;
					break;
				}
			}
		}
		for(int i=0;i<KyTu.length();i++)
		{
			if(KyTu.charAt(i)==kytu1)
			{
				count1++;
			}
		}
		char kytu2 = ')';
		int count2 = 0;
		for (int i = 0; i < KyTu.length(); i++)
		{
			if(KyTu.charAt(i)==kytu2)
			{
				
				if(isOperator1(KyTu.charAt(i-1))==true)
				{
					e2=false;
					break;
				}
			}
		}
		for (int i = 0; i < KyTu.length(); i++)
		{
			if(KyTu.charAt(i)==kytu2)
			{
				count2++;
			}
		}
		if (count1 == count2)
		{
			c = true;
		}
		else 
		{
			c = false;
		}
		//
		for (int i =KyTu.length()-1; i >= 0; i --)
		{
			if(KyTu.charAt(i)==kytu1||KyTu.charAt(i)==kytu2)
			{
				char d=KyTu.charAt(i);
				if(d=='(')
				{
					c1=false;
				}
				break;
			}
		}
		int index1 = KyTu.indexOf(")");
		int index2 = KyTu.indexOf("(");
		if(index1<index2)
		{
			c2=false;
		}
		
		if(c1==true&&c2==true&&c==true&&e1 ==true && e2 ==true)
		{
			e = true;
		}
		else 
		{
			e = false;
			System.out.println("Biểu thức nhập vào đóng mở ngoặc không đúng");
//			throw new ArithmeticException("Biểu thức nhập vào đóng mở ngoặc ko đúng"); 
		}
		return e;
	}
}
