package MachineCoding.ParkingLot.models;

public class Operator extends BaseModel{
    private String empId;
    private String name;

    public Operator(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
