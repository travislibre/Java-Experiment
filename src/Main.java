import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            TestScores results = new TestScores(new int[]{-100, 80, 80, 90});
            System.out.println("Average Score: "+results.avgScores());
        }
        catch (InvalidTestScore ie){
            System.out.println(ie.getMessage());
        }

        try{
            Payroll pay = new Payroll(new int[]{1,2,3},new double[]{20,12,15},new String[]{"Bob","Joe","Marg"},new int[]{1,2,3});
            System.out.println("ID 1's pay: "+pay.idToGross(1));
            Payroll payError = new Payroll(new int[]{-5,0,2},new double[]{-100,0,0},new String[]{"","Joe","Marg"},new int[]{1,2,3});
            System.out.println("ID 1's pay: "+payError.idToGross(1));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            Question3 test = new Question3();
            test.writeArray("test.dat", new int[]{1,2,3,4,5});
            test.readArray("test.dat", new int[5]);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
