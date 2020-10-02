package com.springbt.spamanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "slots")
public class Slot {
    public Slot() {
    }

    public Slot(String slotName, String timing) {
        this.slotName = slotName;
        this.timing = timing;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Column(name = "name", nullable = false, length = 50)
    private String slotName;
    public String getSlotName() {
        return slotName;
    }
    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    @Column(name = "timing", nullable = false, length = 50)
    private String timing;
    public String getTiming() {
        return timing;
    }
    public void setTiming(String timing) {
        this.timing = timing;
    }
}
