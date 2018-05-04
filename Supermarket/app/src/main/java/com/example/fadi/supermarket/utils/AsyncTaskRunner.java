package com.example.fadi.supermarket.utils;

import android.os.AsyncTask;

/**
 * Created by Mohammad on 7/30/2017.
 */

public class AsyncTaskRunner extends AsyncTask<String, String, String> {

    private AsyncResponse asyncResponse;

    public AsyncTaskRunner(AsyncResponse asyncResponse) {
        this.asyncResponse = asyncResponse;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        return HttpManager.getData(params[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        asyncResponse.processData(result);
    }
}
