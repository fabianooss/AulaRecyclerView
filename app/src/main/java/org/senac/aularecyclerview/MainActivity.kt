package org.senac.aularecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import org.senac.aularecyclerview.adapter.ContatoAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvContatos = findViewById<RecyclerView>(R.id.rv_contatos)

        //
        val contatos = listOf<Contato>(
            Contato("Fabiano",
            "fabiano.oss@gmail.com"),
            Contato("Teste", "teste@senac.br"),
            Contato("Teste2", "teste@senac.br")
        )

        val adapter = ContatoAdapter(contatos)
        rvContatos.adapter = adapter
        val layout = LinearLayoutManager( applicationContext)
        // val layout = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        rvContatos.layoutManager = layout

        adapter.onItemClick = {
            Toast.makeText(this, "Contato selecionado: ${it.nome}", Toast.LENGTH_SHORT).show()
        }

    }
}
