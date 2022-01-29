package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create
	@Transactional
	 public void createProduct(Product product)
	 {
		 this.hibernateTemplate.saveOrUpdate(product);
	 }
	
	//get all the Products
	public List<Product> getProduct(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		System.out.println("Product Loded");
		return products;
	}
	
	//delete the single product
	@Transactional
	public void deleteProduct(int pid)
	{
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
		
	}
		//get the single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}
	
}