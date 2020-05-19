package scooter.services;

import okhttp3.Request;
import scooter.services.BaseScooter;
import scooter.util.RequestUtil;

import java.io.IOException;

import static scooter.data.Data.ADMIN_TOKEN;

public class Payment extends BaseScooter {
    private String paymentUrl;
    private RequestUtil requestUtil;


    public Payment(String userId) {
        this.paymentUrl = this.baseUrl + "payment-service/kick-scooter-payment/payments/" + userId
                + "/user-solvency";
        this.requestUtil = new RequestUtil();
    }

    public String getUserSolvency() throws IOException {
        Request request = requestUtil.getRequest(paymentUrl, ADMIN_TOKEN);
        return requestUtil.getResponse(request);
    }
}