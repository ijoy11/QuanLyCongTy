import java.util.ArrayList;
import java.util.List;

class Manager extends Employee {
    public List<Staff> staffList;

    public Manager(String id, String name, String phone, int workingDays) {
        super(id, name, phone, workingDays, 200);
        this.staffList = new ArrayList<>();
    }
//Tinh luong
    @Override
    public int calculateSalary() {
        return workingDays * dailySalary + 100 * staffList.size();
    }
//Them nhan vien
    public void addStaff(Staff staff) {
        staffList.add(staff);
        staff.setManager(this);
    }
//Xoa Nhan Vien
    public void removeStaff(Staff staff) {
        staffList.remove(staff);
        staff.setManager(null);
    }
//so luong nhan vien
    public int getStaffCount() {
        return staffList.size();
    }

    @Override
    public String getPosition() {
        return "Trưởng Phòng";
    }
//Thong tin truong phong
    @Override
    public String toString() {
        return super.toString() + ", Nhân Viên dưới quyền: " + staffList.size();
    }
}