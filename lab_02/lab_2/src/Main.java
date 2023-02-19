import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int array[]= new int[20];
        Random rnd = new Random();
        for(int i=0;i<array.length;++i)
        {
            array[i]= rnd.nextInt(10);
        }

        int number=-1,count=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ціле число: ");
        if (scanner.hasNextInt()) number = scanner.nextInt();
        else {
            System.out.println("Ви ввели не ціле число");
        }

        for (int i=0;i<array.length;++i)
        {
            if(array[i]==number) ++count;
        }

        System.out.println("Масив :");
        for (int i=0;i<array.length;++i)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println("\nЕлемент "+number+" повторюється в масиві "+count+" раз(и/зів)");

    }
}