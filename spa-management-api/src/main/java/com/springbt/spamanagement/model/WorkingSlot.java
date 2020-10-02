package com.springbt.spamanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "working_slots")
public class WorkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "expertId", nullable = false)
    private  Long expertId;

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    @Column(name = "slotId", nullable = false)
        private  Long slotId;


    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }
}
