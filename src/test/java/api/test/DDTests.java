package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTests {

    @Test(priority = 1, dataProvider ="Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userID, String userName, String fname, String lname, String email, String passwd, String phone)
    {
        User userPayload = new User();

        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUserName(userName);
        userPayload.setFirstName(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(email);
        userPayload.setPassword(passwd);
        userPayload.setPhone(phone);

        Response response =UserEndpoints.createUser(userPayload);

        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority=2, dataProvider="UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName)
    {
        Response response = UserEndpoints.deleteUser(userName);

        Assert.assertEquals(response.getStatusCode(),404);
    }

}
