package service;


import java.util.List;
import converter.CandidatiConverter;
import DAO.CandidatiDAO;
import DTO.CandidatiDTO;

public class CandidatiService {


	private CandidatiDAO candidatidao;
	private CandidatiConverter candidaticonverter;
	
	//Istanzio DAO  e Converter specifici.
	public CandidatiService(){
		this.candidatidao = new CandidatiDAO();
		this.candidaticonverter = new CandidatiConverter();
	}
	

	public List<CandidatiDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return candidaticonverter.toDTOList(candidatidao.getAll());
	}


	public CandidatiDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return candidaticonverter.toDTO(candidatidao.read(id));
	}


	public boolean insert(CandidatiDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return candidatidao.insert(candidaticonverter.toEntity(dto));
	}


	public boolean update(CandidatiDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return candidatidao.update(candidaticonverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return candidatidao.delete(id);
	}
}
