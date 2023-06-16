<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">
<form id="sua" action="/phieu-giam-gia/update/${list.maPhieu}" method="post" >
    <div class="mb-3">
        <label class="form-label">Mã phiếu</label>
        <input type="text" value="${list.maPhieu}" name="maPhieu" class="form-control" disabled/>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên phiếu</label>
        <input type="text" value="${list.tenPhieu}" id="tenPhieu" name="tenPhieu" class="form-control" required />

    </div>
    <div class="mb-3">
        <label class="form-label">Ngày bắt đầu</label>
        <input type="date" value="${bd}" name="ngayBatDau" class="form-control" required/>

    </div>
    <div class="mb-3">
        <label class="form-label">Ngày kết thúc</label>
        <input type="date" value="${kt}" name="ngayKetThuc" class="form-control"/>

    </div>
    <div class="mb-3">
        <label class="form-label">Giá trị giảm</label>
        <input type="text" value="${list.giaTriGiam}" name="giaTriGiam" class="form-control"/>

    </div>
    <div class="mb-3">
        <label class="form-label">Trạng thái</label>
        <input type="text" value="${list.trangThai}" name="trangThai" class="form-control"/>

    </div>

    <select class="form-select" name="nguoiSoHuu" id="nguoiSoHuuSelect" aria-label="Default select example">
        <c:forEach items="${listKhachHang}" var="kh">
            <option value="${kh.maKhachHang}" ${list.nguoiSoHuu.tenKhachHang == kh.tenKhachHang ? "selected" : ""}>${kh.maKhachHang}</option>
        </c:forEach>
    </select>

    <button type="submit">Sửa</button>
</form>
<%--<table class="table">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">#</th>--%>
<%--        <th scope="col">First</th>--%>
<%--        <th scope="col">Last</th>--%>
<%--        <th scope="col">Handle</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>

<%--        <tr>--%>
<%--            <th scope="row">${list.maPhieu}</th>--%>
<%--            <td>${list.tenPhieu}</td>--%>
<%--            <td>${list.ngayBatDau}</td>--%>
<%--            <td>${list.ngayKetThuc}</td>--%>
<%--            <td>${list.giaTriGiam}</td>--%>
<%--            <td>${list.trangThai}</td>--%>
<%--            <td>${list.nguoiSoHuu.tenKhanhHang}</td>--%>

<%--        </tr>--%>


<%--    </tbody>--%>
<%--</table>--%>
<script>
    document.getElementById("sua").addEventListener("submit", function(event) {
        // Hỏi người dùng xác nhận trước khi submit form
        if (!confirm("Bạn có chắc chắn muốn sửa phiếu giảm giá này?")) {
            event.preventDefault();
        }
    });
</script>
</body>
</html>