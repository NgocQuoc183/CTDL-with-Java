package DoAn;

import java.util.Scanner;

public class HuanLuyenVienMenu {
		
		public static void main(String[] args) {
			showMenu();
		}
		
		 public static void showMenu() {
			 Scanner scanner = new Scanner(System.in);
				QuanLyHuanLuyenVien quanLy = new QuanLyHuanLuyenVien();
		while (true) {
			System.out.println("+------------------------------------------------+");
			System.out.println("|-------CHƯƠNG TRÌNH QUẢN LÝ HUẤN LUYỆN VIÊN-----|");
			System.out.println("| 1. Nhập danh sách huấn luyện viên              |");
			System.out.println("| 2. Thêm huấn luyện viên vào cuối danh sách     |");
			System.out.println("| 3. Thêm huấn luyện viên vào đầu danh sách      |");
			System.out.println("| 4. Thêm huấn luyện viên vào vị trí bất kì	 |");
			System.out.println("| 5. Hiển thị danh sách huấn luyện viên          |");
			System.out.println("| 6. Xóa huấn luyện viên theo tên                |");
			System.out.println("| 7. Tìm kiếm huấn luyện viên theo tên           |");
			System.out.println("| 8. Sắp xếp danh sách theo tên                  |");
			System.out.println("| 9. Lưu danh sách vào File                      |");
			System.out.println("| 10. Đọc danh sách từ File                      |");
			System.out.println("| 0. Thoát chương trình                          |");
			System.out.println("+------------------------------------------------+");
			System.out.print("Nhập lựa chọn của bạn: ");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				System.out.print("Nhập số lượng huấn luyện viên cần nhập: ");
				int soLuong = Integer.parseInt(scanner.nextLine());
				quanLy.nhapDanhSach(scanner, soLuong);
				break;
			case 2:
				HuanLuyenVien hlvCuoi = quanLy.nhapHuanLuyenVien(scanner);
				quanLy.themCuoi(hlvCuoi);
				break;
			case 3:
				HuanLuyenVien hlvDau = quanLy.nhapHuanLuyenVien(scanner);
				quanLy.themDau(hlvDau);
				break;
			case 4:
				HuanLuyenVien hlvChen = quanLy.nhapHuanLuyenVien(scanner);
				System.out.println("Nhập vị trí muốn chèn");
				int viTri = Integer.parseInt(scanner.nextLine());
				quanLy.chenViTri(hlvChen, viTri);
				break;
			case 5:
				quanLy.hienThiDanhSach();
				break;
			case 6:
				System.out.print("Nhập tên huấn luyện viên cần xóa: ");
				String ten = scanner.nextLine();
				quanLy.xoaHuanLuyenVien(ten);
				break;
			case 7:
				System.out.print("Nhập tên huấn luyện viên cần tìm: ");
				String ten1 = scanner.nextLine();
				quanLy.timKiemHuanLuyenVien(ten1);
				break;
			case 8:
				quanLy.sapXep();
				break;
			case 9:
				System.out.println("Nhập tên file để lưu danh sách huấn luyện viên:");
				String filenameSave = scanner.nextLine();
				quanLy.luuDanhSachHuanLuyenVien(filenameSave);
				break;
			case 10:
				System.out.println("Nhập tên file để đọc danh sách Huấn luyện viên:");
				String filenameLoad = scanner.nextLine();
				quanLy.docDanhSachHuanLuyenVien(filenameLoad);
				break;
			case 0:
				System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
				return; // Thoát khỏi vòng lặp và kết thúc chương trình
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
				break;
			}
		}
	}

}
