package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import modell.IterSelettivo;


public class IterSelettivoDAO {
	private final String QUERY_ALL = "SELECT * FROM IterSelettivo";
	private final String QUERY_CREATE = "INSERT INTO IterSelettivo (id candidato, id staff, punteggio totale scritto, punteggio logica, punteggio php, punteggio java, punteggio inglese, data test scritto, valutazione scritto, data test orale) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM IterSelettivo WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE IterSelettivo SET id candidato = ?, id staff = ?, punteggio totale scritto = ?, punteggio logica = ?, punteggio php = ?, punteggio java = ?, punteggio html = ?, ";
	private final String QUERY_DELETE = "DELETE * FROM IterSelettivo WHERE id = ?";
	
	public IterSelettivoDAO() {
		
	}
	
	//get all
	public List<IterSelettivo> getAll (){
		List<IterSelettivo> iterSelettivoList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			IterSelettivo iterSelettivo;
			while (resultSet.next()) {
				int idIterSelettivo = resultSet.getInt("id");
				int idCandidato = resultSet.getInt("id candidato");
				int idStaff = resultSet.getInt("id staff");
				int punteggioTotaleScritto = resultSet.getInt("punteggio totale scritto");
				int punteggioLogica = resultSet.getInt("punteggio logica");
				int punteggioPhp = resultSet.getInt("punteggio php");
				int punteggioJava = resultSet.getInt("punteggio java");
				int punteggioHTML = resultSet.getInt("punteggio html");
				int punteggioInglese = resultSet.getInt("punteggio inglese");
				Date dataTestScritto = resultSet.getDate("data test scritto");
				int valutazioneOrale = resultSet.getInt("valutazione orale");
				Date dataTestOrale = resultSet.getDate("data test orale");
				iterSelettivo = new IterSelettivo(idIterSelettivo, idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, valutazioneOrale, dataTestOrale);
				iterSelettivo.setIdIterSelettivo(idIterSelettivo);
				iterSelettivoList.add(iterSelettivo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iterSelettivoList;
	}
	
	//insert
	public boolean insert(IterSelettivo iterSelettivoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, iterSelettivoToInsert.getIdCandidato());
			preparedStatement.setInt(2, iterSelettivoToInsert.getIdStaff());
			preparedStatement.setInt(3, iterSelettivoToInsert.getPunteggioTotaleScritto());
			preparedStatement.setInt(4, iterSelettivoToInsert.getPunteggioLogica());
			preparedStatement.setInt(5, iterSelettivoToInsert.getPunteggioPhp());
			preparedStatement.setInt(6, iterSelettivoToInsert.getPunteggioJava());
			preparedStatement.setInt(7, iterSelettivoToInsert.getPunteggioHTML());
			preparedStatement.setInt(8, iterSelettivoToInsert.getPunteggioInglese());
			preparedStatement.setDate(9, iterSelettivoToInsert.getDataTestScritto());
			preparedStatement.setInt(10, iterSelettivoToInsert.getValutazioneOrale());
			preparedStatement.setDate(11, iterSelettivoToInsert.getDataTestOrale());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
		
		// read
	public IterSelettivo read(int idIterSelettivo) {
			Connection connection = ConnectionSingleton.getInstance();
			try {


				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
				preparedStatement.setInt(1, idIterSelettivo);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, valutazioneOrale;
				Date dataTestScritto, dataTestOrale;
				
				idCandidato = resultSet.getInt("id candidato");
				idStaff = resultSet.getInt("id staff");
				punteggioTotaleScritto = resultSet.getInt("punteggio totale scritto");
				punteggioLogica = resultSet.getInt("punteggio logica");
				punteggioPhp = resultSet.getInt("punteggio php");
				punteggioJava = resultSet.getInt("punteggio java");
				punteggioHTML = resultSet.getInt("punteggio html");
				punteggioInglese = resultSet.getInt("punteggio inglese");
				dataTestScritto = resultSet.getDate("data test scritto");
				valutazioneOrale = resultSet.getInt("valutazione orale");
				dataTestOrale = resultSet.getDate("data test orale");
				
				IterSelettivo iterSelettivo = new IterSelettivo(idIterSelettivo, idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, valutazioneOrale, dataTestOrale);
				iterSelettivo.setIdIterSelettivo(resultSet.getInt("id"));

				return iterSelettivo;
			} catch (SQLException e) {
				return null;
			}

		}
	
	// update
	public boolean update(IterSelettivo iterSelettivoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (iterSelettivoToUpdate.getIdIterSelettivo() == 0)
			return false;

		IterSelettivo iterSelettivoRead = read(iterSelettivoToUpdate.getIdIterSelettivo());
		if (!iterSelettivoRead.equals(iterSelettivoToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (iterSelettivoToUpdate.getIdCandidato() == 0) {
					iterSelettivoToUpdate.setIdCandidato(iterSelettivoRead.getIdCandidato());
				}
				if (iterSelettivoToUpdate.getIdStaff() == 0) {
					iterSelettivoToUpdate.setIdStaff(iterSelettivoRead.getIdStaff());
				}
				if (iterSelettivoToUpdate.getPunteggioTotaleScritto() == 0) {
					iterSelettivoToUpdate.setPunteggioTotaleScritto(iterSelettivoRead.getPunteggioTotaleScritto());
				}
				if (iterSelettivoToUpdate.getPunteggioLogica() == 0) {
					iterSelettivoToUpdate.setPunteggioLogica(iterSelettivoRead.getPunteggioLogica());
				}
				if (iterSelettivoToUpdate.getPunteggioPhp() == 0) {
					iterSelettivoToUpdate.setPunteggioPhp(iterSelettivoRead.getPunteggioPhp());
				}
				if (iterSelettivoToUpdate.getPunteggioHTML() == 0) {
					iterSelettivoToUpdate.setPunteggioHTML(iterSelettivoRead.getPunteggioHTML());
				}
				if (iterSelettivoToUpdate.getPunteggioInglese() == 0) {
					iterSelettivoToUpdate.setPunteggioInglese(iterSelettivoRead.getPunteggioInglese());
				}
				if (iterSelettivoToUpdate.getValutazioneOrale() == 0) {
					iterSelettivoToUpdate.setValutazioneOrale(iterSelettivoRead.getValutazioneOrale());
				}
				if (iterSelettivoToUpdate.getDataTestScritto() == null || iterSelettivoToUpdate.getDataTestScritto().equals("")) {
					iterSelettivoToUpdate.setDataTestScritto(iterSelettivoRead.getDataTestScritto());
				} // le date vengono considerate come stringhe
				if (iterSelettivoToUpdate.getDataTestOrale() == null || iterSelettivoToUpdate.getDataTestOrale().equals("")) {
					iterSelettivoToUpdate.setDataTestOrale(iterSelettivoRead.getDataTestOrale());
				}
		
				// Update iter selettivo
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, iterSelettivoToUpdate.getIdCandidato());
				preparedStatement.setInt(2, iterSelettivoToUpdate.getIdStaff());
				preparedStatement.setInt(3, iterSelettivoToUpdate.getPunteggioTotaleScritto());
				preparedStatement.setInt(4, iterSelettivoToUpdate.getPunteggioLogica());
				preparedStatement.setInt(5, iterSelettivoToUpdate.getPunteggioPhp());
				preparedStatement.setInt(6, iterSelettivoToUpdate.getPunteggioJava());
				preparedStatement.setInt(7, iterSelettivoToUpdate.getPunteggioHTML());
				preparedStatement.setInt(8, iterSelettivoToUpdate.getPunteggioInglese());
				preparedStatement.setDate(9, iterSelettivoToUpdate.getDataTestScritto());
				preparedStatement.setInt(10, iterSelettivoToUpdate.getValutazioneOrale());
				preparedStatement.setDate(11, iterSelettivoToUpdate.getDataTestOrale());

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
	
	//delete
	public boolean delete(int idIterSelettivo) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idIterSelettivo);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
