class Grandfather {
    void property() {
        System.out.println("Grandfather property");
    }
}

class Father extends Grandfather {
    void house() {
        System.out.println("Father house");
    }
}

class Son extends Father {
    void bike() {
        System.out.println("Son bike");
    }

    public static void main(String[] args) {
        Son s = new Son();
        s.property();
        s.house();
        s.bike();
    }
}
