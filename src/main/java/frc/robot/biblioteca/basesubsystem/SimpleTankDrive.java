package frc.robot.biblioteca.basesubsystem;
import frc.robot.biblioteca.Motor;

public class SimpleTankDrive extends Drive{
  private Motor m_leftMaster;
  private Motor m_leftSlave;
  private Motor m_rightMaster;
  private Motor m_rightSlave;
  private double twistInv;
  private double driveInv;
  private double invertRight;
  private double invertLeft;
  public SimpleTankDrive(Motor leftMaster, Motor leftSlave, Motor rightMaster, Motor rightSlave){
    super();
    m_leftMaster = leftMaster;
    m_leftSlave = leftSlave;
    m_rightMaster = rightMaster;
    m_rightSlave = rightSlave;
    m_rightSlave.follow(m_rightMaster);
    m_leftSlave.follow(m_leftMaster);
    driveInv = 1;
    twistInv = 1;
    invertLeft = 1;
    invertRight = 1;
  }
  public void invertLeft(boolean inv){
    if(inv){
      invertLeft = -1;
    }else{
      invertLeft = 1;
    }
  }
  public void invertRight(boolean inv){
    if(inv){
      invertRight = -1;
    }else{
      invertRight = 1;
    }
  }
  public void fightingLeft(boolean boo){
    m_leftSlave.setInverted(boo);
  }
  public void fightingRight(boolean boo){
    m_rightSlave.setInverted(boo);
  }
  @Override
  public void gatherInfo(){}
  @Override
  public void doActions(){
    m_leftMaster.set(((m_forward * driveInv) - (m_twist * twistInv)) * invertLeft);
    m_rightMaster.set(((m_forward * driveInv) + (m_twist * twistInv)) * invertRight);
  }
}
