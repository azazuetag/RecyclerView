package com.mtw.alejandro.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.contacto_list_item.view.*

class ContactoListAdapter(private val contactoList: ArrayList<Contacto>)
    : RecyclerView.Adapter<ContactoListAdapter.myviewHolder>() {

    // Tres metodos que hay que sobrescribir
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):ContactoListAdapter.myviewHolder {
        //Inflar xml
        val layoutInflater = LayoutInflater.from(parent?.context)
        return myviewHolder(layoutInflater.inflate(R.layout.contacto_list_item, parent, false))

    }

    // vincular los datos con layout
    override fun onBindViewHolder(holder: myviewHolder?, position: Int) {
        holder?.bind(contactoList[position])
    }

    override fun getItemCount(): Int {
        return contactoList.size
    }

    //Referencia al archivo xml prototipe
    class myviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind (contacto: Contacto){
            itemView.tvNombre.text = contacto.nombre
            itemView.tvTelefono.text = contacto.telefono
            itemView.setOnClickListener {
                Toast.makeText(it.context, "Elemento seleccionado:" + contacto.nombre, Toast.LENGTH_LONG).show()
            }

        }
    }


}