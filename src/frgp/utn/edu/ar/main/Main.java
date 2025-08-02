package frgp.utn.edu.ar.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocio.NegocioMedico;
import frgp.utn.edu.ar.negocio.NegocioEspecialidad;
import frgp.utn.edu.ar.negocio.negocioPaciente;
import frgp.utn.edu.ar.negocio.negocioTurno;
import frgp.utn.edu.ar.negocio.negocioUsuario;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

		// Obtener instancias de negocio
		negocioUsuario negocioUsuario = (negocioUsuario) appContext.getBean("negocioUsuario");
		NegocioEspecialidad negocioEspecialidad = (NegocioEspecialidad) appContext.getBean("negocioEspecialidad");
		NegocioMedico negocioMedico = (NegocioMedico) appContext.getBean("negocioMedico");
		negocioPaciente negocioPaciente = (negocioPaciente) appContext.getBean("negocioPaciente");
		negocioTurno negocioTurno = (negocioTurno) appContext.getBean("negocioTurno");

		// 1. Cargar usuario administrador
		Usuario admin = (Usuario) appContext.getBean("usuarioAdmin");
		negocioUsuario.AddUsuario(admin);
		System.out.println("Usuario admin creado: " + admin.toString());

		// 2. Cargar especialidades (10)
		Especialidad esp1 = (Especialidad) appContext.getBean("especialidadTraumatologia");
		Especialidad esp2 = (Especialidad) appContext.getBean("especialidadCardiologia");
		Especialidad esp3 = (Especialidad) appContext.getBean("especialidadPediatria");
		Especialidad esp4 = (Especialidad) appContext.getBean("especialidadDermatologia");
		Especialidad esp5 = (Especialidad) appContext.getBean("especialidadNeurologia");
		Especialidad esp6 = (Especialidad) appContext.getBean("especialidadOftalmologia");
		Especialidad esp7 = (Especialidad) appContext.getBean("especialidadGinecologia");
		Especialidad esp8 = (Especialidad) appContext.getBean("especialidadOdontologia");
		Especialidad esp9 = (Especialidad) appContext.getBean("especialidadPsiquiatria");
		Especialidad esp10 = (Especialidad) appContext.getBean("especialidadClinicaMedica");

		negocioEspecialidad.AddEspecialidad(esp1);
		negocioEspecialidad.AddEspecialidad(esp2);
		negocioEspecialidad.AddEspecialidad(esp3);
		negocioEspecialidad.AddEspecialidad(esp4);
		negocioEspecialidad.AddEspecialidad(esp5);
		negocioEspecialidad.AddEspecialidad(esp6);
		negocioEspecialidad.AddEspecialidad(esp7);
		negocioEspecialidad.AddEspecialidad(esp8);
		negocioEspecialidad.AddEspecialidad(esp9);
		negocioEspecialidad.AddEspecialidad(esp10);

		System.out.println("Especialidades creadas");

		// 3. Cargar médicos (15) y sus usuarios

		// Médico 1
		Usuario userMed1 = (Usuario) appContext.getBean("usuarioMedico1");
		negocioUsuario.AddUsuario(userMed1);
		Medico med1 = (Medico) appContext.getBean("medico1");
		negocioMedico.addMedico(med1);

		// Médico 2
		Usuario userMed2 = (Usuario) appContext.getBean("usuarioMedico2");
		negocioUsuario.AddUsuario(userMed2);
		Medico med2 = (Medico) appContext.getBean("medico2");
		negocioMedico.addMedico(med2);

		// Médico 3
		Usuario userMed3 = (Usuario) appContext.getBean("usuarioMedico3");
		negocioUsuario.AddUsuario(userMed3);
		Medico med3 = (Medico) appContext.getBean("medico3");
		negocioMedico.addMedico(med3);

		// Médico 4
		Usuario userMed4 = (Usuario) appContext.getBean("usuarioMedico4");
		negocioUsuario.AddUsuario(userMed4);
		Medico med4 = (Medico) appContext.getBean("medico4");
		negocioMedico.addMedico(med4);

		// Médico 5
		Usuario userMed5 = (Usuario) appContext.getBean("usuarioMedico5");
		negocioUsuario.AddUsuario(userMed5);
		Medico med5 = (Medico) appContext.getBean("medico5");
		negocioMedico.addMedico(med5);

		// Médico 6
		Usuario userMed6 = (Usuario) appContext.getBean("usuarioMedico6");
		negocioUsuario.AddUsuario(userMed6);
		Medico med6 = (Medico) appContext.getBean("medico6");
		negocioMedico.addMedico(med6);

		// Médico 7
		Usuario userMed7 = (Usuario) appContext.getBean("usuarioMedico7");
		negocioUsuario.AddUsuario(userMed7);
		Medico med7 = (Medico) appContext.getBean("medico7");
		negocioMedico.addMedico(med7);

		// Médico 8
		Usuario userMed8 = (Usuario) appContext.getBean("usuarioMedico8");
		negocioUsuario.AddUsuario(userMed8);
		Medico med8 = (Medico) appContext.getBean("medico8");
		negocioMedico.addMedico(med8);

		// Médico 9
		Usuario userMed9 = (Usuario) appContext.getBean("usuarioMedico9");
		negocioUsuario.AddUsuario(userMed9);
		Medico med9 = (Medico) appContext.getBean("medico9");
		negocioMedico.addMedico(med9);

		// Médico 10
		Usuario userMed10 = (Usuario) appContext.getBean("usuarioMedico10");
		negocioUsuario.AddUsuario(userMed10);
		Medico med10 = (Medico) appContext.getBean("medico10");
		negocioMedico.addMedico(med10);

		// Médico 11
		Usuario userMed11 = (Usuario) appContext.getBean("usuarioMedico11");
		negocioUsuario.AddUsuario(userMed11);
		Medico med11 = (Medico) appContext.getBean("medico11");
		negocioMedico.addMedico(med11);

		// Médico 12
		Usuario userMed12 = (Usuario) appContext.getBean("usuarioMedico12");
		negocioUsuario.AddUsuario(userMed12);
		Medico med12 = (Medico) appContext.getBean("medico12");
		negocioMedico.addMedico(med12);

		// Médico 13
		Usuario userMed13 = (Usuario) appContext.getBean("usuarioMedico13");
		negocioUsuario.AddUsuario(userMed13);
		Medico med13 = (Medico) appContext.getBean("medico13");
		negocioMedico.addMedico(med13);

		// Médico 14
		Usuario userMed14 = (Usuario) appContext.getBean("usuarioMedico14");
		negocioUsuario.AddUsuario(userMed14);
		Medico med14 = (Medico) appContext.getBean("medico14");
		negocioMedico.addMedico(med14);

		// Médico 15
		Usuario userMed15 = (Usuario) appContext.getBean("usuarioMedico15");
		negocioUsuario.AddUsuario(userMed15);
		Medico med15 = (Medico) appContext.getBean("medico15");
		negocioMedico.addMedico(med15);

		System.out.println("Médicos creados");

		// 4. Cargar pacientes (100)

		Paciente pac1 = (Paciente) appContext.getBean("paciente1");
		negocioPaciente.AddPaciente(pac1);

		Paciente pac2 = (Paciente) appContext.getBean("paciente2");
		negocioPaciente.AddPaciente(pac2);

		// Paciente 3
		Paciente pac3 = (Paciente) appContext.getBean("paciente3");
		negocioPaciente.AddPaciente(pac3);

		// Paciente 4
		Paciente pac4 = (Paciente) appContext.getBean("paciente4");
		negocioPaciente.AddPaciente(pac4);

		// Paciente 5
		Paciente pac5 = (Paciente) appContext.getBean("paciente5");
		negocioPaciente.AddPaciente(pac5);

		// Paciente 6
		Paciente pac6 = (Paciente) appContext.getBean("paciente6");
		negocioPaciente.AddPaciente(pac6);

		// Paciente 7
		Paciente pac7 = (Paciente) appContext.getBean("paciente7");
		negocioPaciente.AddPaciente(pac7);

		// Paciente 8
		Paciente pac8 = (Paciente) appContext.getBean("paciente8");
		negocioPaciente.AddPaciente(pac8);

		// Paciente 9
		Paciente pac9 = (Paciente) appContext.getBean("paciente9");
		negocioPaciente.AddPaciente(pac9);

		// Paciente 10
		Paciente pac10 = (Paciente) appContext.getBean("paciente10");
		negocioPaciente.AddPaciente(pac10);

		// Paciente 11
		Paciente pac11 = (Paciente) appContext.getBean("paciente11");
		negocioPaciente.AddPaciente(pac11);

		// Paciente 12
		Paciente pac12 = (Paciente) appContext.getBean("paciente12");
		negocioPaciente.AddPaciente(pac12);

		// Paciente 13
		Paciente pac13 = (Paciente) appContext.getBean("paciente13");
		negocioPaciente.AddPaciente(pac13);

		// Paciente 14
		Paciente pac14 = (Paciente) appContext.getBean("paciente14");
		negocioPaciente.AddPaciente(pac14);

		// Paciente 15
		Paciente pac15 = (Paciente) appContext.getBean("paciente15");
		negocioPaciente.AddPaciente(pac15);

		// Paciente 16
		Paciente pac16 = (Paciente) appContext.getBean("paciente16");
		negocioPaciente.AddPaciente(pac16);

		// Paciente 17
		Paciente pac17 = (Paciente) appContext.getBean("paciente17");
		negocioPaciente.AddPaciente(pac17);

		// Paciente 18
		Paciente pac18 = (Paciente) appContext.getBean("paciente18");
		negocioPaciente.AddPaciente(pac18);

		// Paciente 19
		Paciente pac19 = (Paciente) appContext.getBean("paciente19");
		negocioPaciente.AddPaciente(pac19);

		// Paciente 20
		Paciente pac20 = (Paciente) appContext.getBean("paciente20");
		negocioPaciente.AddPaciente(pac20);

		// Paciente 21
		Paciente pac21 = (Paciente) appContext.getBean("paciente21");
		negocioPaciente.AddPaciente(pac21);

		// Paciente 22
		Paciente pac22 = (Paciente) appContext.getBean("paciente22");
		negocioPaciente.AddPaciente(pac22);

		// Paciente 23
		Paciente pac23 = (Paciente) appContext.getBean("paciente23");
		negocioPaciente.AddPaciente(pac23);

		// Paciente 24
		Paciente pac24 = (Paciente) appContext.getBean("paciente24");
		negocioPaciente.AddPaciente(pac24);

		// Paciente 25
		Paciente pac25 = (Paciente) appContext.getBean("paciente25");
		negocioPaciente.AddPaciente(pac25);

		// Paciente 26
		Paciente pac26 = (Paciente) appContext.getBean("paciente26");
		negocioPaciente.AddPaciente(pac26);

		// Paciente 27
		Paciente pac27 = (Paciente) appContext.getBean("paciente27");
		negocioPaciente.AddPaciente(pac27);

		// Paciente 28
		Paciente pac28 = (Paciente) appContext.getBean("paciente28");
		negocioPaciente.AddPaciente(pac28);

		// Paciente 29
		Paciente pac29 = (Paciente) appContext.getBean("paciente29");
		negocioPaciente.AddPaciente(pac29);

		// Paciente 30
		Paciente pac30 = (Paciente) appContext.getBean("paciente30");
		negocioPaciente.AddPaciente(pac30);

		// Paciente 31
		Paciente pac31 = (Paciente) appContext.getBean("paciente31");
		negocioPaciente.AddPaciente(pac31);

		// Paciente 32
		Paciente pac32 = (Paciente) appContext.getBean("paciente32");
		negocioPaciente.AddPaciente(pac32);

		// Paciente 33
		Paciente pac33 = (Paciente) appContext.getBean("paciente33");
		negocioPaciente.AddPaciente(pac33);

		// Paciente 34
		Paciente pac34 = (Paciente) appContext.getBean("paciente34");
		negocioPaciente.AddPaciente(pac34);

		// Paciente 35
		Paciente pac35 = (Paciente) appContext.getBean("paciente35");
		negocioPaciente.AddPaciente(pac35);

		// Paciente 36
		Paciente pac36 = (Paciente) appContext.getBean("paciente36");
		negocioPaciente.AddPaciente(pac36);

		// Paciente 37
		Paciente pac37 = (Paciente) appContext.getBean("paciente37");
		negocioPaciente.AddPaciente(pac37);

		// Paciente 38
		Paciente pac38 = (Paciente) appContext.getBean("paciente38");
		negocioPaciente.AddPaciente(pac38);

		// Paciente 39
		Paciente pac39 = (Paciente) appContext.getBean("paciente39");
		negocioPaciente.AddPaciente(pac39);

		// Paciente 40
		Paciente pac40 = (Paciente) appContext.getBean("paciente40");
		negocioPaciente.AddPaciente(pac40);

		// Paciente 41
		Paciente pac41 = (Paciente) appContext.getBean("paciente41");
		negocioPaciente.AddPaciente(pac41);

		// Paciente 42
		Paciente pac42 = (Paciente) appContext.getBean("paciente42");
		negocioPaciente.AddPaciente(pac42);

		// Paciente 43
		Paciente pac43 = (Paciente) appContext.getBean("paciente43");
		negocioPaciente.AddPaciente(pac43);

		// Paciente 44
		Paciente pac44 = (Paciente) appContext.getBean("paciente44");
		negocioPaciente.AddPaciente(pac44);

		// Paciente 45
		Paciente pac45 = (Paciente) appContext.getBean("paciente45");
		negocioPaciente.AddPaciente(pac45);

		// Paciente 46
		Paciente pac46 = (Paciente) appContext.getBean("paciente46");
		negocioPaciente.AddPaciente(pac46);

		// Paciente 47
		Paciente pac47 = (Paciente) appContext.getBean("paciente47");
		negocioPaciente.AddPaciente(pac47);

		// Paciente 48
		Paciente pac48 = (Paciente) appContext.getBean("paciente48");
		negocioPaciente.AddPaciente(pac48);

		// Paciente 49
		Paciente pac49 = (Paciente) appContext.getBean("paciente49");
		negocioPaciente.AddPaciente(pac49);

		// Paciente 50
		Paciente pac50 = (Paciente) appContext.getBean("paciente50");
		negocioPaciente.AddPaciente(pac50);

		// Paciente 51
		Paciente pac51 = (Paciente) appContext.getBean("paciente51");
		negocioPaciente.AddPaciente(pac51);

		// Paciente 52
		Paciente pac52 = (Paciente) appContext.getBean("paciente52");
		negocioPaciente.AddPaciente(pac52);

		// Paciente 53
		Paciente pac53 = (Paciente) appContext.getBean("paciente53");
		negocioPaciente.AddPaciente(pac53);

		// Paciente 54
		Paciente pac54 = (Paciente) appContext.getBean("paciente54");
		negocioPaciente.AddPaciente(pac54);

		// Paciente 55
		Paciente pac55 = (Paciente) appContext.getBean("paciente55");
		negocioPaciente.AddPaciente(pac55);

		// Paciente 56
		Paciente pac56 = (Paciente) appContext.getBean("paciente56");
		negocioPaciente.AddPaciente(pac56);

		// Paciente 57
		Paciente pac57 = (Paciente) appContext.getBean("paciente57");
		negocioPaciente.AddPaciente(pac57);

		// Paciente 58
		Paciente pac58 = (Paciente) appContext.getBean("paciente58");
		negocioPaciente.AddPaciente(pac58);

		// Paciente 59
		Paciente pac59 = (Paciente) appContext.getBean("paciente59");
		negocioPaciente.AddPaciente(pac59);

		// Paciente 60
		Paciente pac60 = (Paciente) appContext.getBean("paciente60");
		negocioPaciente.AddPaciente(pac60);

		// Paciente 61
		Paciente pac61 = (Paciente) appContext.getBean("paciente61");
		negocioPaciente.AddPaciente(pac61);

		// Paciente 62
		Paciente pac62 = (Paciente) appContext.getBean("paciente62");
		negocioPaciente.AddPaciente(pac62);

		// Paciente 63
		Paciente pac63 = (Paciente) appContext.getBean("paciente63");
		negocioPaciente.AddPaciente(pac63);

		// Paciente 64
		Paciente pac64 = (Paciente) appContext.getBean("paciente64");
		negocioPaciente.AddPaciente(pac64);

		// Paciente 65
		Paciente pac65 = (Paciente) appContext.getBean("paciente65");
		negocioPaciente.AddPaciente(pac65);

		// Paciente 66
		Paciente pac66 = (Paciente) appContext.getBean("paciente66");
		negocioPaciente.AddPaciente(pac66);

		// Paciente 67
		Paciente pac67 = (Paciente) appContext.getBean("paciente67");
		negocioPaciente.AddPaciente(pac67);

		// Paciente 68
		Paciente pac68 = (Paciente) appContext.getBean("paciente68");
		negocioPaciente.AddPaciente(pac68);

		// Paciente 69
		Paciente pac69 = (Paciente) appContext.getBean("paciente69");
		negocioPaciente.AddPaciente(pac69);

		// Paciente 70
		Paciente pac70 = (Paciente) appContext.getBean("paciente70");
		negocioPaciente.AddPaciente(pac70);

		// Paciente 71
		Paciente pac71 = (Paciente) appContext.getBean("paciente71");
		negocioPaciente.AddPaciente(pac71);

		// Paciente 72
		Paciente pac72 = (Paciente) appContext.getBean("paciente72");
		negocioPaciente.AddPaciente(pac72);

		// Paciente 73
		Paciente pac73 = (Paciente) appContext.getBean("paciente73");
		negocioPaciente.AddPaciente(pac73);

		// Paciente 74
		Paciente pac74 = (Paciente) appContext.getBean("paciente74");
		negocioPaciente.AddPaciente(pac74);

		// Paciente 75
		Paciente pac75 = (Paciente) appContext.getBean("paciente75");
		negocioPaciente.AddPaciente(pac75);

		// Paciente 76
		Paciente pac76 = (Paciente) appContext.getBean("paciente76");
		negocioPaciente.AddPaciente(pac76);

		// Paciente 77
		Paciente pac77 = (Paciente) appContext.getBean("paciente77");
		negocioPaciente.AddPaciente(pac77);

		// Paciente 78
		Paciente pac78 = (Paciente) appContext.getBean("paciente78");
		negocioPaciente.AddPaciente(pac78);

		// Paciente 79
		Paciente pac79 = (Paciente) appContext.getBean("paciente79");
		negocioPaciente.AddPaciente(pac79);

		// Paciente 80
		Paciente pac80 = (Paciente) appContext.getBean("paciente80");
		negocioPaciente.AddPaciente(pac80);

		// Paciente 81
		Paciente pac81 = (Paciente) appContext.getBean("paciente81");
		negocioPaciente.AddPaciente(pac81);

		// Paciente 82
		Paciente pac82 = (Paciente) appContext.getBean("paciente82");
		negocioPaciente.AddPaciente(pac82);

		// Paciente 83
		Paciente pac83 = (Paciente) appContext.getBean("paciente83");
		negocioPaciente.AddPaciente(pac83);

		// Paciente 84
		Paciente pac84 = (Paciente) appContext.getBean("paciente84");
		negocioPaciente.AddPaciente(pac84);

		// Paciente 85
		Paciente pac85 = (Paciente) appContext.getBean("paciente85");
		negocioPaciente.AddPaciente(pac85);

		// Paciente 86
		Paciente pac86 = (Paciente) appContext.getBean("paciente86");
		negocioPaciente.AddPaciente(pac86);

		// Paciente 87
		Paciente pac87 = (Paciente) appContext.getBean("paciente87");
		negocioPaciente.AddPaciente(pac87);

		// Paciente 88
		Paciente pac88 = (Paciente) appContext.getBean("paciente88");
		negocioPaciente.AddPaciente(pac88);

		// Paciente 89
		Paciente pac89 = (Paciente) appContext.getBean("paciente89");
		negocioPaciente.AddPaciente(pac89);

		// Paciente 90
		Paciente pac90 = (Paciente) appContext.getBean("paciente90");
		negocioPaciente.AddPaciente(pac90);

		// Paciente 91
		Paciente pac91 = (Paciente) appContext.getBean("paciente91");
		negocioPaciente.AddPaciente(pac91);

		// Paciente 92
		Paciente pac92 = (Paciente) appContext.getBean("paciente92");
		negocioPaciente.AddPaciente(pac92);

		// Paciente 93
		Paciente pac93 = (Paciente) appContext.getBean("paciente93");
		negocioPaciente.AddPaciente(pac93);

		// Paciente 94
		Paciente pac94 = (Paciente) appContext.getBean("paciente94");
		negocioPaciente.AddPaciente(pac94);

		// Paciente 95
		Paciente pac95 = (Paciente) appContext.getBean("paciente95");
		negocioPaciente.AddPaciente(pac95);

		// Paciente 96
		Paciente pac96 = (Paciente) appContext.getBean("paciente96");
		negocioPaciente.AddPaciente(pac96);

		// Paciente 97
		Paciente pac97 = (Paciente) appContext.getBean("paciente97");
		negocioPaciente.AddPaciente(pac97);

		// Paciente 98
		Paciente pac98 = (Paciente) appContext.getBean("paciente98");
		negocioPaciente.AddPaciente(pac98);

		// Paciente 99
		Paciente pac99 = (Paciente) appContext.getBean("paciente99");
		negocioPaciente.AddPaciente(pac99);

		Paciente pac100 = (Paciente) appContext.getBean("paciente100");
		negocioPaciente.AddPaciente(pac100);

		System.out.println("Pacientes creados");

		// 5. Cargar turnos (50)
		
		Turno turno1 = (Turno) appContext.getBean("turno1");
		negocioTurno.AddTurno(turno1);

		Turno turno2 = (Turno) appContext.getBean("turno2");
		negocioTurno.AddTurno(turno2);

        // Turno 3
        Turno turno3 = (Turno) appContext.getBean("turno3");
        negocioTurno.AddTurno(turno3);
        
        // Turno 4
        Turno turno4 = (Turno) appContext.getBean("turno4");
        negocioTurno.AddTurno(turno4);
        
        // Turno 5
        Turno turno5 = (Turno) appContext.getBean("turno5");
        negocioTurno.AddTurno(turno5);
        
        // Turno 6
        Turno turno6 = (Turno) appContext.getBean("turno6");
        negocioTurno.AddTurno(turno6);
        
        // Turno 7
        Turno turno7 = (Turno) appContext.getBean("turno7");
        negocioTurno.AddTurno(turno7);
        
        // Turno 8
        Turno turno8 = (Turno) appContext.getBean("turno8");
        negocioTurno.AddTurno(turno8);
        
        // Turno 9
        Turno turno9 = (Turno) appContext.getBean("turno9");
        negocioTurno.AddTurno(turno9);
        
        // Turno 10
        Turno turno10 = (Turno) appContext.getBean("turno10");
        negocioTurno.AddTurno(turno10);
        
        // Turno 11
        Turno turno11 = (Turno) appContext.getBean("turno11");
        negocioTurno.AddTurno(turno11);
        
        // Turno 12
        Turno turno12 = (Turno) appContext.getBean("turno12");
        negocioTurno.AddTurno(turno12);
        
        // Turno 13
        Turno turno13 = (Turno) appContext.getBean("turno13");
        negocioTurno.AddTurno(turno13);
        
        // Turno 14
        Turno turno14 = (Turno) appContext.getBean("turno14");
        negocioTurno.AddTurno(turno14);
        
        // Turno 15
        Turno turno15 = (Turno) appContext.getBean("turno15");
        negocioTurno.AddTurno(turno15);
        
        // Turno 16
        Turno turno16 = (Turno) appContext.getBean("turno16");
        negocioTurno.AddTurno(turno16);
        
        // Turno 17
        Turno turno17 = (Turno) appContext.getBean("turno17");
        negocioTurno.AddTurno(turno17);
        
        // Turno 18
        Turno turno18 = (Turno) appContext.getBean("turno18");
        negocioTurno.AddTurno(turno18);
        
        // Turno 19
        Turno turno19 = (Turno) appContext.getBean("turno19");
        negocioTurno.AddTurno(turno19);
        
        // Turno 20
        Turno turno20 = (Turno) appContext.getBean("turno20");
        negocioTurno.AddTurno(turno20);
        
        // Turno 21
        Turno turno21 = (Turno) appContext.getBean("turno21");
        negocioTurno.AddTurno(turno21);
        
        // Turno 22
        Turno turno22 = (Turno) appContext.getBean("turno22");
        negocioTurno.AddTurno(turno22);
        
        // Turno 23
        Turno turno23 = (Turno) appContext.getBean("turno23");
        negocioTurno.AddTurno(turno23);
        
        // Turno 24
        Turno turno24 = (Turno) appContext.getBean("turno24");
        negocioTurno.AddTurno(turno24);
        
        // Turno 25
        Turno turno25 = (Turno) appContext.getBean("turno25");
        negocioTurno.AddTurno(turno25);
        
        // Turno 26
        Turno turno26 = (Turno) appContext.getBean("turno26");
        negocioTurno.AddTurno(turno26);
        
        // Turno 27
        Turno turno27 = (Turno) appContext.getBean("turno27");
        negocioTurno.AddTurno(turno27);
        
        // Turno 28
        Turno turno28 = (Turno) appContext.getBean("turno28");
        negocioTurno.AddTurno(turno28);
        
        // Turno 29
        Turno turno29 = (Turno) appContext.getBean("turno29");
        negocioTurno.AddTurno(turno29);
        
        // Turno 30
        Turno turno30 = (Turno) appContext.getBean("turno30");
        negocioTurno.AddTurno(turno30);
        
        // Turno 31
        Turno turno31 = (Turno) appContext.getBean("turno31");
        negocioTurno.AddTurno(turno31);
        
        // Turno 32
        Turno turno32 = (Turno) appContext.getBean("turno32");
        negocioTurno.AddTurno(turno32);
        
        // Turno 33
        Turno turno33 = (Turno) appContext.getBean("turno33");
        negocioTurno.AddTurno(turno33);
        
        // Turno 34
        Turno turno34 = (Turno) appContext.getBean("turno34");
        negocioTurno.AddTurno(turno34);
        
        // Turno 35
        Turno turno35 = (Turno) appContext.getBean("turno35");
        negocioTurno.AddTurno(turno35);
        
        // Turno 36
        Turno turno36 = (Turno) appContext.getBean("turno36");
        negocioTurno.AddTurno(turno36);
        
        // Turno 37
        Turno turno37 = (Turno) appContext.getBean("turno37");
        negocioTurno.AddTurno(turno37);
        
        // Turno 38
        Turno turno38 = (Turno) appContext.getBean("turno38");
        negocioTurno.AddTurno(turno38);
        
        // Turno 39
        Turno turno39 = (Turno) appContext.getBean("turno39");
        negocioTurno.AddTurno(turno39);
        
        // Turno 40
        Turno turno40 = (Turno) appContext.getBean("turno40");
        negocioTurno.AddTurno(turno40);
        
        // Turno 41
        Turno turno41 = (Turno) appContext.getBean("turno41");
        negocioTurno.AddTurno(turno41);
        
        // Turno 42
        Turno turno42 = (Turno) appContext.getBean("turno42");
        negocioTurno.AddTurno(turno42);
        
        // Turno 43
        Turno turno43 = (Turno) appContext.getBean("turno43");
        negocioTurno.AddTurno(turno43);
        
        // Turno 44
        Turno turno44 = (Turno) appContext.getBean("turno44");
        negocioTurno.AddTurno(turno44);
        
        // Turno 45
        Turno turno45 = (Turno) appContext.getBean("turno45");
        negocioTurno.AddTurno(turno45);
        
        // Turno 46
        Turno turno46 = (Turno) appContext.getBean("turno46");
        negocioTurno.AddTurno(turno46);
        
        // Turno 47
        Turno turno47 = (Turno) appContext.getBean("turno47");
        negocioTurno.AddTurno(turno47);
        
        // Turno 48
        Turno turno48 = (Turno) appContext.getBean("turno48");
        negocioTurno.AddTurno(turno48);
        
        // Turno 49
        Turno turno49 = (Turno) appContext.getBean("turno49");
        negocioTurno.AddTurno(turno49);

		Turno turno50 = (Turno) appContext.getBean("turno50");
		negocioTurno.AddTurno(turno50);

		System.out.println("Turnos creados");

		// Cerrar contexto
		((ConfigurableApplicationContext) (appContext)).close();

		System.out.println("¡Carga de datos completada exitosamente!");
	}
}