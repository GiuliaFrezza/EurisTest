package it.euris.EurisTest.dao;

import java.util.List;
import it.euris.EurisTest.model.Articolo;


public interface IDao {

	public List<Articolo> articoli();
    public Articolo articolo(String codice);
    public void add(Articolo a);
    public void delete(String codice);
    public void update(Articolo a);
    
}
