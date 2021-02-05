package view;

import java.util.List;
import controller.Request;
import DTO.StaffDTO;
import main.MainDispatcher;

public class StaffView extends AbstractView {
	
	private Request request;
	private String choice;

	public StaffView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione utenti ----------------\n");
			System.out.println("IdStaff\tnome\tcognome\temail\tposizione\tdata_assunzione\tnumero_telefono\tsede\tore_settimanali\tcodiceFIscal");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<StaffDTO> staff = (List<StaffDTO>) request.get("staff");
			for (StaffDTO u: staff)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("User", "doControl", this.request);
	}

}


