package org.sopt.sample.MusicList.viewmodel

import androidx.lifecycle.ViewModel
import org.sopt.sample.remote.api.ResponseMusicShowDTO

class MusicShowViewModel : ViewModel() {
    val musicList = mutableListOf< ResponseMusicShowDTO.Data>()
}