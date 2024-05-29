package com.inner.blackjack.feature.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inner.blackjack.gameserver.repository.GameServerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gameServerRepository: GameServerRepository,
) : ViewModel() {

    private val _event = MutableSharedFlow<Event>()
    val event = _event.asSharedFlow()

    fun createRoom() {
        this.gameServerRepository.createServer()
            .takeIf { it > 0 }
            ?.let { roomCode ->
                viewModelScope.launch {
                    _event.emit(Event.ShowSnackbar("Room Created"))
                    _event.emit(Event.NavigateToGame(roomCode))
                }
            }
    }

    fun enterRoom(enterCode: Int) {
        this.gameServerRepository.connectServer(enterCode)
    }

    sealed interface Event {
        data object Idle : Event
        data class ShowSnackbar(val message: String) : Event
        data class NavigateToGame(val roomCode: Int) : Event
    }
}