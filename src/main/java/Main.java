import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("We will create an array, please enter arrays lenght");
        int n = scanner.nextInt();
        System.out.println("Enter array values");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Insert value on index " + (i) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter a index of element you want to see");
        //if you enter index which you don't have in array that will cause (ArrayIndexOutOfBoundsException) unchecked exception
        int index =  scanner.nextInt();

        //with try-catch we can try our code and if everything is legit try block is executed, if it's not catch block will 'catch' exception and execute that bloch of code :)
        try {
            System.out.println("Value of selected index is: " + array[index]);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Entered index don't exists in this array");
        }


        //this is one example of checked exception
        System.out.println("If you want to try ClassNotFoundException enter number 1, else enter any other number for exit");
        int num = scanner.nextInt();
        if (num == 1){
        try {
            Class.forName("NonExistenceClass");
            ClassLoader.getSystemClassLoader().loadClass("NonExistenceClass");
        }catch (ClassNotFoundException e){
            System.out.println(e);
            System.out.println("This class don't exists");
        }}else
            System.out.println("Bye :)");

    }
}
