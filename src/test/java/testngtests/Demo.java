package testngtests;

import org.testng.annotations.Test;

import com.hms.GenericUtils.BaseClass;

public class Demo extends BaseClass{
@Test(groups = "smoke")
public void start() {
	System.out.println("start the execution");
}
@Test(groups = {"smoke","regression"})
public void continu1() {
	System.out.println("continue the execution");
}
}
