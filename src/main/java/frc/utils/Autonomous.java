package frc.utils;

public interface Autonomous {
    public default void initAuton() {}
    public void runAuton();
    public void finishAuton();
}
