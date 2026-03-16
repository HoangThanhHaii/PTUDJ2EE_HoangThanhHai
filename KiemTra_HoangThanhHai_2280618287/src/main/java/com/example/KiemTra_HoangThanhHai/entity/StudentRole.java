package com.example.KiemTra_HoangThanhHai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_role")
public class StudentRole {

    @Id
    private Long student_id;

    private Long role_id;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}