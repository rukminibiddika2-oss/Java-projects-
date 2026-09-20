package core_java;

class FarmAnimal {
    String name;
    String place;
    String food;
    String sound;

    // Constructor to initialize animal details
    FarmAnimal(String name, String place, String food, String sound) {
        this.name = name;
        this.place = place;
        this.food = food;
        this.sound = sound;
    }

    // Method to display animal details
    void display() {
        System.out.println("Animal Name : " + name);
        System.out.println("Stays At    : " + place);
        System.out.println("Eats        : " + food);
        System.out.println("Sound       : " + sound);
        System.out.println();
    }
}

public class FarmAnimalDemo {
    public static void main(String[] args) {

        // Creating a cow object
        FarmAnimal cow = new FarmAnimal("Cow", "Cowshed", "Grass", "Moo");

        // Creating a pig object
        FarmAnimal pig = new FarmAnimal("Pig", "Pigsty", "Vegetables", "Oink");

        // Creating a horse object
        FarmAnimal horse = new FarmAnimal("Horse", "Stable", "Grass", "Neigh");

        // Displaying details of each animal
        cow.display();
        pig.display();
        horse.display();
    }
}
