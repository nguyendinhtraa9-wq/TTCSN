
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.haui.quanlythuctap.entity.SinhVien;
import vn.edu.haui.quanlythuctap.repository.SinhVienRepository;

@Service
public class SinhVienService {

    private final SinhVienRepository sinhVienRepository;

    public SinhVienService(SinhVienRepository sinhVienRepository) {
        this.sinhVienRepository = sinhVienRepository;
    }

    // Lấy danh sách sinh viên
    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    // Lấy sinh viên theo mã
    public SinhVien getSinhVienById(String maSV) {
        return sinhVienRepository.findById(maSV)
                .orElseThrow(() ->
                    new RuntimeException("Không tìm thấy sinh viên: " + maSV));
    }

    // Thêm sinh viên
    public SinhVien createSinhVien(SinhVien sinhVien) {
        if (sinhVienRepository.existsById(sinhVien.getMaSV())) {
            throw new RuntimeException(
                    "Mã sinh viên đã tồn tại: " + sinhVien.getMaSV());
        }

        return sinhVienRepository.save(sinhVien);
    }

    // Cập nhật sinh viên
    public SinhVien updateSinhVien(String maSV, SinhVien thongTinMoi) {
        SinhVien sinhVien = getSinhVienById(maSV);

        sinhVien.setHoTen(thongTinMoi.getHoTen());
        sinhVien.setNgaySinh(thongTinMoi.getNgaySinh());
        sinhVien.setGioiTinh(thongTinMoi.getGioiTinh());
        sinhVien.setEmail(thongTinMoi.getEmail());
        sinhVien.setSdt(thongTinMoi.getSdt());
        sinhVien.setLop(thongTinMoi.getLop());
        sinhVien.setNganh(thongTinMoi.getNganh());

        return sinhVienRepository.save(sinhVien);
    }

    // Xóa sinh viên
    public void deleteSinhVien(String maSV) {
        SinhVien sinhVien = getSinhVienById(maSV);
        sinhVienRepository.delete(sinhVien);
    }
}
