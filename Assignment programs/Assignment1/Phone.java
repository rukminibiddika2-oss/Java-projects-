interface Camera {
    void takePhoto();
}

interface Music {
    void playMusic();
}

class Phone implements Camera, Music {
    public void takePhoto() {
        System.out.println("Taking photo");
    }

    public void playMusic() {
        System.out.println("Playing music");
    }

    public static void main(String[] args) {
        Phone p = new Phone();
        p.takePhoto();
        p.playMusic();
    }
}
