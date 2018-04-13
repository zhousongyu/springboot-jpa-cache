package com.imooc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aaaa")
public class Aaaa implements Serializable {

    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "dept")
    private String dept;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
