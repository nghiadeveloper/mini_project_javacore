package ra.business.controller;

import ra.business.model.Product;
import ra.business.service.IProductService;
import ra.business.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    public IProductService productService = new ProductServiceIMPL();
    public List<Product> getListProducts(){
        return productService.findAll();
    }
    public void createProducts(Product newProduct){
        productService.save(newProduct);
    }
    public void updateProduct(Product updateProduct){
        productService.save(updateProduct);
    }
    public Product searchProductById(int id){
        return productService.findById(id);
    }
    public List<Product> searchProductsByName(String name){
        return productService.searchProductsByName(name);
    }
    public void  deleteProduct(int id){
        productService.deleteById(id);
    }
}
