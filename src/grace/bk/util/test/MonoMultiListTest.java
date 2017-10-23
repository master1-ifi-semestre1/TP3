package util.test;

import org.junit.Before;
import org.junit.Test;

import util.MonoMultiList;

public class MonoMultiListTest {

	private MonoMultiList<A> monol;
	private MonoMultiList<B> multil;
	
	@Before
	public void setUp() throws Exception {
		monol = new MonoMultiList<A>(new B()); // généricité statique <A> (monomorphe sur B) 
		multil = new MonoMultiList<B>(); // généricité statique <B> (polymorphisme)
	}

	@Test
	public void testAddMono_OK() {
		// TODO 
		// assertTrue("ajout d'un B dans une liste<A> monomorphe<B>", ??? );
	}
	
	@Test
	public void testAddMono_NOK_up() {
//		 TODO 
		// assertFalse("ajout d'un A dans une liste<A> monomorphe<B>", ??? );
	}
	
	@Test
	public void testAddMono_NOK_down() {
//		 TODO 
		// assertFalse("ajout d'un C dans une liste<A> monomorphe<B>", ??? );
	}
	
	@Test
	public void testAddMulti_OK_eq() {
//		 TODO 
		// assertTrue("ajout d'un B dans une liste<B> polymorphe", ??? );
	}
	
	@Test
	public void testAddMulti_NOK_up() {
//		 TODO 
		// assertFalse("ajout d'un A dans une liste<B> polymorphe", ??? );
	}
	
	@Test
	public void testAddMulti_OK_down() {
//		 TODO 
		//assertTrue("ajout d'un C dans une liste<B> polymorphe", ??? );
	}

	class A {
	}
	
	class B extends A {
	}
	
	class C extends B {
	}

}
