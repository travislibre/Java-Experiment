class InvalidName extends Exception{
    public InvalidName(String message){
        super(message);
    }
}
class InvalidEmployeeID extends Exception{
    public InvalidEmployeeID(String message){
        super(message);
    }
}
class InvalidHours extends Exception{
    public InvalidHours(String message){
        super(message);
    }
}
class InvalidPay extends Exception{
    public InvalidPay(String message){
        super(message);
    }
}
public class Payroll {
    int[] employeeId;
    int[] hours;
    double[] payRate;
    double[] wages;
    String[] employeeNames;

    public Payroll(int[] hours, double[] payRate, String[] employeeNames, int[] employeeId) throws Exception {
        setHours(hours); // I call the function in order to check if the hours are valid
        setPayRate(payRate); //// I call the function in order to check if the payRates are valid
        setWages();
        setEmployeeNames(employeeNames);
        setEmployeeId(employeeId);
    }
    public void setEmployeeNames(String[] employeeNames) throws InvalidName {
        for(String s:employeeNames){
            if(s.length()==0){
                throw new InvalidName("Empty name provided");
            }
        }
        this.employeeNames=employeeNames;
    }
    public int[] getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int[] employeeId) throws InvalidEmployeeID {
        for(int i:employeeId){
            if (i<=0){
                throw new InvalidEmployeeID("Invalid Employee ID: "+i);
            }
        }
        this.employeeId = employeeId;

    }

    public int[] getHours() {
        return hours;
    }

    public void setHours(int[] hours) throws InvalidHours {
        for (int hour : hours) {
            if (hour < 0) {
                throw new InvalidHours("Hours less than zero");
            }
            if( hour>84){
                throw new InvalidHours("Hours greater than 84");
            }
        }
        this.hours = hours;
    }

    public double[] getPayRate() {
        return payRate;
    }

    public void setPayRate(double[] payRate) throws InvalidPay {
        for (double pay : payRate) {
            if (pay < 0) {
                throw new InvalidPay("Payrate less than zero.");
            }
            if(pay>25){
                throw new InvalidPay("Payrate greater than 25");
            }
        }
        this.payRate = payRate;
    }

    public double[] getWages() {
        return wages;
    }

    public void setWages() {
        int i = 0;
        this.wages=new double[hours.length];
        while (i < this.hours.length) {
            wages[i] = hours[i] * payRate[i];
            i++;
        }
    }

    public double idToGross(int id) {
        for (int i = 0; i < employeeId.length; i++) {
            if (employeeId[i] == id) {
                return wages[i];
            }
        }
        System.out.println("Employee not found");
        return 0;
    }
}
