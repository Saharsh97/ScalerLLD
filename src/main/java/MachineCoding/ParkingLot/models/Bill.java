package MachineCoding.ParkingLot.models;

import MachineCoding.ParkingLot.models.enums.BillStatus;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private String billNumber;
    private Date exitTime;
    private Ticket ticket;
    private Gate generatedAt;
    private Operator generatedBy;
    private List<Payment> payments;
    private BillStatus billStatus;

    private int amount;  // int or double?
    // 0.20
    // 0.20 * 100 = 20
    // 0.99999999 == 1 this is a transaction loss.

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
