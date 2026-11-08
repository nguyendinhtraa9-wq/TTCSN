
package vn.edu.haui.quanlythuctap.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.haui.quanlythuctap.entity.SinhVien;
import vn.edu.haui.quanlythuctap.service.SinhVienService;

@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienController {

    private final SinhVienService sinhVienService;

    public SinhVienController(SinhVienService sinhVienService) {
        this.sinhVienService = sinhVienService;
    }

    // GET: Lấy danh sách sinh viên
    @GetMapping
    public List<SinhVien> getAllSinhVien() {
        return sinhVienService.getAllSinhVien();
    }

    // GET: Lấy chi tiết sinh viên
    @GetMapping("/{maSV}")
    public SinhVien getSinhVienById(@PathVariable String maSV) {
        return sinhVienService.getSinhVienById(maSV);
    }

    // POST: Thêm sinh viên
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SinhVien createSinhVien(@RequestBody SinhVien sinhVien) {
        return sinhVienService.createSinhVien(sinhVien);
    }

    // PUT: Cập nhật sinh viên
    @PutMapping("/{maSV}")
    public SinhVien updateSinhVien(
            @PathVariable String maSV,
            @RequestBody SinhVien sinhVien) {
        return sinhVienService.updateSinhVien(maSV, sinhVien);
    }

    // DELETE: Xóa sinh viên
    @DeleteMapping("/{maSV}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSinhVien(@PathVariable String maSV) {
        sinhVienService.deleteSinhVien(maSV);
    }
}
