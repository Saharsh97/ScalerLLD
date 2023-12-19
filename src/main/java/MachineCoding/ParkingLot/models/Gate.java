package MachineCoding.ParkingLot.models;

import MachineCoding.ParkingLot.models.enums.GateStatus;
import MachineCoding.ParkingLot.models.enums.GateType;

public class Gate extends BaseModel{
    private int gateNumber;
    private Operator currentOperator;
    private GateType gateType;
    private GateStatus gateStatus;

    public Gate(int gateNumber, Operator currentOperator, GateType gateType) {
        this.gateNumber = gateNumber;
        this.currentOperator = currentOperator;
        this.gateType = gateType;
        this.gateStatus = GateStatus.OPEN;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
