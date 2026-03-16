package com.example.KiemTra_HoangThanhHai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int credits;

    private String lecturer;

    private String image;

    @Column(name = "category_id")
    private Long categoryId;

    public Course() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getImage() {
        return image;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}