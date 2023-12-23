package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.models.enums.PaymentProvider;
import com.scaler.bookmyshow.models.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private String referenceNumber;
    private int amount;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}
