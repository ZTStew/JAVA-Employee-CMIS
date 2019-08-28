public class Employee {
    private String employeeName = "unknown";
    private double employeeSalary = 0;
    private Benefit benefitPackage = new Benefit();

    public Employee(String inEmployeeName, double inEmployeeSalary){
        setEmployeeName(inEmployeeName);
        setEmployeeSalary(inEmployeeSalary);
    }
    public Employee(String inEmployeeName, double inEmployeeSalary, double inContributionRate, String inMedicalPlan, String inDentalPlan){
        this(inEmployeeName, inEmployeeSalary, new Benefit(inContributionRate, inMedicalPlan, inDentalPlan));
    }
    public Employee(String inEmployeeName, double inEmployeeSalary, Benefit inBenefitPackage){
        this(inEmployeeName, inEmployeeSalary);
        setEmployeeBenefits(inBenefitPackage);
    }
    public Employee(Employee inEmp){
        if(inEmp == null){
            inEmp = new Employee();
        } else {
            this.setEmployeeName(inEmp.getEmployeeName());
            this.setEmployeeSalary(inEmp.getEmployeeSalary());
            this.setEmployeeBenefits(inEmp.getBenefitPackage());
        }
    }
    public Employee(){}


    /* Getters and Setters */
    public String getEmployeeName(){
        return this.employeeName;
    }
    public void setEmployeeName(String inEmployeeName){
        if(inEmployeeName != null){
            this.employeeName = inEmployeeName;
        }
    }
    public double getEmployeeSalary(){
        return this.employeeSalary;
    }
    public void setEmployeeSalary(double inEmployeeSalary){
        if(inEmployeeSalary >= 0){
            this.employeeSalary = inEmployeeSalary;
        }
    }
    public Benefit getBenefitPackage(){
        Benefit benPack = benefitPackage;
        return benPack;
    }
    public void setEmployeeBenefits(Benefit inBenefitPackage){
        if(inBenefitPackage != null){
            this.benefitPackage = new Benefit(inBenefitPackage.getContribution401KRate(), inBenefitPackage.getMedicalPlan(), inBenefitPackage.getDentalPlan());
        }
    }
    
    public boolean equals(Employee emp){
        if(this.toString().equals(emp.toString())){
            return true;
        }
        return false;
    }


    public double getSalaryBenefitWitholding(){
        double withhold = 0;
        double monthlyIncome = getEmployeeSalary() / 12;

        withhold += monthlyIncome * (this.getBenefitPackage().getContribution401KRate() / 100);

        if(this.getBenefitPackage().getMedicalPlan().equals("single")){
            withhold += 100;
        } else if(this.getBenefitPackage().getMedicalPlan().equals("family")){
            withhold += 200;
        }

        if(this.getBenefitPackage().getDentalPlan().equals("single")){
            withhold += 40;
        } else if(this.getBenefitPackage().getDentalPlan().equals("family")){
            withhold += 80;
        }

        return withhold;
    }

    @Override
    public String toString(){
        return String.format("Employee Name: %s\nEmployee Salary: $%,.0f\n%s", this.employeeName, this.employeeSalary, this.benefitPackage);
    }
}
