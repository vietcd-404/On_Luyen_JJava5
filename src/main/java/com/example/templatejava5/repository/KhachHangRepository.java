package com.example.templatejava5.repository;

import com.example.templatejava5.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
}
