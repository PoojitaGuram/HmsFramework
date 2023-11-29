package testngtests;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class Testngtest {

	@Test(invocationCount = 2)
public void xcreate() {
	System.out.println("create test");
}
@Test(enabled = false)
public void edit() {
	System.out.println("edit test");
}
@Test(dependsOnMethods =" edit")
public void delete() {
	System.out.println("delete test");


}

}
