<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asignar Turno</title>

<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/2.2.2/css/buttons.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>


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

h1, h2 {
    color: #2E7D32;
    border-bottom: 1px solid #4CAF50;
    padding-bottom: 10px;
    margin: 0 0 20px 0;
    width: 100%;
}

.form-container {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
}

.form-column {
    flex: 1;
    min-width: 300px;
}

.form-section {
    background-color: #f9f9f9;
    border-radius: 5px;
    padding: 15px;
    margin-bottom: 20px;
    box-shadow: 0 0 5px rgba(0,0,0,0.05);
}

.form-section-title {
    color: #2E7D32;
    margin-top: 0;
    padding-bottom: 8px;
    border-bottom: 1px solid #e0e0e0;
    font-size: 18px;
}

.message {
    padding: 10px;
    margin-bottom: 20px;
    border-radius: 4px;
    width: 100%;
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

.form-label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    color: #333;
}

.form-select, .form-control {
    width: 100%;
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
    transition: border-color 0.3s;
    margin-bottom: 15px;
}

.form-select:focus, .form-control:focus {
    border-color: #4CAF50;
    outline: none;
    box-shadow: 0 0 5px rgba(76, 175, 80, 0.3);
}

.button-group {
    display: flex;
    justify-content: flex-end;
    gap: 10px;
    width: 100%;
    margin-top: 20px;
}

.btn {
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.3s;
    text-decoration: none;
    display: inline-flex;
    align-items: center;
    gap: 8px;
}

.btn-primary {
    background-color: #4CAF50;
    color: white;
}

.btn-primary:hover {
    background-color: #45a049;
}

.btn-secondary {
    background-color: #6c757d;
    color: white;
}

.btn-secondary:hover {
    background-color: #5a6268;
}

