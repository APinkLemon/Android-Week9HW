package me.hanhan.todolist.ui;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import me.hanhan.todolist.NoteOperator
import me.hanhan.todolist.R
import me.hanhan.todolist.beans.Note
import java.util.ArrayList

class NoteListAdapter(operator: NoteOperator) :
    RecyclerView.Adapter<NoteViewHolder?>() {
    private val operator: NoteOperator = operator
    private val notes: MutableList<Note> = ArrayList<Note>()
    fun refresh(newNotes: List<Note>?) {
        notes.clear()
        if (newNotes != null) {
            notes.addAll(newNotes)
        }
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, pos: Int): NoteViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView, operator)
    }

    override fun onBindViewHolder(@NonNull holder: NoteViewHolder, pos: Int) {
        holder.bind(notes[pos])
    }

    override fun getItemCount(): Int = notes.size

}
