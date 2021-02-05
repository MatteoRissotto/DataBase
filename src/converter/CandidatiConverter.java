package converter;

import java.util.ArrayList;
import java.util.List;
import DTO.CandidatiDTO;
import modell.Candidati;

public class CandidatiConverter {
		
		/**
		 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		public CandidatiDTO toDTO(Candidati c) {
			CandidatiDTO  candidatiDto = new CandidatiDTO(c.getIdStaff(), c.getNome(),c.getCognome(),c.getEmail(),c.getLuogoProvenienza(), c.getNumero_telefono(),
					c.getTitoloStudio(), c.getTitoloLaurea(),c.getDataCandidatura(), c.getRangeCandidatura(), c.getColloquioConoscitivo(),
					c.getCandidatiTramite(),c.getIdoneita(),c.getCodiceFiscale(),c.getUsertype());
			return candidatiDto;
		}

		/**
		 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		public Candidati toEntity(CandidatiDTO c) {
			Candidati candidati = new Candidati(c.getIdStaff(), c.getNome(),c.getCognome(),c.getEmail(),c.getLuogoProvenienza(), c.getNumero_telefono(),
					c.getTitoloStudio(), c.getTitoloLaurea(),c.getDataCandidatura(), c.getRangeCandidatura(), c.getColloquioConoscitivo(),
					c.getCandidatiTramite(),c.getIdoneita(),c.getCodiceFiscale(),c.getUsertype());
			return candidati;
		}
		
		/**
		 * Metodo per convertire le liste di User.
		 */
		public List<CandidatiDTO> toDTOList(List<Candidati> candidatiList) {
			//Crea una lista vuota.
			List<CandidatiDTO> candidatiDTOList = new ArrayList<CandidatiDTO>();
			
			//Cicla tutti gli elementi della lista e li converte uno a uno
			for(Candidati candidati : candidatiList) {
				//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
				//e lo aggiunge adda lista di DTO
				candidatiDTOList.add(toDTO(candidati));
			}
			return candidatiDTOList;
		}

}
