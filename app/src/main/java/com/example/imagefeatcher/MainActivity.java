package com.example.imagefeatcher;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.imagefeatcher.adapter.CandidateAdapter;
import com.example.imagefeatcher.loader.CandidateLoader;
import com.example.imagefeatcher.web.Candidate;

import java.util.List;


public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<List<Candidate>> {
    private RecyclerView mRecyclerView;

    private CandidateAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CandidateAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        if(getSupportLoaderManager().getLoader(0) == null){
            getSupportLoaderManager().initLoader(0, null, this);
        } else {
            getSupportLoaderManager().restartLoader(0, null, this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public Loader<List<Candidate>> onCreateLoader(int id, Bundle args) {
        return new CandidateLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Candidate>> loader, List<Candidate> data) {
        mAdapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Candidate>> loader) {
        mAdapter.setData(null);
    }
}
