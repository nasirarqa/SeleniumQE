import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class goRestAPI {
	
	//String Token = "ff29e37a8b54482225d4fe07e2d437592ebe0918ac489db4faa99ef5249c7a78";
	
	@Test
	public int addUser(){
	 
		int i = given()
				
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer ff29e37a8b54482225d4fe07e2d437592ebe0918ac489db4faa99ef5249c7a78")
				
				.body("{\r\n" + 
						"    \"name\": \"Nasirtest Userfive\",\r\n" + 
						"    \"gender\": \"male\",\r\n" + 
						"    \"email\": \"nasirT.user5@testapi.com\",\r\n" + 
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
		return i;
	}
	@Test
	public void getUser(){
		given()
				.header("Content-Type", "application/json")
				.log()
				.all()
				.when()
				.get("https://gorest.co.in/public/v1/users/"+addUser())
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.body("data.status", Matchers.equalTo("active"));
				
	}

}
