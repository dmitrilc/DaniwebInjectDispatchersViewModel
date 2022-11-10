package com.hoang.daniwebinjectdispatchersviewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    // injected example
    init {
        viewModelScope.launch(ioDispatcher){
            Log.d("MyViewModel", "IO Dispatcher")
        }
    }

    // Hard-coding example
    init {
        // ViewModelScope already uses Dispatchers.Main by default
        viewModelScope.launch(Dispatchers.Default) {

        }
    }

    // Hard-coding example
    private fun hardCodingTest(){
        viewModelScope.launch(Dispatchers.IO){
            // Do IO work
        }
    }
}