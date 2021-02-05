package DTO;
import java.sql.Date;

public class CandidatiDTO{
	private int idCandidati;
	private int idStaff;
	private String nome;
	private String cognome;
	private String email;
	private String luogoProvenienza;
	private int numero_telefono;
	private String titoloStudio;
	private String titoloLaurea;
	private Date dataCandidatura;
	private String rangeCandidatura;
	private boolean colloquioConoscitivo;
	private String candidatiTramite;
	private boolean idoneita;
	private String codiceFiscale;
	private String usertype;
	
	public CandidatiDTO() {
		
	}
	public CandidatiDTO(int id_S,String name,String cog,String Email,String luogo,int numero,String titolo_s,String titolo_l,Date data, 
			String range,boolean collo_cono,String candidati,boolean idonei,String codice, String usertype ) {
		
		this.usertype=usertype;
		idStaff=id_S;
		nome=name;
		cognome=cog;
		email=Email;
		luogoProvenienza=luogo;
		numero_telefono=numero;
		titoloStudio=titolo_s;
		titoloLaurea=titolo_l;
		dataCandidatura=data;
		rangeCandidatura= range;
		colloquioConoscitivo= collo_cono;
		candidatiTramite=candidati;
		idoneita=idonei;
		codiceFiscale=codice;
		
	}
	public CandidatiDTO(int idCandidati,int id_S,String name,String cog,String Email,String luogo,int numero,String titolo_s,String titolo_l,Date data, 
			String range,boolean collo_cono,String candidati,boolean idonei,String codice, String usertype ) {
		this.idCandidati=idCandidati;
		this.usertype=usertype;
		idStaff=id_S;
		nome=name;
		cognome=cog;
		email=Email;
		luogoProvenienza=luogo;
		numero_telefono=numero;
		titoloStudio=titolo_s;
		titoloLaurea=titolo_l;
		dataCandidatura=data;
		rangeCandidatura= range;
		colloquioConoscitivo= collo_cono;
		candidatiTramite=candidati;
		idoneita=idonei;
		codiceFiscale=codice;
		
	}
	
	
	public void setUsertype(String usertype) {
		this.usertype=usertype;
	}
	
	public String getUsertype() {
		return usertype;
		
	}
	
	
	
	
	
	public void setIdCandidati(int idCandidati) {
		this.idCandidati=idCandidati;
	}
	
	public int getIdCandidati() {
		return idCandidati;
		
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLuogoProvenienza() {
		return luogoProvenienza;
	}

	public void setLuogoProvenienza(String luogoProvenienza) {
		this.luogoProvenienza = luogoProvenienza;
	}

	public int getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(int numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	public String getTitoloStudio() {
		return titoloStudio;
	}

	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}

	public String getTitoloLaurea() {
		return titoloLaurea;
	}

	public void setTitoloLaurea(String titoloLaurea) {
		this.titoloLaurea = titoloLaurea;
	}

	public Date getDataCandidatura() {
		return dataCandidatura;
	}

	public void setDataCandidatura(Date dataCandidatura) {
		this.dataCandidatura = dataCandidatura;
	}

	public String getRangeCandidatura() {
		return rangeCandidatura;
	}

	public void setRangeCandidatura(String rangeCandidatura) {
		this.rangeCandidatura = rangeCandidatura;
	}

	public boolean getColloquioConoscitivo() {
		return colloquioConoscitivo;
	}

	public void setColloquioConoscitivo(boolean colloquioConoscitivo) {
		this.colloquioConoscitivo = colloquioConoscitivo;
	}

	public String getCandidatiTramite() {
		return candidatiTramite;
	}

	public void setCandidatiTramite(String candidatiTramite) {
		this.candidatiTramite = candidatiTramite;
	}

	public boolean getIdoneita() {
		return idoneita;
	}

	public void setIdoneita(boolean idoneita) {
		this.idoneita = idoneita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	
	
	@Override
	public String toString() {
		return  idCandidati + "\t"  + idStaff +"\t\t" +   nome + "\t\t" + cognome + "\t\t" + email + "\t"  + luogoProvenienza +"\t\t" +   numero_telefono + "\t\t" + titoloStudio +"\t\t" +   titoloLaurea + "\t\t" + dataCandidatura + "\t\t" + rangeCandidatura + "\t"  + colloquioConoscitivo +"\t\t" +   candidatiTramite + "\t\t"  + idoneita +"\t\t" +   codiceFiscale + "\t\t" +   usertype + "\t\t";
	}
}
