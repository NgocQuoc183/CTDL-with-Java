package DoAn;

import java.io.Serializable;

class Node implements Serializable {
    CauThu cauThu; // Đối tượng cầu thủ
    Node next; // Trỏ tới node tiếp theo trong danh sách

    // Constructor để tạo một node mới với cầu thủ cụ thể
    public Node(CauThu cauThu) {
        this.cauThu = cauThu;
        this.next = null; // Khi node mới được tạo, không có node tiếp theo
    }
}
