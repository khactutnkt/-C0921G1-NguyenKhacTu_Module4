package vn.codegym.model;

public class ToKhaiYTe {
    private String hoTen;
    private String namSinh;
    private String gioiTinh;
    private String quocTich;
    private String soCMND;
    private ThongTinDiLai thongTinDiLai;
    private ThongTinLienLac thongTinLienLac;
    private String[] trieuChung;
    private String[] lichSuPhoiNhiem;

    public ToKhaiYTe() {
    }

    public ToKhaiYTe(String hoTen, String namSinh, String gioiTinh, String quocTich, String soCMND, ThongTinDiLai thongTinDiLai, ThongTinLienLac thongTinLienLac, String[] trieuChung, String[] lichSuPhoiNhiem) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.soCMND = soCMND;
        this.thongTinDiLai = thongTinDiLai;
        this.thongTinLienLac = thongTinLienLac;
        this.trieuChung = trieuChung;
        this.lichSuPhoiNhiem = lichSuPhoiNhiem;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public ThongTinDiLai getThongTinDiLai() {
        return thongTinDiLai;
    }

    public void setThongTinDiLai(ThongTinDiLai thongTinDiLai) {
        this.thongTinDiLai = thongTinDiLai;
    }

    public ThongTinLienLac getThongTinLienLac() {
        return thongTinLienLac;
    }

    public void setThongTinLienLac(ThongTinLienLac thongTinLienLac) {
        this.thongTinLienLac = thongTinLienLac;
    }

    public String[] getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String[] trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String[] getLichSuPhoiNhiem() {
        return lichSuPhoiNhiem;
    }

    public void setLichSuPhoiNhiem(String[] lichSuPhoiNhiem) {
        this.lichSuPhoiNhiem = lichSuPhoiNhiem;
    }
}
