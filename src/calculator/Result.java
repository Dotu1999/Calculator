package calculator;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Result {
//Độ ưu tiên các toán tử
	public int priority(char c){        // thiet lap thu tu uu tien
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else return 0;
    }
//hàm chia 
public double chia(double a,double b) {
	if(b==0)
	{
		throw new ArithmeticException("Lỗi chia cho 0");
	}
	return (double)a/b;
}
// kiem tra xem co phai toan tu
public boolean isOperator(char c){  
    char operator[] = { '+', '-', '*', '/', ')', '(' };
    Arrays.sort(operator);
    if (Arrays.binarySearch(operator, c) > -1)
        return true;
    else return false;
}
//Chuẩn hóa biểu thức trung tố nhập vào
public String[] processString(String sMath){ // xu ly bieu thuc nhap vao thanh cac phan tu
    String s1 = "", elementMath[] = null;
    Result  IFP = new Result();
    sMath = sMath.trim();
    sMath = sMath.replaceAll("\\s+"," "); //    chuan hoa sMath
    for (int i=0; i<sMath.length(); i++){
        char c = sMath.charAt(i);//sMath.substring(i,1);
        if (!IFP.isOperator(c))
            s1 = s1 + c;
        else s1 = s1 + " " + c + " ";
    }
    s1 = s1.trim();
    s1 = s1.replaceAll("\\s+"," "); //  chuan hoa s1
    elementMath = s1.split(" "); //tach s1 thanh cac phan tu
    //System.out.println(s1);
    return elementMath;
}
//Chuyển từ biểu thức trung tố sang hậu tố 
public String[] InfixToPostfix(String[] elementMath)
{
        Result  IFP = new Result();
        String s1 ="", E[];
        Stack <String> S = new Stack <String>();
        for (int i=0; i<elementMath.length; i++){    // duyet cac phan tu
            char c = elementMath[i].charAt(0);  // c la ky tu dau tien cua moi phan tu
 
            if (!IFP.isOperator(c))         // neu c khong la toan tu
                s1 = s1 + " " + elementMath[i];     // xuat elem vao s1
            else{                       // c la toan tu
                if (c == '(') S.push(elementMath[i]);   // c la "(" -> day phan tu vao Stack
                else{
                    if (c == ')'){          // c la ")"
                        char c1;        //duyet lai cac phan tu trong Stack
                        do{
                            c1 = S.peek().charAt(0);    // c1 la ky tu dau tien cua phan tu
                            if (c1 != '(') s1 = s1 + " " + S.peek();    // trong khi c1 != "("
                            S.pop();
                        }while (c1 != '(');
                    }
                    else{
                        while (!S.isEmpty() && IFP.priority(S.peek().charAt(0)) >= IFP.priority(c)){
                        // Stack khong rong va trong khi phan tu trong Stack co do uu tien >= phan tu hien tai
                            s1 = s1 + " " + S.peek();   // xuat phan tu trong Stack ra s1
                            S.pop();
                        }
                        S.push(elementMath[i]); //  dua phan tu hien tai vao Stack
                    }
                }
            }
        }
        while (!S.isEmpty()){   // Neu Stack con phan tu thi day het vao s1
            s1 = s1 + " " + S.peek();
            S.pop();
        }
        String ss=s1.trim();
        E = ss.split(" ");  //  tach s1 thanh cac phan tu
        return E;
}
//tính gt của biểu thức hậu tố
public double result(String[] Postfix)
{
	Stack <String>S = new <String> Stack ();
	for(int i=0;i<Postfix.length;i++)
	{
		char c = Postfix[i].charAt(0);
		String a=Postfix[i];
		boolean ch=isOperator(c);
		if(ch==false)
		{
			S.push(a);
		}
		else {
		String d1=S.pop();
		String e1=S.pop();
		double d=Double.parseDouble(d1);
		double e=Double.parseDouble(e1);
		switch (a)
        {
            case "+":e +=d; break;
            case "-": e -= d; break;
            case "*": e *= d; break;
            case "/": e=chia(e,d); break;
        }
		String e2=String.valueOf(e);
		S.push(e2);
		
		}
		
		
	}
	String ketqua=S.pop();
	double result=Double.parseDouble(ketqua);
	return result;
	
}

	public static void main(String[] args) {
		KiemTraChuoi test=new KiemTraChuoi();
		Result chuoi=new Result();
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập chuỗi");
		String a = sc.nextLine();
		boolean a1 = test.KiemTraDauNgoac(a);
		boolean a2 = test.KiemTraToanTu(a);
		boolean a3 =test.KiemTraKyTu(a);
		if(a1 == true && a2 == true && a3 == true )
		{
		String[] s=chuoi.processString(a);
		String[] t=chuoi.InfixToPostfix(s);
		try {
			System.out.print("Kết quả biểu thức là:");
			System.out.print(chuoi.result(t));
//			System.out.print(t[2]);
			sc.close();
		}
		catch (Exception e) {
			System.out.print("Không xác định giá trị biểu thức");
        
		}

	    }
	}
}
