package com.example.himanshu.otherapp;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LOAD_COURSES = 0;
    private SimpleCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView)findViewById(R.id.list_view);
        cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,null,
                new String[]{"course_id","course_title"},new int[]{android.R.id.text1,android.R.id.text2},0);
        mListView.setAdapter(cursorAdapter);
        getLoaderManager().initLoader(LOAD_COURSES,null,this);
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
