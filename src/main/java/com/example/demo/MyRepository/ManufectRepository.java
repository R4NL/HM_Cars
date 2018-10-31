package com.example.demo.MyRepository;

import com.example.demo.entity.Manufect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufectRepository extends JpaRepository<Manufect,Long> {
}
