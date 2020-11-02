package com.example.exercicioaula27.todolist.view

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercicioaula27.R
import com.example.exercicioaula27.todolist.model.Tarefa

class TarefaAdapter(
        private val dataSet: MutableList<Tarefa>) : RecyclerView.Adapter<TarefaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = dataSet[position]
        holder.apply {
            bind(tarefa)
            ckbTodo.setOnClickListener {
                tvNomeTarefa.paintFlags =
                    if (ckbTodo.isChecked) {
                        tvNomeTarefa.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    } else {
                        tvNomeTarefa.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                    }
            }

            ivDeletar.setOnClickListener {
                val index = dataSet.indexOf(tarefa)
                dataSet.removeAt(index)
                notifyItemRemoved(index)
            }
        }
    }

    override fun getItemCount() = dataSet.size
}