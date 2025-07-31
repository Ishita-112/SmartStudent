import java.util.Scanner;
public class AdminService{
    private static final String USERNAME="admin";
    private static final String PASSWORD="admin123";
    public boolean login(String user, String pass){
        return USERNAME.equals(user)&& PASSWORD.equals(pass);
    }
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        AdminService admin= new AdminService();
        System.out.println("===Admin Login===");
        System.out.println("Enter username:");
        String user= sc.nextLine();
        System.out.println("Enter password:");
        String pass=sc.nextLine();
        if(admin.login(user,pass)){
            System.out.println("Login successful! Welcome Admin");
        }
        else{
            System.out.println("Invalid credentials. Acccess denied");
        }
        sc.close();
    }
}

