package de.syntax_institut.funappsvorlage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.funappsvorlage.data.AppRepository
import de.syntax_institut.funappsvorlage.data.remote.MemeAPI
import kotlinx.coroutines.launch

class MemesViewModel : ViewModel() {
    val repository = AppRepository(MemeAPI)
    val memes = repository.memes

    fun getMemes() {
        viewModelScope.launch {
            repository.getMemes()
        }
    }
}
