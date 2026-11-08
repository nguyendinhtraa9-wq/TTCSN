
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.haui.quanlythuctap.entity.DoanhNghiep;
import vn.edu.haui.quanlythuctap.repository.DoanhNghiepRepository;

@Service
public class DoanhNghiepService {

    private final DoanhNghiepRepository doanhNghiepRepository;

    public DoanhNghiepService(
            DoanhNghiepRepository doanhNghiepRepository) {
        this.doanhNghiepRepository = doanhNghiepRepository;
    }

    // Lấy danh sách doanh nghiệp
    public List<DoanhNghiep> getAllDoanhNghiep() {
        return doanhNghiepRepository.findAll();
    }

    // Lấy doanh nghiệp theo mã
    public DoanhNghiep getDoanhNghiepById(String maDN) {
        return doanhNghiepRepository.findById(maDN)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Không tìm thấy doanh nghiệp có mã: " + maDN));
    }

    // Thêm doanh nghiệp
    public DoanhNghiep createDoanhNghiep(DoanhNghiep doanhNghiep) {
        if (doanhNghiep.getMaDN() == null
                || doanhNghiep.getMaDN().isBlank()) {
            throw new IllegalArgumentException("Mã doanh nghiệp không được để trống");
        }

        if (doanhNghiepRepository.existsById(doanhNghiep.getMaDN())) {
            throw new RuntimeException(
                    "Mã doanh nghiệp đã tồn tại: " + doanhNghiep.getMaDN());
        }

        if (doanhNghiep.getTenDN() == null
                || doanhNghiep.getTenDN().isBlank()) {
            throw new IllegalArgumentException("Tên doanh nghiệp không được để trống");
        }

        return doanhNghiepRepository.save(doanhNghiep);
    }

    // Cập nhật doanh nghiệp
    public DoanhNghiep updateDoanhNghiep(
            String maDN, DoanhNghiep doanhNghiepMoi) {

        DoanhNghiep doanhNghiepCu = getDoanhNghiepById(maDN);

        doanhNghiepCu.setTenDN(doanhNghiepMoi.getTenDN());
        doanhNghiepCu.setDiaChi(doanhNghiepMoi.getDiaChi());
        doanhNghiepCu.setLinhVuc(doanhNghiepMoi.getLinhVuc());
        doanhNghiepCu.setEmail(doanhNghiepMoi.getEmail());
        doanhNghiepCu.setSdt(doanhNghiepMoi.getSdt());

        return doanhNghiepRepository.save(doanhNghiepCu);
    }

    // Xóa doanh nghiệp
    public void deleteDoanhNghiep(String maDN) {
        DoanhNghiep doanhNghiep = getDoanhNghiepById(maDN);
        doanhNghiepRepository.delete(doanhNghiep);
    }
}
