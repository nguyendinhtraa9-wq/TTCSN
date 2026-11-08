
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import vn.edu.haui.quanlythuctap.entity.NhatKyThucTap;
import vn.edu.haui.quanlythuctap.repository.NhatKyThucTapRepository;

@Service
public class NhatKyThucTapService {

    private final NhatKyThucTapRepository repository;

    public NhatKyThucTapService(
            NhatKyThucTapRepository repository) {
        this.repository = repository;
    }

    // 1. Lấy danh sách nhật ký
    public List<NhatKyThucTap> getAll() {
        return repository.findAll();
    }

    // 2. Tìm nhật ký theo mã
    public NhatKyThucTap getById(String maNK) {
        return repository.findById(maNK)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Khong tim thay nhat ky: " + maNK
                    )
                );
    }

    // 3. Tạo nhật ký mới
    public NhatKyThucTap create(
            NhatKyThucTap nhatKy) {

        if (repository.existsById(nhatKy.getMaNK())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Ma nhat ky da ton tai: " + nhatKy.getMaNK()
            );
        }

        return repository.save(nhatKy);
    }

    // 4. Cập nhật nhật ký
    public NhatKyThucTap update(
            String maNK,
            NhatKyThucTap nhatKyMoi) {

        NhatKyThucTap nhatKyCu = getById(maNK);

        nhatKyCu.setMaDK(nhatKyMoi.getMaDK());
        nhatKyCu.setNgayGhi(nhatKyMoi.getNgayGhi());
        nhatKyCu.setCongViec(nhatKyMoi.getCongViec());
        nhatKyCu.setKetQua(nhatKyMoi.getKetQua());
        nhatKyCu.setGhiChu(nhatKyMoi.getGhiChu());

        return repository.save(nhatKyCu);
    }

    // 5. Xóa nhật ký
    public void delete(String maNK) {
        NhatKyThucTap nhatKy = getById(maNK);
        repository.delete(nhatKy);
    }
}
