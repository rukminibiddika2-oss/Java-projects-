abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("Animal eats");
    }
}

class Rabbit extends Animal {
    void sound() {
        System.out.println("rabbit barks");
    }

    public static void main(String[] args) {
        Rabbit d = new Rabbit ();
        d.sound();
        d.eat();
    }
}
