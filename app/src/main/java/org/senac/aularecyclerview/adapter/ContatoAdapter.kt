package org.senac.aularecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contato.view.*
import org.senac.aularecyclerview.Contato
import org.senac.aularecyclerview.R

class ContatoAdapter(val contatos: List<Contato>) : RecyclerView.Adapter<ContatoAdapter.MyViewHolder>() {

    var onItemClick: ((Contato) -> Unit)? = null
    var onEmailClick: ((Contato) -> Unit)? = null

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvNomeContato = view.findViewById<TextView>(R.id.tv_nome_contato)
        val tvEmailContato = view.findViewById<TextView>(R.id.tv_email_contato)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(contatos.get(adapterPosition))
            }

            tvEmailContato.setOnClickListener {
                onEmailClick?.invoke(contatos.get(adapterPosition))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemContatoView = LayoutInflater
                    .from(parent.context).inflate(R.layout.item_contato, parent,
            false)
        return MyViewHolder(itemContatoView)
    }

    override fun getItemCount(): Int {
       return contatos.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNomeContato.text = contatos.get(position).nome
        holder.tvEmailContato.text = contatos.get(position).email
    }
}