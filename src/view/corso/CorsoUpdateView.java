package view.corso;

import controller.Request;
import main.MainDispatcher;
import view.AbstractView;

public class CorsoUpdateView extends AbstractView{

	private Request request;

	private int idCorso;
	private int idCandidato;
	private int idInsegnante;
	private int idIterSelettivo;
	private String argomentoCorso;
	private int valutazioneComunicazioni;
	private int valutazioneIntuitivita;
	private int valutazioneAttitudine;
	private int valutazioneTeamWork;
	private int oreTotali;
	private int idStaff;
	private final String mode = "UPDATE";

	public CorsoUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Corso", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci idCorso dell'utente:");
			idCorso = getInt();
			System.out.println("Inserisci idCandidato dell'utente:");
			idCandidato = getInt();
			System.out.println("Inserisci idInsegnante dell'utente:");
			idInsegnante = getInt();
			System.out.println("Inserisci idIterSelettivo dell'utente:");
			idIterSelettivo = getInt();
			System.out.println("Inserisci argomentoCorso dell'utente:");
			argomentoCorso = getInput();
			System.out.println("Inserisci valutazioneComunicazioni dell'utente:");
			valutazioneComunicazioni = getInt();
			System.out.println("Inserisci valutazioneIntuitivita dell'utente:");
			valutazioneIntuitivita = getInt();
			System.out.println("Inserisci valutazioneAttitudine dell'utente:");
			valutazioneAttitudine = getInt();
			System.out.println("Inserisci valutazioneTeamWork dell'utente:");
			valutazioneTeamWork = getInt();
			System.out.println("Inserisci oreTotali dell'utente:");
			oreTotali = getInt();
			System.out.println("Inserisci idStaff dell'utente:");
			idStaff = getInt();
			
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idCorso", idCorso);
		request.put("idCandidato", idCandidato);
		request.put("idInsegnante", idInsegnante);
		request.put("idIterSelettivo", idIterSelettivo);
		request.put("argomentoCorso", argomentoCorso);
		request.put("valutazioneComunicazioni", valutazioneComunicazioni);
		request.put("valutazioneIntuitivita", valutazioneIntuitivita);
		request.put("valutazioneAttitudine", valutazioneAttitudine);
		request.put("valutazioneTeamWork", valutazioneTeamWork);
		request.put("oreTotali", oreTotali);
		request.put("idStaff", idStaff);


		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Corso", "doControl", request);
	}

}
