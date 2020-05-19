package scooter.services;

import okhttp3.Request;
import scooter.util.RequestUtil;

import java.io.IOException;

public class ActivateAccount extends BaseScooter {
    private String url;
    public ActivateAccount() {
        this.url = this.baseUrl + "identity-service/kick-scooter-identity/accounts/activate/";
    }

    public int activateUserToken(String token) throws IOException {
        RequestUtil requestUtil = new RequestUtil();
        Request request = requestUtil.getRequest(url + token);
        return requestUtil.getResponseCode(request);
    }
}