/* Responsive design */
@media (max-width: 768px) {
    .form-column {
        flex: 100%;
    }
    
    .container {
        width: 98%;
        padding: 15px;
    }
    
    h2 {
        font-size: 1.5rem;
    }
    
    .btn {
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
        <h2>Asignar Nuevo Turno</h2>
    </div>

    <%-- Mostrar mensajes si existen --%>
    <c:if test="${not empty mensaje}">
        <div class="message ${tipoMensaje}">
            ${mensaje}
        </div>
    </c:if>
    
    <c:if test="${not empty error}">
        <div class="message error">
            ${error}
        </div>
    </c:if>
    
    <form action="${pageContext.request.contextPath}/asignarTurnos.html" id="form-turno" method="post">
        <div class="form-container">
            <!-- Columna Izquierda -->
            <div class="form-column">
                <div class="form-section">
                    <h3 class="form-section-title">Información Médica</h3>
                    
                    <!-- Selección de Especialidad -->
                    <label for="especialidad" class="form-label">Especialidad:</label>
                    <select id="especialidad" name="especialidadId" class="form-select" required
                            onchange="filtrarMedicosPorEspecialidad()">
                        <option value="">-- Seleccione una especialidad --</option>
                        <c:forEach items="${listaEspecialidades}" var="especialidad">
                            <option value="${especialidad.id}">${especialidad.nombre}</option>
                        </c:forEach>
                    </select>
                    
                    <!-- Selección de Médico -->
                    <label for="medico" class="form-label">Médico:</label>
                    <select id="medico" name="medicoId" class="form-select" required disabled>
                        <option value="">-- Primero seleccione una especialidad --</option>
                        <c:forEach items="${listaMedicos}" var="medico">
                            <option value="${medico.legajo}" data-especialidad="${medico.especialidad.id}" class="opcion-medico" style="display:none;">
                                ${medico.apellido}, ${medico.nombre} - ${medico.especialidad.nombre}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            
            <!-- Columna Derecha -->
            <div class="form-column">
                <div class="form-section">
                    <h3 class="form-section-title">Información del Turno</h3>
                    
                    <!-- Selección de Paciente -->
                    <label for="paciente" class="form-label">Paciente:</label>
                    <select id="paciente" name="pacienteDni" class="form-select" required>
                        <option value="">-- Seleccione un paciente --</option>
                        <c:forEach items="${listaPacientes}" var="paciente">
                            <option value="${paciente.dni}">
                                ${paciente.apellido}, ${paciente.nombre} - DNI: ${paciente.dni}
                            </option>
                        </c:forEach>
                    </select>
                    
                    <!-- Fecha del Turno -->
                    <label for="fecha" class="form-label">Fecha:</label>
                    <input type="date" id="fecha" name="fecha" class="form-control" required 
                           min="<fmt:formatDate value='<%= new java.util.Date() %>' pattern='yyyy-MM-dd' />">
                    
                    <!-- Hora del Turno -->
                    <label for="hora" class="form-label">Hora:</label>
                    <select id="hora" name="hora" class="form-select" required>
                        <option value="">-- Seleccione hora --</option>
                        <option value="08:00">08:00</option>
                        <option value="09:00">09:00</option>
                        <option value="10:00">10:00</option>
                        <option value="11:00">11:00</option>
                        <option value="12:00">12:00</option>
                        <option value="13:00">13:00</option>
                        <option value="14:00">14:00</option>
                        <option value="15:00">15:00</option>
                        <option value="16:00">16:00</option>
                        <option value="17:00">17:00</option>
                        <option value="18:00">18:00</option>
                    </select>
                </div>
            </div>
        </div>
        
        <div class="button-group">
            <button type="button" class="btn btn-primary" onclick="validarYMostrarModal()" data-bs-target="#modalConfirmacion">
                <i class="fas fa-calendar-plus"></i> Asignar Turno
            </button>
            <a href="${pageContext.request.contextPath}/turnos" class="btn btn-secondary">
                <i class="fas fa-times"></i> Cancelar
            </a>
        </div>
    </form>
</div>

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
// Función para filtrar médicos según la especialidad seleccionada
function filtrarMedicosPorEspecialidad() {
    const especialidadId = document.getElementById('especialidad').value;
    const selectMedico = document.getElementById('medico');
    const opcionesMedico = document.querySelectorAll('.opcion-medico');
    
    if (especialidadId) {
        // Habilitar el select de médicos
        selectMedico.disabled = false;
        
        // Ocultar todas las opciones primero
        opcionesMedico.forEach(opcion => {
            opcion.style.display = 'none';
        });
        
        // Mostrar solo los médicos de la especialidad seleccionada
        opcionesMedico.forEach(opcion => {
            if (opcion.getAttribute('data-especialidad') === especialidadId) {
                opcion.style.display = 'block';
            }
        });
        
        // Seleccionar la primera opción visible
        const primeraOpcionVisible = selectMedico.querySelector('.opcion-medico[style="display: block;"]');
        if (primeraOpcionVisible) {
            selectMedico.value = primeraOpcionVisible.value;
        } else {
            selectMedico.value = "";
        }
    } else {
        // Deshabilitar si no hay especialidad seleccionada
        selectMedico.disabled = true;
        selectMedico.value = "";
    }
}

// Validación de fecha mínima (hoy)
document.getElementById('fecha').min = new Date().toISOString().split('T')[0];
</script>
<div class="modal fade" id="modalConfirmacion" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalLabel">Confirmación</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
      </div>
      <div class="modal-body">
        ¿Estás seguro de que querés asignar este turno?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary" onclick="document.getElementById('form-turno').submit()">Confirmar</button>
      </div>
    </div>
  </div>
</div>
<script>
function validarYMostrarModal() {
    const form = document.getElementById('form-turno');

    if (form.checkValidity()) {
        const modal = new bootstrap.Modal(document.getElementById('modalConfirmacion'));
        modal.show();
    } else {
        form.reportValidity();
    }
}
</script>
<c:if test="${turnoConfirmado}">
<script>
  window.addEventListener('load', () => {
    const modalExito = new bootstrap.Modal(document.getElementById('modalExito'));
    modalExito.show();
  });
</script>
</c:if>

<div class="modal fade" id="modalExito" tabindex="-1" aria-labelledby="modalExitoLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header bg-success text-white">
        <h5 class="modal-title" id="modalExitoLabel">¡Turno Asignado!</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
      </div>
      <div class="modal-body">
        El turno fue asignado exitosamente.
      </div>
      <div class="modal-footer">
        <a href="${pageContext.request.contextPath}/listarTurnos.html" class="btn btn-success">Aceptar</a>
      </div>
    </div>
  </div>
</div>

</body>
</html>