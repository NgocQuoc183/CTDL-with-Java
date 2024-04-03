package DoAn;

import java.util.Scanner;

public class QuanLyCauThu {
	private Node head;
	LuuTru obj = new LuuTru();
	public QuanLyCauThu() {
		this.head = null;
	}

	// Phương thức nhập danh sách cầu thủ
	public void nhapDanhSach(Scanner scanner, int soLuong, QuanLyCauThu first) {
		for (int i = 0; i < soLuong; i++) {
			boolean themThanhCong = false;
			while (!themThanhCong) {
				System.out.println("Nhập thông tin cầu thủ thứ " + (i + 1) + ":");
				System.out.print("Họ tên: ");
				String hoTen = scanner.nextLine();
				System.out.print("Tuổi: ");
				int tuoi = 0;
				do {
					tuoi = Integer.parseInt(scanner.nextLine());
					if (tuoi <= 18) {
						System.out.println("Cầu thủ phải trên 18 tuổi. Vui lòng nhập lại.");
					}
				} while (tuoi <= 18);
				System.out.print("Giới tính: ");
				String gioiTinh = scanner.nextLine();
				System.out.print("Địa chỉ: ");
				String diaChi = scanner.nextLine();
				System.out.print("Vị trí: ");
				String viTri = scanner.nextLine();
				System.out.print("Số áo: ");
				int soAo = Integer.parseInt(scanner.nextLine());
				System.out.print("Quốc gia: ");
				String quocGia = scanner.nextLine();

				if (soAoDaTonTai(soAo)) {
					System.out.println("Số áo đã tồn tại. Vui lòng nhập lại.");
				} else {
					CauThu cauThu = new CauThu(hoTen, tuoi, gioiTinh, diaChi, viTri, soAo, quocGia);
					themCuoi(cauThu);
					themThanhCong = true;
				}
			}
		}
	}

