package DoAn;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyHuanLuyenVien quanLyHLV = new QuanLyHuanLuyenVien();

        System.out.print("Nhập số lượng huấn luyện viên bạn muốn thêm: ");
        int soLuong = Integer.parseInt(scanner.nextLine()); // Đọc số lượng HLV

        quanLyHLV.nhapDanhSach(scanner, soLuong); // Gọi phương thức để nhập thông tin HLV

        System.out.println("\nDanh sách huấn luyện viên:");
        quanLyHLV.hienThiDanhSach(); // In danh sách HLV

        scanner.close();
    }
}
