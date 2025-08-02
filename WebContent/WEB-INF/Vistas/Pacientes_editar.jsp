<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editar Paciente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f5f5f5;
}

.header {
    background-color: #4CAF50;
    color: white;
    padding: 15px 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.header-title {
    font-size: 20px;
    font-weight: bold;
}

.logout-btn {
    background-color: #f44336;
    color: white;
    padding: 8px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-decoration: none;
    font-size: 14px;
}

.logout-btn:hover {
    background-color: #d32f2f;
}

.container {
    width: 95%;
    margin: 30px auto;
    padding: 20px;
    background-color: white;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    overflow-x: auto;
}

.header-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
    flex-wrap: wrap;
}

h1 {
    color: #2E7D32;
    border-bottom: 1px solid #4CAF50;
    padding-bottom: 10px;
    margin: 0;
}

.button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s;
    text-decoration: none;
    display: inline-block;
    margin-left: 10px;
}

.button:hover {
    background-color: #45a049;
}

.message {
    padding: 10px;
    margin-bottom: 20px;
    border-radius: 4px;
}

.message.success {
    background-color: #dff0d8;
    color: #3c763d;
    border: 1px solid #d6e9c6;
}

.message.error {
    background-color: #f2dede;
    color: #a94442;
    border: 1px solid #ebccd1;
}

/* Estilos para DataTables */
.dataTables_wrapper {
    width: 100%;
    margin-top: 20px;
    overflow-x: auto;
}

table.dataTable {
    width: 100% !important;
    border-collapse: collapse !important;
}

table.dataTable thead th {
    background-color: #4CAF50;
    color: white;
    padding: 10px 8px;
    text-align: left;
    white-space: nowrap;
}

table.dataTable tbody td {
    padding: 8px 10px;
    border-bottom: 1px solid #ddd;
    white-space: nowrap;
}

table.dataTable tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

table.dataTable tbody tr:hover {
    background-color: #e8f5e9;
}

.dataTables_filter input {
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
    margin-bottom: 10px;
}

.dataTables_length select {
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

/* Botones de acción */
.action-buttons {
    display: flex;
    gap: 8px;
}

.edit-button {
    background-color: #FFC107;
    color: #000;
    padding: 6px 12px;
    border: none;
    border-radius: 4px;
    text-decoration: none;
    font-size: 14px;
    display: inline-flex;
    align-items: center;
    gap: 5px;
}

.edit-button:hover {
    background-color: #FFA000;
}

.delete-button {
    background-color: #f44336;
    color: white;
    padding: 6px 12px;
    border: none;
    border-radius: 4px;
    text-decoration: none;
    font-size: 14px;
    display: inline-flex;
    align-items: center;
    gap: 5px;
}

.delete-button:hover {
    background-color: #d32f2f;
}

/* Responsive design */
@media (max-width: 992px) {
    .container {
        width: 98%;
        padding: 15px;
    }
    
    .header-row {
        flex-direction: column;
        align-items: flex-start;
        gap: 15px;
    }
    
    .button {
        margin-left: 0;
    }
}

@media (max-width: 768px) {
    table.dataTable thead th, 
    table.dataTable tbody td {
        padding: 6px 4px;
        font-size: 14px;
    }
    
    .edit-button, .delete-button {
        padding: 4px 8px;
        font-size: 12px;
    }
}

@media (max-width: 576px) {
    .container {
        margin: 15px auto;
        padding: 10px;
    }
    
    h1 {
        font-size: 1.5rem;
    }
    
    .button {
        padding: 8px 12px;
        font-size: 14px;
    }
}
</style>
</head>
<body>
<jsp:include page="Header.jsp" />

<div class="container mt-5">
    <h2>Editar Paciente</h2>
    <form action="editarPaciente.html" method="post">
        <input type="hidden" name="dni" value="${paciente.dni}" />

        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="${paciente.nombre}" required>
        </div>

        <div class="mb-3">
            <label for="apellido" class="form-label">Apellido</label>
            <input type="text" class="form-control" id="apellido" name="apellido" value="${paciente.apellido}" required>
        </div>

        <div class="mb-3">
            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" class="form-control" id="direccion" name="direccion" value="${paciente.direccion}">
        </div>

        <div class="mb-3">
            <label for="localidad" class="form-label">Localidad</label>
            <input type="text" class="form-control" id="localidad" name="localidad" value="${paciente.localidad}">
        </div>

        <div class="mb-3">
            <label for="provincia" class="form-label">Provincia</label>
            <input type="text" class="form-control" id="provincia" name="provincia" value="${paciente.provincia}">
        </div>

        <div class="mb-3">
            <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="${paciente.fechaNacimiento}">
        </div>

        <div class="mb-3">
            <label for="correoElectronico" class="form-label">Correo Electrónico</label>
            <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" value="${paciente.correoElectronico}">
        </div>

        <div class="mb-3">
            <label for="telefono" class="form-label">Teléfono</label>
            <input type="text" class="form-control" id="telefono" name="telefono" value="${paciente.telefono}">
        </div>

        <button type="submit" class="btn btn-success">Guardar Cambios</button>
        <a href="listarPacientes.html" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

</body>
</html>
