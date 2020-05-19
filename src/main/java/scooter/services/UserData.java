package scooter.services;

import okhttp3.Request;
import scooter.data.Data;
import scooter.util.RequestUtil;

import java.io.IOException;

public class UserData extends BaseScooter{

    private String url;

    public UserData(String userID) {
        this.url = this.baseUrl + "identity-service/kick-scooter-identity/accounts/" + userID;
    }


    public String run() throws IOException {
        RequestUtil requestUtil = new RequestUtil();
        Request request = requestUtil.getRequest(url, Data.ADMIN_TOKEN);
        return requestUtil.getResponse(request);

    }
}
