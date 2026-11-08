
package vn.edu.haui.quanlythuctap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "DANG_KY_THUC_TAP")
public class DangKyThucTap {

    @Id
    @Column(name = "MaDK", length = 10)
    private String maDK;

    @Column(name = "MaSV", nullable = false, length = 10)
    private String maSV;

    @Column(name = "MaGV", length = 10)
    private String maGV;

    @Column(name = "MaDN", length = 10)
    private String maDN;

    @Column(name = "MaDot", length = 10)
    private String maDot;

    @Column(name = "NgayDangKy")
    private LocalDate ngayDangKy;

    @Column(name = "TrangThai", length = 30)
    private String trangThai;

    public DangKyThucTap() {}

    public String getMaDK() { return maDK; }
    public void setMaDK(String maDK) { this.maDK = maDK; }

    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getMaGV() { return maGV; }
    public void setMaGV(String maGV) { this.maGV = maGV; }

    public String getMaDN() { return maDN; }
    public void setMaDN(String maDN) { this.maDN = maDN; }

    public String getMaDot() { return maDot; }
    public void setMaDot(String maDot) { this.maDot = maDot; }

    public LocalDate getNgayDangKy() { return ngayDangKy; }
    public void setNgayDangKy(LocalDate ngayDangKy) { this.ngayDangKy = ngayDangKy; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}
