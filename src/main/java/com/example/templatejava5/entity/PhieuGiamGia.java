package com.example.templatejava5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name = "phieugiamgia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhieuGiamGia {
    @Id
    @Column(name = "maphieu")
    private String maPhieu;

    @Column(name = "tenphieu")
    private String tenPhieu;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngaybatdau")
    private Date ngayBatDau;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngayketthuc")
    private Date ngayKetThuc;

    @Column(name = "giatrigiam")
    private BigDecimal giaTriGiam;

    @Column(name = "giatrigiamtoida")
    private BigDecimal giaTriGiamToiDa;

    @Column(name = "hinhthucgiam")
    private boolean hinhThucGiam;

    @Column(name = "trangthai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "nguoisohuu")
    private KhachHang nguoiSoHuu;


}
