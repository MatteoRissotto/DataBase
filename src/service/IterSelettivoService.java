package service;

import java.util.List;
import DAO.IterSelettivoDAO;
import DTO.IterSelettivoDTO;
import converter.IterSelettivoConverter;


public class IterSelettivoService {
	
	private IterSelettivoDAO iterSelettivoDAO;
	private IterSelettivoConverter iterSelettivoConverter;
	
	//Istanzio DAO  e Converter specifici.
	public IterSelettivoService(){
		this.iterSelettivoDAO = new IterSelettivoDAO();
		this.iterSelettivoConverter = new IterSelettivoConverter();
	}
	
		// Ottiene una lista di entità e le restituisce convertendole in DTO
	public List<IterSelettivoDTO> getAll() {
		return iterSelettivoConverter.toDTOList(iterSelettivoDAO.getAll());
	}
	
	// Ottiene un'entità e la restituisce convertendola in DTO
	public IterSelettivoDTO read(int idIterSelettivo) {
		return iterSelettivoConverter.toDTO(iterSelettivoDAO.read(idIterSelettivo));
	}
	
	// Converte un DTO in entità e lo passa al DAO per l'inserimento
	public boolean insert(IterSelettivoDTO dto) {
			return iterSelettivoDAO.insert(iterSelettivoConverter.toEntity(dto));
	}
	
	// Converte un userDTO in entità e lo passa allo userDAO per la modifica
	public boolean update(IterSelettivoDTO dto) {
			return iterSelettivoDAO.update(iterSelettivoConverter.toEntity(dto));
	}
	
	// Questo metodo chiama direttamente il DAO
	public boolean delete(int idIterSelettivo) {
			return iterSelettivoDAO.delete(idIterSelettivo);
	}


// end
}
