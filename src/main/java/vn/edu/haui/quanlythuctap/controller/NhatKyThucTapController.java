
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

import vn.edu.haui.quanlythuctap.entity.NhatKyThucTap;
import vn.edu.haui.quanlythuctap.service.NhatKyThucTapService;

@RestController
@RequestMapping("/api/nhat-ky-thuc-tap")
public class NhatKyThucTapController {

    private final NhatKyThucTapService service;

    public NhatKyThucTapController(
            NhatKyThucTapService service) {
        this.service = service;
    }

    // 1. Lấy danh sách nhật ký
    @GetMapping
    public List<NhatKyThucTap> getAll() {
        return service.getAll();
    }

    // 2. Xem chi tiết nhật ký
    @GetMapping("/{maNK}")
    public NhatKyThucTap getById(
            @PathVariable String maNK) {
        return service.getById(maNK);
    }

    // 3. Tạo nhật ký
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NhatKyThucTap create(
            @RequestBody NhatKyThucTap nhatKy) {
        return service.create(nhatKy);
    }

    // 4. Cập nhật nhật ký
    @PutMapping("/{maNK}")
    public NhatKyThucTap update(
            @PathVariable String maNK,
            @RequestBody NhatKyThucTap nhatKyMoi) {
        return service.update(maNK, nhatKyMoi);
    }

    // 5. Xóa nhật ký
    @DeleteMapping("/{maNK}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String maNK) {
        service.delete(maNK);
    }
}
