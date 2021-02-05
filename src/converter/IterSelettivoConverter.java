package converter;

import java.util.ArrayList;
import java.util.List;
import DTO.IterSelettivoDTO;
import modell.IterSelettivo;

public class IterSelettivoConverter {

	/*
	 * Crea un oggetto di tipo IterSelettivoDTO e lo riempie con i campi del parametro iterSelettivo
	 *  di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public IterSelettivoDTO toDTO(IterSelettivo iterSelettivo) {
		IterSelettivoDTO iterSelettivoDTO = new IterSelettivoDTO(iterSelettivo.getIdCandidato(), iterSelettivo.getIdStaff(), iterSelettivo.getPunteggioTotaleScritto(), iterSelettivo.getPunteggioLogica(), iterSelettivo.getPunteggioPhp(), iterSelettivo.getPunteggioJava(), iterSelettivo.getPunteggioHTML(), iterSelettivo.getPunteggioInglese(), iterSelettivo.getDataTestScritto(), iterSelettivo.getDataTestOrale(), iterSelettivo.getValutazioneOrale());
		return iterSelettivoDTO;
	}
	
	/*
	 * Crea un oggetto di tipo IterSelettivo e lo riempie con i campi del parametro iterSelettivo
	 *  di tipo IterSelettivoDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public IterSelettivo toEntity(IterSelettivoDTO iterSelettivoDTO) {
		IterSelettivo iterSelettivo = new IterSelettivo(iterSelettivoDTO.getIdIterSelettivo(), iterSelettivoDTO.getIdCandidato(), iterSelettivoDTO.getIdStaff(), iterSelettivoDTO.getPunteggioTotaleScritto(), iterSelettivoDTO.getPunteggioLogica(), iterSelettivoDTO.getPunteggioPhp(), iterSelettivoDTO.getPunteggioJava(), iterSelettivoDTO.getPunteggioHTML(), iterSelettivoDTO.getPunteggioInglese(), iterSelettivoDTO.getDataTestScritto(), iterSelettivoDTO.getDataTestOrale(), iterSelettivoDTO.getValutazioneOrale() );
		return iterSelettivo;
	}
		
	
	/*
	 * Metodo per convertire le liste di User.
	 */
	public List<IterSelettivoDTO> toDTOList(List<IterSelettivo> iterSelettivoList) {
		//Crea una lista vuota.
		List<IterSelettivoDTO> iterSelettivoDTOList = new ArrayList<IterSelettivoDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(IterSelettivo iterSelettivo : iterSelettivoList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			iterSelettivoDTOList.add(toDTO(iterSelettivo));
		}
		return iterSelettivoDTOList;
	}
	
//fine
}
