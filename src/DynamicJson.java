import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.ReusableMethods;
import Files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DynamicJson {
	
	@Test
	public void addBook() throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";
		String response =given().log().all().header("Content-Type","application/json")
	    .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Minnu\\Downloads\\BooksData.json"))))
	    .when().post("Library/Addbook.php")
	    .then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js =ReusableMethods.rawToJson(response);
		String id =js.get("ID");
		System.out.println(id);
	}
	
	

}
