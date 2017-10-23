package grace.bk.util.test;

import org.junit.Before;
import org.junit.Test;

import grace.bk.util.MonoDynList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MonoDynListTest {

	private MonoDynList mdl;
	
	@Before
	public void setUp() throws Exception {
		// TODO cr�er une liste de B
		// DONE
		mdl = new MonoDynList(new B());
	}

	@Test
	public void testAdd_OK() {
		// TODO 
		// assertTrue("ajout d'un B dans une liste monomorphe de B", ??? );
		assertTrue(mdl.add(new B()));
	}
	
	@Test
	public void testAdd_NOK_up() {
		// TODO
		// assertFalse("ajout d'un A dans une liste monomorphe de B", ??? );
        assertFalse(mdl.add(new A()));
	}

	@Test
	public void testAdd_NOK_down() {
		// TODO
		// assertFalse("ajout d'un C dans une liste monomorphe de B", ??? );
        assertFalse(mdl.add(new C()));
	}

	class A {
	}

	class B extends A {
	}

	class C extends B {
	}

}