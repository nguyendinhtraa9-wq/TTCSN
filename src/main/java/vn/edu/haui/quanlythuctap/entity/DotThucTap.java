
package vn.edu.haui.quanlythuctap.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOT_THUC_TAP")
public class DotThucTap {

    @Id
    @JsonProperty("maDot")
    @Column(name = "MaDot", length = 10)
    private String MaDot;

    @JsonProperty("tenDot")
    @Column(name = "TenDot", length = 200)
    private String TenDot;

    @JsonProperty("ngayBatDau")
    @Column(name = "NgayBatDau")
    private LocalDate NgayBatDau;

    @JsonProperty("ngayKetThuc")
    @Column(name = "NgayKetThuc")
    private LocalDate NgayKetThuc;

    @JsonProperty("moTa")
    @Column(name = "MoTa", columnDefinition = "TEXT")
    private String MoTa;

    @JsonProperty("trangThai")
    @Column(name = "TrangThai", length = 30)
    private String TrangThai;

    public DotThucTap() {
    }

    public String getMaDot() {
        return MaDot;
    }

    public void setMaDot(String maDot) {
        this.MaDot = maDot;
    }

    public String getTenDot() {
        return TenDot;
    }

    public void setTenDot(String tenDot) {
        this.TenDot = tenDot;
    }

    public LocalDate getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.NgayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.NgayKetThuc = ngayKetThuc;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        this.MoTa = moTa;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        this.TrangThai = trangThai;
    }
}
