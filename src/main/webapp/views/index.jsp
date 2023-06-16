<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">
<form action="/phieu-giam-gia/search" method="get" onsubmit="return validateDateRange()">
    <div class="mb-3">
        <label class="form-label">Ngày bắt đầu</label>
        <input type="date" name="startDate" class="form-control"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Ngày kết thúc</label>
        <input type="date" name="endDate" class="form-control"/>
    </div>
    <button type="submit">Search</button>
</form>
<%--<select class="form-select" name="nguoiSoHuu" aria-label="Default select example">--%>
<%--    <c:forEach items="${listKhachHang}" var="kh">--%>
<%--        <option value="${kh.maKhachHang}" ${list.nguoiSoHuu.tenKhachHang == kh.tenKhachHang ? "selected" : ""}>${kh.tenKhachHang}</option>--%>
<%--    </c:forEach>--%>
<%--</select>--%>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="ph">
        <tr>
            <th scope="row">${ph.maPhieu}</th>
            <td>${ph.tenPhieu}</td>
            <td>${ph.ngayBatDau}</td>
            <td>${ph.ngayKetThuc}</td>
            <td>${ph.giaTriGiam}</td>
            <td>${ph.trangThai}</td>
            <td>${ph.nguoiSoHuu.tenKhachHang}</td>
            <td>
                <a href="/phieu-giam-gia/delete/${ph.maPhieu}" onclick="xoa(event)">Xóa</a>
                <a href="/phieu-giam-gia/edit/${ph.maPhieu}" >Sửa</a>
            </td>
        </tr>
    </c:forEach>
    <c:forEach items="${searchResults}" var="tk">
        <tr>
            <th scope="row">${tk.maPhieu}</th>
            <td>${tk.tenPhieu}</td>
            <td>${tk.ngayBatDau}</td>
            <td>${tk.ngayKetThuc}</td>
            <td>${tk.giaTriGiam}</td>
            <td>${tk.trangThai}</td>
            <td>${tk.nguoiSoHuu.tenKhachHang}</td>
            <td>
                <a href="/phieu-giam-gia/delete/${tk.maPhieu}" onclick="xoa(event)">Xóa</a>
                <a href="/phieu-giam-gia/edit/${tk.maPhieu}">Sửa</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
       <c:forEach begin="1" end="${totalPage}" varStatus="status">
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/phieu-giam-gia/hien-thi?pageNum=${status.index}">${status.index}</a></li>
       </c:forEach>
    </ul>
</nav>
<script>
    function xoa(event) {
        if (!confirm("Bạn có muốn xóa không")) {
            event.preventDefault();
        }
    };
</script>
</body>
</html>