package com.example.imagefeatcher.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.imagefeatcher.R;
import com.example.imagefeatcher.web.Api;
import com.example.imagefeatcher.web.Candidate;

import java.util.List;

import retrofit.RestAdapter;

/**
 * Created by Alex Klimashevsky on 16.07.2015.
 */
public class CandidateLoader extends AsyncTaskLoader<List<Candidate>>{

    private Api mAPi;

    public CandidateLoader(Context context) {
        super(context);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(context.getString(R.string.server_endpoint))
                .build();

        mAPi = restAdapter.create(Api.class);

        onContentChanged();
    }

    @Override
    public List<Candidate> loadInBackground() {
        return mAPi.listCandidates();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
    }
}
