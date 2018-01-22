package net.saj.shoppingbackend.daoimpl;

import java.util.List;

import net.saj.shoppingbackend.dao.CategoryDAO;
import net.saj.shoppingbackend.dto.Category;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list() {
		String selectActiveCategory = " FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	
	// Getting a category based on id
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}
	
	
	// adding a category to database table
	@Override
	public boolean add(Category category) {

		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
			}
			catch(Exception ex){
			
			ex.printStackTrace();
			return false;
			}
	}
	
	// updating a category in the table
	@Override
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
			}
			catch(Exception ex){
			
			ex.printStackTrace();
			return false;
			}
	}
	
	
	@Override
	public boolean delete(Category category) {
			
		category.setActive(false);
		
		try{
			
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			return false;
		}	
		
	}
	
	

}
