package lok;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonenwaggonTest {

	private Personenwaggon p;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		this.p = new Personenwaggon(2000, 8);
	}

	@Test
	public void testFuegeHinzuPerson() {
		boolean test = false;
		try {
			test = p.fuegeHinzuPerson("Frank");
		} catch (Exception e) {
			Assert.assertEquals(true, test);
		}
	}
	
	@Test
	public void testFuegeHinzuPersonZuViele() {
		
			try{
				p.fuegeHinzuPerson("Mr Smith");
				p.fuegeHinzuPerson("Mrs Smith");
				p.fuegeHinzuPerson("Jo");
				p.fuegeHinzuPerson("Mo");
				p.fuegeHinzuPerson("Tobi");
				p.fuegeHinzuPerson("Chris");
				p.fuegeHinzuPerson("Nicky");
				p.fuegeHinzuPerson("Flo");
				p.fuegeHinzuPerson("Jona");
				Assert.fail("should not reach this statement");
			} catch (Exception e) {
				//exception expected, do nothing
			}
	}
}
