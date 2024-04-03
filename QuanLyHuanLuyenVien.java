package DoAn;

import java.util.Scanner;

public class QuanLyHuanLuyenVien {
	private DoublyNode head;
	private DoublyNode tail;

	public QuanLyHuanLuyenVien() {
		this.head = null;
		this.tail = null;
	}

	// Nhập Huấn luyện viên
	public HuanLuyenVien nhapHuanLuyenVien(Scanner scanner) {
		System.out.println("Nhập thông tin huấn luyện viên:");
		System.out.print("Họ tên: ");
		String hoTen = scanner.nextLine();
		System.out.print("Tuổi: ");
		int tuoi = 0;
		do {
			tuoi = Integer.parseInt(scanner.nextLine());
			if (tuoi <= 20) {
				System.out.println("Huấn luyện viên phải trên 20 tuổi. Vui lòng nhập lại.");
			}
		} while (tuoi <= 20);
		System.out.print("Giới tính: ");
		String gioiTinh = scanner.nextLine();
		System.out.print("Địa chỉ: ");
		String diaChi = scanner.nextLine();
		System.out.print("Chuyên môn: ");
		String chuyenMon = scanner.nextLine();
		System.out.print("Năm kinh nghiệm: ");
		int namKinhNghiem = 0;
		do {
			namKinhNghiem = Integer.parseInt(scanner.nextLine());
			if (namKinhNghiem <= 3) {
				System.out.println("Số năm kinh nghiệm phải lớn hơn 3. Vui lòng nhập lại.");
			}
		} while (namKinhNghiem <= 3);
		System.out.print("Bằng cấp: ");
		String bangCap = scanner.nextLine();

		return new HuanLuyenVien(hoTen, tuoi, gioiTinh, diaChi, chuyenMon, namKinhNghiem, bangCap);
	}

	// Phương thức lưu trữ
	public void luuDanhSachHuanLuyenVien(String filename) {
		LuuTruHLV.ghiFile(this.head, filename);
	}

	public void docDanhSachHuanLuyenVien(String filename) {
		DoublyNode newHead = LuuTruHLV.docFile(filename);
		if (newHead != null) {
			this.head = newHead;
			// Cập nhật lại tail
			DoublyNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			this.tail = temp;
			System.out.println("Đọc danh sách thành công");
		} else {
			System.out.println("Không thể đọc danh sách từ file.");
		}
	}

	// Chèn vị trí bất kì
	public void chenViTri(HuanLuyenVien hlv, int viTri) {
		DoublyNode newNode = new DoublyNode(hlv);

		// Nếu chèn đầu
		if (viTri == 0) {
			if (head != null) {
				head.prev = newNode;
			}
			newNode.next = head;
			head = newNode;
			return;
		}

		DoublyNode current = head;
		for (int i = 0; current != null && i < viTri - 1; i++) {
			current = current.next;
		}

		if (current == null) {
			System.out.println("Vị trí chèn vượt quá kích thước của danh sách.");
			return;
		}

		// Chèn nút mới vào danh sách
		newNode.next = current.next;
		newNode.prev = current;

		if (current.next != null) {
			current.next.prev = newNode;
		}

		current.next = newNode;
	}

