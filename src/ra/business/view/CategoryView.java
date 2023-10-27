package ra.business.view;

import  ra.business.config.Config;
import  ra.business.controller.CategoryController;
import  ra.business.model.Category;
import java.util.List;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();
    public void showFormCategoryList(){
        System.out.println("---------------- Danh sách danh mục  ----------------");
        System.out.println("----- ID ----- NAME -----");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("-----"+categoryList.get(i).getId()+"-----"+categoryList.get(i).getName());
        }
        System.out.println("Nhập BACK để quay về menu: ");
        String backMenu = Config.scanner().nextLine();
        if(backMenu.equalsIgnoreCase("back")){
            new Navbar();
        }
    }
    public void formCreateCategory(){
        while (true){
            int id = 0;
            if(categoryList.size()==0){
                id = 1;
            }else {
                id = categoryList.get(categoryList.size()-1).getId()+1;
            }
            System.out.println("tên danh mục: ");
            String name = Config.scanner().nextLine();
            Category category = new Category(id,name);
            categoryController.createCategoryToDB(category);
            System.out.println("Create Success!");
            System.out.println("Enter the any key to continue or Enter back to return Menu: ");
            String backMenu = Config.scanner().nextLine();
            if(backMenu.equalsIgnoreCase("back")){
                new Navbar();
                break;
            }
        }

    }
    public void formUpdateCategory(){
        while (true){
            System.out.println("Nhập mã danh mục cần chỉnh sửa: ");
            int id = Config.scanner().nextInt();
            if(categoryController.detailCategory(id)==null){
                System.err.println("Mã danh mục không tồn tại!");
            } else {
                System.out.println("Tên danh mục: ");
                String name = Config.scanner().nextLine();
                Category category = new Category(id, name);
                categoryController.updateCategory(category);
                System.out.println("Update success!");
                System.out.println("Enter the any key to continue or Enter back to return Menu: ");
                String backMenu = Config.scanner().nextLine();
                if(backMenu.equalsIgnoreCase("back")){
                    new Navbar();
                    break;
                }
            }
        }
    }
}
