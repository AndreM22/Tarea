package cuarentena2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cuarentena2 {
	// Atributos
	private static Connection con;
	private static Cuarentena2 INSTANCE = null;

	// Constructor
	private Cuarentena2() {

	}

	// crear instancia
	private synchronized static void crearInstancia() {
		if (INSTANCE == null) {
			INSTANCE = new Cuarentena2();
			crearConexion();
		}
	}

	// obtener instancia
	public static Cuarentena2 getInstancia() {
		if (INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}

	// crear conexion
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "zeus";
		String password = "Zeus11111";
		String dataBase = "cuarentena2";
		try {
			// importando la libreria de conexion de mysqul

			Class.forName("com.mysql.jdbc.Driver");
			String urlConexion = "jdbc:mysql://" + host + "/" + dataBase + "?user=" + user + "&password=" + password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste :-)");
		} catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}

//		public ArrayList<String> getVendors() throws SQLException {
//			ArrayList <String> listaVendors= new ArrayList<String>();
//			PreparedStatement ps = con.prepareStatement("Select * from vendors");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				listaVendors.add(rs.getString("companyname"));
//				
//			}
//			rs.close();
//			return listaVendors;
//		
//		}
	public ArrayList<String> getPacientes() throws SQLException {
		ArrayList<String> listaPaciente = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement(
				"select persona.nombres from paciente " + "inner join persona on paciente.personaID=persona.CI ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listaPaciente.add(rs.getString("nombres"));
		}
		rs.close();
		return listaPaciente;
	}

	public ArrayList<String> getConsultorioYDoctor() throws SQLException {
		ArrayList<String> listaConsulta = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select persona.nombres, consultorio.* from doctor "
				+ "inner join persona on doctor.personaID=persona.CI "
				+ "inner join consultorio on doctor.consultorioID=consultorio.ID");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listaConsulta.add(rs.getString("nombres") + " " + rs.getString("consultorio.ID") + " "
					+ rs.getString("consultorio.piso") + " " + rs.getString("consultorio.nro"));
		}
		rs.close();
		return listaConsulta;
	}
}
