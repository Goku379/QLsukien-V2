<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách bộ môn</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .form-container {
            display: none; /* Ẩn form ban đầu */
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border: 1px solid #ccc;
            padding: 20px;
            background: white;
            z-index: 1000;
        }
        .overlay {
            display: none; /* Ẩn overlay ban đầu */
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: 500;
        }
    </style>
    <script>
        function toggleForm() {
            const formContainer = document.getElementById('formContainer');
            const overlay = document.getElementById('overlay');
            const isDisplayed = formContainer.style.display === 'block';

            formContainer.style.display = isDisplayed ? 'none' : 'block';
            overlay.style.display = isDisplayed ? 'none' : 'block';
        }
    </script>
</head>
<body>
<h1>Danh sách bộ môn</h1>

<button onclick="toggleForm()">Thêm bộ môn</button>

<div class="overlay" id="overlay" onclick="toggleForm()"></div>

<div class="form-container" id="formContainer">
    <h2>Thêm Bộ Môn</h2>
    <form action="${pageContext.request.contextPath}/QLSK/add" method="post">
        <label for="code">Mã bộ môn:</label><br>
        <input type="text" id="code" name="code" required><br><br>

        <label for="name">Tên bộ môn:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="headEmail">Email chủ nhiệm:</label><br>
        <input type="email" id="headEmail" name="headEmail"><br><br>

        <button type="submit">Lưu</button>
        <button type="button" onclick="toggleForm()">Hủy</button>
    </form>
</div>

<table>
    <tr>
        <th>STT</th>
        <th>Mã bộ môn</th>
        <th>Tên bộ môn</th>
        <th>Email chủ nhiệm</th>
        <th>Chức năng</th>
    </tr>
    <c:forEach items="${departments}" var="department" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${department.code}</td>
            <td>${department.name}</td>
            <td>${department.headEmail}</td>
            <td>
                <a href="${pageContext.request.contextPath}/QLSK/update/${department.id}">Sửa</a>
                <a href="${pageContext.request.contextPath}/QLSK/delete/${department.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
