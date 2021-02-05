package DTO;

public class CorsoDTO {
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
	

	public CorsoDTO(int idCorso, int idCandidato, int idIterSelettivo, String argomentoCorso,
			int valutazioneComunicazioni, int valutazioneIntuitivita, int valutazioneAttitudine,
			int valutazioneTeamWork, int oreTotali, int idStaff) {
		// TODO Auto-generated constructor stub
	}

	public void CorsoDTO(int idCandidato, int idInsegnante, int idIterSelettivo, String argomentoCorso,int valutazioneComunicazioni,int valutazioneIntuitivita, int valutazioneAttitudine, int valutazioneTeamWork, int oreTotali, int idStaff) {
		this.setIdCandidato(idCandidato);
		this.setIdInsegnante(idInsegnante);
		this.setIdIterSelettivo(idIterSelettivo);
		this.setArgomentoCorso(argomentoCorso);
		this.setValutazioneComunicazioni(valutazioneComunicazioni);
		this.setValutazioneIntuitivita(valutazioneIntuitivita);
		this.setValutazioneAttitudine(valutazioneAttitudine);
		this.setValutazioneTeamWork(valutazioneTeamWork);
		this.setOreTotali(oreTotali);
		this.setIdStaff(idStaff);

		
	}
	
	public int getIdStaff() {
		return idStaff;
	}

	private void setIdStaff(int idStaff) {
		// TODO Auto-generated method stub
		
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public int getIdInsegnante() {
		return idInsegnante;
	}

	public void setIdInsegnante(int idInsegnante) {
		this.idInsegnante = idInsegnante;
	}

	public int getIdIterSelettivo() {
		return idIterSelettivo;
	}

	public void setIdIterSelettivo(int idIterSelettivo) {
		this.idIterSelettivo = idIterSelettivo;
	}

	public String getArgomentoCorso() {
		return argomentoCorso;
	}

	public void setArgomentoCorso(String argomentoCorso) {
		this.argomentoCorso = argomentoCorso;
	}

	public int getValutazioneComunicazioni() {
		return valutazioneComunicazioni;
	}

	public void setValutazioneComunicazioni(int valutazioneComunicazioni) {
		this.valutazioneComunicazioni = valutazioneComunicazioni;
	}

	public int getValutazioneIntuitivita() {
		return valutazioneIntuitivita;
	}

	public void setValutazioneIntuitivita(int valutazioneIntuitivita) {
		this.valutazioneIntuitivita = valutazioneIntuitivita;
	}

	public int getValutazioneAttitudine() {
		return valutazioneAttitudine;
	}

	public void setValutazioneAttitudine(int valutazioneAttitudine) {
		this.valutazioneAttitudine = valutazioneAttitudine;
	}

	public int getValutazioneTeamWork() {
		return valutazioneTeamWork;
	}

	public void setValutazioneTeamWork(int valutazioneTeamWork) {
		this.valutazioneTeamWork = valutazioneTeamWork;
	}

	public int getOreTotali() {
		return oreTotali;
	}

	public void setOreTotali(int oreTotali) {
		this.oreTotali = oreTotali;
	}
}
