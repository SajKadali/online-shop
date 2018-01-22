package net.saj.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import net.saj.shoppingbackend.dao.CategoryDAO;
import net.saj.shoppingbackend.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.saj.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
	/*@Test
	public void testAddCategory(){
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is the description for Television");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category to the table", true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		
		category = categoryDAO.get(1);
		
		assertEquals("Successfully fetched a category from the table","Television", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		
		category = categoryDAO.get(1);
		category.setName("TV");
		
		assertEquals("Successfully updated the category in the table", true , categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		
		category = categoryDAO.get(1);
		
		assertEquals("Successfully deleted the category in the table", true , categoryDAO.delete(category));
	}
	*/
	/*
	@Test
	public void testListCategory(){
		
		assertEquals("Successfully fetched the categories list from the table",3 , categoryDAO.list().size());
	}
	*/
	
	@Test
	public void testCRUDCategory(){
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is the description for Laptop");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category to the table", true,categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is the description for Television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category to the table", true,categoryDAO.add(category));
		
		// fetching and renaming the category
		
			
			category = categoryDAO.get(2);
			category.setName("TV");
			
			assertEquals("Successfully updated the category in the table", true , categoryDAO.update(category));
			
			//deleting the category
			category = categoryDAO.get(2);
			
			assertEquals("Successfully deleted the category in the table", true , categoryDAO.delete(category));
			
			// fetching the list
			assertEquals("Successfully fetched the categories list from the table",1 , categoryDAO.list().size());

	}
		
		
}
