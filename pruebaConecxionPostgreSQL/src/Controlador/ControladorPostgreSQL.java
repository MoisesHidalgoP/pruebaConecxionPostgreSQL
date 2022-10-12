package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.ConexionPostgresql;
import Modelo.dtoAlumno;
import Modelo.dtoAlumnoAsignaturas;
import Modelo.ConsultasPostgreSQL;
import Util.variablesConexionPostgreSQL;

public class ControladorPostgreSQL {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CONSTANTES
		final String HOST = variablesConexionPostgreSQL.getHost();
		final String PORT = variablesConexionPostgreSQL.getPort();
		final String DB = variablesConexionPostgreSQL.getDb();
		final String USER = variablesConexionPostgreSQL.getUser();
		final String PASS = variablesConexionPostgreSQL.getPass();
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<>();
		ArrayList<dtoAlumnoAsignaturas> listAlumnosAsignaturas = new ArrayList<>();

		
		/*Se crea una instancia de la clase en la que estamos para poder generar la conexión a PostgreSQL
		*utilizando el método generaConexion
		*/
		System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Lamada generaConexion");
		ConexionPostgresql conexionPostgresql = new ConexionPostgresql();
		Connection conexionGenerada = conexionPostgresql.generaConexion(HOST,PORT,DB,USER,PASS);
		
		if(conexionGenerada != null) {
			
			//Llamar al método que ejecuta la consulta
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada selectAllAlumnos");
			listAlumnos = ConsultasPostgreSQL.selectAllAlumnos(conexionGenerada);
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Número alumnos: "+i);
			for(Modelo.dtoAlumno alumnos: listAlumnos) {
				System.out.println(alumnos.getNombre()+ " " +alumnos.getApellidos());			}
			}
		
		
        if(conexionGenerada != null) {
			
			//Llamar al método que ejecuta la consulta
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada selectAllAlumnosAsig");
			listAlumnosAsignaturas = ConsultasPostgreSQL.selectAllAlumnosAsig(conexionGenerada);
			int i = listAlumnosAsignaturas.size();
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Número alumnos y asignaturas: "+i);
			for(Modelo.dtoAlumnoAsignaturas alumnosAsig: listAlumnosAsignaturas) {
				System.out.println(alumnosAsig.getNombre()+" "+alumnosAsig.getApellidos()+" "+alumnosAsig.getNombA());			}
			}
        
			
			
		}		
	
	}




