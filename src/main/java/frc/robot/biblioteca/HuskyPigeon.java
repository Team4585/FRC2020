package frc.robot.biblioteca;

import com.ctre.phoenix.sensors.PigeonIMU;

public class HuskyPigeon extends Vector3DIn {
    private PigeonIMU m_pigeon;
    public HuskyPigeon(int ID) {
        super();
        m_pigeon = new PigeonIMU(ID);
        reset();
    }
    public void gatherInfo() {
        double[] angles = new double[3];
        m_pigeon.getYawPitchRoll(angles);
        setValue(new HuskyVector3D(angles[0], angles[1], angles[2]));
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
}