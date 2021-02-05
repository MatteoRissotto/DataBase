package DTO;
import java.sql.Date;

public class IterSelettivoDTO {
	
	private int idIterSelettivo;
	private int idCandidato;
	private int punteggioTotaleScritto;
	private int punteggioLogica;
	private int punteggioPhp;
	private int punteggioJava;
	private int punteggioHTML;
	private int punteggioInglese;
	private Date dataTestScritto;
	private Date dataTestOrale;
	private int valutazioneOrale;
	
	public IterSelettivoDTO() { //costruttore vuoto
		
	}
	
	/* costruttore con attributo */
	public IterSelettivoDTO(int idCandidato, int punteggioTotaleScritto,
			int punteggioLogica, int punteggioPhp, int punteggioJava, int punteggioHTML, 
			int punteggioInglese, Date dataTestScritto, Date dataTestOrale, int vautazioneOrale) {
		
		this.setIdCandidato(idCandidato);
		this.setPunteggioTotaleScritto(punteggioTotaleScritto);
		this.setPunteggioLogica(punteggioLogica);
		this.setPunteggioPhp(punteggioPhp);
		this.setPunteggioJava(punteggioJava);
		this.setPunteggioHTML(punteggioHTML);
		this.setPunteggioInglese(punteggioInglese);
		this.setDataTestScritto(dataTestScritto);
		this.setDataTestOrale(dataTestOrale);
		this.setValutazioneOrale(vautazioneOrale);
	}

	public IterSelettivoDTO(int idCandidato2, int idStaff, int punteggioTotaleScritto2, int punteggioLogica2,
			int punteggioPhp2, int punteggioJava2, int punteggioHTML2, int punteggioInglese2, Date dataTestScritto2,
			Date dataTestOrale2, int valutazioneOrale2) {
		// TODO Auto-generated constructor stub
	}

	public int getIdIterSelettivo() {
		return idIterSelettivo;
	}

	public void setIdIterSelettivo(int idIterSelettivo) {
		this.idIterSelettivo = idIterSelettivo;
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public int getPunteggioTotaleScritto() {
		return punteggioTotaleScritto;
	}

	public void setPunteggioTotaleScritto(int punteggioTotaleScritto) {
		this.punteggioTotaleScritto = punteggioTotaleScritto;
	}

	public int getPunteggioLogica() {
		return punteggioLogica;
	}

	public void setPunteggioLogica(int punteggioLogica) {
		this.punteggioLogica = punteggioLogica;
	}

	public int getPunteggioPhp() {
		return punteggioPhp;
	}

	public void setPunteggioPhp(int punteggioPhp) {
		this.punteggioPhp = punteggioPhp;
	}

	public int getPunteggioJava() {
		return punteggioJava;
	}

	public void setPunteggioJava(int punteggioJava) {
		this.punteggioJava = punteggioJava;
	}

	public int getPunteggioHTML() {
		return punteggioHTML;
	}

	public void setPunteggioHTML(int punteggioHTML) {
		this.punteggioHTML = punteggioHTML;
	}

	public int getPunteggioInglese() {
		return punteggioInglese;
	}

	public void setPunteggioInglese(int punteggioInglese) {
		this.punteggioInglese = punteggioInglese;
	}

	public Date getDataTestScritto() {
		return dataTestScritto;
	}

	public void setDataTestScritto(Date dataTestScritto) {
		this.dataTestScritto = dataTestScritto;
	}

	public Date getDataTestOrale() {
		return dataTestOrale;
	}

	public void setDataTestOrale(Date dataTestOrale) {
		this.dataTestOrale = dataTestOrale;
	}

	public int getValutazioneOrale() {
		return valutazioneOrale;
	}

	public void setValutazioneOrale(int valutazioneOrale) {
		this.valutazioneOrale = valutazioneOrale;
	}

	public int getIdStaff() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
