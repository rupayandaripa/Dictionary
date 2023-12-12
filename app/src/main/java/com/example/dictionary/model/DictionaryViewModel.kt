package com.example.dictionary.model


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionary.network.DictionaryApi
import com.example.dictionary.network.WordData
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.IOException
import kotlin.reflect.KProperty

class DictionaryViewModel : ViewModel() {
    var response : List<WordData>? by mutableStateOf(null)
    var word: String by mutableStateOf("")


    fun getMeaning() {
        viewModelScope.launch {
            try {
                response = DictionaryApi.retrofitService.getMeaning(word)
                Log.d(TAG , "Raw Json Response: $response")


            } catch(e: IOException) {
                Log.d(TAG , "its an error")

            }
        }
    }
}


