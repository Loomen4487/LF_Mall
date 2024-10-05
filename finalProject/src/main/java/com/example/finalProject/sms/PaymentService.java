package com.example.finalProject.sms;

import com.siot.IamportRestClient.IamportClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final IamportClient iamportClient;

    public PaymentService() {
        this.iamportClient = new IamportClient("0867041087273817","9Q1IIuhBdqwhjvyupUeWgeK5817wPmnR9skV3gF3oap7EgfobKyzRrHYHpRSZ6VxtjgvkhJPkiFDJTye");
    }
}
