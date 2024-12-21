public class Director extends Employee {
    private double shares; //phan tram co phan cua cong ty

    public Director(String id, String name, String phone,int workingDays, double shares) {
        super(id, name, phone, workingDays, 300);
        this.shares = shares;
    }

    @Override
    public int calculateSalary() {
        return dailySalary *  workingDays;
    }

    @Override
    public String getPosition() {
        return "Giam Doc";
    }
//Tinh luong giam doc
    public double calculateTotalincome(double companyProfit){
        return calculateSalary() + (shares * companyProfit /100);
    }

    public double getShares() {
        return shares;
    }
//Thong tin giam doc
    @Override
    public String toString() {
        return super.toString() + ", Phan Tram co phan: "  + shares + "%";
    }
}
