package ra.business.controller;

import ra.business.model.Category;
import ra.business.service.CategoryServiceIMPL;
import ra.business.service.ICategoryService;

import java.util.List;

public class CategoryController {
    public ICategoryService categoryService = new CategoryServiceIMPL();
    public List<Category> getListCategory(){
        return categoryService.findAll();
    }
    public void createCategoryToDB(Category category){
        categoryService.save(category);
    }
    public void updateCategory(Category category){
        categoryService.save(category);
    }
    public Category detailCategory(int id){
      return categoryService.findById(id);
    }
}
