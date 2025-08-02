<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editar Turno</title>
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

<jsp:include page="Header.jsp" />

<div class="container mt-5 mb-5">
    <div class="bg-white p-4 rounded shadow-sm">
        <h2 class="mb-4 text-success border-bottom pb-2">Editar Turno</h2>

        <c:if test="${not empty mensaje}">
            <div class="alert ${tipoMensaje == 'success' ? 'alert-success' : 'alert-danger'}" role="alert">
                ${mensaje}
            </div>
        </c:if>

        <form action="editarturno.html" method="post">
            <input type="hidden" name="id" value="${turno.id}" />

            <div class="mb-3">
                <label for="fecha" class="form-label">Fecha:</label>
                <input type="date" class="form-control" name="fecha" id="fecha" value="${turno.fecha}" required />
            </div>

            <div class="mb-3">
                <label for="hora" class="form-label">Hora:</label>
                <input type="time" class="form-control" name="hora" id="hora" value="${turno.hora}" required />
            </div>

            <div class="mb-3">
                <label for="observacion" class="form-label">Observación:</label>
                <input type="text" class="form-control" name="observacion" id="observacion" value="${turno.observacion}" />
            </div>

            <div class="mb-3">
                <label for="estado" class="form-label">Estado:</label>
                <select name="estado" id="estado" class="form-select" required>
                    <option value="PROXIMO" ${turno.estado == 'PROXIMO' ? 'selected' : ''}>Próximo</option>
                    <option value="CANCELADO" ${turno.estado == 'CANCELADO' ? 'selected' : ''}>Cancelado</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="medicoId" class="form-label">Médico:</label>
                <select name="medicoId" id="medicoId" class="form-select" required>
                    <c:forEach var="medico" items="${listaMedicos}">
                        <option value="${medico.legajo}" ${medico.legajo == turno.medico.legajo ? 'selected' : ''}>
                            ${medico.nombre} ${medico.apellido}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-4">
                <label for="pacienteDni" class="form-label">Paciente:</label>
                <select name="pacienteDni" id="pacienteDni" class="form-select" required>
                    <c:forEach var="paciente" items="${listaPacientes}">
                        <option value="${paciente.dni}" ${paciente.dni == turno.paciente.dni ? 'selected' : ''}>
                            ${paciente.nombre} ${paciente.apellido}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="d-flex gap-2">
                <button type="submit" class="btn btn-success">Guardar Cambios</button>
                <a href="listarTurnos.html?legajo=" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
