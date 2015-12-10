package com.cquacmer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by xuwei on 15/11/1.
 */
@Table(name="user")
@Entity
public class User implements Serializable {
    private int id;
    private String name;
    private String hust_name;
    private String username;
    private String password;
    private String poj;
    private String hdu;
    private String fzu;
    private String codeforces;
    private String uva;
    private String zoj;
    private String email;
    private String thirt;
    private String iDCard;
    private String schoolId;
    private String campus;
    private String major;
    private String telephone;
    private String blog;
    private List<Role> role;
    private boolean locked;
    private String salt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getThirt() {
        return thirt;
    }

    public void setThirt(String thirt) {
        this.thirt = thirt;
    }

    public String getiDCard() {
        return iDCard;
    }

    public void setiDCard(String iDCard) {
        this.iDCard = iDCard;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hust_name='" + hust_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", poj='" + poj + '\'' +
                ", hdu='" + hdu + '\'' +
                ", fzu='" + fzu + '\'' +
                ", codeforces='" + codeforces + '\'' +
                ", uva='" + uva + '\'' +
                ", zoj='" + zoj + '\'' +
                ", email='" + email + '\'' +
                ", thirt='" + thirt + '\'' +
                ", iDCard='" + iDCard + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", campus='" + campus + '\'' +
                ", major='" + major + '\'' +
                ", telephone='" + telephone + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }

}
