<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Administrador</title>
<style>
/* [Estilos anteriores se mantienen igual...] */

/* Nueva barra de acceso rápido CENTRADA */
.quick-access-container {
	background-color: #2E7D32;
	padding: 10px 0;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	width: 100%;
}

.quick-access-bar {
	max-width: 1200px;
	margin: 0 auto;
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
	gap: 10px;
	padding: 0 20px;
}

.quick-access-link {
	color: white;
	text-decoration: none;
	padding: 5px 15px;
	border-radius: 4px;
	white-space: nowrap;
	font-size: 14px;
	transition: background-color 0.3s;
	background-color: rgba(255, 255, 255, 0.1);
}

.quick-access-link:hover {
	background-color: #1B5E20;
	text-decoration: none;
}

/* Responsive design */
@media ( max-width : 768px) {
	.quick-access-bar {
		justify-content: flex-start;
		overflow-x: auto;
		padding-bottom: 5px;
		flex-wrap: nowrap;
	}
	.quick-access-link {
		padding: 5px 12px;
		font-size: 13px;
	}
}
</style>
</head>
<body>

        <%
            String nombreUsuario = (String) session.getAttribute("nombreUsuario");
            String rolUsuario = (String) session.getAttribute("rolUsuario");
            //System.out.print(nombreUsuario);
            //System.out.print(rolUsuario);
        %>
<div class="header">
    <div class="header-title">
    	<% if(rolUsuario.equals("ADMINISTRADOR")) { %>
        <a href="irHomeAdmin.html" style="color: white; text-decoration: none;">
            Sistema de Gestión Clínica Médica
        </a>
        <a href="irHomeAdmin.html" style="color: white; text-decoration: none;">
            Sistema de Gestión Clínica Médica
        </a>
        <% } else {%>
        <a href="irHomeMedico.html" style="color: white; text-decoration: none;">
            Sistema de Gestión Clínica Médica
        </a>
        <%} %>
    </div>
    <div>
        <span>Bienvenido, <%=nombreUsuario%></span> <a
            href="${pageContext.request.contextPath}/auth/logout"
            class="logout-btn">Cerrar Sesión</a>
    </div>
</div>


	<!-- Barra de acceso rápido CENTRADA -->
	<div class="quick-access-container">
		<div class="quick-access-bar">
				<a href="altaPaciente.html" class="quick-access-link">Nuevo	Paciente</a>
				<a href="listarPacientes.html" class="quick-access-link">Listar Pacientes</a>
				<a href="altaMedico.html" class="quick-access-link">Nuevo Médico</a>
				<a href="listarMedicos.html" class="quick-access-link">Listar Médicos</a>
				<a href="asignarTurnos.html" class="quick-access-link">Asignar Turnos</a>
				<a href="informes.html" class="quick-access-link">Informes</a>
		</div>
	</div>

	<!-- [Resto del contenido se mantiene igual...] -->

</body>
</html>