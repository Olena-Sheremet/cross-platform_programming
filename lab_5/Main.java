import java.util.*;

public class Main {
    public static void main(String[] args) {
       List<Integer> arr=new ArrayList<>();
       Random rnd = new Random();
       arr.add( rnd.nextInt(10));
       arr.add( rnd.nextInt(10));
       arr.add( rnd.nextInt(10));
       arr.add( rnd.nextInt(10));
       arr.add( rnd.nextInt(10));
       arr.add( rnd.nextInt(10));
       arr.add( rnd.nextInt(10));
       System.out.println(" List : " + arr);
       metod1(arr); //вивід List з N позтції
       metod2(arr,3,5); //Підмножина з firstIndex по lastIndex включно
       metod3();//додання  заданого елементу в задану позицію (LinkedList).
       metod4();  //значення елементу та його позицію в LinkedList
       metod5(arr);// пошук дублікатів в колекції List
       metod6();//метод, який з вхідного речення робить Map, де ключ - символ, а значення к-ть входження цього символу в речення.
       
    }


    private static void metod6() {
        String str="Example string for collection map";
        HashMap<Character, Integer> myHashMap = new HashMap<Character, Integer>();
        char ch;
        for(int i=0;i<str.length()-1;++i){
            ch=str.charAt(i);
            int count=1;
              if(!myHashMap.containsKey(ch)){
                  for(int j=i+1;j<str.length();++j){
                      int ch2=str.charAt(j);
                      if(ch==ch2) ++count;
                  }
                  myHashMap.put(ch,count);
              }
        }
        myHashMap.remove(' ');
        System.out.println("HashMap: "+myHashMap);
    }

    private static void metod5(List<Integer> arr) {
        List<Integer> dublicates =new ArrayList<>();
        for (int i = 0; i< arr.size()-1; ++i)
        {
            for (int j = i+1; j< arr.size(); ++j)
            {
                if(arr.get(i)== arr.get(j)) dublicates.add(arr.get(j));
            }
        }
        System.out.println("Dublicates: " + dublicates);
    }

    private static void metod4() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Java");
        linkedList.add("Java Script");
        linkedList.add("C/C++");
        linkedList.add("C# .net");
        for (int i =0; i<linkedList.size();++i)
        {
            System.out.println("Element : \" "+linkedList.get(i)+ "\" in pos: " +i);
        }
    }

    private static void metod3() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Java");
        linkedList.add("Java Script");
        linkedList.add("C/C++");
        linkedList.add("C# .net");
        System.out.println("LinkedLIst:"+linkedList);

        int index = 2;
        String line = "HTML and CSS";
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть позицію вставки елементи : ");
        int index = scanner.nextInt();
        System.out.print("Введіть рядок для вставки : ");
        String line = scanner.nextLine();
        */
        linkedList.add(index,line);
        System.out.println("LinkedLIst:"+linkedList);
    }

    private static void metod1(List<Integer> arr){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть позицію з якої виводити елементи : ");
        int index = scanner.nextInt();
            System.out.println("Вивід List з позиції " + index);
            for (int i=index;i<arr.size();++i) {
                System.out.println(arr.get(i));
            }


    }
    private static void metod2(List<Integer> arr, int firstIndex, int lastIndex){
        List<Integer> subset= new ArrayList<>();
        for (int i=firstIndex;i<=lastIndex;++i) {
            subset.add(arr.get(i));
        }
        System.out.println("Підмножина з  " + firstIndex +" по " + lastIndex);
        for (int i=0;i<subset.size();++i) {
            System.out.println(subset.get(i));
        }
    }
}
