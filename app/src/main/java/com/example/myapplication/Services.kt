package com.example.myapplication

/*

Why service we if have async task :  services help do task continuously in background
                                     async task does the task and is destroyed

Service -> appliaction component that performs long tasks in the background
           It does not require any UI interaction
           switch to another app also or app is closed

           Trigerred from : Any thread
           Runs On : Main Thread

           Not bound to activity lifecycle

           May block main thread

           eh : downloading data, play music,


           Asynctask vs Service :

           asyntask has UI interactions but service does not
           asyntask published from Main thread goes to worker thread and comes to publish the changes again to Main thread

           Thread bs Sercies :

           thread is OS provided to run tasks in backgeounr
           Services is android component which uses the thread to run in background with no UI interaction


           Types :

           Foreground Service : it shows status of service in status bar
                                music, audio playing

           Background Service : operations not noticeble to user
                                doing some db storing, checking notifications from db, syncing

           Bound Service : appliaction components (activity and frag) are bound to this service
                            costantly u get data from service (seek bar in music player rovided u the data)
                           if components unbind it is killed


          Intent Service : subclass of Service
                           handles one request at a time only (no simultaneous execution)
                           Triggered from : Main Thread and passed to worker thread to handle it




            started service                      Bound service

            run for infinite time               stops when all are unbinded or else keeping running even if app is closed

            self kill or stopped by client


            Life cycle :

            startService()                      bindService()
            oncreate                            oncreate
            onstart                             onbind
            runs                                runs
            stops                               unbind
            onDestory                            ondestroy
 */
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

// User defined service started service
class Services : Service() {

    private lateinit var player:MediaPlayer


   //activity calls onStart methods which calls onStartCoammnd method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.setLooping(true)
        player.start()
        return START_STICKY       // if service terminated restared again
    }

    // called on StopService()
    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    //compusory override this method when creating a  service
    override fun onBind(intent: Intent): IBinder? {
        // returned null as we r not binging component here
        return null
    }
}


