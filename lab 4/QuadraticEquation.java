public class QuadraticEquation {
    private int a;
    private int b;
    private int c;
    public QuadraticEquation(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public void SolutionOfTheEquation() throws EquationsWithoutSolutions
    {
        int D=b*b-4*a*c;
        if(D<0) {throw new EquationsWithoutSolutions();}
        if(D==0){
            double x=(-b)/(2*a);
            System.out.println("Рівнняння "+a+"x^2+"+b+"x+"+c+"=0 має один розв'язок x="+x);
        }
        if(D>0){
            double x1=((-b)+Math.sqrt(D))/(2*a);
            double x2=((-b)-Math.sqrt(D))/(2*a);
            System.out.println("Рівнняння "+a+"x^2+"+b+"x+"+c+"=0 має два розв'язоки: " );
            System.out.println("x1="+x1+";  x2="+x2+".");
        }
    }

}
