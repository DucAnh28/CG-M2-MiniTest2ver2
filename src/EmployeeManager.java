import Model.Employee;
import Model.FullTimeEmployee;
import Model.PartTimeEmployee;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        FullTimeEmployee b1 = new FullTimeEmployee(100, 0, 10000);
        FullTimeEmployee b2 = new FullTimeEmployee(10, 50, 20000);
        PartTimeEmployee b3 = new PartTimeEmployee(3.4f);
        PartTimeEmployee b4 = new PartTimeEmployee(10.0f);
        employees.add(b1);
        employees.add(b2);
        employees.add(b3);
        employees.add(b4);
        System.out.println(getParttimeUnderSalary());
        System.out.println(getSumSalaryPtEmployee());
        System.out.println(sortListFtEmployee());
    }

    //    1. Lay ra luong trung binh cua cong ty
    public static float getAverageSalary(){
        float sum= 0;
        for (Employee e: employees
        ) {
            sum += e.getSalary();
        }
        float average = sum/employees.size();
        return average;
    }
    //    2. Lay danh sach nhan vien luong thap hon luong tb
    public static ArrayList<Employee> getParttimeUnderSalary(){
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        float average = getAverageSalary();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof PartTimeEmployee &&
                    employees.get(i).getSalary()<average)
                employeeArrayList.add(employees.get(i));
        }
        return employeeArrayList;
    }
    // 3. Tổng số lương phải trả cho nhân viên bán tgian
    public static String getSumSalaryPtEmployee(){
        double sum = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof PartTimeEmployee){
                sum += employees.get(i).getSalary();
            }
        }
        return "Total salary of Part time employee : " +sum;
    }
    // 4. Sắp xếp nhân viên toàn tgian theo số lương tăng dần
    public static ArrayList<Employee> sortListFtEmployee(){
        ArrayList<Employee> arrayList1 = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof FullTimeEmployee){
                arrayList1.add(employees.get(i));
            }
        }
        arrayList1.sort((((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))));
        return arrayList1;
    }
    // Chọn
    public static void choice(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    break;
                case 2:
                    System.out.println("Draw the square");
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}