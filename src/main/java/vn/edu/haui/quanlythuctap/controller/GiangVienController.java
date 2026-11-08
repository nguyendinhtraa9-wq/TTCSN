
package vn.edu.haui.quanlythuctap.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.haui.quanlythuctap.entity.GiangVien;
import vn.edu.haui.quanlythuctap.service.GiangVienService;

@RestController
@RequestMapping("/api/giang-vien")
public class GiangVienController {

    private final GiangVienService giangVienService;

    public GiangVienController(GiangVienService giangVienService) {
        this.giangVienService = giangVienService;
    }

    // 1. Lấy danh sách giảng viên
    @GetMapping
    public ResponseEntity<List<GiangVien>> getAllGiangVien() {
        return ResponseEntity.ok(
                giangVienService.getAllGiangVien());
    }

    // 2. Lấy giảng viên theo mã
    @GetMapping("/{maGV}")
    public ResponseEntity<GiangVien> getGiangVienById(
            @PathVariable String maGV) {
        return ResponseEntity.ok(
                giangVienService.getGiangVienById(maGV));
    }

    // 3. Thêm giảng viên
    @PostMapping
    public ResponseEntity<GiangVien> createGiangVien(
            @RequestBody GiangVien giangVien) {
        GiangVien savedGiangVien =
                giangVienService.createGiangVien(giangVien);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedGiangVien);
    }

    // 4. Cập nhật giảng viên
    @PutMapping("/{maGV}")
    public ResponseEntity<GiangVien> updateGiangVien(
            @PathVariable String maGV,
            @RequestBody GiangVien giangVien) {
        return ResponseEntity.ok(
                giangVienService.updateGiangVien(maGV, giangVien));
    }

    // 5. Xóa giảng viên
    @DeleteMapping("/{maGV}")
    public ResponseEntity<Void> deleteGiangVien(
            @PathVariable String maGV) {
        giangVienService.deleteGiangVien(maGV);
        return ResponseEntity.noContent().build();
    }
}
