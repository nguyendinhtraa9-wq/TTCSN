
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.haui.quanlythuctap.entity.DangKyThucTap;
import vn.edu.haui.quanlythuctap.repository.DangKyThucTapRepository;

@Service
public class DangKyThucTapService {

    private final DangKyThucTapRepository repository;

    public DangKyThucTapService(DangKyThucTapRepository repository) {
        this.repository = repository;
    }

    public List<DangKyThucTap> getAll() {
        return repository.findAll();
    }

    public DangKyThucTap getById(String maDK) {
        return repository.findById(maDK)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Khong tim thay dang ky thuc tap: " + maDK
                    )
                );
    }

    public DangKyThucTap create(DangKyThucTap dangKy) {
        if (repository.existsById(dangKy.getMaDK())) {
            throw new RuntimeException(
                "Ma dang ky da ton tai: " + dangKy.getMaDK()
            );
        }

        return repository.save(dangKy);
    }

    public DangKyThucTap update(
            String maDK, DangKyThucTap dangKyMoi) {

        DangKyThucTap dangKyCu = getById(maDK);

        dangKyCu.setMaSV(dangKyMoi.getMaSV());
        dangKyCu.setMaGV(dangKyMoi.getMaGV());
        dangKyCu.setMaDN(dangKyMoi.getMaDN());
        dangKyCu.setMaDot(dangKyMoi.getMaDot());
        dangKyCu.setNgayDangKy(dangKyMoi.getNgayDangKy());
        dangKyCu.setTrangThai(dangKyMoi.getTrangThai());

        return repository.save(dangKyCu);
    }

    public void delete(String maDK) {
        DangKyThucTap dangKy = getById(maDK);
        repository.delete(dangKy);
    }
}
