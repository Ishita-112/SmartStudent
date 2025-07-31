import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add a new student
    public void addStudent(Student s) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO students (name, roll_no, department, email, phone, marks) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getRollNo());
            ps.setString(3, s.getDepartment());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setInt(6, s.getMarks());
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student s = new Student(
                    rs.getString("name"),
                    rs.getString("roll_no"),
                    rs.getString("department"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("marks")
                );
                s.setId(rs.getInt("id"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        return list;
    }

    // Update student marks
    public void updateStudentMarks(String rollNo, int newMarks) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "UPDATE students SET marks = ? WHERE roll_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, newMarks);
            ps.setString(2, rollNo);
            int updated = ps.executeUpdate();
            if (updated > 0) {
                System.out.println("Marks updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating marks: " + e.getMessage());
        }
    }

    // Delete a student
    public void deleteStudent(String rollNo) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE roll_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rollNo);
            int deleted = ps.executeUpdate();
            if (deleted > 0) {
                System.out.println("Student deleted.");
            } else {
                System.out.println("No student found.");
            }
        } catch (SQLException e) {
            System.out.println(" Error deleting student: " + e.getMessage());
        }
    }

    //  Search by department
    public void searchByDepartment(String dept) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM students WHERE department = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dept);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(" " + rs.getString("name") + " - " + rs.getString("roll_no"));
            }
        } catch (SQLException e) {
            System.out.println("Error searching: " + e.getMessage());
        }
    }

    // Main method to test this class independently
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Add a new student
        Student s1 = new Student("Ishita Khare", "CS101", "Computer Science", "ishita@example.com", "9876543210", 91);
        dao.addStudent(s1);

        // List all students
        List<Student> students = dao.getAllStudents();
        System.out.println("\n All Students:");
        for (Student s : students) {
            s.display();
        }

        // Update marks
        dao.updateStudentMarks("CS101", 95);

        // Delete student
        dao.deleteStudent("CS101");
    }
}





