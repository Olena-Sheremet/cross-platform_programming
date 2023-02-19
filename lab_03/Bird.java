public class Bird extends Animal implements CanFly{
    void Bird(){
        System.out.println("I`m a Bird!");
    }
    @Override void Voice(){
        System.out.println("Chirp-chirp");
    }

}
