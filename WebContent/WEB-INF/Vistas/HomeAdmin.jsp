<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Administrador</title>

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

.header-title a {
    color: white;
    text-decoration: none;
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
}

.section-title {
    color: #2E7D32;
    border-bottom: 1px solid #4CAF50;
    padding-bottom: 10px;
    margin: 20px 0;
}

.menu-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
    gap: 20px;
    margin-top: 20px;
}

.menu-card {
    background-color: #f5f5f5;
    border-radius: 5px;
    padding: 20px;
    transition: all 0.3s ease;
    border-left: 4px solid #4CAF50;
}

.menu-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
    background-color: #e8f5e9;
}

.menu-card h3 {
    margin-top: 0;
    color: #2E7D32;
}

.menu-link {
    display: block;
    margin: 8px 0;
    color: #007BFF;
    text-decoration: none;
    padding: 5px 0;
    transition: all 0.2s;
}

.menu-link:hover {
    text-decoration: underline;
    color: #0056b3;
    padding-left: 5px;
}

.menu-link i {
    margin-right: 8px;
    width: 20px;
    text-align: center;
}

.user-info {
    background-color: #e8f5e9;
    padding: 10px;
    border-radius: 4px;
    margin-bottom: 20px;
    font-size: 14px;
}

.footer {
    text-align: center;
    padding: 15px;
    background-color: #333;
    color: white;
    margin-top: 30px;
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

/* Responsive design */
@media (max-width: 992px) {
    .container {
        width: 98%;
        padding: 15px;
    }
    
    .menu-grid {
        grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
    }
}

@media (max-width: 768px) {
    .menu-grid {
        grid-template-columns: 1fr;
    }
    
    .menu-card {
        padding: 15px;
    }
}

@media (max-width: 576px) {
    .container {
        margin: 15px auto;
        padding: 10px;
    }
    
    .section-title {
        font-size: 1.5rem;
    }
}
</style>
</head>
<body>

    <jsp:include page="Header.jsp" />

    <div class="container">
        <h1 class="section-title">Panel de Administración</h1>

        <div class="menu-grid">
            <!-- Gestión de Pacientes -->
            <div class="menu-card">
                <h3><i class="fas fa-user-injured"></i> Gestión de Pacientes</h3>
                <a href="altaPaciente.html" class="menu-link">
                    <i class="fas fa-plus-circle"></i> Alta de Paciente
                </a> 
                <a href="listarPacientes.html" class="menu-link">
                    <i class="fas fa-list"></i> Listado de Pacientes
                </a>
            </div>

            <!-- Gestión de Médicos -->
            <div class="menu-card">
                <h3><i class="fas fa-user-md"></i> Gestión de Médicos</h3>
                <a href="altaMedico.html" class="menu-link">
                    <i class="fas fa-plus-circle"></i> Alta de Médico
                </a>
                <a href="listarMedicos.html" class="menu-link">
                    <i class="fas fa-list"></i> Listado de Médicos
                </a>
            </div>

            <!-- Gestión de Turnos -->
            <div class="menu-card">
                <h3><i class="fas fa-calendar-check"></i> Gestión de Turnos</h3>
                <a href="asignarTurnos.html" class="menu-link">
                    <i class="fas fa-plus-circle"></i> Asignar Turnos
                </a>
                <a href="listarTurnos.html?legajo=" class="menu-link">
                    <i class="fas fa-list"></i> Listado de Turnos
                </a>
            </div>

            <!-- Informes -->
            <div class="menu-card">
                <h3><i class="fas fa-chart-bar"></i> Reportes Estadísticos</h3>
                <a href="informeMedicosMasSolicitados.html" class="menu-link">
                    <i class="fas fa-chart-line"></i> Médicos más solicitados
                </a>
                <a href="informePacientesFrecuentes.html" class="menu-link">
                    <i class="fas fa-chart-pie"></i> Pacientes más frecuentes
                </a>
                <a href="informeEspecialidadesPopulares.html" class="menu-link">
                    <i class="fas fa-chart-area"></i> Especialidades más populares
                </a>
            </div>
        </div>
    </div>

    <div class="footer">
        &copy; 2025 Sistema de Gestión Médica
    </div>

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>

</body>
</html>