	// Phương thức thêm huấn luyện viên vào cuối danh sách
	public void themCuoi(HuanLuyenVien hlv) {
		DoublyNode newNode = new DoublyNode(hlv);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	// Thêm 1 huấn luyện viên vào đầu danh sách
	public void themDau(HuanLuyenVien hlv) {
		DoublyNode newNode = new DoublyNode(hlv);
		if (head == null) {
			head = tail = newNode;

		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	// Phương thức nhập danh sách huấn luyện viên
	public void nhapDanhSach(Scanner scanner, int soLuong) {
		for (int i = 0; i < soLuong; i++) {
			System.out.println("Nhập thông tin huấn luyện viên thứ " + (i + 1) + ":");
			System.out.print("Họ tên: ");
			String hoTen = scanner.nextLine();
			System.out.print("Tuổi: ");
			int tuoi = 0;
			do {
				tuoi = Integer.parseInt(scanner.nextLine());
				if (tuoi <= 20) {
					System.out.println("Huấn luyện viên phải trên 20 tuổi. Vui lòng nhập lại.");
				}
			} while (tuoi <= 20);
			System.out.print("Giới tính: ");
			String gioiTinh = scanner.nextLine();
			System.out.print("Địa chỉ: ");
			String diaChi = scanner.nextLine();
			System.out.print("Chuyên môn: ");
			String chuyenMon = scanner.nextLine();
			System.out.print("Năm kinh nghiệm: ");
			int namKinhNghiem = 0;
			do {
				namKinhNghiem = Integer.parseInt(scanner.nextLine());
				if (namKinhNghiem <= 3) {
					System.out.println("Số năm kinh nghiệm phải lớn hơn 3. Vui lòng nhập lại.");
				}
			} while (namKinhNghiem <= 3);
			System.out.print("Bằng cấp: ");
			String bangCap = scanner.nextLine();

			HuanLuyenVien hlv = new HuanLuyenVien(hoTen, tuoi, gioiTinh, diaChi, chuyenMon, namKinhNghiem, bangCap);
			themCuoi(hlv);
		}
	}

	public void hienThiDanhSach() {
		DoublyNode temp = head;

		// Kiểm tra xem danh sách có trống không
		if (temp == null) {
			System.out.println("Danh sách huấn luyện viên trống.");
			return;
		}

		// In đầu bảng và tiêu đề cột
		System.out.println(
				"+--------------------------------------------------------------------------------------------------------------------+");
		System.out.printf("| %-20s | %-5s | %-10s | %-20s | %-15s | %-15s | %-10s |\n", "Họ Tên", "Tuổi", "Giới Tính",
				"Địa Chỉ", "Chuyên Môn", "Kinh Nghiệm", "Bằng Cấp");
		System.out.println(
				"+--------------------------------------------------------------------------------------------------------------------+");

		// Vòng lặp qua danh sách và in thông tin của mỗi huấn luyện viên
		while (temp != null) {
			HuanLuyenVien hlv = temp.hlv;
			System.out.printf("| %-20s | %-5d | %-10s | %-20s | %-15s | %-15d | %-10s |\n", hlv.getHoTen(),
					hlv.getTuoi(), hlv.getGioiTinh(), hlv.getDiaChi(), hlv.getChuyenMon(), hlv.getNamKinhNghiem(),
					hlv.getBangCap());
			temp = temp.next;
		}
		System.out.println(
				"+--------------------------------------------------------------------------------------------------------------------+");
	}

	// Xoá huấn luyện viên theo tên
	public void xoaHuanLuyenVien(String ten) {
		DoublyNode temp = head;

		while (temp != null && !temp.hlv.getHoTen().equalsIgnoreCase(ten)) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Không tìm thấy huấn luyện viên có tên: " + ten);
			return;
		}

		if (temp.prev != null) {
			temp.prev.next = temp.next;
		} else {
			head = temp.next; // Xoá ở đầu danh sách
		}

		if (temp.next != null) {
			temp.next.prev = temp.prev;
		} else {
			tail = temp.prev; // Xoá ở cuối danh sách
		}

		System.out.println("Đã xoá huấn luyện viên có tên: " + ten);
	}

	// Tìm kiếm huấn luyện viên
	public void timKiemHuanLuyenVien(String ten1) {
		DoublyNode temp = head;
		while (temp != null) {
			if (temp.hlv.getHoTen().equalsIgnoreCase(ten1)) {
				HuanLuyenVien hlv = temp.hlv;
				System.out.println("Thông tin huấn luyện viên tìm thấy:");
				System.out.println("Họ tên: " + hlv.getHoTen());
				System.out.println("Tuổi: " + hlv.getTuoi());
				System.out.println("Giới tính: " + hlv.getGioiTinh());
				System.out.println("Địa chỉ: " + hlv.getDiaChi());
				System.out.println("Chuyên môn: " + hlv.getChuyenMon());
				System.out.println("Năm kinh nghiệm: " + hlv.getNamKinhNghiem());
				System.out.println("Bằng cấp: " + hlv.getBangCap());
				return; // Dừng việc tìm kiếm sau khi tìm thấy
			}
			temp = temp.next;
		}
		// Nếu không tìm thấy
		System.out.println("Không tìm thấy huấn luyện viên có tên: " + ten1);
	}

	// Sắp xếp
	public void sapXep() {
		if (head == null || head.next == null) {
			System.out.println("Danh sách huấn luyện viên đã sắp xếp hoặc không có gì để sắp xếp.");
			return; // Danh sách trống hoặc chỉ có một phần tử, không cần sắp xếp
		}

		boolean wasChanged;

		do {
			DoublyNode current = head;
			DoublyNode previous = null;
			wasChanged = false;

			while (current != null && current.next != null) {
				DoublyNode next = current.next;

				if (current.hlv.getHoTen().compareToIgnoreCase(next.hlv.getHoTen()) > 0) {
					// Đổi chỗ current và next
					current.next = next.next;
					next.prev = current.prev;

					if (next.next != null) {
						next.next.prev = current;
					}
					if (current.prev != null) {
						current.prev.next = next;
					}

					next.next = current;
					current.prev = next;

					if (previous == null) {
						head = next;
					} else {
						previous.next = next;
					}

					wasChanged = true;
				} else {
					previous = current;
				}

				current = next;
			}
		} while (wasChanged);

		// Cập nhật lại tail
		DoublyNode temp = head;
		while (temp != null && temp.next != null) {
			temp = temp.next;
		}
		tail = temp;

		System.out.println("Danh sách huấn luyện viên đã được sắp xếp theo tên.");
	}

}