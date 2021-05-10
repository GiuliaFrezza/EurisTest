package it.euris.EurisTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.euris.EurisTest.dao.IDao;
import it.euris.EurisTest.model.*;


	
@RestController()
@RequestMapping("/articoli")

public class ArticoliController {

	@Autowired
	private IDao dao;
	
	@GetMapping()
	public List <Articolo> get(){
		return dao.articoli();
	}
	
	@GetMapping("/{codice}")
	public Articolo get(@PathVariable String codice){
	
		Costo prova = creoOggetto(codice);
		return dao.articolo(codice);
	}
	
	@PostMapping()
	public void post(@RequestBody Articolo a) {
		dao.add(a);
	}
	
	@PutMapping()
	public void put(@RequestBody Articolo a) {
		dao.update(a);
	}
	
	@DeleteMapping("/{codice}")
	public void delete(@PathVariable String codice) {
		dao.delete(codice);
	}
	//rcreazione di un oggetto di tipo Costo da codice identificativo
	private Costo creoOggetto(String codice) {
		return new Costo(dao.articolo(codice).getCosto());
	}
	
	@GetMapping("/somma/{codice1}&{codice2}")
	public String somma(@PathVariable String codice1, @PathVariable String codice2) {
		
		
		Costo addendo1 = creoOggetto(codice1);
		Costo addendo2 = creoOggetto(codice2);
		return addendo1.somma(addendo2).toString();
	}
	
	@GetMapping("/sottrazione/{codice1}&{codice2}")
	public String sottrazione(@PathVariable String codice1, @PathVariable String codice2) {
		Costo sottraendo1 = creoOggetto(codice1);
		Costo sottraendo2 = creoOggetto(codice2);
		return sottraendo1.sottrai(sottraendo2).toString();
	}
	
	@GetMapping("/moltiplicazione/{codice}&{fattore2}")
	public String moltiplicazione(@PathVariable String codice, @PathVariable int fattore2) {
		Costo fattore1 = creoOggetto(codice);
		Costo ris = fattore1.moltiplica(fattore2); 
		return ris.toString();
	}
	
	@GetMapping("/divisione/{codice}&{divisore}")
	public String divisione(@PathVariable String codice, @PathVariable int divisore) {
		
		Costo dividendo = creoOggetto(codice);
		return dividendo.dividi(divisore); 
		
	}
}