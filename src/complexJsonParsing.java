import static org.testng.Assert.assertEquals;

import Files.payLoad;
import io.restassured.path.json.JsonPath;

public class complexJsonParsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//print count of courses
		JsonPath js = new JsonPath(payLoad.coursePrice());
		int courseCount = js.getInt("courses.size()");
		System.out.println(courseCount);
		//print purchase amount
		int Totalamount= js.getInt("dashboard.purchaseAmount");
		System.out.println(Totalamount);
		//print title of first course
		 String title1 = js.getString("courses.title[1]");
		 System.out.println(title1);
		 
		 //print all course title and respective prizes
		 
		 for (int i=0;i<courseCount;i++)
		 {
			System.out.println(js.get("courses.title["+i+"]") +" : price is " + js.getInt("courses.price["+i+"]"));
		 }
		 
		 for (int i=0;i<courseCount;i++)
		 {
			 String courseTitles= js.get("courses.title["+i+"]");
			 if(courseTitles.equalsIgnoreCase("RPA"))
			 {
				 System.out.println(js.getInt("courses.copies["+i+"]"));
				 break;
			 }
			 		
		 }
		 int sum=0;
		 for (int i=0;i<courseCount;i++)
		 {
			int priceCourse =js.getInt("courses.price["+i+"]");
			int copiesCourse =js.getInt("courses.copies["+i+"]") ;
			sum = sum +(priceCourse*copiesCourse);
		 }
		 System.out.println(sum);
		 //assert.assertEquals(sum, Totalamount);
		 
	}

}
