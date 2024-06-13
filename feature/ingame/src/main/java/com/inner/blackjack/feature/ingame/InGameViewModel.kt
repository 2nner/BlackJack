package com.inner.blackjack.feature.ingame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inner.blackjack.gameserver.repository.GameServerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InGameViewModel @Inject constructor(
    private val gameServerRepository: GameServerRepository,
) : ViewModel() {

    fun exitGame() {
        viewModelScope.launch {
            gameServerRepository.disconnectServer()
        }
    }
}