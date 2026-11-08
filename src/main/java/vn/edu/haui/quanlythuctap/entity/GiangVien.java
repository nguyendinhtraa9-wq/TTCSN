
package vn.edu.haui.quanlythuctap.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GIANG_VIEN")
public class GiangVien {

    @Id
    @JsonProperty("maGV")
    @Column(name = "MaGV", length = 10)
    private String MaGV;

    @JsonProperty("hoTen")
    @Column(name = "HoTen", nullable = false, length = 50)
    private String HoTen;

    @JsonProperty("email")
    @Column(name = "Email", length = 50)
    private String Email;

    @JsonProperty("sdt")
    @Column(name = "SDT", length = 20)
    private String SDT;

    @JsonProperty("khoa")
    @Column(name = "Khoa", length = 50)
    private String Khoa;

    public GiangVien() {
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String maGV) {
        this.MaGV = maGV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        this.HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        this.Khoa = khoa;
    }
}
