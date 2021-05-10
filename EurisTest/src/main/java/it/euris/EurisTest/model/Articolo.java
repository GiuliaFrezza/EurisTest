package it.euris.EurisTest.model;

import it.euris.EurisTest.util.IMappable;

public class Articolo implements IMappable{
	
	private String codice;
	private String nome;
	private String costo;
	
	public Articolo(String codice, String nome, String costo) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.costo = costo;
	}
	
	/*
	 * Necessito del costruttore vuoto per permettere all' interfaccia
	 * IMappable di creare automaticamente l'oggetto Articolo
	 */
	public Articolo() {
		super();
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "{codice:" + codice + ", nome:" + nome + ", costo:" + costo + "}";
	}
}