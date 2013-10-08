package fr.renater.idegest.tu;

import java.io.IOException;

import org.idegest.util.UtilHtml;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class UtilHtmlTest extends TestCase{
	
	private UtilHtml uh;
	
	@Before
	public void setUp() throws Exception {
		this.uh = new UtilHtml(); // 2
	}
	@Test
	public void test2NElementsToHtml(){
		UtilHtml uh = new UtilHtml();
		String arg[] = {"A", "B", "C"};
		String expectedHtmlTab =
		   "<table><tr><td>A</td></tr><tr><td>B</td></tr><tr><td>C</td></tr></table>";
		  assertEquals("cas général: toHtmlTab", 
		               expectedHtmlTab, uh.toHtmlTab(arg, arg.length));
	}
	@Test
	public void test2TbVide(){
	 UtilHtml uh = new UtilHtml();
	 String arg[] = {};
	 String expectedHtmlTab = "(vide)";
	 assertEquals("toHtmlTab : tableau vide", expectedHtmlTab, uh.toHtmlTab(arg, 10));
	}
	@Test
	public void test2UnElement(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A"};
		 String expectedHtmlTab = "<table><tr><td>A</td></tr></table>";
		 assertEquals("toHtmlTab: une ligne",
		 expectedHtmlTab, uh.toHtmlTab(arg, arg.length));
	}
	@Test
	public void test2NMoinsUnElement(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A", "B", "C"};
		 String expectedHtmlTab = "<table><tr><td>A</td></tr><tr><td>B</td></tr><tr><td>...</td></tr></table>";
		 assertEquals("toHtmlTab : cas moins 1",
		 expectedHtmlTab, uh.toHtmlTab(arg, arg.length-1));
		
	}
	@Test
	public void test2N2Element(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A", "B", "C"};
		 String expectedHtmlTab ="<table><tr><td>A</td></tr><tr><td>...</td></tr></table>";
		 assertEquals("toHtmlTab : cas médian impair",
		 expectedHtmlTab, uh.toHtmlTab(arg, arg.length/2));
		
	}
	//dernier test
	@Test
	public void test20Element(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A", "B", "C"};
		 String expectedHtmlTab =""; 
		 assertEquals("toHtmlTab : cas maxRows = 0",
		 expectedHtmlTab, uh.toHtmlTab(arg, 0));
		
	}
}
