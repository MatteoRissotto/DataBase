package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import modell.Staff;
/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class StaffDAO {

	private final String QUERY_ALL = "SELECT * FROM Staff";
	private final String QUERY_CREATE = "INSERT INTO Staff (idStaff, idIterSelettivo, nome,cognome,email,posizione,numeroTelefono,dataAssunzione,sede,oreSettimanali) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM Staff WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE Staff SET idStaff=?,idIterSelettivo,nome=?,cognome=?, email=?, posizione=?,numeroTelefono=?,dataAssunzione=?,sede=?,oreSettimanali=?,codiceFiscale=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM Staff WHERE id=?";

	public StaffDAO() {

	}

	public List<Staff> getAll() {
		List<Staff> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Staff staff;
			while (resultSet.next()) {
				
				int idStaff= resultSet.getInt("idStaff");
				int idIterSelettivo= resultSet.getInt("idIterSelettivo");
				String  nome= resultSet.getString("nome");
				String  cognome= resultSet.getString("cognome");
				String  email = resultSet.getString("email");
				String posizione = resultSet.getString("posizione");
				int numeroTelefono= resultSet.getInt("numeroTelefono");
				Date dataAssunzione= resultSet.getDate("dataAssunzione");
				String sede= resultSet.getString("sede");
				int oreSettimanali= resultSet.getInt("oreSettimanali");
				String codiceFiscale = resultSet.getString("codiceFiscale");

				
				staff = new Staff(idStaff, idIterSelettivo, nome,cognome,email,posizione,numeroTelefono,dataAssunzione,sede,oreSettimanali,codiceFiscale);
				staff.setIdStaff(idStaff);
				usersList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public boolean insert(Staff staffToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, staffToInsert.getIdStaff());
			preparedStatement.setInt(2, staffToInsert.getIdIterSelettivo());
			preparedStatement.setString(3, staffToInsert.getNome());
			preparedStatement.setString(4, staffToInsert.getCognome());
			preparedStatement.setString(5, staffToInsert.getEmail());
			preparedStatement.setString(6, staffToInsert.getPosizione());
			preparedStatement.setInt(7, staffToInsert.getNumeroTelefono());
			preparedStatement.setDate(8, staffToInsert.getDataAssunzione());
			preparedStatement.setString(9, staffToInsert.getSede());
			preparedStatement.setInt(10,staffToInsert.getOreSettimanali());
			preparedStatement.setString(10,staffToInsert.getCodiceFiscale());

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Staff read(int idstaff) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idstaff);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			/*int idStaff, idIterSelettivo,numeroTelefono,oreSettimanali;
			String nome,cognome,email,posizione,sede;
			Date dataAssunzione;*/

			int idStaff= resultSet.getInt("idStaff");
			int idIterSelettivo= resultSet.getInt("idIterSelettivo");
			String  nome= resultSet.getString("nome");
			String  cognome= resultSet.getString("cognome");
			String  email= resultSet.getString("email");
			String posizione = resultSet.getString("posizione");
			int numeroTelefono= resultSet.getInt("numeroTelefono");
			Date dataAssunzione= resultSet.getDate("dataAssunzione");
			String sede= resultSet.getString("sede");
			int oreSettimanali= resultSet.getInt("oreSettimanali");
			String codiceFiscale = resultSet.getString("codiceFiscale");
			
			Staff staff= new Staff(idStaff, idIterSelettivo, nome,cognome,email,posizione,numeroTelefono,dataAssunzione,sede,oreSettimanali, codiceFiscale);
			staff.setIdStaff(idStaff);

			return staff;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Staff staffToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (staffToUpdate.getIdStaff() == 0)
			return false;

		Staff staffRead = read(staffToUpdate.getIdStaff());
		if (!staffRead.equals(staffToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (staffToUpdate.getIdStaff()== 0) {
					staffToUpdate.setIdStaff(staffRead.getIdStaff());
				}

				if (staffToUpdate.getIdIterSelettivo() == 0) {
					staffToUpdate.setIdIterSelettivo(staffRead.getIdIterSelettivo());
				}

				if (staffToUpdate.getCognome() == null || staffToUpdate.getCognome().equals("")) {
					staffToUpdate.setCognome(staffRead.getCognome());
				}
				
				if (staffToUpdate.getEmail() == null || staffToUpdate.getEmail().equals("")) {
					staffToUpdate.setEmail(staffRead.getEmail());
				}

				
				if (staffToUpdate.getPosizione() == null || staffToUpdate.getPosizione().equals("")) {
					 staffToUpdate.setPosizione(staffRead.getPosizione());
				}

				if (staffToUpdate.getNumeroTelefono() == 0) {
					staffToUpdate.setNumeroTelefono(staffRead.getNumeroTelefono());
				}

				if (staffToUpdate.getDataAssunzione() == null || staffToUpdate.getDataAssunzione().equals("")) {
					staffToUpdate.setDataAssunzione(staffRead.getDataAssunzione());
				}

				if (staffToUpdate.getSede() == null ||staffToUpdate.getSede().equals("")) {
					staffToUpdate.setSede(staffRead.getSede());
				}

				if (staffToUpdate.getOreSettimanali() == 0) {
					staffToUpdate.setOreSettimanali(staffRead.getOreSettimanali());
				}


				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, staffToUpdate.getIdStaff());
				preparedStatement.setInt(2, staffToUpdate.getIdIterSelettivo());
				preparedStatement.setString(3, staffToUpdate.getNome());
				preparedStatement.setString(4, staffToUpdate.getCognome());
				preparedStatement.setString(5, staffToUpdate.getEmail());
				preparedStatement.setString(6, staffToUpdate.getPosizione());
				preparedStatement.setInt(7, staffToUpdate.getNumeroTelefono());
				preparedStatement.setDate(8, staffToUpdate.getDataAssunzione());
				preparedStatement.setString(9, staffToUpdate.getSede());
				preparedStatement.setInt(10,staffToUpdate.getOreSettimanali());
				preparedStatement.setString(10,staffToUpdate.getCodiceFiscale());

				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int idstaff) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idstaff);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
