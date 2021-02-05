package modell;
import java.sql.Date;

public class Staff {
	
	
	private int idStaff;
	private int idIterSelettivo;
	private String nome;
	private String cognome;
	private String email;
	private String posizione;
	private int numeroTelefono;
	private Date dataAssunzione;
	private String sede;
	private int oreSettimanali;
	private String codiceFiscale;
	
	public Staff() {
	}
	
	public Staff(int idStaf, int idIterSelettivo, String nome, String cognome, String email, String posizione, int numeroTelefono,
			 Date dataAssunzione, String sede, int oreSettimanali, String codiceFiscale) {
		this.setIdStaff(idStaff);
		this.setIdIterSelettivo(idIterSelettivo);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setPosizione(posizione);
		this.setNumeroTelefono(numeroTelefono);
		this.setDataAssunzione(dataAssunzione);
		this.setSede(sede);
		this.setOreSettimanali(oreSettimanali);
		this.setCodiceFiscale(codiceFiscale);

		
		
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public int getIdIterSelettivo() {
		return idIterSelettivo;
	}
	public void setIdIterSelettivo(int idIterSelettivo) {
		this.idIterSelettivo = idIterSelettivo;
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
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(int numero_telefono) {
		this.numeroTelefono = numero_telefono;
	}
	public Date getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public int getOreSettimanali() {
		return oreSettimanali;
	}
	public void setOreSettimanali(int oreSettimanali) {
		this.oreSettimanali = oreSettimanali;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getData_assunzione() {
		// TODO Auto-generated method stub
		return null;
	}
}
