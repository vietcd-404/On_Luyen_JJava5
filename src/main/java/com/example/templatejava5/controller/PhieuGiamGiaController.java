package com.example.templatejava5.controller;

import com.example.templatejava5.entity.KhachHang;
import com.example.templatejava5.entity.PhieuGiamGia;
import com.example.templatejava5.service.KhachHangService;
import com.example.templatejava5.service.PhieuGiamGiaService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/phieu-giam-gia")
public class PhieuGiamGiaController {
    @Autowired
    private PhieuGiamGiaService phieuGiamGiaService;

    @Autowired
    private KhachHangService khachHangService;


//    @GetMapping("/hien-thi")
//    public String getAll(Model model) {
//        List<PhieuGiamGia> list = this.phieuGiamGiaService.getList();
//        model.addAttribute("list", list);
//        List<KhachHang> list1 = this.khachHangService.getList();
//        model.addAttribute("listKhachHang", list1);
//        return "index";
//    }

    @GetMapping("/hien-thi")
    public String getAllPage(Model model,@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
        Page<PhieuGiamGia> page = phieuGiamGiaService.getPage(pageable);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("list",page.getContent());
        return "index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        phieuGiamGiaService.delete(id);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model) {
        PhieuGiamGia phieuGiamGia = phieuGiamGiaService.findById(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBatDau = dateFormat.format(phieuGiamGia.getNgayBatDau());
        String ngayKetThuc = dateFormat.format(phieuGiamGia.getNgayKetThuc());
        model.addAttribute("bd", ngayBatDau);
        model.addAttribute("kt", ngayKetThuc);
        model.addAttribute("list", phieuGiamGia);
        List<KhachHang> list1 = this.khachHangService.getList();
        model.addAttribute("listKhachHang", list1);
        return "update";
    }

    @PostMapping("/update/{maPhieu}")
    public String update(@PathVariable("maPhieu") String id,
                         @ModelAttribute("phieuGiamGia") @DateTimeFormat(pattern = "yyyy-MM-dd") PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaService.update(id, phieuGiamGia);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                         @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                         Model model) {
        List<PhieuGiamGia> searchResults = phieuGiamGiaService.searchByDateRange(startDate, endDate);
        model.addAttribute("searchResults", searchResults);
        return "index";
    }


}
