package scooter.services;

import okhttp3.Request;
import scooter.data.CardDto;
import scooter.data.CardObject;
import scooter.data.UserCardDto;
import scooter.util.RequestUtil;

import java.io.IOException;

import static scooter.data.Data.*;

public class CardService extends BaseScooter {
    private String url;
    private RequestUtil requestUtil;

    public CardService() {
        this.url = this.baseUrl + "payment-service/kick-scooter-payment/cards";
        this.requestUtil = new RequestUtil();
    }

    public String addCard(CardObject cardObject) throws IOException {
        Request request = requestUtil.postRequest(url, cardObject, USER_TOKEN);
        return requestUtil.getResponse(request);
    }

    public UserCardDto deleteCard() throws IOException {
        CardDto payload = new CardDto(USER_ID, LAST_FOUR);
        Request request = requestUtil.deleteRequest(url, USER_TOKEN, payload);
        return requestUtil.getResponseAs(UserCardDto.class, request);
    }
}
