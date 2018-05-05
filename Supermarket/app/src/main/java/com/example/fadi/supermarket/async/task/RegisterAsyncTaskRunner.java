package com.example.fadi.supermarket.async.task;

import android.os.AsyncTask;

import com.example.fadi.supermarket.util.HttpManager;

/**
 * Created by Mohammad on 7/30/2017.
 */

public class RegisterAsyncTaskRunner extends AsyncTask<String, String, Boolean> {

    private AsyncResponse asyncResponse;

    public RegisterAsyncTaskRunner(AsyncResponse asyncResponse) {
        this.asyncResponse = asyncResponse;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {

        return HttpManager.register(params[0], params[1], params[2]);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        asyncResponse.processData(result);
    }
}
