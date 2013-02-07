package lok;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class GueterwaggonTest {

private Gueterwaggon g;
	
	@Before
	public void setUp() throws Exception {
		this.g = new Gueterwaggon(100, 10000);
	}
	
	@Test
	public void testFuegeHinzuGut() {
		try {
			g.fuegeHinzuGut(100);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void terstFuegeHinzuGutZuViel() {
		try {
			g.fuegeHinzuGut(100000);
			Assert.fail();
		} catch (Exception e) {
		}
	}

}
