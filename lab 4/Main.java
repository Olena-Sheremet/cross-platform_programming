import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class Main {
    public static void main(String[] args)
    {
        try{
            method1();
        }catch(FileNotFoundException ex){ // обробка checked exception
            System.out.println("Exception: Запис файлу на заповнений диск ");
        }

        System.out.println("Продовження виконання програми...");

        try{
            method2();
        }
        catch (NullPointerException ex){ // обробка unchecked exception
            System.out.println("NullPointerException: metod2() не працює з нульовими значеннями " );
        }

        try {method3();
        }
        catch (ArithmeticException ex){
            System.out.println("Arithmetic Exception: Ділення на нуль ");
        }finally {
            int a=3;
            int b=4;
            int sum=a+b;
            System.out.println("Finally block :  Sum = " + sum);
        }

        //власний exception
        try {
            int a1=3,b1=5,c1=4; //рівняння без розв'язків
            int a2=2,b2=9,c2=1; //рівняння має 2 розв'язки
            QuadraticEquation equation1= new QuadraticEquation(a1,b1,c1);
            equation1.SolutionOfTheEquation();
            QuadraticEquation equation2= new QuadraticEquation(a2,b2,c2);
            equation2.SolutionOfTheEquation();
        }catch (EquationsWithoutSolutions ex){
            System.out.println("-----------------------------");
            System.out.println(ex.toString());

        }
    }

    private static void method1() throws FileNotFoundException {

        //File file = new File("C2:/","badFileName.txt");
        throw new FileNotFoundException();
    }

    private static void method2()
    {
        int[] dataArray = null;
        System.out.println("Value at index 2:" + dataArray[2]);
    }
    private static void method3()
    {
        int a = 100;
        int b = 0;
        System.out.println(a / b);
    }
}
