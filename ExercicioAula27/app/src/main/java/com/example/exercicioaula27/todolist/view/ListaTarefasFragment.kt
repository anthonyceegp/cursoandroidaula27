package com.example.exercicioaula27.todolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercicioaula27.R
import com.example.exercicioaula27.todolist.model.Tarefa

class ListaTarefasFragment : Fragment() {
    private lateinit var viewLista: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLista = inflater.inflate(R.layout.fragment_lista_tarefas, container, false)

        val viewManager = LinearLayoutManager(context)
        val recyclerView = viewLista.findViewById<RecyclerView>(R.id.rvLista)
        val viewAdapter = TarefaAdapter(
            arrayListOf(
                Tarefa("Tarefa 1"),
                Tarefa("Tarefa 2", true)
            )
        )

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        return viewLista
    }

    companion object {
        fun newInstance() = ListaTarefasFragment()
    }
}