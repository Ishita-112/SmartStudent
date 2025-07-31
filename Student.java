public class Student {
    private int id;
    private String name;
    private String rollNo;
    private String department;
    private String email;
    private String phone;
    private int marks;

    // Constructor without ID (for new inserts)
    public Student(String name, String rollNo, String department, String email, String phone, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Display student details
    public void display() {
        System.out.println("Student Info:");
        System.out.println("ID        : " + id);
        System.out.println("Name      : " + name);
        System.out.println("Roll No   : " + rollNo);
        System.out.println("Department: " + department);
        System.out.println("Email     : " + email);
        System.out.println("Phone     : " + phone);
        System.out.println("Marks     : " + marks);
    }

    // Optional: main method to test the class
    public static void main(String[] args) {
        Student s = new Student("Ishita Khare", "23CS001", "Computer Science", "ishita@example.com", "9876543210", 92);
        s.setId(1); // simulate database ID
        s.display();
    }
}




