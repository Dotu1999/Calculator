package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.KiemTraChuoi;
import calculator.Result;

class IntegrationTest {

	@Test
	void testTichHop() {
		KiemTraChuoi test=new KiemTraChuoi();
		String a ="(2+3)*6+(2*3)/2";
		boolean a1 = test.KiemTraDauNgoac(a);
		assertEquals(true, a1);
		boolean a2 = test.KiemTraToanTu(a);
		assertEquals(true, a2);
		boolean a3 = test.KiemTraKyTu(a);
		assertEquals(true, a3);
		if (a1 == true && a2 == true && a3 == true)
		{
		Result chuoi=new Result();
		String[] s=chuoi.processString(a);
		String[] t=chuoi.InfixToPostfix(s);
		double gt =chuoi.result(t);
		assertEquals(33, gt);
		}
		
	}

}
