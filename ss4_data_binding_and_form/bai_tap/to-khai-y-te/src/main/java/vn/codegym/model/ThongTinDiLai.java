package vn.codegym.model;

public class ThongTinDiLai {
    private String phuongTien;
    private String soHieuphuongTien;
    private String soGhe;
    private String ngayKhoiHanh;
    private String ThangKhoiHanh;
    private String namKhoiHanh;
    private String ngayKetThuc;
    private String thangKetThuc;
    private String namKetThuc;
    private String tinhDaDiDen;

    public ThongTinDiLai() {
    }

    public ThongTinDiLai(String phuongTien, String soHieuphuongTien, String soGhe, String ngayKhoiHanh, String thangKhoiHanh, String namKhoiHanh, String ngayKetThuc, String thangKetThuc, String namKetThuc, String tinhDaDiDen) {
        this.phuongTien = phuongTien;
        this.soHieuphuongTien = soHieuphuongTien;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        ThangKhoiHanh = thangKhoiHanh;
        this.namKhoiHanh = namKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.thangKetThuc = thangKetThuc;
        this.namKetThuc = namKetThuc;
        this.tinhDaDiDen = tinhDaDiDen;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public String getSoHieuphuongTien() {
        return soHieuphuongTien;
    }

    public void setSoHieuphuongTien(String soHieuphuongTien) {
        this.soHieuphuongTien = soHieuphuongTien;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getThangKhoiHanh() {
        return ThangKhoiHanh;
    }

    public void setThangKhoiHanh(String thangKhoiHanh) {
        ThangKhoiHanh = thangKhoiHanh;
    }

    public String getNamKhoiHanh() {
        return namKhoiHanh;
    }

    public void setNamKhoiHanh(String namKhoiHanh) {
        this.namKhoiHanh = namKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getThangKetThuc() {
        return thangKetThuc;
    }

    public void setThangKetThuc(String thangKetThuc) {
        this.thangKetThuc = thangKetThuc;
    }

    public String getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(String namKetThuc) {
        this.namKetThuc = namKetThuc;
    }

    public String getTinhDaDiDen() {
        return tinhDaDiDen;
    }

    public void setTinhDaDiDen(String tinhDaDiDen) {
        this.tinhDaDiDen = tinhDaDiDen;
    }
}
