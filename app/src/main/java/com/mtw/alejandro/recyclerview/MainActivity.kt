package com.mtw.alejandro.recyclerview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var contactos: ArrayList<Contacto> = ArrayList()
    // Declaramos una variable que posteriormente se inicializa posteriormente obligatoria
    private lateinit var mylayoutManager: RecyclerView.LayoutManager
    private lateinit var myContactosAdapter: ContactoListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        addContactos()


        mylayoutManager = LinearLayoutManager(this)
        myContactosAdapter = ContactoListAdapter(contactos)

        // Para no repetir rvListaContactos en las propiedades
        rvListaContactos.apply {
            setHasFixedSize(true)
            layoutManager = mylayoutManager
            adapter = myContactosAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
    }

    private fun addContactos() {
        contactos.add(Contacto("Alex Lora", "876866767"))
        contactos.add(Contacto("Juan Perez", "43876878678"))
        contactos.add(Contacto("Abraham Alejandro", "345345456"))
        contactos.add(Contacto("Luis Guzmàn", "3422344"))
    }

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
}
