package com.example.exercicioaula27.todolist.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercicioaula27.R
import com.example.exercicioaula27.todolist.model.Tarefa
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ListaTarefasFragment(private val mainContext: Context) : Fragment() {
    private lateinit var viewLista: View
    private val tarefas = arrayListOf(
        Tarefa("Tarefa 1"),
        Tarefa("Tarefa 2", true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLista = inflater.inflate(R.layout.fragment_lista_tarefas, container, false)

        val viewManager = LinearLayoutManager(context)
        val recycler = viewLista.findViewById<RecyclerView>(R.id.rvLista)
        val viewAdapter = TarefaAdapter(tarefas)
        val btnAddNew = viewLista.findViewById<Button>(R.id.btnAddNewTodo)

        recycler.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        btnAddNew.setOnClickListener {
            val alertDialog = MaterialAlertDialogBuilder(mainContext)
            val layout = layoutInflater.inflate(R.layout.alert_dialog_new_todo, null)

            val btnOk = layout.findViewById<Button>(R.id.btnAddAlert)
            val btnCancel = layout.findViewById<Button>(R.id.btnCancelAlert)
            btnOk.setOnClickListener {
                Toast.makeText(mainContext, "add", Toast.LENGTH_LONG).show()
            }
            btnCancel.setOnClickListener {
                Toast.makeText(mainContext, "cancel", Toast.LENGTH_LONG).show()
            }
            alertDialog.apply {
                setView(layout)
                show()
            }
        }

        return viewLista
    }

    companion object {
//        fun newInstance() = ListaTarefasFragment()
    }
}