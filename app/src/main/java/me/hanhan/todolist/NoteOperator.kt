package me.hanhan.todolist

import me.hanhan.todolist.beans.Note

interface NoteOperator {
    fun deleteNote(note: Note?)
    fun updateNote(note: Note?)
}