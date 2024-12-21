public class Staff extends Employee {
    private Manager manager;

    public Staff(String id, String name, String phone, int workingDays) {
        super(id, name, phone, workingDays, 100);
        this.manager = null;
    }

    @Override
    public String getPosition() {
        return "Nhân Viên";
    }
//Tinh Luong
    public int calculateSalary(){
        return workingDays * dailySalary;
    }

    public void setManager(Manager manager){
        this.manager = manager;
    }

    public Manager getManager(){
        return manager;
    }

    public String getPositon(){
        return "Nhân Viên";
    }
//Thong tin nhan vien
    public String toString(){
        return super.toString() + (manager != null ? ", Trưởng Phòng: " + manager.getName(): "");
    }
}
