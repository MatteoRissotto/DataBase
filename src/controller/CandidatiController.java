package controller;

//Problema con Date


import java.sql.Date;
import java.util.List;

import conversioneData.ConversioneData;
import DTO.CandidatiDTO;
import main.MainDispatcher;
import service.CandidatiService;


public class CandidatiController implements Controller{
	private static String sub_package = "user.";
	ConversioneData conversionedata=new ConversioneData();
	private CandidatiService candidatiService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public CandidatiController() {
		this.candidatiService = new CandidatiService();
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
		 int idCandidati;
		 int idStaff;
		 String nome;
		 String cognome;
		 String email;
		 String luogoProvenienza;
		 int numero_telefono;
		 String titoloStudio;
		 String titoloLaurea;
		 Date dataCandidatura;
		 String rangeCandidatura;
		 boolean colloquioConoscitivo;
		 String candidatiTramite;
		 boolean idoneita;
		 String codiceFiscale;
		 String usertype;
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			idCandidati = Integer.parseInt(request.get("idCandidati").toString());
			CandidatiDTO candidatiDTO = candidatiService.read(idCandidati);
			request.put("candidati", candidatiDTO);
			MainDispatcher.getInstance().callView(sub_package + "CandidatiRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			String date;
			 idCandidati = Integer.parseInt(request.get("id").toString());
			 idStaff = Integer.parseInt(request.get("id staff").toString());
			 nome = request.get("nome").toString();
			 cognome = request.get("cognome").toString();
			 email = request.get("email").toString();
			 luogoProvenienza = request.get("luogo/provenienza").toString();
			 numero_telefono =Integer.parseInt( request.get("telefono").toString());
			 titoloStudio = request.get("titolo studio").toString();
			 titoloLaurea = request.get("titolo laurea").toString();
			 date=conversionedata.fromSql(dataCandidatura);
			 date=request.get("data candidatura").toString();
			 rangeCandidatura = request.get("range candidatura").toString();
			 colloquioConoscitivo = Boolean.parseBoolean(request.get("colloquio conosciuto").toString());
			 candidatiTramite = request.get("candidati tramite").toString();
			 idoneita = Boolean.parseBoolean(request.get("idoneità").toString());
				
			//costruisce l'oggetto user da inserire
			CandidatiDTO candidatitoinsert = new CandidatiDTO(idStaff, nome, cognome, email, luogoProvenienza, numero_telefono,
					titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo,
					candidatiTramite, idoneita, codiceFiscale, usertype);
			//invoca il service
			candidatiService.insert(candidatitoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "CandidatiInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idCandidati = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			candidatiService.delete(idCandidati);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CandidatiDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			String data;
			 idCandidati = Integer.parseInt(request.get("id").toString());
			 idStaff = Integer.parseInt(request.get("id staff").toString());
			 nome = request.get("nome").toString();
			 cognome = request.get("cognome").toString();
			 email = request.get("email").toString();
			 luogoProvenienza = request.get("luogo/provenienza").toString();
			 numero_telefono =Integer.parseInt( request.get("telefono").toString());
			 titoloStudio = request.get("titolo studio").toString();
			 titoloLaurea = request.get("titolo laurea").toString();
			 data = conversionedata.fromSql(dataCandidatura);
			 data =request.get("data candidatura").toString();
			 rangeCandidatura = request.get("range candidatura").toString();
			 colloquioConoscitivo = Boolean.parseBoolean(request.get("colloquio conosciuto").toString());
			 candidatiTramite = request.get("candidati tramite").toString();
			 idoneita = Boolean.parseBoolean(request.get("idoneità").toString());
			 CandidatiDTO candidatiinsert = new CandidatiDTO(idStaff, nome, cognome, email, luogoProvenienza, numero_telefono,
						titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo,
						candidatiTramite, idoneita, codiceFiscale, usertype);
			candidatiinsert.setIdCandidati(idCandidati);
			candidatiService.update(candidatiinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CandidatiUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "CANDIDATILIST":
			List<CandidatiDTO> candidatiDTO = candidatiService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("candidato", candidatiDTO);
			MainDispatcher.getInstance().callView("Candidati", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CandidatiDelete", null);
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
