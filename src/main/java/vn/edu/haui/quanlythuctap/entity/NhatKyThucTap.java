
package vn.edu.haui.quanlythuctap.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHAT_KY_THUC_TAP")
public class NhatKyThucTap {

    @Id
    @Column(name = "MaNK", length = 10, nullable = false)
    private String maNK;

    @Column(name = "MaDK", length = 10, nullable = false)
    private String maDK;

    @Column(name = "NgayGhi")
    private LocalDate ngayGhi;

    @Column(name = "CongViec", columnDefinition = "TEXT")
    private String congViec;

    @Column(name = "KetQua", columnDefinition = "TEXT")
    private String ketQua;

    @Column(name = "GhiChu", columnDefinition = "TEXT")
    private String ghiChu;

    public NhatKyThucTap() {
    }

    public String getMaNK() {
        return maNK;
    }

    public void setMaNK(String maNK) {
        this.maNK = maNK;
    }

    public String getMaDK() {
        return maDK;
    }

    public void setMaDK(String maDK) {
        this.maDK = maDK;
    }

    public LocalDate getNgayGhi() {
        return ngayGhi;
    }

    public void setNgayGhi(LocalDate ngayGhi) {
        this.ngayGhi = ngayGhi;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
