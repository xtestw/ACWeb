package com.cquacmer.model;

import javax.persistence.*;

/**
 * Created by xuwei on 15/11/1.
 */
@Table(name="user")
@Entity
public class User {
    private int id;
    private String name;
    private String hust_name;
    private String username;
    private String poj;
    private String hdu;
    private String fzu;
    private String codeforces;
    private String uva;
    private String zoj;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 9)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHust_name() {
        return hust_name;
    }

    public void setHust_name(String hust_name) {
        this.hust_name = hust_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPoj() {
        return poj;
    }

    public void setPoj(String poj) {
        this.poj = poj;
    }

    public String getHdu() {
        return hdu;
    }

    public void setHdu(String hdu) {
        this.hdu = hdu;
    }

    public String getFzu() {
        return fzu;
    }

    public void setFzu(String fzu) {
        this.fzu = fzu;
    }

    public String getCodeforces() {
        return codeforces;
    }

    public void setCodeforces(String codeforces) {
        this.codeforces = codeforces;
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public String getZoj() {
        return zoj;
    }

    public void setZoj(String zoj) {
        this.zoj = zoj;
    }
}
