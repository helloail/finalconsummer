package com.example.foryoudicodingconsummer;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.foryoudicodingconsummer.adapter.AdapterList;
import com.example.foryoudicodingconsummer.interfaces.LoadNotesCallback;
import com.example.foryoudicodingconsummer.model.FilmInit;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.foryoudicodingconsummer.helper.MappingHelper.mapCursorMovieToArrayList;
import static com.example.foryoudicodingconsummer.model.MovieContract.MovieColumns.CONTENT_URI;

public class MainActivity extends AppCompatActivity implements LoadNotesCallback {



    private AdapterList adapterList;
    private static HandlerThread handlerThread;
    Handler handler;
    private DataObserver myObserver;
    private static final String EXTRA_STATE = "EXTRA_STATE";

    @BindView(R.id.search_recycler)
    RecyclerView rvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapterList = new AdapterList(this);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvMovies.setAdapter(adapterList);

        handlerThread = new HandlerThread("DataObserver");
        handlerThread.start();

        handler = new Handler(handlerThread.getLooper());
        myObserver = new DataObserver(handler, this);

        getContentResolver().registerContentObserver(CONTENT_URI, true, myObserver);
        new getData(this, this).execute();

    }



    @Override
    public void postExecute(Cursor notes) {

        ArrayList<FilmInit> listNotes = mapCursorMovieToArrayList(notes);
        if (listNotes.size() > 0) {
            adapterList.setListNotes(listNotes);
        } else {
            Toast.makeText(this, "Tidak Ada data saat ini", Toast.LENGTH_SHORT).show();
            adapterList.setListNotes(new ArrayList<FilmInit>());
        }
    }

    private static class getData extends AsyncTask<Void, Void, Cursor> {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadNotesCallback> weakCallback;


        private getData(Context context, LoadNotesCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return weakContext.get().getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor data) {
            super.onPostExecute(data);
            weakCallback.get().postExecute(data);
        }

    }

    static class DataObserver extends ContentObserver {
        final Context context;

        public DataObserver(Handler handler, Context context) {
            super(handler);
            this.context = context;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            new getData(context, (MainActivity) context).execute();
        }
    }
}
