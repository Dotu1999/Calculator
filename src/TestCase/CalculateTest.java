package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.Result;

class CalculateTest {

	@Test
	void priorityTest() {
		Result ketqua= new Result();
		int ch=ketqua.priority('+');
		assertEquals(1, ch);
		ch=ketqua.priority('-');
		assertEquals(1, ch);
		ch=ketqua.priority('/');
		assertEquals(2, ch);
		ch=ketqua.priority('*');
		assertEquals(2, ch);
		ch=ketqua.priority('u');
		assertEquals(0, ch);
	}
	void isOperatorTest() {
		Result ketqua= new Result();
		boolean ch= ketqua.isOperator('+');
		assertEquals(true, ch);
		ch= ketqua.isOperator('-');
		assertEquals(true, ch);
		ch= ketqua.isOperator('*');
		assertEquals(true, ch);
		ch= ketqua.isOperator('/');
		assertEquals(true, ch);
		ch= ketqua.isOperator('$');
		assertEquals(false, ch);
	}
	void processStringTest() {
		Result S = new Result();
		String[] Profix = S.processString("23+14*2-4");
		String[] bieuthuc={"23","+","14","*","2","-","4"};
		assertArrayEquals(bieuthuc, Profix);
		Profix = S.processString("(23)*4+9");
		String[] bieuthuc1={"(","23",")","*","4","+","9"};
		assertArrayEquals(bieuthuc1, Profix);
	}
	void resultTest() {
		Result S = new Result();
		String[] chuoi= {"23","14","2","*","+","4","-"};
		double gt=S.result(chuoi);
	    assertEquals(47,gt);
	}
	void InfixToPostfixTest() {
		Result S = new Result();
		String[] bieuthuc={"23","+","14","*","2","-","4"};
		String[] Profix = S.InfixToPostfix(bieuthuc);
		String[] bieuthuc1={"23","14","2","*","+","4","-"};
		assertArrayEquals(bieuthuc1, Profix);
	}

}
