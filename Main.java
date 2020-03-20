package cuarentena2;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Cuarentena2.getInstancia();
		Cuarentena2 instancia = Cuarentena2.getInstancia();
		try {
			// Mostrar lista de pacientes
			ArrayList<String> listPacientes = instancia.getPacientes();
			System.out.println("Lista de pacientes");
			for (String paciente : listPacientes) {
				System.out.println(paciente);
			}
			// Mostrar consultorio y doctores
			ArrayList<String> listDocCon = instancia.getConsultorioYDoctor();
			System.out.println("Nombre id Piso #");
			for (String dato : listDocCon) {
				System.out.println(dato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
