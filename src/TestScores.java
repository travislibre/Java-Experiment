/*
Write an exception class named InvalidTestScore. Modify the TestScores class you wrote in
Programming Challenge 1 so that it throws an InvalidTestScore exception if any of the test
scores in the array are invalid.
 */
public class TestScores {
    private int[] testScores;
    public TestScores(int[] testScores) throws InvalidTestScore {
        for (int i : testScores) {
            if (i > 100 | i < 0) {
                throw new InvalidTestScore("Test score invalid");
            }
            this.testScores = testScores;
        }
    }
    public int avgScores(){
        int sum=0;
        for(int i:this.testScores){
            sum = sum+i;
        }
        return sum/this.testScores.length;
    }
}
