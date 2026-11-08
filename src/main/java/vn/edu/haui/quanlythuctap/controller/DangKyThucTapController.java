
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

import vn.edu.haui.quanlythuctap.entity.DangKyThucTap;
import vn.edu.haui.quanlythuctap.service.DangKyThucTapService;

@RestController
@RequestMapping("/api/dang-ky-thuc-tap")
public class DangKyThucTapController {

    private final DangKyThucTapService service;

    public DangKyThucTapController(DangKyThucTapService service) {
        this.service = service;
    }

    @GetMapping
    public List<DangKyThucTap> getAll() {
        return service.getAll();
    }

    @GetMapping("/{maDK}")
    public DangKyThucTap getById(@PathVariable String maDK) {
        return service.getById(maDK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DangKyThucTap create(
            @RequestBody DangKyThucTap dangKy) {
        return service.create(dangKy);
    }

    @PutMapping("/{maDK}")
    public DangKyThucTap update(
            @PathVariable String maDK,
            @RequestBody DangKyThucTap dangKyMoi) {
        return service.update(maDK, dangKyMoi);
    }

    @DeleteMapping("/{maDK}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String maDK) {
        service.delete(maDK);
    }
}
