package com.example.templatejava5.service;

import com.example.templatejava5.entity.PhieuGiamGia;
import com.example.templatejava5.repository.PhieuGiamGiaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PhieuGiamGiaService {
    @Autowired
    private PhieuGiamGiaRepository phieuGiamGiaRepository;


    public List<PhieuGiamGia> getList() {
        return phieuGiamGiaRepository.findAll();
    }

    public PhieuGiamGia add(PhieuGiamGia phieuGiamGia) {
        return phieuGiamGiaRepository.save(phieuGiamGia);
    }

    public boolean delete(String id) {
        phieuGiamGiaRepository.deleteById(id);
        return true;
    }

    public PhieuGiamGia update(String id, PhieuGiamGia phieuGiamGia) {
        PhieuGiamGia giamGia = phieuGiamGiaRepository.findById(phieuGiamGia.getMaPhieu()).orElse(null);
        giamGia.setMaPhieu(phieuGiamGia.getMaPhieu());
        giamGia.setTenPhieu(phieuGiamGia.getTenPhieu());
        giamGia.setNgayBatDau(phieuGiamGia.getNgayBatDau());
        giamGia.setNgayKetThuc(phieuGiamGia.getNgayKetThuc());
        giamGia.setGiaTriGiam(phieuGiamGia.getGiaTriGiam());
        giamGia.setTrangThai(phieuGiamGia.getTrangThai());
        giamGia.setNguoiSoHuu(phieuGiamGia.getNguoiSoHuu());
        return phieuGiamGiaRepository.save(giamGia);
    }

    public PhieuGiamGia findById(String id) {
        return phieuGiamGiaRepository.findById(id).orElse(null);
    }

    public List<PhieuGiamGia> searchByDateRange(Date startDate, Date endDate) {
        return phieuGiamGiaRepository.findByNgayBatDauBetween(startDate, endDate);
    }

    public Page<PhieuGiamGia> getPage(Pageable pageable){
        return phieuGiamGiaRepository.findAll(pageable);
    }
}
