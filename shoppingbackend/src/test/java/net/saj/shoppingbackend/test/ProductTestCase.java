package net.saj.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import net.saj.shoppingbackend.dao.ProductDAO;
import net.saj.shoppingbackend.dto.Product;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {

		private static AnnotationConfigApplicationContext context;
		
		private static ProductDAO productDAO;
		private Product product;
		
		@BeforeClass
		public static void init(){
			
			context = new AnnotationConfigApplicationContext();
			context.scan("net.saj.shoppingbackend");
			context.refresh();
			
			productDAO = (ProductDAO) context.getBean("productDAO");
			
		}
		
		
		/*@Test
		public void testCRUDProduct(){
			
			// add operation
			product = new Product();
			
			product.setName("Oppo Selfie S53");
			product.setDescription("This is the description for Oppo mobile");
			product.setBrand("Oppo");
			product.setUnitprice(25000);
			product.setCategoryId(3);
			product.setActive(true);
			product.setSupplierId(3);
			
			assertEquals("Something went wrong while adding a product to the table", true,productDAO.add(product));
			
			// fetching and renaming the product
			
				
				product = productDAO.get(2);
				product.setName("Samsung Galaxy S7");
				
				assertEquals("Something went wrong while  updating the product in the table", true , productDAO.update(product));
				
				//deleting the product
				product = productDAO.get(2);
				
				assertEquals("Something went wrong while deleting the product in the table", true , productDAO.delete(product));
				
				// fetching the list
				assertEquals("Something went wrong while fetching the categories list from the table",6 , productDAO.list().size());

		}*/
			@Test
			public void testListActiveProducts(){
				
				assertEquals("Something went wrong while fetching the categories list from the table",5, productDAO.listActiveProducts().size());

			}
			
			@Test
			public void testListActiveProductsByCategory(){
				
				assertEquals("Something went wrong while fetching the categories list from the table",3, productDAO.listActiveProductsByCategory(3).size());

				assertEquals("Something went wrong while fetching the categories list from the table",2, productDAO.listActiveProductsByCategory(1).size());

			}
			
	}


