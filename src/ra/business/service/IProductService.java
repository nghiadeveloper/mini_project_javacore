package ra.business.service;

import ra.business.model.Product;

import java.util.List;

public interface IProductService extends IGenericService<Product>{
    List<Product> searchProductsByName(String name);
}
