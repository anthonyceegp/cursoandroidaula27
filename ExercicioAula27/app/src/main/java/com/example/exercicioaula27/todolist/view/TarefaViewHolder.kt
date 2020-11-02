package com.example.exercicioaula27.todolist.view

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exercicioaula27.R
import com.example.exercicioaula27.todolist.model.Tarefa
import com.google.android.material.checkbox.MaterialCheckBox

class TarefaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ckbTodo: MaterialCheckBox = view.findViewById(R.id.ckbToDo)
    val tvNomeTarefa: TextView = view.findViewById(R.id.tvNomeTarefa)
    val ivDeletar: ImageView = view.findViewById(R.id.ivDeletar)

    fun bind(tarefa: Tarefa) {
        ckbTodo.isChecked = tarefa.isDone
        tvNomeTarefa.apply {
            text = tarefa.nome
            if (tarefa.isDone) {
                paintFlags = tvNomeTarefa.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
    }
}