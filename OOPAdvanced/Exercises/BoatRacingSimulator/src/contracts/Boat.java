package contracts;

public interface Boat extends Modelable {

    double calculateRaceSpeed(Race race);

    boolean isMotorBoat();
}
