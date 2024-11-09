package com.example.notebookmvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notebookmvvm.DataBase.NoteDataBase
import com.example.notebookmvvm.Repository.NoteRepository
import com.example.notebookmvvm.ViewModel.NoteViewModel
import com.example.notebookmvvm.ViewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()

    }
    private fun setUpViewModel(){
        val noteRepository=NoteRepository(NoteDataBase(this))
        val viewModelProviderFactory=NoteViewModelFactory(application,noteRepository)
        noteViewModel=ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}