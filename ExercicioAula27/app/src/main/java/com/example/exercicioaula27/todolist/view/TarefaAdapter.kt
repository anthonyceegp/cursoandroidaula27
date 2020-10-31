package com.example.exercicioaula27.todolist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.exercicioaula27.R
import com.example.exercicioaula27.todolist.model.Todo
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import kotlinx.android.synthetic.main.fragment_tarefa.view.*

class TarefaAdapter(private val dataSet:List<Todo>):RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    class TarefaViewHolder(view:View):RecyclerView.ViewHolder(view){
        private val ckbTodo: MaterialCheckBox = view.findViewById(R.id.ckbToDo)

        fun bind(task:Todo){
            ckbTodo.text=task.tarefa
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_tarefa,parent,false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount()=dataSet.size

}