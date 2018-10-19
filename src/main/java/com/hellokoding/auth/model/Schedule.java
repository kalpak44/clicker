package com.hellokoding.auth.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {
    private Long id;
    private boolean isExecuted;
    private String name;
    private Date created;
    private Date updated;
    private User user;
    private long initialDelay;
    private long delay;
    private byte unit;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public String getName() {
        return name;
    }

    @CreatedDate
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @LastModifiedDate
    public Date getUpdated() {
        return updated;
    }


    public long getInitialDelay() {
        return initialDelay;
    }

    public long getDelay() {
        return delay;
    }

    public byte getUnit() {
        return unit;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInitialDelay(long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public void setUnit(byte unit) {
        this.unit = unit;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    @Column(name = "user")
    public void setUser(User user) {
        this.user = user;
    }
}
