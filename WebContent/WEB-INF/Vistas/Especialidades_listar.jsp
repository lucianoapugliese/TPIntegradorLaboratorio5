<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Especialidades</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        line-height: 1.6;
    }
    .container {
        max-width: 700px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        background-color: #f9f9f9;
    }
    h1 {
        color: #333;
        text-align: center;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    .button {
        background-color: #4CAF50;
        color: white;
        padding: 8px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 14px;
        text-decoration: none;
    }
    .button:hover {
        background-color: #45a049;
    }
    .form-group {
        margin-top: 20px;
        text-align: right;
    }
    .message {
        margin: 15px 0;
        padding: 10px;
        border-radius: 4px;
    }
    .success {
        background-color: #dff0d8;
        color: #3c763d;
        border: 1px solid #d6e9c6;
    }
    .error {
        background-color: #f2dede;
        color: #a94442;
        border: 1px solid #ebccd1;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Listado de Especialidades</h1>

    <%-- Mostrar mensajes si existen --%>
    <c:if test="${not empty mensaje}">
        <div class="message ${tipoMensaje}">
            ${mensaje}
        </div>
    </c:if>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre de la Especialidad</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaEspecialidades}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="form-group">
        <a href="altaEspecialidad.html" class="button">Agregar nueva especialidad</a>
    </div>
</div>
</body>
</html>
