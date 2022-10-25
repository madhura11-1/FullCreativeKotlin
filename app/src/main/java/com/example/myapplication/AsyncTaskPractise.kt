package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AsyncTaskPractise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_practise)
    }


    inner class PlayMusic() : AsyncTask<Void,Void,String>(){

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): String {
            TODO("Not yet implemented")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

        }


    }

}