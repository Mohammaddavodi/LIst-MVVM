package com.example.notebookmvvm.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notebookmvvm.Model.Note
import java.util.concurrent.locks.Lock


@Database(entities = [Note::class], version = 1,exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object{
        @Volatile
        private var instace: NoteDataBase? = null
        private var Lock = Any()

        operator fun invoke(context: Context)= instace ?:
        synchronized(Lock){
            instace?:
            createDatabase(context).also{
                instace=it
            }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                NoteDataBase::class.java,
                "note_database"
            ).build()
    }


}