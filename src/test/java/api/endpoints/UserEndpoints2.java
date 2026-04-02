package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

// created for preform  create, Update, Retrieve and Delete requests to the User API's
public class UserEndpoints2 {


    // Method for getting url's from Properties file
    static ResourceBundle get_url()
    {
        ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load properties file
        return routes;
    }

    public static Response createUser (User payload)
    {
        String postURL= get_url().getString("post_url"); //return the url

       Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(postURL);
       return response;
    }

    public static Response getUser (String username)
    {
        String getURL =get_url().getString("get_url");

        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("username",username)

                .when()
                .get(getURL);
        return response;

    }

    public static Response updateUser (String username, User payload)
    {
        String updateURL= get_url().getString("update_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",username)

                .when()
                .put(updateURL);
        return response;
    }

    public static Response deleteUser (String username)
    {

        String deleteURL = get_url().getString("delete_url");
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("username",username)

                .when()
                .delete(deleteURL);
        return response;
    }
}
