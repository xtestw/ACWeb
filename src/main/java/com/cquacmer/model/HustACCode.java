package com.cquacmer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuwei on 15/11/1.
 */
@Table(name="hustACCode")
@Entity
public class HustACCode implements Serializable {
    private int id;
    private String source;
    private String pid;
    private String username;
    private String language;
    private String code;
    private int memSize;
    private int time;
    private int codeLength;
    private Date submit;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 9)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMemSize() {
        return memSize;
    }

    public void setMemSize(int memSize) {
        this.memSize = memSize;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getSubmit() {
        return submit;
    }

    public void setSubmit(Date submit) {
        this.submit = submit;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }
}
