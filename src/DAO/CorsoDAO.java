package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import modell.Corso;

public class CorsoDAO {
	private final String QUERY_ALL = "SELECT * FROM Corso";
	private final String QUERY_CREATE = "INSERT INTO Corso (idCandidato, idInsegnante, idIterSelettivo, argomentoCorso, valutazioneComunicazioni, valutazioneIntuitivita, valutazioneAttitudine, valutazioneTeamWork, oreTotali, idStaff) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM Corso WHERE idCorso=?";
	private final String QUERY_UPDATE = "UPDATE Corso SET idCandidato=?, idIterSelettivo=?, argomentoCorso=?, valutazioneComunicazioni=?, valutazioneIntuitivita=?, valutazioneAttitudine=?, valutazioneTeamWork=?, oreTotali=?, idStaff=? WHERE idCorso=?";
	private final String QUERY_DELETE = "DELETE FROM Corso WHERE idCorso=?";
	
	public CorsoDAO() {

	}
	public List<Corso> getAll() {
		List<Corso> corsoList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Corso corso;
			while (resultSet.next()) {
				int idCorso = resultSet.getInt("idCorso");
				int idCandidato = resultSet.getInt("idCandidato");
				int idIterSelettivo = resultSet.getInt("idIterSelettivo");
				String argomentoCorso = resultSet.getString("argomentoCorso");
				int valutazioneComunicazioni = resultSet.getInt("valutazioneComunicazioni");
				int valutazioneIntuitivita = resultSet.getInt("valutazioneIntuitivita");
				int valutazioneAttitudine = resultSet.getInt("valutazioneAttitudine");
				int valutazioneTeamWork = resultSet.getInt("valutazioneTeamWork");
				int oreTotali = resultSet.getInt("oreTotali");
				int idStaff = resultSet.getInt("idStaff");
				//dubbi
				corso = new Corso(idCorso, idCandidato, idIterSelettivo, argomentoCorso, valutazioneComunicazioni, valutazioneIntuitivita, valutazioneAttitudine, valutazioneTeamWork, oreTotali, idStaff);
				corso.setIdCorso(idCorso);
				corsoList.add(corso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corsoList;
	}

	public boolean insert(Corso corsoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, corsoToInsert.getIdCorso());
			preparedStatement.setInt(2, corsoToInsert.getIdCandidato());
			preparedStatement.setInt(3, corsoToInsert.getIdIterSelettivo());
			preparedStatement.setString(4, corsoToInsert.getArgomentoCorso());
			preparedStatement.setInt(5, corsoToInsert.getValutazioneComunicazioni());
			preparedStatement.setInt(6, corsoToInsert.getValutazioneIntuitivita());
			preparedStatement.setInt(7, corsoToInsert.getValutazioneAttitudine());
			preparedStatement.setInt(8, corsoToInsert.getValutazioneTeamWork());
			preparedStatement.setInt(9, corsoToInsert.getOreTotali());
			preparedStatement.setInt(10, corsoToInsert.getIdStaff());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Corso read(int idCorso) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idCorso);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int  idCandidato, idIterSelettivo, valutazioneComunicazioni, valutazioneIntuitivita, valutazioneAttitudine, valutazioneTeamWork, oreTotali, idStaff;
			String argomentoCorso;

			idCandidato = resultSet.getInt("idCandidato");
			idIterSelettivo = resultSet.getInt("idIterSelettivo");
			valutazioneComunicazioni = resultSet.getInt("valutazioneComunicazioni");
			valutazioneIntuitivita = resultSet.getInt("valutazioneIntuitivita");
			valutazioneAttitudine = resultSet.getInt("valutazioneAttitudine");
			valutazioneTeamWork = resultSet.getInt("valutazioneTeamWork");
			oreTotali = resultSet.getInt("oreTotali");
			idStaff = resultSet.getInt("idStaff");
			argomentoCorso = resultSet.getString("argomentoCorso");
						
			Corso corso = new Corso(idCandidato, idIterSelettivo, idStaff, argomentoCorso, valutazioneComunicazioni, valutazioneIntuitivita, valutazioneAttitudine, valutazioneTeamWork, oreTotali, idStaff);
			corso.setIdCorso(resultSet.getInt("idCorso"));

			return corso;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Corso corsoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (corsoToUpdate.getIdCorso() == 0)
			return false;

		Corso corsoRead = read(corsoToUpdate.getIdCorso());
		if (!corsoRead.equals(corsoToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (corsoToUpdate.getIdCandidato() == 0) {
					corsoToUpdate.setIdCandidato(corsoRead.getIdCandidato());
				}
				
				if (corsoToUpdate.getIdIterSelettivo() == 0) {
					corsoToUpdate.setIdIterSelettivo(corsoRead.getIdIterSelettivo());
				}

				if (corsoToUpdate.getArgomentoCorso() == null || corsoToUpdate.getArgomentoCorso().equals("")) {
					corsoToUpdate.setArgomentoCorso(corsoRead.getArgomentoCorso());
				}
				
				if (corsoToUpdate.getValutazioneComunicazioni() == 0) {
					corsoToUpdate.setValutazioneComunicazioni(corsoRead.getValutazioneComunicazioni());
				}
				
				if (corsoToUpdate.getValutazioneIntuitivita() == 0) {
					corsoToUpdate.setValutazioneIntuitivita(corsoRead.getValutazioneIntuitivita());
				}
				
				if (corsoToUpdate.getValutazioneAttitudine() == 0) {
					corsoToUpdate.setValutazioneAttitudine(corsoRead.getValutazioneAttitudine());
				}
				
				if (corsoToUpdate.getValutazioneTeamWork() == 0) {
					corsoToUpdate.setValutazioneTeamWork(corsoRead.getValutazioneTeamWork());
				}
				
				if (corsoToUpdate.getOreTotali() == 0) {
					corsoToUpdate.setOreTotali(corsoRead.getOreTotali());
				}
				
				if (corsoToUpdate.getIdStaff() == 0) {
					corsoToUpdate.setIdStaff(corsoRead.getIdStaff());
				}

				
				// Update the corso
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, corsoToUpdate.getIdCandidato());
				preparedStatement.setInt(2, corsoToUpdate.getIdIterSelettivo());
				preparedStatement.setString(3, corsoToUpdate.getArgomentoCorso());
				preparedStatement.setInt(4, corsoToUpdate.getValutazioneComunicazioni());
				preparedStatement.setInt(5, corsoToUpdate.getValutazioneIntuitivita());
				preparedStatement.setInt(6, corsoToUpdate.getValutazioneAttitudine());
				preparedStatement.setInt(7, corsoToUpdate.getValutazioneTeamWork());
				preparedStatement.setInt(8, corsoToUpdate.getOreTotali());
				preparedStatement.setInt(9, corsoToUpdate.getIdStaff());
			
				
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

	public boolean delete(int idCorso) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idCorso);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
