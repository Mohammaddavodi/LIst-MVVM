package com.example.notebookmvvm.Repository

import androidx.room.Query
import com.example.notebookmvvm.DataBase.NoteDataBase
import com.example.notebookmvvm.Model.Note

class NoteRepository(private val db:NoteDataBase) {
    suspend fun insertNote(note:Note)=db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note:Note)=db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note:Note)=db.getNoteDao().updateNote(note)

    fun getAllNotes()=db.getNoteDao().getAllNotes()
    fun searchNote(query: String?)=db.getNoteDao().searchNote(query)
}