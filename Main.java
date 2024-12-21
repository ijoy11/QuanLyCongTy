import java.util.Comparator;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Company company = new Company("", "", 10000);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==========================");
            System.out.println("1. Nhập thông tin công ty");
            System.out.println("2. Phân bổ nhân viên vào trưởng phòng");
            System.out.println("3. Thêm, xóa thông tin một nhân sự");
            System.out.println("4. Xuất ra thông tin toàn bộ nhân viên trong công ty");
            System.out.println("5. Tính và xuất tổng lương cho toàn công ty");
            System.out.println("6. Tìm nhân viên thường có lương cao nhất");
            System.out.println("7. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
            System.out.println("8. Sắp xếp nhân viên toàn công ty theo thứ tự ABC (theo tên)");
            System.out.println("9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
            System.out.println("10. Tìm giám đốc có số lượng cổ phần nhiều nhất");
            System.out.println("11. Tính và xuất tổng thu nhập của từng giám đốc");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên công ty: ");
                    String companyName = sc.nextLine();
                    System.out.print("Nhập mã số thuế: ");
                    String taxCode = sc.nextLine();
                    System.out.print("Nhập doanh thu tháng: ");
                    double revenue = sc.nextDouble();
                    sc.nextLine();
                    company = new Company(companyName, taxCode, revenue);
                    System.out.println("Thông tin công ty đã được cập nhật.");
                    break;
                case 2:
                    System.out.print("Nhập mã nhân viên: ");
                    String staffId = sc.nextLine();
                    System.out.print("Nhập mã trưởng phòng: ");
                    String managerId = sc.nextLine();

                    Staff staff = null;
                    Manager manager = null;

                    for (Employee emp : company.getEmployees()) {
                        if (emp instanceof Staff && emp.getId().equals(staffId)) {
                            staff = (Staff) emp;
                        }
                        if (emp instanceof Manager && emp.getId().equals(managerId)) {
                            manager = (Manager) emp;
                        }
                    }

                    if (staff != null && manager != null) {
                        manager.addStaff(staff);
                        System.out.println("Phân bổ nhân viên thành công.");
                    } else {
                        System.out.println("Không tìm thấy nhân viên hoặc trưởng phòng.");
                    }
                    break;
                case 3:
                    System.out.println("1. Thêm nhân sự");
                    System.out.println("2. Xóa nhân sự");
                    System.out.print("Chọn: ");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    if (subChoice == 1) {
                        System.out.print("Nhập mã nhân viên: ");
                        String id = sc.nextLine();
                        System.out.print("Nhập họ tên: ");
                        String name = sc.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String phone = sc.nextLine();
                        System.out.print("Nhập số ngày làm việc: ");
                        int workingDays = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Chọn chức vụ: 1-Nhân Viên, 2-Trưởng Phòng, 3-Giám Đốc");
                        int role = sc.nextInt();
                        sc.nextLine();

                        if (role == 1) {
                            company.addEmployee(new Staff(id, name, phone, workingDays));
                        } else if (role == 2) {
                            company.addEmployee(new Manager(id, name, phone, workingDays));
                        } else if (role == 3) {
                            System.out.print("Nhập phần trăm cổ phần: ");
                            double shares = sc.nextDouble();
                            sc.nextLine();
                            company.addEmployee(new Director(id, name, phone, workingDays, shares));
                        }
                        System.out.println("Thêm nhân sự thành công.");
                    } else if (subChoice == 2) {
                        System.out.print("Nhập mã nhân sự cần xóa: ");
                        String idToRemove = sc.nextLine();
                        company.removeEmployee(idToRemove);
                        System.out.println("Xóa nhân sự thành công.");
                    }
                    break;
                case 4:
                    company.listEmployees();
                    break;
                case 5:
                    System.out.println("Tổng lương: " + company.calculateTotalSalary());
                    break;
                case 6:
                    Staff highestPaidStaff = null;
                    for (Employee emp : company.getEmployees()) {
                        if (emp instanceof Staff) {
                            if (highestPaidStaff == null || emp.calculateSalary() > highestPaidStaff.calculateSalary()) {
                                highestPaidStaff = (Staff) emp;
                            }
                        }
                    }
                    if (highestPaidStaff != null) {
                        System.out.println("Nhân viên thường có lương cao nhất: " + highestPaidStaff);
                    }
                    break;
                case 7:
                    Manager mostStaffManager = null;
                    for (Employee emp : company.getEmployees()) {
                        if (emp instanceof Manager) {
                            if (mostStaffManager == null || ((Manager) emp).getStaffCount() > mostStaffManager.getStaffCount()) {
                                mostStaffManager = (Manager) emp;
                            }
                        }
                    }
                    if (mostStaffManager != null) {
                        System.out.println("Trưởng phòng có số nhân viên dưới quyền nhiều nhất: " + mostStaffManager);
                    }
                    break;
                case 8:
                    company.getEmployees().sort(Comparator.comparing(Employee::getName));
                    System.out.println("Danh sách nhân viên sau khi sắp xếp ABC:");
                    company.listEmployees();
                    break;
                case 9:
                    company.getEmployees().sort((e1, e2) -> Integer.compare(e2.calculateSalary(), e1.calculateSalary()));
                    System.out.println("Danh sách nhân viên sau khi sắp xếp lương giảm dần:");
                    company.listEmployees();
                    break;
                case 10:
                    Director mostSharesDirector = null;
                    for (Employee emp : company.getEmployees()) {
                        if (emp instanceof Director) {
                            if (mostSharesDirector == null || ((Director) emp).getShares() > mostSharesDirector.getShares()) {
                                mostSharesDirector = (Director) emp;
                            }
                        }
                    }
                    if (mostSharesDirector != null) {
                        System.out.println("Giám đốc có cổ phần nhiều nhất: " + mostSharesDirector);
                    }
                    break;
                case 11:
                    for (Employee emp : company.getEmployees()) {
                        if (emp instanceof Director) {
                            Director director = (Director) emp;
                            double totalIncome = director.calculateTotalincome(company.calculateCompanyProfit());
                            System.out.println("Tổng thu nhập của giám đốc " + director.getName() + ": " + totalIncome);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}