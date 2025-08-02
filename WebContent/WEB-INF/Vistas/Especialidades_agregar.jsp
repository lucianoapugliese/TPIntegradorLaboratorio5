<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Especialidad</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        line-height: 1.6;
    }
    .container {
        max-width: 500px;
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
    .form-group {
        margin-bottom: 15px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input[type="text"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .button {
        background-color: #4CAF50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    .button:hover {
        background-color: #45a049;
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
    <h1>Agregar Nueva Especialidad</h1>
    
    <%-- Mostrar mensajes de éxito/error --%>
    <% if(request.getAttribute("mensaje") != null) { %>
        <div class="message <%= request.getAttribute("tipoMensaje") %>">
            <%= request.getAttribute("mensaje") %>
        </div>
    <% } %>
    
    <form action="altaEspecialidad.html" method="post">
        <input type="hidden" name="action" value="guardar">
        
        <div class="form-group">
            <label for="nombre">Nombre de la Especialidad:</label>
            <input type="text" id="nombreEspecialidad" name="nombreEspecialidad" required 
                   placeholder="Ingrese el nombre de la especialidad"
                   value="<%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "" %>">
        </div>
        
        <div class="form-group">
            <button type="submit" class="button">Guardar Especialidad</button>
            <a href="listarEspecialidades.html" style="margin-left: 10px;">Volver al listado</a>
        </div>
    </form>
</div>
</body>
</html>