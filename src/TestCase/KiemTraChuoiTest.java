package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.KiemTraChuoi;

class KiemTraChuoiTest {

	@Test
	void KiemTraDauNgoacTest() {
		KiemTraChuoi S= new KiemTraChuoi();
		boolean ketqua=S.KiemTraDauNgoac("(2)+(5)");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraDauNgoac("((2))");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraDauNgoac("((((((25))))))");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraDauNgoac("(+27)");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraDauNgoac("(2-)");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraDauNgoac("((2+456)-(4467))");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraDauNgoac("(2)+(7");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraDauNgoac("(256+5)*4");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraDauNgoac("((2)+(5))+97+((8)-6)");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraDauNgoac("((2)+)");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraDauNgoac("((*2))");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraDauNgoac("((28+)+)");
		assertEquals(false, ketqua);
	}
	void KiemTraKyTuTest(){
		KiemTraChuoi S= new KiemTraChuoi();
		boolean ketqua=S.KiemTraKyTu("2-3+4*5/6");
		assertEquals(true, ketqua);
	    ketqua=S.KiemTraKyTu("2-3+4*5/0");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraKyTu("(246754-3484)+4*5/6");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraKyTu("2*3/376-3+4*5/6");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraKyTu("+4*5/6=");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraKyTu("2%-3+4*5/6");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraKyTu("?357-3+4*5/6");
		assertEquals(false, ketqua);
	}
	void KiemTraToanTuTest() {
		KiemTraChuoi S= new KiemTraChuoi();
		boolean ketqua=S.KiemTraToanTu("2*546+8*56/9");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraToanTu("(2)*5+8");
		assertEquals(true, ketqua);
		ketqua=S.KiemTraToanTu("2+-8");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraToanTu("2**5");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraToanTu("2//5");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraToanTu("2+5+");
		assertEquals(false, ketqua);
		ketqua=S.KiemTraToanTu("+2/5");
		assertEquals(false, ketqua);
	}

}
