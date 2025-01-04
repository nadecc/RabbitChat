package com.rabbitchat.rabbitchat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rabbitchat.rabbitchat.models.User

class MainViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        _user.value = User("Vasily")
    }

    fun updateUserName(name: String) {
        _user.value = _user.value?.copy(name = name)
    }
}
