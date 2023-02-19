public class Main {
    public static void main(String[] args) {
        System.out.println("!!!For Bird:");
        Bird bird = new Bird();
        bird.Animal();
        bird.Bird();
        bird.Voice();
        bird.Fly();
        System.out.println("For Parrot:");
        Parrot parrot = new Parrot();
        parrot.Animal();
        parrot.Bird();
        parrot.Parrot();
        parrot.Voice();
        bird.Fly();

        System.out.println("\n!!!For Mammal:");
        Mammal mammal = new Mammal();
        mammal.Animal();
        mammal.Mammal();
        mammal.Voice();
        System.out.println("For Bat:");
        Bat bat = new Bat();
        bat.Animal();
        bat.Mammal();
        bat.Bat();
        bat.Voice();
        System.out.println("For Horse:");
        Horse horse = new Horse();
        horse.Animal();
        horse.Mammal();
        horse.Horse();
        horse.Voice();

        System.out.println("\n!!!For Reptile:");
        Reptile reptile = new Reptile();
        reptile.Animal();
        reptile.Reptile();
        reptile.Voice();
        System.out.println("For Snake:");
        Snake snake = new Snake();
        snake.Animal();
        snake.Reptile();
        snake.Voice();
        System.out.println("For Lizard:");
        Lizard lizard = new Lizard();
        lizard.Animal();
        lizard.Reptile();
        lizard.Lizard();
        lizard.Voice();



    }
}