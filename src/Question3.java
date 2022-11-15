/*
Design a class that has a static method named writeArray. The method should take two
arguments: the name of a file and a reference to an int array. The file should be opened as a
binary file, the contents of the array should be written to the file, and then the file should be
closed.
Write a second method in the class named readArray. The method should take two arguments:
the name of a file and a reference to an int array. The file should be opened, data should be
read from the file and stored in the array, and then the file should be closed.
Demonstrate both methods in a program.
 */

import java.io.*;

public class Question3 {
    public void writeArray(String name, int[] array) throws IOException {
        FileOutputStream fp = new FileOutputStream(name);
        DataOutputStream dp = new DataOutputStream(fp);
        for(int i:array){
            try{
                dp.writeInt(i);
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        dp.close();
        fp.close();
    }
    public void readArray(String name, int[] array) throws IOException {
        DataInputStream dp = new DataInputStream(new FileInputStream(name));
        boolean eof = true;
        int count = 0;
        while(eof){
            try {
                int i = dp.readInt();
                array[count]=i;
                count++;
            }
            catch(EOFException e){
                eof=false;
            }
        }
        for(int i : array){
            System.out.println(i);
        }
        dp.close();
    }
}
