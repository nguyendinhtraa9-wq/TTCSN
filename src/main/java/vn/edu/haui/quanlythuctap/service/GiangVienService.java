
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.haui.quanlythuctap.entity.GiangVien;
import vn.edu.haui.quanlythuctap.repository.GiangVienRepository;

@Service
public class GiangVienService {

    private final GiangVienRepository giangVienRepository;

    public GiangVienService(GiangVienRepository giangVienRepository) {
        this.giangVienRepository = giangVienRepository;
    }

    // 1. Lấy danh sách giảng viên
    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.findAll();
    }

    // 2. Tìm giảng viên theo mã
    public GiangVien getGiangVienById(String maGV) {
        return giangVienRepository.findById(maGV)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Không tìm thấy giảng viên có mã: " + maGV));
    }

    // 3. Thêm giảng viên
    public GiangVien createGiangVien(GiangVien giangVien) {
        if (giangVienRepository.existsById(giangVien.getMaGV())) {
            throw new RuntimeException(
                    "Mã giảng viên đã tồn tại: " + giangVien.getMaGV());
        }

        return giangVienRepository.save(giangVien);
    }

    // 4. Cập nhật giảng viên
    public GiangVien updateGiangVien(
            String maGV, GiangVien giangVienMoi) {

        GiangVien giangVienCu = getGiangVienById(maGV);

        giangVienCu.setHoTen(giangVienMoi.getHoTen());
        giangVienCu.setEmail(giangVienMoi.getEmail());
        giangVienCu.setSDT(giangVienMoi.getSDT());
        giangVienCu.setKhoa(giangVienMoi.getKhoa());

        return giangVienRepository.save(giangVienCu);
    }

    // 5. Xóa giảng viên
    public void deleteGiangVien(String maGV) {
        GiangVien giangVien = getGiangVienById(maGV);
        giangVienRepository.delete(giangVien);
    }
}
