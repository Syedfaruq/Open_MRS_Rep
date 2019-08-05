package Object_ReUsable;

import org.testng.annotations.Test;

public class TestNGException {

	@Test(expectedExceptions = TestNGException.class)
	public void TestException() {
		System.out.println("Object_Reusable");
	}

}
