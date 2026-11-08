
package vn.edu.haui.quanlythuctap.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BAO_CAO_THUC_TAP")
public class BaoCaoThucTap {

    @Id
    @JsonProperty("maBC")
    @Column(name = "MaBC", length = 10)
    private String MaBC;

    @JsonProperty("maDK")
    @Column(name = "MaDK", nullable = false, length = 10)
    private String MaDK;

    @JsonProperty("tieuDe")
    @Column(name = "TieuDe", length = 200)
    private String TieuDe;

    @JsonProperty("noiDung")
    @Column(name = "NoiDung", columnDefinition = "TEXT")
    private String NoiDung;

    @JsonProperty("ngayNop")
    @Column(name = "NgayNop")
    private LocalDate NgayNop;

    @JsonProperty("trangThai")
    @Column(name = "TrangThai", length = 30)
    private String TrangThai;

    public BaoCaoThucTap() {
    }

    public String getMaBC() {
        return MaBC;
    }

    public void setMaBC(String maBC) {
        this.MaBC = maBC;
    }

    public String getMaDK() {
        return MaDK;
    }

    public void setMaDK(String maDK) {
        this.MaDK = maDK;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.TieuDe = tieuDe;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        this.NoiDung = noiDung;
    }

    public LocalDate getNgayNop() {
        return NgayNop;
    }

    public void setNgayNop(LocalDate ngayNop) {
        this.NgayNop = ngayNop;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        this.TrangThai = trangThai;
    }
}
