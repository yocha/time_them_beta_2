package com.upwiththekite.timethembeta2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import io.realm.Realm

class AddEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        title = "Add Event"

        val addEventButton = findViewById<Button>(R.id.addNewEventbutton)
        addEventButton.setOnClickListener {
            val addEventNameEditText = findViewById<EditText>(R.id.newEventNameEditText)
            val eventName = addEventNameEditText.text.toString()
            if (eventName.isNotBlank()) {
                val event = Event()
                event.name = eventName
                val realm = Realm.getDefaultInstance()
                realm.beginTransaction()
                realm.copyToRealm(event)
                realm.commitTransaction()
                finish()
            } else {

            }
        }


    }
}
