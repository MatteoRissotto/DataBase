package modell;
import java.sql.Date;

public class Candidati {
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
	private String userType;
	
	
	public Candidati() {
		
	}
	public Candidati(int id_C,int id_S,String name,String cog,String Email,String luogo,int numero,String titolo_s,String titolo_l,Date data, 
			String range,boolean collo_cono,String candidati,boolean idonei,String codice, String Type ) {
		
		idCandidati=id_C;
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
		userType = Type;
		
	}
	public Candidati(int idStaff2, String nome2, String cognome2, String email2, String luogoProvenienza2,
			int numero_telefono2, String titoloStudio2, String titoloLaurea2, Date dataCandidatura2,
			String rangeCandidatura2, boolean colloquioConoscitivo2, String candidatiTramite2, boolean idoneita2,
			String codiceFiscale2, String usertype2) {
		// TODO Auto-generated constructor stub
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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

	public boolean isColloquioConoscitivo() {
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

	public boolean isIdoneita() {
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
	public boolean getIdoneita() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean getColloquioConoscitivo() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getUsertype() {
		// TODO Auto-generated method stub
		return null;
	}

}
