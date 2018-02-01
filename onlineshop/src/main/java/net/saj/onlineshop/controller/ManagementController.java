package net.saj.onlineshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.saj.onlineshop.util.FileUploadUtility;
import net.saj.onlineshop.validator.ProductValidator;
import net.saj.shoppingbackend.dao.CategoryDAO;
import net.saj.shoppingbackend.dao.ProductDAO;
import net.saj.shoppingbackend.dto.Category;
import net.saj.shoppingbackend.dto.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	public CategoryDAO categoryDAO;
	
	@Autowired
	public ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation" ,required=false) String operation){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		if(operation != null){
			
			if(operation.equals("product")){
				
				mv.addObject("message", "Product submitted successfully");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title", "Manage Products");
		
		// Fetch the product from the database
		Product nProduct = productDAO.get(id);
		
		mv.addObject("product",nProduct);
		
		return mv;
	}
	
	// handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
												Model model, HttpServletRequest request){
		
		if(mProduct.getId() == 0) {
		new ProductValidator().validate(mProduct, results);
		}
		else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);

			}
		}
		
		// check if there are any errors
		if(results.hasErrors()){
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product submission");

			return "page";
			
		}
		
		logger.info(mProduct.toString());
		
		if(mProduct.getId() == 0){
		// create a new product record
		productDAO.add(mProduct);
		}
		else{
			// Update the product
			productDAO.update(mProduct);
			
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		// Fetch the product from the database
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		
		// Activating or deactivating the product based on the value of active field
		
		
		product.setActive(!isActive);
		
		
		logger.info(product.toString());

		// Updating the product
		productDAO.update(product);
		
		return (isActive)? "You have successfully deactivated the product" + product.getId(): 
							"You have successfully activated the product" + product.getId();
		
	
	}
	
	//returning categories
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
}
