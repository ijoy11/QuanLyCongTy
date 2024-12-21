
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String taxCode;
    private double monthlyIncome;
    private List<Employee> employees;

    public Company(String name, String taxCode, double monthlyIncome) {
        this.name = name;
        this.taxCode = taxCode;
        this.monthlyIncome = monthlyIncome;
        this.employees = new ArrayList<>();
    }
//Them
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
//Xoa
    public void removeEmployee(String id) {
        Employee toRemove = null;
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                toRemove = emp;
                break;
            }
        }
        if (toRemove != null) {
            employees.remove(toRemove);
            if (toRemove instanceof Manager) {
                Manager manager = (Manager) toRemove;
                for (Staff staff : manager.staffList) {
                    staff.setManager(null); // Ngắt liên kết nhân viên khỏi trưởng phòng
                }
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
//Danh sach
    public void listEmployees() {
        System.out.println("Nhung nhan vien o cong ty: " + name + ":");
        int i = 1;
        for (Employee emp : employees) {
            System.out.println(i++ + ". " + emp);
        }
    }
    //Tong luong
    public int calculateTotalSalary() {
        return employees.stream().mapToInt(Employee::calculateSalary).sum();
    }
    //Tong loi nhuan
    public double calculateCompanyProfit(){
        return monthlyIncome - calculateTotalSalary();
    }
}
