package org.sopt.sample.User

import androidx.lifecycle.ViewModel
import org.sopt.sample.remote.api.ResponseUser

class UserViewModel : ViewModel() {
    val userList = mutableListOf<ResponseUser.User>()}