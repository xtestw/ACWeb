package com.cquacmer.model;

import javax.persistence.*;

@Table(name="problem")
@Entity
public class Problem {
    private Integer id;

    private String ojName;

    private String ojId;

    private Integer level;

    private String tags;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 9)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOjName() {
        return ojName;
    }

    public void setOjName(String ojName) {
        this.ojName = ojName == null ? null : ojName.trim();
    }

    public String getOjId() {
        return ojId;
    }

    public void setOjId(String ojId) {
        this.ojId = ojId == null ? null : ojId.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }
}