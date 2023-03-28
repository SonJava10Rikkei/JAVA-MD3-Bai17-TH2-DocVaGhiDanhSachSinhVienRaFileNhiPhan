package rikkei.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// B3.  Tạo lớp Main và tạo phương thức writeToObject(String path, List<Student> students) để ghi danh sách học viên hiện có vào trong file nhị phân
public class Main {
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // B4. Tạo phương thức main trong lớp Main và khai báo một danh sách học viên:
    public static void main(String[] args) {
        String PATH_FILE = "F:\\Workspace_JAVA\\JAVA-MD3-Bai17\\JAVA-MD3-Bai17-TH2-DocVaGhiDanhSachSinhVienRaFileNhiPhan\\src\\rikkei\\academy\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Trinh Duc Toan", "Ha Noi"));
        students.add(new Student(2, "Le Viet Dung", "Phu Tho"));
        students.add(new Student(3, "Phung Trung Dung", "Da Nang"));
        students.add(new Student(4, "Nguyen Khanh Tung", "Ha Noi"));
        students.add(new Student(5, "Nguyen Dong Chinh", "Hai Duong"));
        // B5. Gọi phương thức writeToFile trong hàm main để ghi danh sách học viên trên ra file có tên là student.txt
        writeToFile(PATH_FILE, students);
        //7: Gọi phương thức readDataFromFile trong hàm main và hiển thị danh sách các học viên đang có trong file
        List<Student> studentDataFromFile = readDataFromFile(PATH_FILE);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }

    // B6: Tạo phương thức readDataFromFile(String path) trong lớp Main để lấy ra danh sách học viên đang có trong file student.txt
    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
