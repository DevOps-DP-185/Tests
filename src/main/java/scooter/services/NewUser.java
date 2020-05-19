package scooter.services;

import okhttp3.Request;
import scooter.data.User;
import scooter.util.RequestUtil;
import java.io.IOException;
import static scooter.data.Data.SYMBOL;
import static scooter.data.Data.EMPTY_STRING;

public class NewUser extends BaseScooter {
    private String url;

    public NewUser() {
        this.url = this.baseUrl + "identity-service/kick-scooter-identity/accounts/sign-up";
    }

    public String getRegistrationUserToken(User user) throws IOException {
        RequestUtil requestUtil = new RequestUtil();
        Request request = requestUtil.postRequest(url, user);
        return requestUtil.getResponse(request).replace(SYMBOL, EMPTY_STRING);
    }
}
