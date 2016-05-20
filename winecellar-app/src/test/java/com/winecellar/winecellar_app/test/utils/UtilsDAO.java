package com.winecellar.winecellar_app.test.utils;

//import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;

//import com.winecellar.winecellar_app.model.Wine;

@Stateless
@LocalBean
public class UtilsDAO {

    @PersistenceContext
    private EntityManager eManager;
    
	public void deleteTable(){
		eManager.createQuery("DELETE FROM Wine").executeUpdate();
	}
      
}
