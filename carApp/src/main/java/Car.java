public class Car {
    public static final int SPEEDACCE = 10;
    public static final int MAXSPEED = 120;
    public static final int LOWESTSPEED = 0;
    private String model;
    private String color;
    private int speed;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
        this.speed = 0;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void accelerate() {
        if (speed + SPEEDACCE <= MAXSPEED) {
            speedAcceleration();
            showDetails();
        } else {
            System.out.println("La vitesse maximale est atteinte.");
        }
    }

    private void speedAcceleration() {
        speed += SPEEDACCE;
    }

    public void slowDown() {
        if (speed - SPEEDACCE >= LOWESTSPEED) {
            speedDecceleration();
            showDetails();
        } else {
            System.out.println("La voiture est déjà à l'arrêt.");
        }
    }

    private void speedDecceleration() {
        speed -= SPEEDACCE;
    }

    public void showDetails() {
        System.out.println("Modèle : " + model);
        System.out.println("Couleur : " + color);
        System.out.println("Vitesse actuelle : " + speed);
    }
}