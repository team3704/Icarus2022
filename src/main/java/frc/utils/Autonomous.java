package frc.utils;

public interface Autonomous {
    default void initAuton() {}
    public void runAuton();
    /**
     * Must end all processes or movements in this method
     */
    public void finishAuton();
}
