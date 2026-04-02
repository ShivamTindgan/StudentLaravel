package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// created for preform  create, Update, Retrieve and Delete requests to the User API's
public class UserEndpoints {

    public static Response createUser (User payload)
    {
       Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Routes.createUrl);
       return response;
    }

    public static Response getUser (String username)
    {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("username",username)

                .when()
                .get(Routes.getUrl);
        return response;

    }

    public static Response updateUser (String username, User payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",username)

                .when()
                .put(Routes.updateUrl);
        return response;
    }

    public static Response deleteUser (String username)
    {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("username",username)

                .when()
                .delete(Routes.deleteUrl);
        return response;
    }
}
