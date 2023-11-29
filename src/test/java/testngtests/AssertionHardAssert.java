package testngtests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AssertionHardAssert {
@Test
public void test1() {
	System.out.println("a1");
	System.out.println("a2");
	assertEquals("A", "B");
	System.out.println("a3");
	System.out.println("a4");
}
@Test
public void test2() {
	int a=45;
	System.out.println("b1");
	System.out.println("b2");
	assertNotNull(a);
	System.out.println("b3");
	System.out.println("b4");
}

	

}
