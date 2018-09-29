package com.example.himanshu.otherapp;

import android.app.LoaderManager;
import android.arch.lifecycle.Observer;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LOAD_COURSES = 0;
    private SimpleCursorAdapter cursorAdapter;
    private SensorLiveData sensorLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView)findViewById(R.id.list_view);
        final TextView textView= (TextView)findViewById(R.id.sensor);
        cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,null,
                new String[]{"course_id","course_title"},new int[]{android.R.id.text1,android.R.id.text2},0);
        mListView.setAdapter(cursorAdapter);
        getLoaderManager().initLoader(LOAD_COURSES,null,this);


        sensorLiveData= (SensorLiveData) getLastCustomNonConfigurationInstance();

        if (sensorLiveData==null) {

            sensorLiveData=
                    new SensorLiveData(this, Sensor.TYPE_LIGHT,
                            SensorManager.SENSOR_DELAY_UI);
        }
        sensorLiveData.observe(this, new Observer<SensorLiveData.Event>() {
            @Override
            public void onChanged(@Nullable SensorLiveData.Event event) {
                if(event!=null)
                textView.setText(String.valueOf(event.values[0]));
            }
        });
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return sensorLiveData;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if(id==LOAD_COURSES){
            Uri uri=Uri.parse("content://com.example.himanshu.noteapp.provider");
            String[] selection={"_id,course_id,course_title"};
            return new CursorLoader(this,uri,selection,null,null,"course_title");
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if(loader.getId()==LOAD_COURSES){
            cursorAdapter.changeCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if(loader.getId()==LOAD_COURSES){
            cursorAdapter.changeCursor(null);
        }
    }
}
