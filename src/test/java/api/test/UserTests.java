package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userPayload;

    public Logger logger;    // for logs

    @BeforeClass
    public void setUp()
    {
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUserName("JohnAnderson");
        userPayload.setFirstName("John");
        userPayload.setLastName("Cena");
        userPayload.setEmail("j@yopmail.com");
        userPayload.setPassword("jcn");
        userPayload.setPhone("1234123401");

        System.out.println(userPayload.getUserName());

        //logs

        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority=1)
    public void testCreateUser()
    {
        logger.info("**************** Creating User *******************");
//        System.out.println(userPayload.getUserName());
        Response response=UserEndpoints.createUser(userPayload);
// First of all Log information
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("First test is executed");
//        System.out.println(userPayload.getUserName());
        logger.info("**************** User is created ******************");
    }
    @Test(priority=2, dependsOnMethods="testCreateUser")
    public void testGetUserByName()
    {
        logger.info("**************** Reading the user info ******************");

        System.out.println("2nd test executed"+userPayload.getUserName());
        Response response = UserEndpoints.getUser(this.userPayload.getUserName());

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);

        System.out.println("Second test is executed");
        System.out.println(response.asString());

        logger.info("**************** User is fetched ******************");

    }

    @Test(priority = 3, dependsOnMethods="testCreateUser")
    public void testUpdateUser() {

        logger.info("**************User is updating *********************");

//Update user details
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        System.out.println(userPayload.getUserName());
        Response response = UserEndpoints.updateUser(this.userPayload.getUserName(), userPayload);
        response.then().log().all();
//       response.then().log().body().statusCode(200);   Another way of Assertion, verifying the status code

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("User is updated");

        logger.info("**************User is updated *********************");
    }

    @Test(priority =4, dependsOnMethods = "testCreateUser")
    public void testDeleteUser(){

        logger.info("************** Deleting the user *********************");

        Response response = UserEndpoints.deleteUser(this.userPayload.getUserName());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("user is deleted");

        logger.info("************** User is deleted *********************");
    }

}
