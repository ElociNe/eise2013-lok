package lok;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class LokomotiveTest {
	Lokomotive l;
	@Before
	public void setUp() throws Exception {
		l = new Lokomotive(200);
		l.lokfuehrerSteigtEin("basd", "1", new Date());
	}

	@Test
	public void testLosfahren() {
		try {
			l.losfahren();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
	@Test
	public void testLosfahrenfaehrtschon() {
		try {
			l.losfahren();
			l.losfahren();
			Assert.fail("should not reach this statement");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void testLosfahrenOhneLokfuehrer() {
		try {
			l.lokfuehrerSteigtAus();
			l.losfahren();
			Assert.fail("should not reach this statement");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void testLosfahrenWaggonsZuSchwer() {
		try {
			Viehwaggon v = new Viehwaggon(30000,20000,2000);
			v.fuegeHinzuVieh(1000);
			l.ankoppelnVieh(v);
			l.losfahren();
			Assert.fail("should not reach this statement");
		} catch (Exception e) {
		}
	}
	@Test
	public void testAnhalten() {
		try {
			l.losfahren();
			l.anhalten();
			Assert.assertEquals(0,l.getLokStatus());
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
	@Test
	public void testAnhaltenHaeltSchon() {
		try {
			l.anhalten();
			Assert.fail();
		} catch (Exception e) {
			
			//expected
		}
	}

	@Test
	public void testAnkoppelnGueter() {
		try {
			l.ankoppelnGueter(new Gueterwaggon(100, 1000));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAnkoppelnGueterFaehrt() {
		try {
			l.losfahren();
			l.ankoppelnGueter(new Gueterwaggon(100, 1000));
			Assert.fail();
		} catch (Exception e) {
			// expected
		}
	}

	@Test
	public void testAnkoppelnPerso() {
		try {
			l.ankoppelnPerso(new Personenwaggon(100, 10));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAnkoppelnPersoFaehrt() {
		try {
			l.losfahren();
			l.ankoppelnPerso(new Personenwaggon(100, 10));
			Assert.fail();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testAnkoppelnVieh() {
		try {
			l.ankoppelnVieh(new Viehwaggon(100, 10, 10));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAnkoppelnViehFaehrt() {
		try {
			l.losfahren();
			l.ankoppelnVieh(new Viehwaggon(100, 10, 10));
			Assert.fail();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testAnkoppelnKipp() {
		try {
			l.ankoppelnKipp(new Kippwaggon(100, 10));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAnkoppelnKippFaehrt() {
		try {
			l.losfahren();
			l.ankoppelnKipp(new Kippwaggon(100, 10));
			Assert.fail();
		} catch (Exception e) {
		}
	}


	public void testAbkoppelnGueter() {
		try {
			l.abkoppelnGueter(new Gueterwaggon(100, 1000));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAbkoppelnGueterFaehrt() {
		try {
			l.losfahren();
			l.abkoppelnGueter(new Gueterwaggon(100, 1000));
			Assert.fail();
		} catch (Exception e) {
			// expected
		}
	}

	@Test
	public void testAbkoppelnPerso() {
		try {
			l.abkoppelnPerso(new Personenwaggon(100, 10));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAbkoppelnPersoFaehrt() {
		try {
			l.losfahren();
			l.abkoppelnPerso(new Personenwaggon(100, 10));
			Assert.fail();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testAbkoppelnVieh() {
		try {
			l.abkoppelnVieh(new Viehwaggon(100, 10, 10));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAbkoppelnViehFaehrt() {
		try {
			l.losfahren();
			l.abkoppelnVieh(new Viehwaggon(100, 10, 10));
			Assert.fail();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testAbkoppelnKipp() {
		try {
			l.abkoppelnKipp(new Kippwaggon(100, 10));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAbkoppelnKippFaehrt() {
		try {
			l.losfahren();
			l.abkoppelnKipp(new Kippwaggon(100, 10));
			Assert.fail();
		} catch (Exception e) {
		}
	}




}
