package Modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasPostgreSQL {

public static ArrayList<dtoAlumno> selectAllAlumnos(Connection conexionGenerada) {
		
		System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnos] Entra en selectAllAlumnos");
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<>();
		
		try {
			
			//Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			//Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"proyectoEclipse\".\"alumnos\"");
		    
			//Llamada a la conversión a dtoAlumno
			listAlumnos = dtoADto.resultsetAdtoAlumno(resultadoConsulta);
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnos] Número alumnos: "+i);
			
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnos] Cierre conexión, declaración y resultado");				
		    resultadoConsulta.close();
		    declaracionSQL.close();
		    //conexionGenerada.close();
			
		} catch (SQLException e) {
			
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL: " + e);
			return listAlumnos;
			
		}
		return listAlumnos;
		
	}


public static ArrayList<dtoAlumnoAsignaturas> selectAllAlumnosAsig(Connection conexionGenerada) {
	
	System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnosAsig] Entra en selectAllAlumnosAsig");
	Statement declaracionSQL = null;
	ResultSet resultadoConsulta = null;
	ArrayList<dtoAlumnoAsignaturas> listAlumnosAsig = new ArrayList<>();
	
	try {
		
		//Se abre una declaración
		declaracionSQL = conexionGenerada.createStatement();
		//Se define la consulta de la declaración y se ejecuta
		resultadoConsulta = declaracionSQL.executeQuery("SELECT al.nombre, al.apellidos,asi.\"nombreAsig\"  FROM \"proyectoEclipse\".alumnos al    INNER JOIN \"proyectoEclipse\".rel_alumn_asig r ON al.\"id_alumno\" = r.id_alumno     INNER JOIN \"proyectoEclipse\".asignatura asi ON r.id_asignatura = asi.id_asignatura");
	    
		//Llamada a la conversión a dtoAlumno
		listAlumnosAsig = dtoADto.resultsetAdtoAlumnoAsig(resultadoConsulta);
		int i = listAlumnosAsig.size();
		System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnosAsig] Número alumnos: "+i);
		
		System.out.println("[INFORMACIÓN-consultasPostgreSQL-selectAllAlumnosAsig] Cierre conexión, declaración y resultado");				
	    resultadoConsulta.close();
	    declaracionSQL.close();
	    //conexionGenerada.close();
		
	} catch (SQLException e) {
		
		System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL: " + e);
		return listAlumnosAsig;
		
	}
	return listAlumnosAsig;
	
}

}
