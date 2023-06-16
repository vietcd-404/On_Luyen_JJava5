package com.example.templatejava5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Table(name = "khachhang")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhachhang")
    private Integer maKhachHang;

    @Column(name = "tenkhachhang")
    private String tenKhachHang;
}
