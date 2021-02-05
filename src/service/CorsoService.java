package service;

import java.util.List;
//import converter.CorsoConverter;
import DAO.CorsoDAO;
import DTO.CorsoDTO;
import converter.CorsoConverter;

public class CorsoService {
	private CorsoDAO corsoDAO;
	private CorsoConverter corsoConverter;
	
	//Istanzio DAO  e Converter specifici.
	public CorsoService(){
		this.corsoDAO = new CorsoDAO();
		this.corsoConverter = new CorsoConverter();
	}
	

	public List<CorsoDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return corsoConverter.toDTOList(corsoDAO.getAll());
	}


	public CorsoDTO read(int idCorso) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return corsoConverter.toDTO(corsoDAO.read(idCorso));
	}


	public boolean insert(CorsoDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return corsoDAO.insert(corsoConverter.toEntity(dto));  //controllare dto tra parentesi
	}


	public boolean update(CorsoDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return corsoDAO.update(corsoConverter.toEntity(dto));	//controllare dto tra parentesi
	}


	public boolean delete(int idCorso) {
		// Questo mtodo chiama direttamente il DAO
		return corsoDAO.delete(idCorso);
	}
}
