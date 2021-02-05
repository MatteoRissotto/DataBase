package controller;

import java.util.List;

import DTO.CorsoDTO;
import main.MainDispatcher;
import service.CorsoService;



public class CorsoController implements Controller{

	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "corso.";
	
	private CorsoService corsoService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public CorsoController() {
		this.corsoService = new CorsoService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int idCorso, idIterSelettivo,valutazioneComunicazioni,valutazioneIntuitivita,valutazioneAttitudine,valutazioneTeamWork,oreTotali,idCandidato,idStaff;
		String argomentoCorso;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			idCorso = Integer.parseInt(request.get("idCorso").toString());
			CorsoDTO corsoDTO = corsoService.read(idCorso);
			request.put("corso", corsoDTO);
			MainDispatcher.getInstance().callView(sub_package + "CorsoRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			idCorso = Integer.parseInt(request.get("idCorso").toString());
			idIterSelettivo = Integer.parseInt(request.get("idIterSelettivo").toString());
			argomentoCorso = request.get("argomentoCorso").toString();
			valutazioneComunicazioni = Integer.parseInt(request.get("valutazioneComunicazioni").toString());
			valutazioneIntuitivita = Integer.parseInt(request.get("valutazioneIntuitivita").toString());
			valutazioneAttitudine = Integer.parseInt(request.get("valutazioneAttitudine").toString());
			valutazioneTeamWork  = Integer.parseInt(request.get("valutazioneTeamWork").toString());
			oreTotali = Integer.parseInt(request.get("oreTotali").toString());
			idCandidato = Integer.parseInt(request.get("idCandidato").toString());
			idStaff = Integer.parseInt(request.get("idStaff").toString());
		
			//costruisce l'oggetto user da inserire
			CorsoDTO corsotoinsert = new CorsoDTO(idCorso, idCandidato, idIterSelettivo, argomentoCorso, valutazioneComunicazioni, valutazioneIntuitivita, valutazioneAttitudine, valutazioneTeamWork, oreTotali, idStaff);
			//invoca il service
			corsoService.insert(corsotoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "CorsoInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idCorso = Integer.parseInt(request.get("idCorso").toString());
			//Qui chiama il service
			corsoService.delete(idCorso);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CorsoDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idCorso = Integer.parseInt(request.get("idCorso").toString());
			idIterSelettivo = Integer.parseInt(request.get("idIterSelettivo").toString());
			argomentoCorso = request.get("argomentoCorso").toString();
			valutazioneComunicazioni = Integer.parseInt(request.get("valutazioneComunicazioni").toString());
			valutazioneIntuitivita = Integer.parseInt(request.get("valutazioneIntuitivita").toString());
			valutazioneAttitudine = Integer.parseInt(request.get("valutazioneAttitudine").toString());
			valutazioneTeamWork  = Integer.parseInt(request.get("valutazioneTeamWork").toString());
			oreTotali = Integer.parseInt(request.get("oreTotali").toString());
			idCandidato = Integer.parseInt(request.get("idCandidato").toString());
			idStaff = Integer.parseInt(request.get("idStaff").toString());
			
			CorsoDTO corsotoupdate = new CorsoDTO(idCorso, idCandidato, idIterSelettivo, argomentoCorso, valutazioneComunicazioni, valutazioneIntuitivita, valutazioneAttitudine, valutazioneTeamWork, oreTotali, idStaff);
			corsotoupdate.setIdCorso(idCorso);
			corsoService.update(corsotoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CorsoUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "CORSOLIST":
			List<CorsoDTO> corsoDTO1 = corsoService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("corso", corsoDTO1);
			MainDispatcher.getInstance().callView("Corso", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CorsoRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CorsoInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CorsoUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CorsoDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
