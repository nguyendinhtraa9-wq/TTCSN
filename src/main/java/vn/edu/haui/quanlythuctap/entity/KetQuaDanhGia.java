
package vn.edu.haui.quanlythuctap.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KET_QUA_DANH_GIA")
public class KetQuaDanhGia {

    @Id
    @Column(name = "MaDG", length = 10, nullable = false)
    private String maDG;

    @Column(name = "MaDK", nullable = false, length = 10)
    private String maDK;

    @Column(name = "MaGV", length = 10)
    private String maGV;

    @Column(name = "Diem")
    private Float diem;

    @Column(name = "NhanXet", columnDefinition = "TEXT")
    private String nhanXet;

    @Column(name = "NgayDanhGia")
    private LocalDate ngayDanhGia;

    public KetQuaDanhGia() {
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getMaDK() {
        return maDK;
    }

    public void setMaDK(String maDK) {
        this.maDK = maDK;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

    public LocalDate getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(LocalDate ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }
}
