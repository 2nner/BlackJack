package com.inner.blackjack.gameserver.service

import io.socket.client.IO
import io.socket.client.Socket

class BlackJackSocketService {

    private var socket: Socket? = null

    fun createSocket(): Int {
        repeat(5) {
            val port = (10000..65535).random()
            val socket = IO.socket("http://localhost:$port")

            try {
                if (!socket.isActive) {
                    this.socket = socket.open()
                    socket.connect()
                }
                return port
            } catch (e: Exception) {
                disconnectSocket()
            }
        }

        return -1
    }

    fun connectSocket(enterCode: Int) {
        try {
            val socket = IO.socket("http://localhost:$enterCode")
            socket.connect()
            this.socket = socket
        } catch (e: Exception) {
            disconnectSocket()
        }
    }

    fun disconnectSocket() {
        this.socket?.disconnect()
        this.socket = null
    }
}