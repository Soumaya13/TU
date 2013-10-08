package fr.renater.idegest.tu;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URI;
import java.text.Normalizer;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class GestAjoutUsersTest extends TestCase {

	/** l'OUT */
	private GestAjoutUsers gau;

	@Before
	public void setUp() throws Exception {
		try {
			this.gau = new GestAjoutUsers("testusers.xml"); // 2
		} catch (IOException e) {
			fail("Création de l'OUT impossible !");
		}
	}

	@Test
	public void test2PremiersCarsGenUid() {
		String uid = this.gau.genUid("Bob", "Martin");
		uid = uid.substring(0, 2).toLowerCase();// 3
		System.out.println(uid);
		assertTrue("Les 2 premiers caractères sont valides",
				uid.equals("bm"));
		
		// 4
		/*
		 * try { GestAjoutUsers gau = new GestAjoutUsers("testusers.xml");
		 * String uid = gau.genUid("Bob", "Martin"); if (! uid.startsWith("BM"))
		 * fail("Premiers caractères de l'uid invalides !"); } catch
		 * (IOException e) { fail("Création de l'OUT impossible !"); }
		 */
	}

	@Test
	public void test2PremiersCarsGenUidBis() {
		String uid = this.gau.genUid("Bob", "Martin"); // 1
	String premscar = uid.substring(0, 2).toLowerCase(); // 2
	System.out.println(premscar);
	assertEquals("Les 2 premiers caractères sont valides", "bm", premscar);// 3
	}
	
	@Test
	public void test2Minuscule(){
		String uid = this.gau.genUid("Bob", "Martin");
		String minus = uid.toLowerCase();
		System.out.println(uid.toLowerCase());
		assertEquals("Les caractères sont en minuscules", "bmartin",minus);
	}
	@Test
	public void test2Cars5Min(){
		String uid = this.gau.genUid("Bob", "Martin");
		String premscar = uid.substring(0, 7).toLowerCase();
		System.out.println(premscar);
		assertEquals("Premiere lettre du prenom + 5 caractères derrière", "bmartin",premscar);
		
		
	}
	@Test
	public void test2Cars9Max(){
		String uid = this.gau.genUid("Bob", "Martinezo");
		String premscar = uid.substring(0, 10).toLowerCase();
		System.out.println(premscar);
		assertEquals("Premiere lettre du prenom + 9 caractères derrière", "bmartinezo",premscar);
	}
	@Test
	public void test2CarsIntrus(){
		String uid = this.gau.genUid("B{b", "M:éếrtin");
		uid = uid.toLowerCase();
		String car = Normalizer.normalize(uid, Normalizer.Form.NFD);
		car = car.replaceAll("[^\\p{ASCII}]", "");
		car = car.replaceAll("[!#$€%&'`(),;:/@...]","");
		System.out.println(car);
		assertEquals("Erreur", "bmeertin",car);
		
	}
	/**
	 * Des utilisateurs peuvent avoir le même nom et prénom.
	 *  Il fo donc faire en sorte qu'ils aient chacun des uid différents
	 */
	@Test
	public void test2User(){
	User usr = this.gau.addUser("Bob", "Martinezo");
	System.out.println(usr);
	
	User usr1 = this.gau.addUser("Bob", "Martinezo");
	System.out.println(usr1);
	
	assertNotSame(usr, usr1);
	
	}
	@Test
	public void test2PwCarEquals(){
		String usr = this.gau.genPassword(123);
		int nbUsr = usr.length();
		System.out.println(nbUsr);
		
		
		assertEquals(3,nbUsr);

		
		
	
	}

}
