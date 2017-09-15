package com.upwiththekite.timethembeta2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import io.realm.Realm

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            var addEventIntent = Intent(this, AddEventActivity::class.java)
            startActivity(addEventIntent)
        }
    }

    override fun onResume() {
        super.onResume()

        val realm = Realm.getDefaultInstance()
        val query = realm.where(Event::class.java)
        val results = query.findAll()
        val eventListView = findViewById<ListView>(R.id.eventListView)

        eventListView.setOnItemClickListener { _, _, i, _ ->
            val selectEvent = results[i]
            val timeEventIntent = Intent(this, TimeEventActivity::class.java)
            timeEventIntent.putExtra("event", selectEvent.getId())
            startActivity(timeEventIntent)
        }

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, results)
        eventListView.adapter = adapter
    }

    /*

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    */
}
