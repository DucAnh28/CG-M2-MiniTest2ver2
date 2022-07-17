import Model.Employee;
import Model.FullTimeEmployee;
import Model.PartTimeEmployee;
import java.util.ArrayList;

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
    public static ArrayList<Employee> SortListFtEmployee(){
        ArrayList<Employee> arrayList1 = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof FullTimeEmployee){
                arrayList1.add(employees.get(i));
            }
        }
        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i).getSalary()<arrayList1.get(i+1).getSalary()){

            }
        }
    }
}