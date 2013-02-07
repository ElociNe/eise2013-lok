package lok;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ViehwaggonTest {
	
	private Viehwaggon v;
	
	@Before
	public void setUp() throws Exception {
		v = new Viehwaggon(1000, 2000, 5);
	}

	@Test
	public void testFuegeHinzuVieh() {
		boolean test;
		try {
			test = v.fuegeHinzuVieh(250);
			assertEquals(true, test);
		} catch (Exception e) {
			
			Assert.fail("Should not reach this statement");
		}
	
	}

	@Test
	public void testFuegeHinzuViehZuVielVieh() {
		try {
			v.fuegeHinzuVieh(100);
			v.fuegeHinzuVieh(100);
			v.fuegeHinzuVieh(100);
			v.fuegeHinzuVieh(100);
			v.fuegeHinzuVieh(100);
			v.fuegeHinzuVieh(100);
			Assert.fail("Should not reach this statement");
		} catch (Exception e) {			
			//expected
		}
	}

	@Test
	public void testFuegeHinzuViehZuVielGewicht() {
		
		try {
			v.fuegeHinzuVieh(2500);
			Assert.fail("Should not reach this statement");
		} catch (Exception e) {			
			//expected
		}
	}
}
