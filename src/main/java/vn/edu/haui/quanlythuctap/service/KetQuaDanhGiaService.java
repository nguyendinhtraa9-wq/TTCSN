
package vn.edu.haui.quanlythuctap.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import vn.edu.haui.quanlythuctap.entity.KetQuaDanhGia;
import vn.edu.haui.quanlythuctap.repository.KetQuaDanhGiaRepository;

@Service
public class KetQuaDanhGiaService {

    private final KetQuaDanhGiaRepository repository;

    public KetQuaDanhGiaService(KetQuaDanhGiaRepository repository) {
        this.repository = repository;
    }

    // Lấy danh sách kết quả đánh giá
    public List<KetQuaDanhGia> getAll() {
        return repository.findAll();
    }

    // Lấy kết quả đánh giá theo mã
    public KetQuaDanhGia getById(String maDG) {
        return repository.findById(maDG)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Khong tim thay ket qua danh gia: " + maDG));
    }

    // Thêm kết quả đánh giá
    public KetQuaDanhGia create(KetQuaDanhGia ketQua) {
        if (ketQua.getMaDG() == null || ketQua.getMaDG().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Ma danh gia khong duoc de trong");
        }

        if (repository.existsById(ketQua.getMaDG())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ma danh gia da ton tai: " + ketQua.getMaDG());
        }

        return repository.save(ketQua);
    }

    // Cập nhật kết quả đánh giá
    public KetQuaDanhGia update(String maDG, KetQuaDanhGia ketQuaMoi) {
        KetQuaDanhGia ketQuaCu = getById(maDG);

        ketQuaCu.setMaDK(ketQuaMoi.getMaDK());
        ketQuaCu.setMaGV(ketQuaMoi.getMaGV());
        ketQuaCu.setDiem(ketQuaMoi.getDiem());
        ketQuaCu.setNhanXet(ketQuaMoi.getNhanXet());
        ketQuaCu.setNgayDanhGia(ketQuaMoi.getNgayDanhGia());

        return repository.save(ketQuaCu);
    }

    // Xóa kết quả đánh giá
    public void delete(String maDG) {
        KetQuaDanhGia ketQua = getById(maDG);
        repository.delete(ketQua);
    }
}
