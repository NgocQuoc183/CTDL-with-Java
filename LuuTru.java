package DoAn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class LuuTru {

    // Phương thức ghi danh sách cầu thủ vào file
    public static void ghiFile(Node head, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(head);
            System.out.println("Danh sách cầu thủ đã được lưu vào file " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    // Phương thức đọc danh sách cầu thủ từ file
    public static Node docFile(String filename) {
        Node head = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            head = (Node) in.readObject();
            System.out.println("Danh sách cầu thủ đã được đọc từ file " + filename);
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Lớp Node không được tìm thấy.");
            c.printStackTrace();
            return null;
        }
        return head;
    }
}
