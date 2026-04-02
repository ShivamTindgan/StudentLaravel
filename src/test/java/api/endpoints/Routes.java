package api.endpoints;

public class Routes {

    public static String baseUrl= "https://petstore.swagger.io";
    public static String baseLaravelUrl="https://api.sparkl.ac/api/v1/";

    //*** User module  ***

    public static String createUrl = baseUrl+"/v2/user";
    public static String getUrl = baseUrl+"/v2/user/{username}";
    public static String updateUrl = baseUrl+"/v2/user/{username}";
    public static String deleteUrl = baseUrl+ "/v2/user/{username}";


    // Laravel Student Module
    public static String otpUrl= baseLaravelUrl+"users/otp";
    public static String loginUrl= baseLaravelUrl+"users/login";
    public static String futureSessionUrl=baseLaravelUrl+"sessions?time_frame=future&limit=1&page=1&sort_order=asc";
    public static String studentAssignmentNotificationUrl=baseLaravelUrl+"assignments/notifications";

//    Pet Module
//    Store Module
    // Laravel Teacher Module
    //Laravel Infinity
    // Laravel Common endpoints




}

