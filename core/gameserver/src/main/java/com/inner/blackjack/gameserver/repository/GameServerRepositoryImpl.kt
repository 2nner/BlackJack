package com.inner.blackjack.gameserver.repository

import com.inner.blackjack.gameserver.service.BlackJackSocketService
import javax.inject.Inject

class GameServerRepositoryImpl @Inject constructor(
    private val socketService: BlackJackSocketService,
) : GameServerRepository {

    override fun createServer(): Int {
        return this.socketService.createSocket()
    }

    override fun connectServer(enterCode: Int) {
        this.socketService.connectSocket(enterCode)
    }
}