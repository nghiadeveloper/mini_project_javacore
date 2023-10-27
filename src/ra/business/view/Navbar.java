package  ra.business.view;
public class Navbar {
    public static void navbarAdmin(){
        System.out.println("---------------------- SHOP -------------------------");
        System.out.println("1. Quản lý sản phẩm");
        System.out.println("2. Quản lý danh mục");
        System.out.println("3. Exit");
        System.out.println("------------------------------------------------------");
    }

    // Admin
    public static void navbarCategoryManager() {
        System.out.println("---------------------- SHOP -------------------------");
        System.out.println("1. Hiển thị danh sách danh mục");
        System.out.println("2. Thêm mới danh mục");
        System.out.println("3. Chỉnh sửa danh mục");
        System.out.println("4. Exit");
        System.out.println("------------------------------------------------------");
    }
    public static void navbarProductManager() {
        System.out.println("---------------------- SHOP -------------------------");
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Chỉnh sửa sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Exit");
        System.out.println("------------------------------------------------------");
    }
}