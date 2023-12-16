package MachineCoding.ParkingLot.models;

import MachineCoding.ParkingLot.models.enums.PaymentMode;
import MachineCoding.ParkingLot.models.enums.PaymentStatus;

import java.util.Date;

public class Payment extends BaseModel{
    private Long amount;
    private Date time;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceId;
    private Bill bill;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
