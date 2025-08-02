<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Medicos</title>

<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/2.2.2/css/buttons.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

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

<div class="container">
    <div class="header-row">
        <h1>Listado de Médicos</h1>
        <a href="altaMedico.html" class="button">
            <i class="fas fa-plus"></i> Nuevo Médico
        </a>
    </div>

    <%-- Mostrar mensajes si existen --%>
    <c:if test="${not empty mensaje}">
        <div class="message ${tipoMensaje}">
            ${mensaje}
        </div>
    </c:if>

    <table id="medicosTable" class="display">
        <thead>
            <tr>
                <th>Legajo</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Sexo</th>
                <th>F. Nac.</th>
                <th>Dirección</th>
                <th>Localidad</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Días Trabajo</th>
                <th>Horario</th>
                <th>Especialidad</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaMedicos}" var="medico">
                <tr>
                    <td>${medico.legajo}</td>
                    <td>${medico.nombre}</td>
                    <td>${medico.apellido}</td>
                    <td>${medico.sexo}</td>
                    <td>${medico.fechaNacimiento}</td>
                    <td>${medico.direccion}</td>
                    <td>${medico.localidad}</td>
                    <td>${medico.email}</td>
                    <td>${medico.telefono}</td>
                    <td>${medico.diasTrabajo}</td>
                    <td>${medico.horarioTrabajo}</td>
                    <td>${medico.especialidad != null ? medico.especialidad.nombre : ''}</td>
                    <td>
                        <div class="action-buttons">
                            <a href="editarMedico.html?legajo=${medico.legajo}" class="edit-button" title="Editar">
                                <i class="fas fa-edit"></i>
                            </a>
                             <a href="bajaMedico.html?legajo=${medico.legajo}" class="delete-button" title="Borrar">
                                <i class="fas fa-trash"></i>
                            </a>

                       
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
<!-- DataTables Buttons -->
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/2.2.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/2.2.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>

<script>
$(document).ready(function() {
    $('#medicosTable').DataTable({
        dom: 'Bfrtip',
        buttons: [],
        scrollX: true,
        pageLength: 5,
        language: {
            "decimal": "",
            "emptyTable": "No hay médicos registrados",
            "info": "Mostrando _START_ a _END_ de _TOTAL_ médicos",
            "infoEmpty": "Mostrando 0 a 0 de 0 registros",
            "infoFiltered": "(filtrado de _MAX_ registros totales)",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Mostrar _MENU_ médicos",
            "loadingRecords": "Cargando...",
            "processing": "Procesando...",
            "search": "Buscar:",
            "zeroRecords": "No se encontraron médicos",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            "aria": {
                "sortAscending": ": activar para ordenar la columna ascendente",
                "sortDescending": ": activar para ordenar la columna descendente"
            }
        },
        responsive: true
    });
});
</script>
</body>
</html>