package de.syntax_institut.funappsvorlage.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.funappsvorlage.data.model.Meme
import de.syntax_institut.funappsvorlage.data.remote.MemeAPI

const val TAG = "AppRepositoryTAG"

/**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 */
class AppRepository(private val api: MemeAPI) {

    private val _memes = MutableLiveData<List<Meme>>()
    val memes: LiveData<List<Meme>>
        get() = _memes

    suspend fun getMemes() {
        try {
            val result = api.service.getMemes()
            _memes.postValue(result.data.memes)
        } catch (e: Exception) {
            Log.e(TAG, "Fehler beim fetchen der Meme Daten: ${e.message}")
        }
    }
}
