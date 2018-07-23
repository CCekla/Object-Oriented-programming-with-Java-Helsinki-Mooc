
package application;

public interface Sensor {
    boolean isOn();  // returns true if the sensor is on
    void on();       // switches the sensor on
    void off();      // switches the sensor off
    int measure();  // returns the sensor reading if the sensor is on
                     // if the sensor is off, it throws an IllegalStateException
}


package application;

public class ConstantSensor implements Sensor{
    private int measure;
    
    public ConstantSensor(int measure){
        this.measure = measure;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {
        
    }

    @Override
    public void off() {
        
    }

    @Override
    public int measure() {
        return this.measure;
    }
}


package application;

import java.util.Random;

public class Thermometer implements Sensor{
    private boolean status;
    private Random randomizer;
    
    public Thermometer(){
        this.status = false;
        this.randomizer = new Random();
    }

    @Override
    public boolean isOn() {
        return this.status;
    }

    @Override
    public void on() {
        this.status = true;
    }

    @Override
    public void off() {
        this.status = false;
    }

    @Override
    public int measure() {
        if(this.status){
            return randomizer.nextInt(61)-30;
        }
        throw new IllegalStateException("Some text");
    }
    
}


package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional){
        this.sensors.add(additional);
    }
    
    public List<Integer> readings(){
        return this.readings;
    }

    @Override
    public boolean isOn() {
        boolean status = true;
        for(Sensor sensor : this.sensors){
            if(!sensor.isOn()){
                status = false;
            }            
        }
        return status;
    }

    @Override
    public void on() {
        for(Sensor sensor : this.sensors){
            sensor.on();
        }
    }

    @Override
    public void off() {
        for(Sensor sensor : this.sensors){
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if(!isOn()){
            throw new IllegalStateException("This sensor is off");
        }
        int sensorNumber = this.sensors.size();
        int measureSum = 0;
        for(Sensor sensor : this.sensors){
            measureSum += sensor.measure();
        }
        this.readings.add(measureSum/sensorNumber);
        return measureSum/sensorNumber;
    }
}
