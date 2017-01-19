package com.khalilayache.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

/**
 * @author USUARIO
 * @since 17/01/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String mUrl;

    public EarthquakeLoader(Context context, String mUrl) {
        super(context);
        this.mUrl = mUrl;
    }

    @Override
    protected void onStartLoading() {
        Log.i("MainAc QuakeReport Log", "onStartLoading() ");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i("MainAc QuakeReport Log", "loadInBackground() ");
        if(mUrl == null){
            return null;
        }

        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}
