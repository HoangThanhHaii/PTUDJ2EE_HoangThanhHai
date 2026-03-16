package com.example.KiemTra_HoangThanhHai.repository;

import com.example.KiemTra_HoangThanhHai.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}