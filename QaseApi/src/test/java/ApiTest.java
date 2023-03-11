import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    String myToken = "insert the token here";
    String baseUri = "https://api.qase.io";
    @Test
    // получить список всех проектов
    public void getAllProjects() {
        given()
                .baseUri(baseUri)
                .basePath("/v1/project")
                .contentType(ContentType.JSON)
                .header("Token", myToken)
                .when().get()
                .then().statusCode(200)
                .body("status", equalTo(true));
        System.out.println("Список проектов получен");
    }
    @Test
    // создать новый проект, получить его, удалить
    public void createGetDeleteProject() {
        // создать json body запроса
        Map<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("title","New test project");
        jsonBody.put("code","PJC");
        Response response = given()
                .baseUri(baseUri)
                .basePath("/v1/project")
                .contentType(ContentType.JSON)
                .header("Token", myToken)
                .body(jsonBody)
                .when().post()
                .then().statusCode(200)
                .body("status", equalTo(true))
                .extract().response();
        // извлечь code проекта из ответа
        String projectCodeExtracted = response.path("result.code");
        System.out.println("Проект создан");
        // получить проект по code
        given()
                .baseUri(baseUri)
                .basePath("/v1/project/" + projectCodeExtracted)
                .contentType(ContentType.JSON)
                .header("Token", myToken)
                .when().get()
                .then().statusCode(200)
                .body("status", equalTo(true));
        System.out.println("Проект получен");
        // удалить проект по code
        given()
                .baseUri(baseUri)
                .basePath("/v1/project/" + projectCodeExtracted)
                .contentType(ContentType.JSON)
                .header("Token", myToken)
                .when().delete()
                .then().statusCode(200)
                .body("status", equalTo(true));
        System.out.println("Проект удален");
        System.out.println("Код проекта " + projectCodeExtracted);
    }
}
