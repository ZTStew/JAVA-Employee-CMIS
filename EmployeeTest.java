/*
 * Program makes use of overloaded constructors to make objects with default values
 * for those not filled in as well as enable the user to make copies of an object
 * and then modify this copy independently of the copied object.
 *
 * Objects are intended to resemble a list of benefits an employee may sign up for
 * and allows the employee to change these values as well as view the values.
 *
 * @author Stewart
 * @version JAVA 8, 8/4/2019
 */

class EmployeeTest{
    public static void main(String[] args){

        /* Test Cases */
        // Testing the no-argsEmployee constructor (and the toString method)
        System.out.println("Testing the no-args Employee constructor (and the toString method)".toUpperCase());
        Employee employee0= new Employee();
        System.out.println(employee0);
        System.out.println("---");
        // Testing the 2-argsEmployee constructor
        System.out.println("Testing the 2-args Employee constructor".toUpperCase());
        Employee employee1= new Employee("Maxwell Smart", 120000);
        System.out.println(employee1);
        System.out.println("---");

        // Testing the full Benefit constructor and one of the Employee mutators
        System.out.println("Testing the full Benefit constructor and one of the Employee mutators".toUpperCase());
        Benefit benefitMS= new Benefit(1, "Single", "None");
        employee1.setEmployeeBenefits(benefitMS);
        System.out.println(employee1);
        System.out.println("---");
        // Testing the 3-argsEmployee constructorSystem.out.println("Testing the 3-args Employee constructor".toUpperCase());
        Benefit benefitBR= new Benefit(5, "Family", "Single");
        Employee employee2= new Employee("Basil Rathbone", 360000, benefitBR);
        System.out.println(employee2);
        // Also testing the getSalaryBenefitWitholding() method and an accessor
        System.out.printf(employee2.getEmployeeName() + "'s monthly salary withholdings are $%,.2f\n",employee2.getSalaryBenefitWitholding());
        System.out.println("---");
        // Testing a null Benefit 
        System.out.println("Testing a null Benefit".toUpperCase());
        Employee employeeNull= new Employee("Careless Dude", 10000, null);
        System.out.println(employeeNull);
        System.out.println("---");
        // Testing changes in benefitBR do not affect Basil's benefit package
        System.out.println("Testing changes in benefitBR do not affect Basil's benefit package".toUpperCase());
        System.out.println("benefitBR was:\n"+ benefitBR);
        benefitBR.setDentalPlan("NONE");
        System.out.println("\nbenefitBR is now:\n"+ benefitBR);
        System.out.println("\n"+ employee2);
        System.out.println("---");
        // Testingthe fully loaded Employee constructor (and handling of "funny" capitalization
        System.out.println("Testing the fully loaded constructor (and handling of \"funny\" ".toUpperCase() + "capitalization".toUpperCase() + ")");
        Employee employee3= new Employee("Ariana Grande", 1000000, 2, "Single", "NOnE");
        System.out.println(employee3);
        System.out.println("---");
        // Testing the Employee copy constructor and the Employee equals method
        System.out.println("Testing the Employee copy constructor and the Employee equals method".toUpperCase());
        Employee doppelgangerAriana= new Employee(employee3);
        System.out.println("Ariana and her doppelganger are identical: "+ doppelgangerAriana.equals(employee3));
        System.out.println("Their references are the same: "+ (employee3== doppelgangerAriana));
        System.out.println("---");
        // Testing one cannot change Ariana's benefit by changing her doppelganger's benefits
        System.out.println("Testing one cannot change Ariana's benefit by changing her doppelganger's".toUpperCase());
        Benefit updatedBenefit= new Benefit(0, "Family", "Family");
        doppelgangerAriana.setEmployeeBenefits(updatedBenefit);
        System.out.println(employee3);
        System.out.println("\n"+ doppelgangerAriana);
        System.out.println("---");
        // Testing how to change contribution rates (and some mutators / accessors)
        System.out.println("Testing how to change contribution rates (and some mutators / accessors)".toUpperCase());
        System.out.printf(employee2.getEmployeeName() + "'s monthly salary current withholdings are $%,.2f\n", employee2.getSalaryBenefitWitholding());
        System.out.println("Changing Basil's 401K contribution rate to 10%!");
        Benefit tmp= employee2.getBenefitPackage();
        tmp.setContribution401KRate(10);
        employee2.setEmployeeBenefits(tmp);
        System.out.printf(employee2.getEmployeeName() + "'s monthly salary new withholdings are $%,.2f\n", employee2.getSalaryBenefitWitholding());
    }
}
