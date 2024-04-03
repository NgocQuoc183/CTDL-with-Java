package DoAn;
import java.io.Serializable;

public class Nguoi implements Serializable {
	
	    // Thuộc tính chung cho cả Cầu thủ và Huấn luyện viên
	    private String hoTen;
	    private int tuoi;
	    private String gioiTinh;
	    private String diaChi;

	    // Hàm khởi tạo mặc định
	    public Nguoi() {
	    }

	    // Hàm khởi tạo đầy đủ
	    public Nguoi(String hoTen, int tuoi, String gioiTinh, String diaChi) {
	        this.hoTen = hoTen;
	        this.tuoi = tuoi;
	        this.gioiTinh = gioiTinh;
	        this.diaChi = diaChi;
	    }

	    // Getter và setter cho các thuộc tính
	    public String getHoTen() {
	        return hoTen;
	    }

	    public void setHoTen(String hoTen) {
	        this.hoTen = hoTen;
	    }
	    

	    public int getTuoi() {
	        return tuoi;
	    }

	    public void setTuoi(int tuoi) {
	        this.tuoi = tuoi;
	    }

	    public String getGioiTinh() {
	        return gioiTinh;
	    }

	    public void setGioiTinh(String gioiTinh) {
	        this.gioiTinh = gioiTinh;
	    }

	    public String getDiaChi() {
	        return diaChi;
	    }

	    public void setDiaChi(String diaChi) {
	        this.diaChi = diaChi;
	    }
}
