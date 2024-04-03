package DoAn;

import java.io.Serializable;

public class CauThu extends Nguoi implements Serializable {
	private int soAo;
	public int getSoAo() {
		return soAo;
	}

	public void setSoAo(int soAo) {
		this.soAo = soAo;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	private String viTri;
	private String quocGia;

	public CauThu() {
	}

	public CauThu(String hoTen, int tuoi, String gioiTinh, String diaChi, String viTri, int soAo, String quocGia) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.viTri = viTri;
		this.soAo = soAo;
		this.quocGia = quocGia;
	}


}
