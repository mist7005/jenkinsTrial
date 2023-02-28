package tyss;

import org.testng.Assert;

public class TestNgPrac2 {
	
	String s="abhi";
	
	
	public static void main(String[] args) {
		TestNgPrac1 p1=new TestNgPrac1("abhi");
		TestNgPrac2 p2=new TestNgPrac2();
		Assert.assertEquals(p1.getData(), p2.s);
		System.out.println("pass");
		
	}
}
