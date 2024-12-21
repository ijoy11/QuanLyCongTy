public abstract class Employee {
    protected String id;
    protected String name;
    protected String phone;
    protected int workingDays;
    protected int dailySalary;

    public Employee(String id, String name, String phone, int workingDays, int dailySalary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.workingDays = workingDays;
        this.dailySalary = dailySalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getDailySalary() {
        return dailySalary;
    }
    public abstract String getPosition();

    public abstract int calculateSalary();
//Thong tin cua employee
    public String toString(){
        return "ID: " + id + ", Ten: " + name + ", Chuc Vu: " + getPosition() + ", Luong: " + calculateSalary();
    }
}