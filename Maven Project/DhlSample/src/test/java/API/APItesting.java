package API;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APItesting {
String Token = "d3ff59156616d67b3e0f5123bdebd6608519592d88a3b5430a2bcb2a09a04032";
static int resID;	
@Test
public void addUser(){
 
	
	resID = given()
			
			.header("Content-Type", "application/json")
			.header("Authorization", "Bearer "+Token)
			
			.body("{\r\n" + 
					"    \"name\": \"Harsh Patii\",\r\n" + 
					"    \"gender\": \"male\",\r\n" + 
					"    \"email\": \"Harsh.Patii@testapi.com\",\r\n" + 
					"    \"status\": \"active\"\r\n" + 
					"}")
			.log()
			.all()
	.when()
			.post("https://gorest.co.in/public/v1/users")
	.then()
			.log()
			.all()
			.assertThat()
			.statusCode(201)
			.extract()
			.response()
			.body()
			.path("data.id");
}
@Test
public void getUser(){
	given()
			.header("Content-Type", "application/json")
			.log()
			.all()
			.when()
			.get("https://gorest.co.in/public/v1/users/"+ resID)
			.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.body("data.status", Matchers.equalTo("active"));
			
}
}
