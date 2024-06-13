package com.inner.blackjack.gameserver.repository

interface GameServerRepository {
    suspend fun createServer(): Int
    suspend fun connectServer(enterCode: Int)
    suspend fun disconnectServer()
}