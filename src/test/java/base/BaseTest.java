package base; 
import io.restassured.RestAssured; 
import io.restassured.builder.RequestSpecBuilder; 
import io.restassured.filter.log.LogDetail; 
import io.restassured.http.ContentType; 
import org.testng.annotations.BeforeClass; 
import utils.ConfigReader; 
public class BaseTest { 
  @BeforeClass 
  public void setup() { 
    RestAssured.baseURI = "https://api.github.com"; 
    RestAssured.requestSpecification = new RequestSpecBuilder() 
      .addHeader("Authorization", "Bearer " + ConfigReader.get("token")) 
      .setContentType(ContentType.JSON) 
      .log(LogDetail.ALL) 
      .build(); 
  } 
} 
