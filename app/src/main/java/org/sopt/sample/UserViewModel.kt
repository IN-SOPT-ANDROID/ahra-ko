package org.sopt.sample

import androidx.lifecycle.ViewModel
import org.sopt.sample.remote.ResponseUser

class UserViewModel : ViewModel() {
    val userList = mutableListOf<ResponseUser.User>()
}