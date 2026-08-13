interface Animal {
    void sound();
}

class Horse implements Animal {
    public void sound() {
        System.out.println("horse barks");
    }

    public static void main(String[] args) {
        Horse d = new Horse ();
        d.sound();
    }
}
