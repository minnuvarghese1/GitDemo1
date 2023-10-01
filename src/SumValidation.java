import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payLoad;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourse()
	{
		JsonPath js = new JsonPath(payLoad.coursePrice());
		int courseCount = js.getInt("courses.size()");
		int Totalamount= js.getInt("dashboard.purchaseAmount");
		
		int sum=0;
		 for (int i=0;i<courseCount;i++)
		 {
			int priceCourse =js.getInt("courses.price["+i+"]");
			int copiesCourse =js.getInt("courses.copies["+i+"]") ;
			sum = sum +(priceCourse*copiesCourse);
		 }
		 System.out.println(sum);
		 Assert.assertEquals(sum, Totalamount);;
	}
}
