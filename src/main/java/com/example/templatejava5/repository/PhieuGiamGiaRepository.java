package com.example.templatejava5.repository;

import com.example.templatejava5.entity.PhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, String> {
    List<PhieuGiamGia> findByNgayBatDauBetween(Date startDate, Date endDate);
}
