class Person {
    void walk() {
        System.out.println("Person walks");
    }
}

class Student extends Person {
    void study() {
        System.out.println("Student studies");
    }
}

interface Sports {
    void play();
}

class CollegeStudent extends Student implements Sports {
    public void play() {
        System.out.println("Student plays sports");
    }

    public static void main(String[] args) {
        CollegeStudent s = new CollegeStudent();
        s.walk();
        s.study();
        s.play();
    }
}
