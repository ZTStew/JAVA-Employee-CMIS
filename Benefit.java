public class Benefit {
    double contribution401KRate = 0;
    String medicalPlan = "none";
    String dentalPlan = "none";

    /* Constructors */
    public Benefit(){ }
    public Benefit(double inContribution401KRate){
        this(inContribution401KRate, "none", "none");
    }
    public Benefit(double inContribution401KRate, String inMedicalPlan){
        this(inContribution401KRate, inMedicalPlan, "none");
    }
    public Benefit(double inContribution401KRate, String inMedicalPlan, String inDentalPlan){
        setContribution401KRate(inContribution401KRate);
        setMedicalPlan(inMedicalPlan);
        setDentalPlan(inDentalPlan);
    }
    public Benefit(Benefit benefit){
        setContribution401KRate(benefit.getContribution401KRate());
        setMedicalPlan(benefit.getMedicalPlan());
        setDentalPlan(benefit.getDentalPlan());
    }

    /* Getters and Setters */
    public double getContribution401KRate(){
        return this.contribution401KRate;
    }
    public void setContribution401KRate(double inContribution401KRate){
        if(inContribution401KRate >= 0 && inContribution401KRate <= 100){
            this.contribution401KRate = inContribution401KRate;
        }
    }

    public String getMedicalPlan(){
        return this.medicalPlan;
    }
    public void setMedicalPlan(String inMedicalPlan){
        inMedicalPlan = inMedicalPlan.toLowerCase();
        if(inMedicalPlan.equals("single") || inMedicalPlan.equals("family") || inMedicalPlan.equals("none")){
            this.medicalPlan = inMedicalPlan;
        }
    }

    public String getDentalPlan(){
        return this.dentalPlan;
    }
    public void setDentalPlan(String inDentalPlan){
        inDentalPlan = inDentalPlan.toLowerCase();
        if(inDentalPlan.equals("single") || inDentalPlan.equals("family") || inDentalPlan.equals("none")){
            this.dentalPlan = inDentalPlan;
        }
    }

    @Override
    public String toString(){
        return String.format("401K: %.1f%%\nMedical Plan: %s\nDental Plan: %s", getContribution401KRate(), getMedicalPlan(), getDentalPlan());
    }
}