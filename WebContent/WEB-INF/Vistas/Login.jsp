<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Sistema de Gestión Médica</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f9f9f9;
    }
    .container {
        max-width: 400px;
        width: 100%;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 5px;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        color: #333;
        text-align: center;
        margin-bottom: 20px;
    }
    .form-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    .button {
        background-color: #4CAF50;
        color: white;
        padding: 12px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }
    .button:hover {
        background-color: #45a049;
    }
    .message {
        margin: 15px 0;
        padding: 10px;
        border-radius: 4px;
        text-align: center;
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
    .footer {
        text-align: center;
        margin-top: 20px;
        color: #777;
        font-size: 14px;
    }
    .brand {
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        color: #333;
        margin-bottom: 30px;
    }
</style>
</head>
<body>
<div class="container">
    <div class="brand">Sistema de Gestión Clínica Médica</div>
    
    <%-- Mostrar mensajes de error --%>
    <% if(request.getAttribute("mensaje") != null) { %>
        <div class="message <%= request.getAttribute("tipoMensaje") %>">
            <%= request.getAttribute("mensaje") %>
        </div>
    <% } %>
    
    <h1>Iniciar Sesión</h1>
    
    <form action="login.html" method="post">
        <div class="form-group">
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" required 
                   placeholder="Ingrese su nombre de usuario">
        </div>
        
        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required 
                   placeholder="Ingrese su contraseña">
        </div>
        
        <div class="form-group">
            <button type="submit" class="button">Ingresar</button>
        </div>
    </form>
    
    <div class="footer">
        &copy; 2025 Sistema de Gestión Médica
    </div>
</div>
</body>
</html>