package DTO;

import java.sql.Date;

public class StaffDTO {
	
	private int idStaff;
	private String nome;
	private String cognome;
	private String email;
	private String posizione;
	private Date data_assunzione;
	private int numero_telefono;
	private String sede;
	private int ore_settimanali;
	private String codice_fiscale;

	
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

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public Date getData_assunzione() {
		return data_assunzione;
	}

	public void setData_assunzione(Date data_assunzione) {
		this.data_assunzione = data_assunzione;
	}

	public int getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(int numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public int getOre_settimanali() {
		return ore_settimanali;
	}

	public void setOre_settimanali(int ore_settimanali) {
		this.ore_settimanali = ore_settimanali;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public StaffDTO() {
		
	}
	
	public StaffDTO(int id_S,String name,String surmame,String Email,String position,Date data,int num,String Sede, int ore_sett, String codice)
{
		
		idStaff=id_S;
		nome=name;
		cognome=surmame;
		email=Email;
		posizione=position;
		data_assunzione=data;
		numero_telefono=num;
		sede=Sede;
		ore_settimanali=ore_sett;
		codice_fiscale=codice;
		
	}
}
