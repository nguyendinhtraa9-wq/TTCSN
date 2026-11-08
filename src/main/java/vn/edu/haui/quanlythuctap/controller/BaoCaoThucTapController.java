
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

import vn.edu.haui.quanlythuctap.entity.BaoCaoThucTap;
import vn.edu.haui.quanlythuctap.service.BaoCaoThucTapService;

@RestController
@RequestMapping("/api/bao-cao-thuc-tap")
public class BaoCaoThucTapController {

    private final BaoCaoThucTapService baoCaoService;

    public BaoCaoThucTapController(
            BaoCaoThucTapService baoCaoService) {
        this.baoCaoService = baoCaoService;
    }

    @GetMapping
    public List<BaoCaoThucTap> getAllBaoCao() {
        return baoCaoService.getAllBaoCao();
    }

    @GetMapping("/{maBC}")
    public BaoCaoThucTap getBaoCaoById(
            @PathVariable String maBC) {
        return baoCaoService.getBaoCaoById(maBC);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaoCaoThucTap createBaoCao(
            @RequestBody BaoCaoThucTap baoCao) {
        return baoCaoService.createBaoCao(baoCao);
    }

    @PutMapping("/{maBC}")
    public BaoCaoThucTap updateBaoCao(
            @PathVariable String maBC,
            @RequestBody BaoCaoThucTap baoCao) {
        return baoCaoService.updateBaoCao(maBC, baoCao);
    }

    @DeleteMapping("/{maBC}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBaoCao(@PathVariable String maBC) {
        baoCaoService.deleteBaoCao(maBC);
    }
}
