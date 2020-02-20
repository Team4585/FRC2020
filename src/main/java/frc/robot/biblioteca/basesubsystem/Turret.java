package frc.robot.biblioteca.basesubsystem;
import frc.robot.biblioteca.RoboBaseClass;
//import PID;
//import math;

public abstract class Turret extends RoboBaseClass {
  private double m_currentAngleX = 0;
  private double m_targetAngleX = 0;
  private double m_currentAngleY = 0;
  private double m_targetAngleY = 0;
  
  private double m_xMin = -180;
  private double m_xMax = 180;
  private double m_yMin = 0;
  private double m_yMax = 0;
  protected boolean m_PIDEnable = true;
  
  //private PID PIDX;
  //private PID PIDY;
  
  public Turret(double xMin, double xMax, double yMin, double yMax, boolean doPID) {
    super();
    m_xMin = xMin;
    m_xMax = xMax;
    m_yMin = yMin;
    m_yMax = yMax;
    m_PIDEnable = doPID;
    //PIDX = new PID();
    //PIDY = new PID();
  }
  public double getCurrentX() {
    return m_currentAngleX;
  }
  public double getCurrentY() {
    return m_currentAngleY;
  }
  public void setTargetX(double x) {
    m_targetAngleX = Math.max(Math.min(x, m_xMax), m_xMin);//limit input to -360 and 360
  }
  public void setTargetY(double y) {
    m_targetAngleY = Math.max(Math.min(y, m_yMax), m_yMin);//limit input to -360 and 360
  }
  protected void setCurrentX(double x) {
    m_currentAngleX = x;
  }
  protected void setCurrentY(double y) {
    m_currentAngleY = y;
  }
  abstract public void shoot(double velocity);
  abstract public void rotateX(double x);
  abstract public void rotateY(double y);
  @Override
  public void doActions() {
    /*if(m_PIDEnable) {
      //PIDX.calculateError(m_currentAngleX, m_targetAngleX);
      //PIDY.calculateError(m_currentAngleY, m_targetAngleY);
      //rotateX(PIDX.get());
      //rotateY(PIDY.get());
    }*/
  }
}
