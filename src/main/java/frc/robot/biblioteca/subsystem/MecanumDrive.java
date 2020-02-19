package frc.robot.biblioteca.subsystem;
import frc.robot.biblioteca.Motor;

public class MecanumDrive extends Drive{
    private Motor m_frontLeft;
    private Motor m_frontRight;
    private Motor m_backLeft;
    private Motor m_backRight;
    public MecanumDrive(Motor frontLeft, Motor frontRight, Motor backLeft, Motor backRight){
        super();
        m_frontLeft = frontLeft;
        m_frontRight = frontRight;
        m_backLeft = backLeft;
        m_backRight = backRight;
    }
    public void doActions(){
        m_frontLeft.set(this.getSpeed(true, true));
        m_frontRight.set(this.getSpeed(false, false));
        m_backLeft.set(this.getSpeed(true, false));
        m_backRight.set(this.getSpeed(false, true));
    }
    private double getSpeed(boolean isLeft, boolean isLeftGrain){
        double totalSpeed = m_forward;
        if(isLeft){
            totalSpeed -= m_twist;
        }else{
            totalSpeed += m_twist;
        }
        if(isLeftGrain){
            totalSpeed -= m_strafe;
        }else{
            totalSpeed += m_strafe;
        }
        return totalSpeed;
    }
    public void gatherInfo(){}
}
