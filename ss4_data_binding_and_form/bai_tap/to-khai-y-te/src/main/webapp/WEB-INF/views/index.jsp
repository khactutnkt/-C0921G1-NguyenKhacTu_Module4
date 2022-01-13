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
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h4>TỜ KHAI Y TẾ</h4>
            <h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN KÊ KHAI SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h6>
            <div>
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
                <div>Năm sinh (*)</div>
                <th:select path="namSinh" items="${namSinhList}"/>
            </div>
            <div class="col-lg-4">
                <div>Giới tính (*)</div>
                <th:select path="gioiTinh" items="${gioiTinhList}"/>
            </div>
            <div class="col-lg-4">
                <div>Quốc tịch (*)</div>
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

    </form:form>

</div>



</body>
</html>
