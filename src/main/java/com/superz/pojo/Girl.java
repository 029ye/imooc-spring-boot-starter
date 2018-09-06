package com.superz.pojo;

import javax.persistence.*;

public class Girl {
    @Id
    private Integer id;

    private Integer age;

    @Column(name = "cup_size")
    private String cupSize;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return cup_size
     */
    public String getCupSize() {
        return cupSize;
    }

    /**
     * @param cupSize
     */
    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}