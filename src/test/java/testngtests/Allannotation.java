package testngtests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Allannotation {
	@BeforeSuite
	public void bs() {
		System.out.println("before suite");
	}
	@BeforeClass
	public void bc() {
		System.out.println("before class");
	}
	
	@BeforeClass
	public void bc1(){
		System.out.println("before classs1");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	@BeforeMethod
	public void  bm() {
		System.out.println("before method");
	}
      @AfterClass
	public void ac() {
    	  System.out.println("after class");
      }
      @Test
      public void test2() {
    	  System.out.println("test2");
      }
      @BeforeMethod
      public void bm1() {
    	  System.out.println("before method1");
      }
      @AfterClass
      public void ac1() {
    	  System.out.println("after class1");
      }
      @BeforeMethod
      public void bm2() {
    	  System.out.println("before 9method2");
      }
      @AfterMethod
      public void am()
      {
    	  System.out.println("after method");
      }
      @AfterSuite
      public void as() {
    	  System.out.println("after suite");
      }
	


}
