package lok;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class KippwaggonTest {

	private Kippwaggon k;
	
	@Before
	public void setUp() throws Exception {
		this.k = new Kippwaggon(2000, 100);
	}
	
	@Test
	public void testBeladen() {
		try {
			k.beladen(100);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testBeladenZuViel() {
		try {
			k.beladen(3000);
			Assert.fail();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testBeladenGekippt() {
		try {
			k.kippen();
			k.beladen(100);
			Assert.fail();
		} catch (Exception e) {
		}
	}

}
