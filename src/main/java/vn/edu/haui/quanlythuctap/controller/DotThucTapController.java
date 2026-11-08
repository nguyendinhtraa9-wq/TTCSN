
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

import vn.edu.haui.quanlythuctap.entity.DotThucTap;
import vn.edu.haui.quanlythuctap.service.DotThucTapService;

@RestController
@RequestMapping("/api/dot-thuc-tap")
public class DotThucTapController {

    private final DotThucTapService dotThucTapService;

    public DotThucTapController(
            DotThucTapService dotThucTapService) {
        this.dotThucTapService = dotThucTapService;
    }

    // 1. Lấy danh sách đợt thực tập
    @GetMapping
    public List<DotThucTap> getAllDotThucTap() {
        return dotThucTapService.getAllDotThucTap();
    }

    // 2. Lấy chi tiết đợt thực tập
    @GetMapping("/{maDot}")
    public DotThucTap getDotThucTapById(
            @PathVariable String maDot) {
        return dotThucTapService.getDotThucTapById(maDot);
    }

    // 3. Thêm đợt thực tập
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DotThucTap createDotThucTap(
            @RequestBody DotThucTap dotThucTap) {
        return dotThucTapService.createDotThucTap(dotThucTap);
    }

    // 4. Cập nhật đợt thực tập
    @PutMapping("/{maDot}")
    public DotThucTap updateDotThucTap(
            @PathVariable String maDot,
            @RequestBody DotThucTap dotThucTap) {
        return dotThucTapService.updateDotThucTap(
                maDot, dotThucTap);
    }

    // 5. Xóa đợt thực tập
    @DeleteMapping("/{maDot}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDotThucTap(
            @PathVariable String maDot) {
        dotThucTapService.deleteDotThucTap(maDot);
    }
}
