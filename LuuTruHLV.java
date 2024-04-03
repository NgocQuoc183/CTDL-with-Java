package DoAn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class LuuTruHLV implements Serializable {

	// Phương thức ghi danh sách huấn luyện viên vào file
	public static void ghiFile(DoublyNode head, String filename) {
		try (FileOutputStream fileOut = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(head);
			System.out.println("Danh sách huấn luyện viên đã được lưu vào file " + filename);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	// Phương thức đọc danh sách huấn luyện viên từ file
	public static DoublyNode docFile(String filename) {
		DoublyNode head = null;
		try (FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			head = (DoublyNode) in.readObject();
			System.out.println("Danh sách huấn luyện viên đã được đọc từ file " + filename);
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Lớp DoublyNode không được tìm thấy.");
			c.printStackTrace();
			return null;
		}
		return head;
	}
}
