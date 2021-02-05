package converter;

import java.util.ArrayList;
import java.util.List;

import DTO.StaffDTO;
import modell.Staff;

public class StaffConverter {

	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public StaffDTO toDTO(Staff staff) {
		StaffDTO staffDTO = new StaffDTO(staff.getIdStaff(),staff.getNome(), staff.getCognome(), staff.getEmail(),staff.getPosizione(), staff.getData_assunzione(),
                staff.getNumeroTelefono(),staff.getSede(),staff.getOreSettimanali(),staff.getCodiceFiscale());
    return staffDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Staff toEntity(Staff staff) {
		StaffDTO staffDto = new StaffDTO(staff.getIdStaff(),staff.getNome(), staff.getCognome(), staff.getEmail(),staff.getPosizione(), staff.getData_assunzione(),
                staff.getNumeroTelefono(),staff.getSede(),staff.getOreSettimanali(),staff.getCodiceFiscale());
    return staff;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	public List<StaffDTO> toDTOList(List<Staff> list) {
		//Crea una lista vuota.
		List<StaffDTO> staffDTOList = new ArrayList<StaffDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Staff staff: list) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			staffDTOList.add(toDTO(staff));
		}
		return staffDTOList;
	}

}
