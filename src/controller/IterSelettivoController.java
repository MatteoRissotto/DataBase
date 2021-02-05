package controller;

import service.LoginService;
import service.IterSelettivoService;

import java.sql.Date;
import java.util.List;


import DTO.IterSelettivoDTO;
import main.MainDispatcher;

public class IterSelettivoController implements Controller{

	private static String sub_package = "iterSelettivo.";
	
	private IterSelettivoService iterSelettivoService;
	
	// costruisce un oggetto di tipo iterSelettivoService per poterne usare i metodi
	public IterSelettivoController() {
		this.iterSelettivoService = new IterSelettivoService();
	}
	
	/*
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
		int idIterSelettivo;
		int idCandidato;
		int idStaff;
		int punteggioTotaleScritto;
		int punteggioLogica;
		int punteggioPhp;
		int punteggioJava;
		int punteggioHTML;
		int punteggioInglese;
		Date dataTestScritto;
		Date dataTestOrale;
		int valutazioneOrale;
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			idIterSelettivo = Integer.parseInt(request.get("idIterSelettivo").toString());
			IterSelettivoDTO iterSelettivoDTO = iterSelettivoService.read(idIterSelettivo);
			request.put("iterSelettivo", iterSelettivoDTO);
			MainDispatcher.getInstance().callView(sub_package + "IterSelettivoRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			idCandidato = Integer.parseInt(request.get("idCandidato").toString());
			idStaff = Integer.parseInt(request.get("idStaff").toString());
			punteggioTotaleScritto = Integer.parseInt(request.get("punteggioTotaleScritto").toString());
			punteggioLogica = Integer.parseInt(request.get("punteggioLogica").toString());
			punteggioPhp = Integer.parseInt(request.get("punteggioPhp").toString());
			punteggioJava = Integer.parseInt(request.get("punteggioJava").toString());
			punteggioHTML = Integer.parseInt(request.get("punteggioHTML").toString());
			punteggioInglese = Integer.parseInt(request.get("punteggioInglese").toString());
			dataTestScritto = formatter.parse(dateInString(request.get("dataTestScritto").toString())); /** come passare da data a string??? **/
			dataTestOrale = formatter.parse(dateInString(request.get("dataTestOrale").toString())); /**come passare da data a string??? **/
			valutazioneOrale = Integer.parseInt(request.get("valutazioneOrale").toString());
			
						
			//costruisce l'oggetto user da inserire
			IterSelettivoDTO iterSelettivotoinsert = new IterSelettivoDTO(idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, dataTestOrale, valutazioneOrale);
			//invoca il service
			iterSelettivoService.insert(iterSelettivotoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "IterSelettivoInsert", request);
			break;
			
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idIterSelettivo = Integer.parseInt(request.get("idIterSelettivo").toString());
			//Qui chiama il service
			iterSelettivoService.delete(idIterSelettivo);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "IterSelettivoDelete", request);
			break;
			
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idIterSelettivo = Integer.parseInt(request.get("idIterSelettivo").toString());
			idCandidato = Integer.parseInt(request.get("idCandidato").toString());
			idStaff = Integer.parseInt(request.get("idStaff").toString());
			punteggioTotaleScritto = Integer.parseInt(request.get("punteggioTotaleScritto").toString());
			punteggioLogica = Integer.parseInt(request.get("punteggioLogica").toString());
			punteggioPhp = Integer.parseInt(request.get("punteggioPhp").toString());
			punteggioJava = Integer.parseInt(request.get("punteggioJava").toString());
			punteggioHTML = Integer.parseInt(request.get("punteggioHTML").toString());
			punteggioInglese = Integer.parseInt(request.get("punteggioInglese").toString());
			dataTestScritto = Integer.parseInt(request.get("dataTestScritto").toString()); /**come passare da date a string **/
			dataTestOrale = Integer.parseInt(request.get("dataTestOrale").toString()); /** come passare da date a string **/
			valutazioneOrale = Integer.parseInt(request.get("valutazioneOrale").toString());
							
			IterSelettivoDTO iterSelettivotoupdate = new IterSelettivoDTO(idCandidato, idStaff, punteggioTotaleScritto, punteggioLogica, punteggioPhp, punteggioJava, punteggioHTML, punteggioInglese, dataTestScritto, dataTestOrale, valutazioneOrale);
			iterSelettivotoupdate.setIdIterSelettivo(idIterSelettivo);
			iterSelettivoService.update(iterSelettivotoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "IterSelettivoUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "ITERSELETTIVOLIST":
			List<IterSelettivoDTO> iterSelettivo1DTO = iterSelettivoService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("iterSelettivo1", iterSelettivo1DTO);
			MainDispatcher.getInstance().callView("User", request);
			break;
		
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
						
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoRead", null);
				break;
					
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoInsert", null);
				break;
					
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoUpdate", null);
				break;
					
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "IterSelettivoDelete", null);
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
//END
}
