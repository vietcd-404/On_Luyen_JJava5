package com.example.templatejava5.service;

import com.example.templatejava5.entity.KhachHang;
import com.example.templatejava5.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHang> getList(){
        return khachHangRepository.findAll();
    }

}
