package com.springbt.spamanagement.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "userId")
    private  Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userid) {
        this.userId = userid;
    }

    @Column(name = "expertId")
    private  Long expertId;

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    @Column(name = "slotId")
    private  Long slotId;

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    @Column(name = "date")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
