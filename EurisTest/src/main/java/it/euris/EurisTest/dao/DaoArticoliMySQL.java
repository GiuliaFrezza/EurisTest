package it.euris.EurisTest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import it.euris.EurisTest.model.Articolo;
import it.euris.EurisTest.util.BasicDao;
import it.euris.EurisTest.util.IMappable;

@Repository
public class DaoArticoliMySQL extends BasicDao implements IDao {

	/*
	 * Questa classe viene usata per l'interazione con il database
	 * da qui si eseguiranno tutte le query attraverso i metodi "execute", "getAll" e "getOne"
	 * implementati in util.BasicDao
	 */
	
	private static final String UPDATE_ARTICOLI = "UPDATE articoli SET nome=?, costo= ?";
	private static final String DELETE_FROM = "DELETE FROM articoli";
	private static final String INSERT_INTO_ARTICOLI = "INSERT INTO articoli VALUES (?,?,?)";
	private static final String WHERE_CODICE = " WHERE codice = ?";
	private static final String SELECT_ARTICOLI = "SELECT * FROM articoli";

	
	
	public DaoArticoliMySQL(
			@Value("${db.address}") String dbAddress,
			@Value("${db.user}") String user,
			@Value("${db.password}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Articolo> articoli() {
 		List<Articolo> ris = new ArrayList<>();
		List<Map<String,String>> maps = getAll(SELECT_ARTICOLI);
		for (Map<String, String> map : maps) {
			ris.add(IMappable.fromMap(Articolo.class, map));
		}
		return ris;		
	}

	@Override
	public Articolo articolo(String codice) {
		Map<String, String> map = getOne(SELECT_ARTICOLI+WHERE_CODICE, codice);
		Articolo ris = IMappable.fromMap(Articolo.class, map);
		return ris;
	}

	@Override
	public void add(Articolo a) {
		execute(INSERT_INTO_ARTICOLI,a.getCodice(),
										a.getNome(), 
										a.getCosto());
		
	}

	@Override
	public void delete(String codice) {
		execute(DELETE_FROM+ WHERE_CODICE, codice);
	}

	@Override
	public void update(Articolo a) {
		execute(UPDATE_ARTICOLI+ WHERE_CODICE, a.getNome(),
												a.getCosto(),
												a.getCodice());
	}

}
