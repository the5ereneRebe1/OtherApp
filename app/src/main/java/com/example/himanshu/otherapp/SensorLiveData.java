package com.example.himanshu.otherapp;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorLiveData extends LiveData<SensorLiveData.Event> {
    final private SensorManager sensorManager;
    final private Sensor sensor;
    final private int delay;

    public SensorLiveData(Context ctx,int sensorType, int delay) {
        sensorManager= (SensorManager) ctx.getApplicationContext().getSystemService(Context.SENSOR_SERVICE);
        this.sensor=sensorManager.getDefaultSensor(sensorType);

        this.delay = delay;
        if(this.sensor==null)
            throw new IllegalStateException("Cannot access this sensor");
    }

    @Override
    protected void onActive() {
        super.onActive();
        sensorManager.registerListener(listener,sensor,delay);
    }
    SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            setValue(new Event(event));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onInactive() {
        super.onInactive();
        sensorManager.unregisterListener(listener);
    }

    public class Event {
        final float[] values;

        public Event(SensorEvent event) {
            this.values = new float[event.values.length];
            System.arraycopy(event.values,0,values,0,event.values.length);
        }

    }
}
