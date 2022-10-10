package Exceptions;

public class Example2 {
    public static void main(String[] args) {
        //try block containing exception prone code
        try{
            System.out.println("try Block:: Begin");
            int myArray[]=new int[5];
            myArray [5]=10/0;
        }
        //multiple catch blocks
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception :: Divide by zero!!");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds :: Accessed index out of bounds");
        }
        catch(Exception e)
        {
            System.out.println("Exception :: " + e.getMessage ());
        }
        System.out.println("rest of the code");
    }
}
