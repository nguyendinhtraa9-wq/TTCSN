
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

import vn.edu.haui.quanlythuctap.entity.DoanhNghiep;
import vn.edu.haui.quanlythuctap.service.DoanhNghiepService;

@RestController
@RequestMapping("/api/doanh-nghiep")
public class DoanhNghiepController {

    private final DoanhNghiepService doanhNghiepService;

    public DoanhNghiepController(
            DoanhNghiepService doanhNghiepService) {
        this.doanhNghiepService = doanhNghiepService;
    }

    // Lấy danh sách doanh nghiệp
    @GetMapping
    public ResponseEntity<List<DoanhNghiep>> getAllDoanhNghiep() {
        return ResponseEntity.ok(
                doanhNghiepService.getAllDoanhNghiep());
    }

    // Lấy doanh nghiệp theo mã
    @GetMapping("/{maDN}")
    public ResponseEntity<DoanhNghiep> getDoanhNghiepById(
            @PathVariable String maDN) {
        return ResponseEntity.ok(
                doanhNghiepService.getDoanhNghiepById(maDN));
    }

    // Thêm doanh nghiệp
    @PostMapping
    public ResponseEntity<DoanhNghiep> createDoanhNghiep(
            @RequestBody DoanhNghiep doanhNghiep) {
        DoanhNghiep savedDoanhNghiep =
                doanhNghiepService.createDoanhNghiep(doanhNghiep);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedDoanhNghiep);
    }

    // Cập nhật doanh nghiệp
    @PutMapping("/{maDN}")
    public ResponseEntity<DoanhNghiep> updateDoanhNghiep(
            @PathVariable String maDN,
            @RequestBody DoanhNghiep doanhNghiep) {
        return ResponseEntity.ok(
                doanhNghiepService.updateDoanhNghiep(
                        maDN, doanhNghiep));
    }

    // Xóa doanh nghiệp
    @DeleteMapping("/{maDN}")
    public ResponseEntity<Void> deleteDoanhNghiep(
            @PathVariable String maDN) {
        doanhNghiepService.deleteDoanhNghiep(maDN);
        return ResponseEntity.noContent().build();
    }
}
