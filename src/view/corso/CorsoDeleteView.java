package view.corso;

import controller.Request;
import main.MainDispatcher;
import view.AbstractView;

public class CorsoDeleteView extends AbstractView{
	
	private Request request;

	private int idCorso;
	private final String mode = "DELETE";

	public CorsoDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Corso", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'utente:");
			idCorso = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idCorso", idCorso);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Corso", "doControl", request);
	}

}
