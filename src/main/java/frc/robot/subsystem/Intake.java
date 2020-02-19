package frc.robot.subsystem;

import frc.robot.biblioteca.RoboBaseClass;
//use HuskyVictor, Solenoid, and LightSensor

public class Intake extends RoboBaseClass {
    private int totalIn;
    public Intake() {
        //instantiate motor, solenoid, and lightsensor
    }
    public void gatherInfo() {
        //check if the light sensor senses things
        //add to total in
    }
    public void doActions() {

    }
    public void intake(double speed) {
        //activate motor
    }
    public void activatePiston(boolean up) {
        //set the piston
    }
    public int getTotalIn() {
        return totalIn;
    }
}
