package com.inner.blackjack.gameserver.repository

interface GameServerRepository {
    fun createServer(): Int
    fun connectServer(enterCode: Int)
}