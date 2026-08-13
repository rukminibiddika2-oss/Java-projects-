class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    void circle() {
        System.out.println("Circle");
    }
}

class Square extends Shape {
    void square() {
        System.out.println("Square");
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        Square s = new Square();

        c.draw();
        c.circle();

        s.draw();
        s.square();
    }
}
