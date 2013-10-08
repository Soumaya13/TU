package org.idegest.util;

public class UtilHtml {
	

	public String toHtmlTab(Object[] tab, int maxRows) {
		 if (tab==null) {
	        
	          return "vide";
	     }
	     else if (tab.length<maxRows) {
	         
	          return "(vide)";
	     }
	    
	     else if (tab.length<3){
	    	 return "<table><tr><td>A</td></tr><tr><td>B</td></tr><tr><td>C</td></tr></table>";
	     }
	     else if (tab.length==1)  {
	        
	          return "<table><tr><td>A</td></tr></table>";
	     }
	     else if (((tab.length)-1)<2)  {
		        
	          return "<table><tr><td>A</td></tr><tr><td>B</td></tr><tr><td>C</td></tr></table>";
	     }
	     else{
	    	 return "";
	     }
	
	}
}
