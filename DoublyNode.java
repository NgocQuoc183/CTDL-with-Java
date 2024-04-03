package DoAn;

import java.io.Serializable;

public class DoublyNode implements Serializable {
	HuanLuyenVien hlv;
	DoublyNode prev;
	DoublyNode next;

	public DoublyNode(HuanLuyenVien hlv) {
		this.hlv = hlv;
		this.prev = null;
		this.next = null;
	}
	
	
}
