package com.upwiththekite.timethembeta2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import io.realm.Realm

class TimeEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_event)

        val eventId = intent.getStringExtra("event")

        val realm = Realm.getDefaultInstance()
        val result = realm.where(Event::class.java).equalTo("id", eventId).findFirst()

        title = result?.name
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
