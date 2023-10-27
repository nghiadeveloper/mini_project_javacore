package ra.business.view;

import ra.business.config.Config;
import ra.business.model.Product;
import java.util.Scanner;

public class ShopManagement {
    public static void generalManager() {
        boolean check = true;
        while (check) {
            System.out.println("----------- Quản lý bán hàng -------------- \n");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý danh mục");
            System.out.println("3. Exit");
            System.out.println("------------------------------------------- \n");
            System.out.println("Mời bạn chọn: ");
            Scanner scanner=new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ShopManagement.productManagement();
                    break;
                case 2:
                    ShopManagement.categoryManagement();
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }
    // quản lí danh mục
    public static void categoryManagement() {
        while (true) {
            Navbar.navbarCategoryManager();
            System.out.println("Mời bạn chọn: ");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new CategoryView().showFormCategoryList();
                    break;
                case 2:
                    new CategoryView().formCreateCategory();
                    break;
                case 3:
                    new CategoryView().formUpdateCategory();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("chương trình chỉ cho phép nhập từ 1 đến 4!");
            }
            if (choice == 4) {
                break;
            }
        }
    }

    // quản lí sản phẩm
    public static void productManagement() {
        while (true) {
            Navbar.navbarProductManager();
            System.out.println("Mời bạn chọn: ");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new ProductView().showListProduct();
                    break;
                case 2:
                    new ProductView().formCreateProduct();
                    break;
                case 3:
                    new ProductView().updateProducts();
                    break;
                case 4:
                    new ProductView().deleteProductById();
                    break;
                case 5:
                    new ProductView().searchProductsByName();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("chương trình chỉ cho phép nhập từ 1 đến 6!");
            }
            if (choice == 6) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ShopManagement.generalManager();
    }
}
