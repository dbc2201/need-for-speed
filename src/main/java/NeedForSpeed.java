class NeedForSpeed {
    private final int speed;
    private final int batteryDrain;
    private int distanceDriven;
    private int batteryRemaining;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.batteryRemaining = 100;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public boolean batteryDrained() {
        return batteryRemaining <= 0;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (!batteryDrained()) {
            distanceDriven += speed;
            batteryRemaining -= batteryDrain;
        }
    }

    public int getBatteryDrain() {
        return batteryDrain;
    }

    public int getSpeed() {
        return speed;
    }
}

class RaceTrack {
    private final int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean carCanFinish(NeedForSpeed car) {
        return (100 / car.getBatteryDrain()) * car.getSpeed() >= distance;
    }
}
