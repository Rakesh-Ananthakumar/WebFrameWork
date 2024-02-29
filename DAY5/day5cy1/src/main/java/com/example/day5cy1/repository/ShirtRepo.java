package com.example.day5cy1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day5cy1.model.Shirt;

@Repository
public interface ShirtRepo extends JpaRepository<Shirt,Integer>
{
    
}
