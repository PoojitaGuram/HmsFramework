package testngtests;

import org.testng.annotations.Test;

import com.hms.GenericUtils.BaseClass;

public class Demo1 extends BaseClass{
	@Test(groups = "regression")
	public void end() {
		System.out.println("end the execution");
	}
	@Test(groups = "smoke")
	public void stop() {
		System.out.println("stop the execution");
	}
}
