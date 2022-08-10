import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void getFile(String fileName) throws NonExistentFileExtensionException {

        //this is my checked exception, where I tried to read file witch don't exists
        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                file.nextLine();
            }
        } catch (FileNotFoundException err) {
            //idk is this way okay or not, this will print WrongFileExceptionMessage, I tried to handle this problem o this way, I doubt it is a good idea,but it is only one for now
            if (!isNameCorrect(fileName)) {
                WrongFileNameException wrongFileNameException = new WrongFileNameException("File with name : " + fileName + " does not exists");
                System.out.println(wrongFileNameException.getMessage());
                System.out.println(err);
                System.out.println();
                //if we comment previous four lines and uncomment the ne after this comment, that will throw
                //throw new WrongFileNameException("Wrong file name : " + fileName, err);
            }
        }
    }

    public static void ddd() throws WrongFileNameException {
        System.out.println("Enter any string to start custom unchecked exception");
        String fileName = scanner.nextLine();
        getFile(fileName);
    }

    private static boolean isNameCorrect(String fileName) {
        if (fileName.equals("trueName.txt"))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws WrongFileNameException {
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        while (num == 1) {
            System.out.println("1.Enter to see custom checked exception");
            System.out.println("2.Enter to create array and see custom unchecked exception (if you enter negative number for array lenght), and also other one " +
                    "unchecked exception if you enter in index search index which you don't have in that array ");
            System.out.println("3.Enter to see checked exception");
            int num2 = scanner.nextInt();
            if (num2 == 1) {
                ddd();
            } else if (num2 == 2) {
                int[] array;
                System.out.println("We will create an array, please enter array lenght");
                try {


                    int n = scanner.nextInt();
                    array = new int[n];

                    System.out.println("Enter array values");
                    for (int i = 0; i < n; i++) {
                        System.out.print("Insert value on index " + (i) + ": ");
                        array[i] = scanner.nextInt();
                    }
                    System.out.println("Enter a index of element you want to see");
                    //if you enter index which you don't have in array that will cause (ArrayIndexOutOfBoundsException) unchecked exception
                    int index = scanner.nextInt();

                    //with try-catch we can try our code and if everything is legit try block is executed, if it's not catch block will 'catch' exception and execute that bloch of code :)
                    try {
                        System.out.println("Value of selected index is: " + array[index]);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Entered index don't exists in this array");
                    }

                } catch (NegativeArraySizeException exc) {
                    //I commented this and used instance of this exception to print messages because I didn't want to that exception break app, but if uncomment line
                    //after this, soo it can throw exception
                    //throw new ArrayLenghtCantBeNegative("Array lenght should be positive ", exc);
                    ArrayLenghtCantBeNegative arrayLenghtCantBeNegative = new ArrayLenghtCantBeNegative("Array with negative size can't be created", exc);
                    System.out.println(arrayLenghtCantBeNegative.getMessage());
                    System.out.println(arrayLenghtCantBeNegative.getCause());
                    System.out.println();

                }

            } else if (num2 == 3) {
                //this is one example of checked exception
                try {
                    Class.forName("NonExistenceClass");
                    ClassLoader.getSystemClassLoader().loadClass("NonExistenceClass");
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                    System.out.println("This class don't exists");
                }
            }


            System.out.println("If you want to run again enter 1, if you want to exit enter 2");
            num = scanner.nextInt();

        }

    }

}

