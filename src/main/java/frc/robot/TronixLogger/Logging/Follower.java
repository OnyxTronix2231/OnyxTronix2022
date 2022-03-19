package frc.robot.TronixLogger.Logging;

public interface Follower<T> {

    T getValue();

    T getLastValue();

    void updateLastValue();

    String getName();

    int getCounter();

    void update();
}
