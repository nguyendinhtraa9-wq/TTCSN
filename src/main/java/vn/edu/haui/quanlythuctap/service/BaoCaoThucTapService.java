
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.haui.quanlythuctap.entity.BaoCaoThucTap;
import vn.edu.haui.quanlythuctap.repository.BaoCaoThucTapRepository;

@Service
public class BaoCaoThucTapService {

    private final BaoCaoThucTapRepository baoCaoRepository;

    public BaoCaoThucTapService(
            BaoCaoThucTapRepository baoCaoRepository) {
        this.baoCaoRepository = baoCaoRepository;
    }

    // Lấy danh sách báo cáo
    public List<BaoCaoThucTap> getAllBaoCao() {
        return baoCaoRepository.findAll();
    }

    // Lấy báo cáo theo mã
    public BaoCaoThucTap getBaoCaoById(String maBC) {
        return baoCaoRepository.findById(maBC)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Không tìm thấy báo cáo: " + maBC));
    }

    // Thêm báo cáo
    public BaoCaoThucTap createBaoCao(BaoCaoThucTap baoCao) {
    	if (baoCao.getMaBC() == null || baoCao.getMaBC().isBlank()) {
            throw new IllegalArgumentException(
                "Mã báo cáo không được để trống"
            );
        }

        if (baoCaoRepository.existsById(baoCao.getMaBC())) {
            throw new IllegalArgumentException(
                "Mã báo cáo đã tồn tại: " + baoCao.getMaBC()
            );
        }

        if (baoCao.getMaDK() == null || baoCao.getMaDK().isBlank()) {
            throw new IllegalArgumentException(
                "Mã đăng ký thực tập không được để trống"
            );
        }

        return baoCaoRepository.save(baoCao);
    }

    // Cập nhật báo cáo
    public BaoCaoThucTap updateBaoCao(
            String maBC, BaoCaoThucTap thongTinMoi) {

        BaoCaoThucTap baoCao = getBaoCaoById(maBC);

        if (thongTinMoi.getMaDK() == null
                || thongTinMoi.getMaDK().isBlank()) {
            throw new IllegalArgumentException(
                    "Mã đăng ký thực tập không được để trống");
        }

        baoCao.setMaDK(thongTinMoi.getMaDK());
        baoCao.setTieuDe(thongTinMoi.getTieuDe());
        baoCao.setNoiDung(thongTinMoi.getNoiDung());
        baoCao.setNgayNop(thongTinMoi.getNgayNop());
        baoCao.setTrangThai(thongTinMoi.getTrangThai());

        return baoCaoRepository.save(baoCao);
    }

    // Xóa báo cáo
    public void deleteBaoCao(String maBC) {
        BaoCaoThucTap baoCao = getBaoCaoById(maBC);
        baoCaoRepository.delete(baoCao);
    }
}
