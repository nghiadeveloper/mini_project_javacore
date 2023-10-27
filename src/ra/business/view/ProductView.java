package ra.business.view;

import ra.business.config.Config;
import ra.business.controller.ProductController;
import ra.business.model.Category;
import ra.business.model.Product;

import java.util.List;

public class ProductView {
    private ProductController productController = new ProductController();
    private List<Product> productList = productController.getListProducts();
    private List<Category> categoryList = new Config<Category>().readFromFile(Config.PATH_CATEGORY);

    public void showListProduct() {
        if (productList.size() == 0) {
            System.out.println("Không có sản phẩm nào hết");
        } else {
            for (Product product : productList) {
                System.out.println("-------------------------");
                System.out.println(product);
            }
        }
    }

    public void formCreateProduct() {
        System.out.println("Nhập số lượng sản phẩm muốn tạo: ");
        int number = Config.scanner().nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("\n" + "Nhập sản phẩm: " + (i + 1));

            Product newProduct = new Product();
            if (productList.size() == 0) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(productList.get(productList.size() - 1).getProductId() + 1);
            }
            System.out.println("Tên sản phẩm: ");
            newProduct.setProductName(Config.scanner().nextLine());
            System.out.println("Mô tả sản phẩm");
            newProduct.setDescription(Config.scanner().nextLine());
            System.out.println("Giá tiền: ");
            newProduct.setPrice(Config.scanner().nextFloat());
            newProduct.setStatus(true);
            // chọn danh mục cho sản phẩm
            for (Category cat: categoryList) {
                System.out.printf("ID:%d  - Name:%s \n",cat.getId(),cat.getName());
            }

            while (true) {
                boolean check = false;
                System.out.println("Chọn mã danh mục: ");
                int idCat = Config.scanner().nextInt();
                for (Category cat : categoryList) {
                    if (cat.getId() == idCat) {
                        newProduct.setCategory(cat);
                        check= true;
                    }
                }
                if (!check) {
                    System.err.println("Mã danh mục không tồn tại!");
                }else {
                    break;
                }
            }
            // tiến hành thêm vào danh sách
            productController.createProducts(newProduct);
            System.out.println("Success");
        }

    }
    public void updateProducts(){
        System.out.println("Nhập mã sản phẩm cần chỉnh sửa: ");
        int idEdit = Config.scanner().nextInt();
        Product editProduct = productController.searchProductById(idEdit);
        if (editProduct == null) {
            System.err.println("Sản phẩm không tồn tại");
        }else {
            System.out.println("Tên sản phẩm: ");
            editProduct.setProductName(Config.scanner().nextLine());
            System.out.println("Mô tả: ");
            editProduct.setDescription(Config.scanner().nextLine());
            System.out.println("Giá tiền: ");
            editProduct.setPrice(Config.scanner().nextFloat());
            editProduct.setStatus(true);
            // chọn danh mục cho sản phẩm
            for (Category cat: categoryList
            ) {
                System.out.printf("ID:%d  - Name:%s \n",cat.getId(),cat.getName());
            }

            while (true) {
                boolean check = false;
                System.out.println("Chọn mã danh mục sản phẩm");
                int idCat = Config.scanner().nextInt();
                for (Category cat : categoryList) {
                    if (cat.getId() == idCat) {
                        editProduct.setCategory(cat);
                        check= true;
                    }
                }
                if (!check) {
                    System.err.println("Mã danh mục không tồn tại!");
                }else {
                    break;
                }
            }
            productController.updateProduct(editProduct);
            System.out.println("Success");

        }
    }
    public void deleteProductById(){
        System.out.println("Chọn mã sản phẩm cần xóa: ");
        int idDelete = Config.scanner().nextInt();
        Product productDelete = productController.searchProductById(idDelete);
        if (productDelete==null){
            System.err.println("Sản phẩm không tồn tại");
        }else {
            productController.deleteProduct(idDelete);
            System.out.println("delete success");
        }
    }
    public void searchProductsByName(){
        System.out.println("Nhập tên sản phẩm cần tìm kiếm: ");
        String name = Config.scanner().nextLine();
        List<Product> listSearch = productController.searchProductsByName(name);
        if (listSearch.size() == 0) {
            System.out.println("Sản phẩm không tồn tại");
        }else {
            for (Product product : listSearch) {
                System.out.println("-------------------------");
                System.out.println(product);
            }
        }
    }

}