	// Kiểm tra số áo đã tồn tại trong danh sách
	private boolean soAoDaTonTai(int soAo) {
		Node temp = head;
		while (temp != null) {
			if (temp.cauThu.getSoAo() == soAo) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	// Ghi File
	public void luuDanhSachCauThu(String filename) {
		LuuTru.ghiFile(this.head, filename);
	}

	// Đọc file
	public void docDanhSachCauThu(String filename) {
		this.head = LuuTru.docFile(filename);
		if (this.head != null) {
			System.out.println("Danh sách cầu thủ đã được khôi phục từ file.");
		} else {
			System.out.println("Không thể đọc danh sách cầu thủ từ file.");
		}
	}

	// Thêm cầu thủ vào đầu danh sách
	public void themDau(CauThu cauThu) {
		Node newNode = new Node(cauThu);
		newNode.next = head;
		head = newNode;
	}

	// Thêm cầu thủ vào cuối danh sách
	public void themCuoi(CauThu cauThu) {
		Node newNode = new Node(cauThu);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	// Thêm vào vị trí bất kì
	public void chenViTri(CauThu cauThu, int viTri) {
		Node newNode = new Node(cauThu);

		if (viTri == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node current = head;
		for (int i = 0; current != null && i < viTri - 1; i++) {
			current = current.next;
		}
		if (current == null) {
			System.out.println("Vị trí chèn vượt quá kích thước danh sách");
			return;
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	// Thêm 1 cầu thủ dùng cho thêm đầu và thêm cuối
	public CauThu nhapThongTinCauThu(Scanner scanner) {
		System.out.print("Họ tên: ");
		String hoTen = scanner.nextLine();
		System.out.print("Tuổi: ");
		int tuoi = 0;
		do {
			tuoi = Integer.parseInt(scanner.nextLine());
			if (tuoi <= 18) {
				System.out.println("Tuổi phải trên 18. Vui lòng nhập lại.");
			}
		} while (tuoi <= 18);
		System.out.print("Giới tính: ");
		String gioiTinh = scanner.nextLine();
		System.out.print("Địa chỉ: ");
		String diaChi = scanner.nextLine();
		System.out.print("Vị trí: ");
		String viTri = scanner.nextLine();
		System.out.print("Số áo: ");
		int soAo = Integer.parseInt(scanner.nextLine());
		System.out.print("Quốc gia: ");
		String quocGia = scanner.nextLine();

		return new CauThu(hoTen, tuoi, gioiTinh, diaChi, viTri, soAo, quocGia);
	}

	public void suaThongTinCauThu(Scanner scanner, String tenCauThu) {
		Node temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.cauThu.getHoTen().equalsIgnoreCase(tenCauThu)) {
				System.out.println("Cầu thủ được tìm thấy: ");
				System.out.println("Họ tên: " + temp.cauThu.getHoTen() + " | Tuổi: " + temp.cauThu.getTuoi()
						+ " | Giới tính: " + temp.cauThu.getGioiTinh() + " | Địa chỉ: " + temp.cauThu.getDiaChi()
						+ " | Vị trí: " + temp.cauThu.getViTri() + " | Số áo: " + temp.cauThu.getSoAo()
						+ " | Quốc gia: " + temp.cauThu.getQuocGia());
				System.out.println(
						"Nhập thông tin mới cho cầu thủ này. Nhập 'skip' nếu không muốn thay đổi thông tin nào.");

				System.out.print("Họ tên mới (hiện tại: " + temp.cauThu.getHoTen() + "): ");
				String hoTen = scanner.nextLine();
				if (!hoTen.equalsIgnoreCase("skip"))
					temp.cauThu.setHoTen(hoTen);

				System.out.print("Tuổi mới (hiện tại: " + temp.cauThu.getTuoi() + "): ");
				String tuoiStr = scanner.nextLine();
				if (!tuoiStr.equalsIgnoreCase("skip"))
					temp.cauThu.setTuoi(Integer.parseInt(tuoiStr));

				System.out.print("Giới tính mới (hiện tại: " + temp.cauThu.getGioiTinh() + "): ");
				String gioiTinh = scanner.nextLine();
				if (!gioiTinh.equalsIgnoreCase("skip"))
					temp.cauThu.setGioiTinh(gioiTinh);

				System.out.print("Địa chỉ mới (hiện tại: " + temp.cauThu.getDiaChi() + "): ");
				String diaChi = scanner.nextLine();
				if (!diaChi.equalsIgnoreCase("skip"))
					temp.cauThu.setDiaChi(diaChi);

				System.out.print("Vị trí mới (hiện tại: " + temp.cauThu.getViTri() + "): ");
				String viTri = scanner.nextLine();
				if (!viTri.equalsIgnoreCase("skip"))
					temp.cauThu.setViTri(viTri);

				System.out.print("Số áo mới (hiện tại: " + temp.cauThu.getSoAo() + "): ");
				String soAoStr = scanner.nextLine();
				if (!soAoStr.equalsIgnoreCase("skip"))
					temp.cauThu.setSoAo(Integer.parseInt(soAoStr));

				System.out.print("Quốc gia mới (hiện tại: " + temp.cauThu.getQuocGia() + "): ");
				String quocGia = scanner.nextLine();
				if (!quocGia.equalsIgnoreCase("skip"))
					temp.cauThu.setQuocGia(quocGia);

				found = true;
				break;
			}
			temp = temp.next;
		}
		if (!found) {
			System.out.println("Không tìm thấy cầu thủ có tên: " + tenCauThu);
		}
	}

	// Hiển thị danh sách cầu thủ
	public void hienThiDanhSach() {
		Node temp = head;
		System.out.println(
				"+-----------------------------------------------------------------------------------------------------------------+");
		System.out.printf("| %-20s | %-5s | %-10s | %-20s | %-15s | %-6s | %-15s |\n", "Họ tên", "Tuổi", "Giới tính",
				"Địa chỉ", "Vị trí", "Số áo", "Quốc gia");
		System.out.println(
				"+-----------------------------------------------------------------------------------------------------------------+");
		while (temp != null) {
			CauThu cauThu = temp.cauThu;
			System.out.printf("| %-20s | %-5d | %-10s | %-20s | %-15s | %-6d | %-15s |\n", cauThu.getHoTen(),
					cauThu.getTuoi(), cauThu.getGioiTinh(), cauThu.getDiaChi(), cauThu.getViTri(), cauThu.getSoAo(),
					cauThu.getQuocGia());
			temp = temp.next;
		}
		System.out.println(
				"+-----------------------------------------------------------------------------------------------------------------+");
	}

	// Tìm kiếm cầu thủ
	public void timKiemCauThu(String tenCauThu) {
		Node temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.cauThu.getHoTen().equalsIgnoreCase(tenCauThu)) {
				System.out.println("Cầu thủ được tìm thấy: ");
				System.out.println("Họ tên: " + temp.cauThu.getHoTen() + " | Tuổi: " + temp.cauThu.getTuoi()
						+ " | Giới tính: " + temp.cauThu.getGioiTinh() + " | Địa chỉ: " + temp.cauThu.getDiaChi()
						+ " | Vị trí: " + temp.cauThu.getViTri() + " | Số áo: " + temp.cauThu.getSoAo()
						+ " | Quốc gia: " + temp.cauThu.getQuocGia());
				found = true;
				break;
			}
			temp = temp.next;
		}
		if (!found) {
			System.out.println("Không tìm thấy cầu thủ có tên: " + tenCauThu);
		}
	}

	// Xoá cầu thủ
	public void xoaCauThu(String tenCauThuXoa) {
		Node temp = head;
		Node prev = null;
		while (temp != null && !temp.cauThu.getHoTen().equalsIgnoreCase(tenCauThuXoa)) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Không tìm thấy cầu thủ có tên: " + tenCauThuXoa + " để xóa.");
		} else {
			if (prev == null) {
				head = head.next;
			} else {
				prev.next = temp.next;
			}
			System.out.println("Cầu thủ " + tenCauThuXoa + " đã được xóa khỏi danh sách.");
		}
	}

	// Xắp xếp cầu thủ
	public void sapXep() {
		if (head == null || head.next == null) {
			return;
		}
		boolean swapped;
		do {
			Node current = head;
			Node prev = null;
			Node next = head.next;
			swapped = false;

			while (next != null) {
				if (current.cauThu.getHoTen().compareToIgnoreCase(next.cauThu.getHoTen()) > 0) {
					swapped = true;
					if (prev != null) {
						Node temp = next.next;
						prev.next = next;
						next.next = current;
						current.next = temp;
					} else {
						head = next;
						current.next = next.next;
						next.next = current;
					}
					prev = next;
					next = current.next;
				} else {
					prev = current;
					current = next;
					next = next.next;
				}
			}
		} while (swapped);
		// Thông báo
		System.out.println("Danh sách đã được xắp xếp theo tên");
		hienThiDanhSach();

	}
}
