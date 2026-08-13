// Interface
interface Printable {
    void print();
}

// Abstract Class
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle extends Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Report implements Printable {
    public void print() {
        System.out.println("Printing Report");
    }
}

// Book Class
class Book {

    private int bookId;
    private String bookName;
    private String author;
    private double price;

    // Default Constructor
    Book() {
        bookId = 0;
        bookName = "Unknown";
        author = "Unknown";
        price = 0;
    }

    // Parameterized Constructor
    Book(int id, String name, String author, double price) {
        this.bookId = id;
        this.bookName = name;
        this.author = author;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }

    public void display() {
        System.out.println(bookId + " " + bookName + " " + author + " " + price);
    }
}

// Inheritance
class Person {
    String name = "Rukmini";
}

class Student extends Person {
    int roll = 101;
}

class Faculty extends Person {
    String subject = "Java";
}

// Method Overloading
class Area {

    void area(int side) {
        System.out.println("Square Area = " + side * side);
    }

    void area(int l, int b) {
        System.out.println("Rectangle Area = " + l * b);
    }

    void area(double r) {
        System.out.println("Circle Area = " + 3.14 * r * r);
    }
}

// Method Overriding
class Vehicle {

    void display() {
        System.out.println("Vehicle");
    }
}

class Car extends Vehicle {

    void display() {
        System.out.println("Car");
    }
}

class Bike extends Vehicle {

    void display() {
        System.out.println("Bike");
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Book b1 = new Book();
        Book b2 = new Book(101, "Java Programming", "James Gosling", 500);

        b1.display();
        b2.display();

        Student s = new Student();
        Faculty f = new Faculty();

        System.out.println("Student Name: " + s.name);
        System.out.println("Roll No: " + s.roll);

        System.out.println("Faculty Name: " + f.name);
        System.out.println("Subject: " + f.subject);

        Area obj = new Area();

        obj.area(5);
        obj.area(5, 10);
        obj.area(4.5);

        Vehicle v;

        v = new Car();
        v.display();

        v = new Bike();
        v.display();

        Shape c = new Circle();
        c.draw();

        Shape r = new Rectangle();
        r.draw();

        Report rp = new Report();
        rp.print();
    }
}
