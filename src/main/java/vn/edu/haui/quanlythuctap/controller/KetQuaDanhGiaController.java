
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

import vn.edu.haui.quanlythuctap.entity.KetQuaDanhGia;
import vn.edu.haui.quanlythuctap.service.KetQuaDanhGiaService;

@RestController
@RequestMapping("/api/ket-qua-danh-gia")
public class KetQuaDanhGiaController {

    private final KetQuaDanhGiaService service;

    public KetQuaDanhGiaController(KetQuaDanhGiaService service) {
        this.service = service;
    }

    // GET: Lấy toàn bộ kết quả đánh giá
    @GetMapping
    public ResponseEntity<List<KetQuaDanhGia>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET: Lấy kết quả đánh giá theo mã
    @GetMapping("/{maDG}")
    public ResponseEntity<KetQuaDanhGia> getById(
            @PathVariable String maDG) {
        return ResponseEntity.ok(service.getById(maDG));
    }

    // POST: Thêm kết quả đánh giá
    @PostMapping
    public ResponseEntity<KetQuaDanhGia> create(
            @RequestBody KetQuaDanhGia ketQua) {
        KetQuaDanhGia ketQuaMoi = service.create(ketQua);
        return ResponseEntity.status(HttpStatus.CREATED).body(ketQuaMoi);
    }

    // PUT: Cập nhật kết quả đánh giá
    @PutMapping("/{maDG}")
    public ResponseEntity<KetQuaDanhGia> update(
            @PathVariable String maDG,
            @RequestBody KetQuaDanhGia ketQua) {
        return ResponseEntity.ok(service.update(maDG, ketQua));
    }

    // DELETE: Xóa kết quả đánh giá
    @DeleteMapping("/{maDG}")
    public ResponseEntity<Void> delete(@PathVariable String maDG) {
        service.delete(maDG);
        return ResponseEntity.noContent().build();
    }
}
