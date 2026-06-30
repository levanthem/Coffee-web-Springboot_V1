package com.levanthem.coffee.themcoffee.entity;

// Tuong lai co entity, quan he 1 nhieu

import jakarta.persistence.Id;

public class Category {
    //@Id..
    private Long id;  // Kieu id tu tang phai dung Long L hoa ,
    private String name;
    private String description;

    public Category() {
    }

    //Key tu tang xoa Id
    public Category(Long id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
