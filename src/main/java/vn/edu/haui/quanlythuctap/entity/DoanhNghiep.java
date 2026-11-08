
package vn.edu.haui.quanlythuctap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOANH_NGHIEP")
public class DoanhNghiep {

    @Id
    @Column(name = "MaDN", length = 10)
    private String maDN;

    @Column(name = "TenDN", nullable = false, length = 50)
    private String tenDN;

    @Column(name = "DiaChi", length = 255)
    private String diaChi;

    @Column(name = "LinhVuc", length = 50)
    private String linhVuc;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "SDT", length = 20)
    private String sdt;

    public DoanhNghiep() {}

    public String getMaDN() { return maDN; }
    public void setMaDN(String maDN) { this.maDN = maDN; }

    public String getTenDN() { return tenDN; }
    public void setTenDN(String tenDN) { this.tenDN = tenDN; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getLinhVuc() { return linhVuc; }
    public void setLinhVuc(String linhVuc) { this.linhVuc = linhVuc; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
}
