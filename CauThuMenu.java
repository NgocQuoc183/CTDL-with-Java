package DoAn;

import java.util.Scanner;

public class CauThuMenu {
	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		Scanner scanner = new Scanner(System.in);
		QuanLyCauThu quanLyCauThu = new QuanLyCauThu();
		int choice;

		do {
			System.out.println("+----------------------------------------+");
			System.out.println("|----------Menu Quản Lý Cầu Thủ---------|");
			System.out.println("| 1. Thêm cầu thủ mới                 	|");
			System.out.println("| 2. Thêm cầu thủ vào đầu danh sách   	|");
			System.out.println("| 3. Thêm cầu thủ vào cuối danh sách  	|");
			System.out.println("| 4. Thêm cầu thủ vào vị trí bất kì  	|");
			System.out.println("| 5. Hiển thị danh sách cầu thủ     	|");
			System.out.println("| 6. Tìm kiếm cầu thủ theo tên      	|");
			System.out.println("| 7. Xóa cầu thủ theo tên           	|");
			System.out.println("| 8. Sắp xếp cầu thủ theo tên       	|");
			System.out.println("| 9. Lưu danh sách cầu thủ vào file 	|");
			System.out.println("| 10. Đọc danh sách cầu thủ từ file  	|");
			System.out.println("| 11. Sửa thông tin cầu thủ             |");
			System.out.println("| 0. Thoát                          	|");
			System.out.println("+----------------------------------------+");
			System.out.print("| Nhập lựa chọn của bạn: ");

			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				System.out.println("Nhập số lượng cầu thủ bạn muốn thêm: ");
				int soLuong = Integer.parseInt(scanner.nextLine());
				quanLyCauThu.nhapDanhSach(scanner, soLuong, quanLyCauThu);
				break;
			case 2:
				// Thêm cầu thủ vào đầu danh sách
				System.out.println("Nhập thông tin cầu thủ để thêm vào đầu danh sách:");
				CauThu cauThuDau = quanLyCauThu.nhapThongTinCauThu(scanner);
				quanLyCauThu.themDau(cauThuDau);
				break;
			case 3:
				System.out.println("Nhập thông tin cầu thủ để thêm vào cuối danh sách:");
				CauThu cauThuCuoi = quanLyCauThu.nhapThongTinCauThu(scanner);
				quanLyCauThu.themCuoi(cauThuCuoi);
				break;
			case 4:
				CauThu cauThuChen = quanLyCauThu.nhapThongTinCauThu(scanner);
				System.out.println("Nhập vị trí muốn chèn");
				int viTri = Integer.parseInt(scanner.nextLine());
				quanLyCauThu.chenViTri(cauThuChen, viTri);
				break;
			case 5:
				quanLyCauThu.hienThiDanhSach();
				break;
			case 6:
				System.out.println("Nhập tên cầu thủ bạn muốn tìm kiếm:");
				String tenCauThu = scanner.nextLine();
				quanLyCauThu.timKiemCauThu(tenCauThu);
				break;
			case 7:
				System.out.println("Nhập tên cầu thủ bạn muốn xóa:");
				String tenCauThuXoa = scanner.nextLine();
				quanLyCauThu.xoaCauThu(tenCauThuXoa);
				break;
			case 8:
				quanLyCauThu.sapXep();
				break;
			case 9:
				System.out.println("Nhập tên file để lưu danh sách cầu thủ:");
				String filenameSave = scanner.nextLine();
				quanLyCauThu.luuDanhSachCauThu(filenameSave);
				break;
			case 10:
				System.out.println("Nhập tên file để đọc danh sách cầu thủ:");
				String filenameLoad = scanner.nextLine();
				quanLyCauThu.docDanhSachCauThu(filenameLoad);
				break;
			case 11:
				System.out.println("Nhập tên cầu thủ bạn muốn sửa thông tin: ");
				String tenCauThuSua = scanner.nextLine();
				quanLyCauThu.suaThongTinCauThu(scanner, tenCauThuSua);
				break;
			case 0:
				System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
			}
		} while (choice != 0);
	}

}
