package frc.robot.TronixLogger.Logging;

public interface Follower<T> {

    T getValue();

    T getLastValue();

    void updateLastValue();

    String getName();

    int getDelay();

    void update();

    void updateByDelay();

    int convertMileSecondsToUnits(int delayInMS);
}
