package com.example.demo.repository;

import com.example.demo.model.TargetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository<TargetEntity, Long> {
}
