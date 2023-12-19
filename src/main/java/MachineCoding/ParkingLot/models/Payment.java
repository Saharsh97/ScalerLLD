package MachineCoding.ParkingLot.models;

import MachineCoding.ParkingLot.models.enums.PaymentMode;
import MachineCoding.ParkingLot.models.enums.PaymentStatus;

public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Bill bill;
    private String refId;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }
}
