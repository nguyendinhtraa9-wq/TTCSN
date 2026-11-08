
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.haui.quanlythuctap.entity.DotThucTap;
import vn.edu.haui.quanlythuctap.repository.DotThucTapRepository;

@Service
public class DotThucTapService {

    private final DotThucTapRepository dotThucTapRepository;

    public DotThucTapService(
            DotThucTapRepository dotThucTapRepository) {
        this.dotThucTapRepository = dotThucTapRepository;
    }

    // Lấy danh sách đợt thực tập
    public List<DotThucTap> getAllDotThucTap() {
        return dotThucTapRepository.findAll();
    }

    // Lấy đợt thực tập theo mã
    public DotThucTap getDotThucTapById(String maDot) {
        return dotThucTapRepository.findById(maDot)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Không tìm thấy đợt thực tập: " + maDot));
    }

    // Thêm đợt thực tập
    public DotThucTap createDotThucTap(DotThucTap dotThucTap) {
        if (dotThucTap.getMaDot() == null
                || dotThucTap.getMaDot().isBlank()) {
            throw new IllegalArgumentException(
                    "Mã đợt thực tập không được để trống");
        }

        if (dotThucTapRepository.existsById(dotThucTap.getMaDot())) {
            throw new RuntimeException(
                    "Mã đợt thực tập đã tồn tại: "
                            + dotThucTap.getMaDot());
        }

        if (dotThucTap.getTenDot() == null
                || dotThucTap.getTenDot().isBlank()) {
            throw new IllegalArgumentException(
                    "Tên đợt thực tập không được để trống");
        }

        if (dotThucTap.getNgayBatDau() != null
                && dotThucTap.getNgayKetThuc() != null
                && dotThucTap.getNgayKetThuc()
                        .isBefore(dotThucTap.getNgayBatDau())) {
            throw new IllegalArgumentException(
                    "Ngày kết thúc không được trước ngày bắt đầu");
        }

        return dotThucTapRepository.save(dotThucTap);
    }

    // Cập nhật đợt thực tập
    public DotThucTap updateDotThucTap(
            String maDot, DotThucTap thongTinMoi) {

        DotThucTap dotThucTap = getDotThucTapById(maDot);

        if (thongTinMoi.getTenDot() == null
                || thongTinMoi.getTenDot().isBlank()) {
            throw new IllegalArgumentException(
                    "Tên đợt thực tập không được để trống");
        }

        if (thongTinMoi.getNgayBatDau() != null
                && thongTinMoi.getNgayKetThuc() != null
                && thongTinMoi.getNgayKetThuc()
                        .isBefore(thongTinMoi.getNgayBatDau())) {
            throw new IllegalArgumentException(
                    "Ngày kết thúc không được trước ngày bắt đầu");
        }

        dotThucTap.setTenDot(thongTinMoi.getTenDot());
        dotThucTap.setNgayBatDau(thongTinMoi.getNgayBatDau());
        dotThucTap.setNgayKetThuc(thongTinMoi.getNgayKetThuc());
        dotThucTap.setMoTa(thongTinMoi.getMoTa());
        dotThucTap.setTrangThai(thongTinMoi.getTrangThai());

        return dotThucTapRepository.save(dotThucTap);
    }

    // Xóa đợt thực tập
    public void deleteDotThucTap(String maDot) {
        DotThucTap dotThucTap = getDotThucTapById(maDot);
        dotThucTapRepository.delete(dotThucTap);
    }
}
