package it.euris.EurisTest.model;

public class Costo {
	
	
	
	private int pence;
	private int shilling;
	private int pound;
	
	/*
	 * la classe Costo è utilizzata per semplificare i calcoli sui prezzi degli articoli
	 * il costruttore prende come parametro una stringa che avrà come formato "Xp Ys Zd"
	 * con le operazioni effettuate su questa stringa andrà a inserire i valori nelle proprietà 
	 * 
	 */
	
	public Costo(String costo) {
		super();
		String[] temp = costo.split(" ");
		
		pound = estraiNumero(temp[0]);
		shilling = estraiNumero(temp[1]);
		pence = estraiNumero(temp[2]);	
	}	
	
	//il metodo estraiNumero rimuove le lettere poste alla fine della stringa in modo da avere solo il valore numerico
	private int estraiNumero(String string) { 
		return Integer.parseInt(string.substring(0, string.length() - 1));
	}
	
	
	//trasforma tutto in pence in modo da effettuare i calcoli su questi
	private int toPence() {
		return pound * 240 + shilling * 12 + pence;
	}
	
	//una volta effettuati i calcoli sui pence inserisce i nuovi valori nelle proprietà di Costo
	private Costo fromPence(int pence){
		shilling = pence / 12;
		this.pence = pence % 12;
		pound = shilling / 20;
		shilling = shilling % 20;
		return this;
	}
	
	// restituisce una nuova stringa in formato "Xp Ys Zd"
	public String toString() {;
		return pound+"p "+shilling+"s "+pence+"d";
	}
	
	
	public Costo somma(Costo addendo) {

		int somma =addendo.toPence() + this.toPence();
		Costo ris = fromPence(somma);
	
		return ris;
	}
	
	public Costo sottrai (Costo sottraendo) {
		int sottrazione;
		
		//controllo che non venga fatta una sottrazione con risultato negativo
		if(sottraendo.toPence() > this.toPence()) {
			sottrazione = sottraendo.toPence() - this.toPence();
		}
		else {
			sottrazione = this.toPence() +- sottraendo.toPence();
		}
		
		Costo ris = fromPence(sottrazione);
		return ris;
	}

	public Costo moltiplica (int fattore) {

		int moltiplicazione = this.toPence() * fattore;
		Costo ris = fromPence(moltiplicazione);
	
		return ris;
	}
	
	public String dividi(int divisore) {
		Costo ris = fromPence(this.toPence() / divisore);
		Costo resto = fromPence(this.toPence() % divisore);
		return ris.toString()+" ("+resto.toString()+")";
	}	
}
