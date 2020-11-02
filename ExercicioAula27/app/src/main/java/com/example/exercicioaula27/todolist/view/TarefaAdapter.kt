package com.example.exercicioaula27.todolist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercicioaula27.R
import com.example.exercicioaula27.todolist.model.Tarefa

class TarefaAdapter(private val dataSet: List<Tarefa>) :
    RecyclerView.Adapter<TarefaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}