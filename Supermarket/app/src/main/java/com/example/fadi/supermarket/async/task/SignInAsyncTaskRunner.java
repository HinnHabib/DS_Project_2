package com.example.fadi.supermarket.async.task;

import android.os.AsyncTask;

import com.example.fadi.supermarket.util.HttpManager;

/**
 * Created by Mohammad on 7/30/2017.
 */

public class SignInAsyncTaskRunner extends AsyncTask<String, String, Boolean> {

    private AsyncResponse asyncResponse;

    public SignInAsyncTaskRunner(AsyncResponse asyncResponse) {
        this.asyncResponse = asyncResponse;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {

        return HttpManager.signIn(params[0], params[1]);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        asyncResponse.processData(result);
    }
}
