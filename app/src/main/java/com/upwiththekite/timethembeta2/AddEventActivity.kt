package com.upwiththekite.timethembeta2

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import io.realm.Realm

class AddEventActivity : AppCompatActivity() {

    internal var builder: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        title = "Add Event"

        val addEventButton = findViewById<Button>(R.id.addNewEventbutton)
        addEventButton.setOnClickListener {
            val addEventNameEditText = findViewById<EditText>(R.id.newEventNameEditText)
            val eventName = addEventNameEditText.text.toString()
            if (eventName.isNotBlank()) {
                val realm = Realm.getDefaultInstance()
                val result = realm.where(Event::class.java).equalTo("name", eventName).findFirst()
                if (result == null) {
                    val event = Event()
                    event.name = eventName
                    realm.beginTransaction()
                    realm.copyToRealm(event)
                    realm.commitTransaction()
                    finish()
                } else {
                    showAlert("Duplicate event found!")
                }
            } else {
                showAlert("Event name can't be blank!")
            }
        }

        builder = AlertDialog.Builder(this@AddEventActivity)
    }

    private fun showAlert(message: String = "") {
        builder!!.setMessage(message)
        builder!!.show()
    }

}
