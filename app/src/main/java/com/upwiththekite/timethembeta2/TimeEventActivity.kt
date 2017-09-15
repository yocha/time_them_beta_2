package com.upwiththekite.timethembeta2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        menuInflater.inflate(R.menu.menu_time_event, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        val eventId = intent.getStringExtra("event")
        val realm = Realm.getDefaultInstance()
        val result = realm.where(Event::class.java).equalTo("id", eventId).findFirst()

        return when (item.itemId) {
            R.id.deleteEventItem -> {
                realm.beginTransaction()
                result?.deleteFromRealm()
                realm.commitTransaction()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
