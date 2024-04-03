package DoAn;

import java.io.Serializable;

public class HuanLuyenVien extends Nguoi implements Serializable {
	private int namKinhNghiem;
	private String chuyenMon;
	private String bangCap;

	public HuanLuyenVien() {
	}

	 public HuanLuyenVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String chuyenMon, int namKinhNghiem, String bangCap) {
	        super(hoTen, tuoi, gioiTinh, diaChi);
	        this.chuyenMon = chuyenMon;
	        this.namKinhNghiem = namKinhNghiem;
	        this.bangCap = bangCap;
	    }

	public int getNamKinhNghiem() {
		return namKinhNghiem;
	}

	public void setNamKinhNghiem(int namKinhNghiem) {
		this.namKinhNghiem = namKinhNghiem;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public String getBangCap() {
		return bangCap;
	}

	public void setBangCap(String bangCap) {
		this.bangCap = bangCap;
	}
	 
	 
	
}