<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
<%--    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css"/>--%>
<%--    <script src="../../bootstrap413/js/bootstrap.min.js"></script>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

    <style>
        span{
            color: red;
        }
        input{
            width: 100%;
        }
        select{
            width: 100%;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h4>TỜ KHAI Y TẾ</h4>
            <h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN KÊ KHAI SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h6>
            <div class="text-danger font-weight-bold">
                Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật
            </div>
        </div>
    </div>
    <form:form modelAttribute="toKhaiYTe" method="post" action="/">
        <div class="row">
            <div class="col-lg-12">
                <div>Họ tên (ghi chữ IN HOA) <span>(*)</span></div>
                <th:input path="hoTen"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div>Năm sinh <span>(*)</span></div>
                <th:select path="namSinh" items="${namSinhList}"/>
            </div>
            <div class="col-lg-4">
                <div>Giới tính <span>(*)</span></div>
                <th:select path="gioiTinh" items="${gioiTinhList}"/>
            </div>
            <div class="col-lg-4">
                <div>Quốc tịch <span>(*)</span></div>
                <th:input path="quocTich"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div>Số hộ chiếu hoặc số CMND <span>(*)</span></div>
                <th:input path="soCMND"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div>Thông tin đi lại <span>(*)</span></div>
                <th:radiobuttons path="thongTinDiLai.phuongTien" items="${phuongTienList}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div>Số hiệu phuong tiện</div>
                <th:input path="thongTinDiLai.soHieuphuongTien"/>
            </div>
            <div class="col-lg-6">
                <div>Số ghế</div>
                <th:input path="thongTinDiLai.soGhe"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div>Trong vòng 14 ngày, anh/chị có đến tỉnh thành phố nào? <span>(*)</span></div>
                <th:input path="thongTinDiLai.tinhDaDiDen"/>
            </div>
        </div>
        <div class="row">
            <div>Địa chỉ liên lạc</div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div>Tỉnh/thành <span>(*)</span></div>
                <th:input path="thongTinLienLac.tinhThanh"/>
            </div>
            <div class="col-lg-4">
                <div>Quận/huyện <span>(*)</span></div>
                <th:input path="thongTinLienLac.quanHuyen"/>
            </div>
            <div class="col-lg-4">
                <div>Phường/xã <span>(*)</span></div>
                <th:input path="thongTinLienLac.phuongXa"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div>Địa chỉ nơi ở <span>(*)</span></div>
                <th:input path="thongTinLienLac.diaChiNoiO"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div>Điện thoại <span>(*)</span></div>
                <th:input path="thongTinLienLac.dienThoai"/>
            </div>
            <div class="col-lg-6">
                <div>Email</div>
                <th:input path="thongTinLienLac.email"/>
            </div>
        </div>
        <div class="row">
            <div>Trong vòng 14 ngày qua ,Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không? <span>(*)</span></div>
            <div class="col-lg-6">
                <table class="table table-bordered">
                    <tr class="bg-secondary">
                        <th>Triệu chứng</th>
                        <th class="text-center">Có</th>
                    </tr>
                    <tr>
                        <td>Sốt <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Sốt"/></td>
                    </tr>
                    <tr>
                        <td>Ho <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Ho"/></td>
                    </tr>
                    <tr>
                        <td>Khó thở <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Khó thở"/></td>
                    </tr>
                    <tr>
                        <td>Đau họng <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Đau họng"/></td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-6">
                <table class="table table-bordered col-lg-6">
                    <tr class="bg-secondary">
                        <th>Triệu chứng</th>
                        <th class="text-center">Có</th>
                    </tr>
                    <tr>
                        <td>Nôn/buồn nôn <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Nôn/buồn nôn"/></td>
                    </tr>
                    <tr>
                        <td>Tiêu chảy <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Tiêu chảy"/></td>
                    </tr>
                    <tr>
                        <td>Xuất huyết ngoài da <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Xuất huyết ngoài da"/></td>
                    </tr>
                    <tr>
                        <td>Nổi ban ngoài da <span>(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Nổi ban ngoài da"/></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div>.Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có <span>(*)</span></div>
            <div class="col-lg-12">
                <table class="table table-bordered">
                    <tr class="bg-secondary">
                        <th></th>
                        <th class="text-center">Có</th>
                    </tr>
                    <tr>
                        <td>Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật /
                            tiếp xúc động vật <span>(*)</span>
                        </td>
                        <td><th:checkbox path="lichSuPhoiNhiem" value="Đến nơi có dịch"/></td>
                    </tr>
                    <tr>
                        <td>Tiếp xúc gần(<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span>(*)</span>
                        </td>
                        <td><th:checkbox path="lichSuPhoiNhiem" value="Tiếp xúc gần"/></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
                <div class="col-lg-12 text-danger">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch , thuộc quản lý của
                    Ban chỉ đạo quốc về Phòng chống dịch Covid-19.<br> Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý</div>
            <div class="col-lg-12 text-center">
                <button type="submit">GỬI TỜ KHAI</button>
            </div>
        </div>
    </form:form>

    <h3 class="font-weight-bold text-primary">${mess1}</h3>

</div>



</body>
</html>
