package bukalapakTest.API;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ApiTest {
    String url = "https://jsonplaceholder.typicode.com/posts";
    String postRequest = "{\n" +
            "  \"title\": \"recommendation\",\n" +
            "  \"body\": \"motorcycle\",\n" +
            "  \"userId\": 12\n" +
            "}";

    @Test(priority = 1)
    public void CorrectDataTypeJsonSchema(){
        given()
                .when()
                .get(url)
                .then()
                .assertThat().log().all()
                .body(matchesJsonSchemaInClasspath("dataType.json"));
    }

    @Test(priority = 2)
    public void CorrectDataTypeWithEqual() {
        given()
                .when()
                .get(url)
                .then()
                .assertThat().log().all()
                .body("userId[0]", Matchers.equalTo(1))  //integer
                .body("id[0]", Matchers.equalTo(1))     //integer
                .body("title[0]", Matchers.equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))   //string
                .body("body[0]", Matchers.equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))  //string
                .statusCode(200);
    }

    @Test(priority = 3)
    public void CorrectPostResponse(){
        given()
                .when()
                .body(postRequest)
                .post(url)
                .then()
                .assertThat().log().all()
                .statusCode(201);
    }
}
