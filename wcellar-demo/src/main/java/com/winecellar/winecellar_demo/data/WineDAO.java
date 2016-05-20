package com.winecellar.winecellar_demo.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.winecellar.winecellar_demo.model.Wine;


@Stateless
@LocalBean
public class WineDAO {

    @PersistenceContext
    private EntityManager eManager;
    
	public List<Wine> getAllWines() {
    	final Query query=eManager.createQuery("SELECT w FROM Wine w");
        return query.getResultList();
    }
	
	public List<Wine> getWinesByName(final String name) {
    	final Query query=eManager.createQuery("SELECT w FROM Wine AS w "+
    								"WHERE w.name LIKE ?1");
    	query.setParameter(1, "%"+name.toUpperCase()+"%");
        return query.getResultList();
    }
	
	public Wine getWine(final int identity) {
        return eManager.find(Wine.class, identity);
    }
	
	public void save(final Wine wine){
		eManager.persist(wine);
	}
	
	public void update(final Wine wine) {
		eManager.merge(wine);
	}
	
	public void delete(final int identity) {
		eManager.remove(getWine(identity));
	}
	public void deleteTable(){
		eManager.createQuery("DELETE FROM Wine").executeUpdate();
	}
      
}
