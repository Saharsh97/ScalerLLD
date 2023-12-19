package MachineCoding.ParkingLot.models;

import java.util.Date;

// every model, or every entry in the database, has basic details like id, createAt, updatedAt

// you will realise their importance when we have databases.
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
