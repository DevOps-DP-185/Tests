package scooter.services;

import okhttp3.Request;
import scooter.data.User;
import scooter.util.RequestUtil;

import java.io.IOException;

public class AuthorizedUser extends BaseScooter {
    private String url;
    public final String REPLACE_STRING = "Bearer ";
    public final  String EMPTY_STRING = "";

    public AuthorizedUser() {
        this.url = this.baseUrl + "identity-service/kick-scooter-identity/accounts/sign-in";
    }

    public String getBearerTokenAuthorizedUser(User user) throws IOException {
        RequestUtil requestUtil = new RequestUtil();
        Request request = requestUtil.postRequest(url, user);
        String bearerToken = requestUtil.getAuthorizationToken(request);
        return bearerToken.replace(REPLACE_STRING, EMPTY_STRING);
    }
}
