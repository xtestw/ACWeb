package com.cquacmer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name="problem")
@Entity
public class Problem implements Serializable {

    public Problem(){
        ojName="";
        ojId="";
        tags="";
        level="简单";
      //  solutions=new ArrayList<Solution>();

    }

    private Integer id;

    private String ojName;

    private String ojId;

    private String level;

    private String tags;

    //private List<Solution> solutions;

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
        this.ojName = ojName;
    }

    public String getOjId() {
        return ojId;
    }

    public void setOjId(String ojId) {
        this.ojId = ojId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
//  @OneToMany(targetEntity = Solution.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // @JoinColumn(name="pid")
    /*public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }*/
}