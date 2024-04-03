package DoAn;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HuanLuyenVienMenu hlvMenu = new HuanLuyenVienMenu();
        CauThuMenu ctMenu = new CauThuMenu();
        DeQuyMenu dqMenu = new DeQuyMenu();

        while (true) {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|-------CHƯƠNG TRÌNH QUẢN LÝ CẤU TRÚC DỮ LIỆU VÀ GIẢI THUẬT-----|");
            System.out.println("| 1. Làm việc với Menu quản lý huấn luyện viên                  |");
            System.out.println("| 2. Làm việc với Menu quản lý cầu thủ                          |");
            System.out.println("| 3. Làm việc với Menu đệ quy                                   |");
            System.out.println("| 0. Thoát chương trình                                         |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.print("| Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Dùng nextLine() ngay sau nextInt() để loại bỏ ký tự xuống dòng thừa
    

            switch (choice) {
            case 1:
                hlvMenu.showMenu();
                break;
            case 2: 
                ctMenu.showMenu();
                break;
            case 3: 
                dqMenu.showMenu();
                break; // Thêm break để tránh "fall through"
            case 0:
                System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                return; // Không đóng Scanner nếu bạn muốn tránh lỗi
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                break;
            }
        }
    }
}
