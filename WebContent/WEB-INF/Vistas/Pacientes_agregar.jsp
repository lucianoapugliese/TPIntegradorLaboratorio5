<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Paciente</title>

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

/* Form styles */
.form-container {
    max-width: 1000px;
    margin: 0 auto;
}

.form-columns {
    display: flex;
    gap: 30px;
    margin-bottom: 20px;
}

.form-column {
    flex: 1;
    min-width: 0;
}

.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    color: #555;
}

input[type="text"],
input[type="email"],
input[type="tel"],
input[type="date"],
select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
    font-size: 16px;
}

input[type="text"]:focus,
input[type="email"]:focus,
input[type="tel"]:focus,
input[type="date"]:focus,
select:focus {
    border-color: #4CAF50;
    outline: none;
    box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
}

.form-actions {
    margin-top: 20px;
    display: flex;
    align-items: center;
    justify-content: center;
    clear: both;
}

.form-actions a {
    margin-left: 15px;
    color: #007BFF;
    text-decoration: none;
}

.form-actions a:hover {
    text-decoration: underline;
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
    .form-columns {
        flex-direction: column;
        gap: 0;
    }
    
    .form-group {
        margin-bottom: 10px;
    }
    
    input[type="text"],
    input[type="email"],
    input[type="tel"],
    input[type="date"],
    select {
        padding: 8px;
        font-size: 14px;
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
    
    .form-actions {
        flex-direction: column;
        align-items: center;
        gap: 10px;
    }
    
    .form-actions a {
        margin-left: 0;
        margin-top: 10px;
    }
}
</style>
</head>
<body>

    <jsp:include page="Header.jsp" />

<div class="container">
    <div class="header-row">
        <h1>Agregar Nuevo Paciente</h1>
        <a href="listarPacientes.html" class="button">
            <i class="fas fa-arrow-left"></i> Volver al listado
        </a>
    </div>

    <%-- Mostrar mensajes si existen --%>
    <c:if test="${not empty mensaje}">
        <div class="message ${tipoMensaje}">
            ${mensaje}
        </div>
    </c:if>

    <div class="form-container">
        <form id="form-paciente" action="altaPaciente.html" method="post">
            <input type="hidden" name="action" value="guardar">

            <div class="form-columns">
                <!-- Columna Izquierda -->
                <div class="form-column">
                    <div class="form-group">
                        <label for="dni">DNI:</label>
                        <input type="text" pattern="^\d{7,8}$" maxlength="8" title="Por favor ingrese un DNI válido" class="form-control" id="dni" name="dni" required placeholder="Ingrese el DNI del paciente">
                    </div>

                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" id="nombre" name="nombre" pattern="^[A-Za-zÁÉÍÓÚáéíóúÑññ\s]+$" title="Por favor ingrese un nombre válido" required placeholder="Ingrese el nombre">
                    </div>

                    <div class="form-group">
                        <label for="apellido">Apellido:</label>
                        <input type="text" id="apellido" name="apellido" pattern="^^[A-Za-zÁÉÍÓÚáéíóúÑññ\s]+$" title="Por favor ingrese un apellido válido" required placeholder="Ingrese el apellido">
                    </div>

                    <div class="form-group">
                        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>
                    </div>
                </div>

                <!-- Columna Derecha -->
                <div class="form-column">
                    <div class="form-group">
                        <label for="direccion">Dirección:</label>
                        <input type="text" id="direccion" name="direccion" required placeholder="Ingrese la dirección">
                    </div>

                    <div class="form-group">
                        <label for="localidad">Localidad:</label>
                        <input type="text" id="localidad" name="localidad" required placeholder="Ingrese la localidad">
                    </div>

                    <div class="form-group">
                        <label for="provincia">Provincia:</label>
                        <input type="text" id="provincia" name="provincia" required placeholder="Ingrese la provincia">
                    </div>

                    <div class="form-group">
                        <label for="correoElectronico">Correo Electrónico:</label>
                        <input type="email" id="correoElectronico" name="correoElectronico" required placeholder="ejemplo@dominio.com">
                    </div>
                    
                    <div class="form-group">
               			 <label for="telefono">Teléfono:</label>
              			 <input type="tel" id="telefono" name="telefono" pattern="^\d{8,15}$" title="Por favor ingrese un teléfono válido" maxlength="15" required placeholder="Ingrese el número de teléfono">
          			</div>
                </div>
            </div>



            <div class="form-actions">
                <button type="button" class="button" onclick="validarYMostrarModal()">
                    <i class="fas fa-save"></i> Guardar Paciente
                </button>
                <a href="altaPaciente.html">Cancelar</a>
            </div>
        </form>
    </div>
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
  window.addEventListener('DOMContentLoaded', () => {
    const hoy = new Date().toISOString().split("T")[0];
    document.getElementById("fechaNacimiento").max = hoy;
  });
</script>
<div class="modal fade" id="modalConfirmacion" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalLabel">Confirmación</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
      </div>
      <div class="modal-body">
        ¿Estás seguro de que querés agregar este paciente?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary" onclick="document.getElementById('form-paciente').submit()">Confirmar</button>
      </div>
    </div>
  </div>
</div>
<script>
function validarYMostrarModal() {
    const form = document.getElementById('form-paciente');

    if (form.checkValidity()) {
        const modal = new bootstrap.Modal(document.getElementById('modalConfirmacion'));
        modal.show();
    } else {
        form.reportValidity();
    }
}
</script>
<c:if test="${pacienteConfirmado}">
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
        <h5 class="modal-title" id="modalExitoLabel">¡Paciente agregado!</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
      </div>
      <div class="modal-body">
        El paciente fue agregado exitosamente.
      </div>
      <div class="modal-footer">
        <a href="${pageContext.request.contextPath}/listarPacientes.html" class="btn btn-success">Aceptar</a>
      </div>
    </div>
  </div>
</div>

</body>
</html>