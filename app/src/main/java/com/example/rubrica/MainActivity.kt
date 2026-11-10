package com.example.rubrica

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveButton: Button = findViewById(R.id.save)
        val nameView: EditText = findViewById(R.id.name)
        val lastnameView: EditText = findViewById(R.id.lastname)
        val telView: EditText = findViewById(R.id.telephone)

        // Ottieni l'istanza del DAO
        val dbDAO = PeopleDatabase.getInstance(application).getDao()

        saveButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val newPerson = Person(
                    name = nameView.text.toString(),
                    surname = lastnameView.text.toString(),
                    tel = telView.text.toString()
                )
                // Avvia il task in background
                myBackgroundTask(newPerson, dbDAO)
            }
        })
    }

    private fun myBackgroundTask(p: Person, DAO: PeopleDAO) {
        Thread(Runnable {
            // Inserisci la persona nel DB
            DAO.insert(p)

            // Verifica stampando nei log tutti i cognomi salvati
            val result = DAO.getAll()
            for (e in result) {
                Log.i("gfl", e.surname.toString())
            }
        }).start()
    }
}