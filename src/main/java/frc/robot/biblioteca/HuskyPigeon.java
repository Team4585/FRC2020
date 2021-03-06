package frc.robot.biblioteca;

import com.ctre.phoenix.sensors.PigeonIMU;
import frc.robot.biblioteca.HuskyVector3D;

public class HuskyPigeon extends Vector3DIn {
    public PigeonIMU m_pigeon;
    private HuskyVector3D m_heading;
    public HuskyPigeon(int ID) {
        super();
        m_pigeon = new PigeonIMU(ID);
        reset();
    }
    public void gatherInfo() {
        double[] angles = new double[3];
        m_pigeon.getYawPitchRoll(angles);
        m_heading = new HuskyVector3D(angles[0], angles[1], angles[2]);
    }
    public HuskyVector3D getHeading(){
        return m_heading;
    }
    public void reset() {
        m_pigeon.setYaw(0);
    }
    public void adjustToRange(double offset) {
        while(getValue().getX() < offset) {
            getValue().setX(getValue().getX()+360);
        }
        while(getValue().getX() > offset+360) {
            getValue().setX(getValue().getX()-360);
        }
    }
    public static double adjustToRange(double value, double offset) {
        double returnValue = value;
        while(returnValue < offset) {
            returnValue += 360;
        }
        while(returnValue > offset+360) {
            returnValue -= 360;
        }
        return returnValue;
    }
}