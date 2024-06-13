package com.inner.blackjack.gameserver.service

import io.socket.client.IO
import io.socket.client.Socket
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class BlackJackSocketService {

    private val lock = Mutex()
    private var socket: Socket? = null

    suspend fun createSocket(): Int {
        lock.withLock {
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
    }

    suspend fun connectSocket(enterCode: Int) {
        lock.withLock {
            try {
                val socket = IO.socket("http://localhost:$enterCode")
                socket.connect()
                this.socket = socket
            } catch (e: Exception) {
                disconnectSocket()
            }
        }
    }

    suspend fun disconnectSocket() {
        lock.withLock {
            this.socket?.disconnect()
            this.socket = null
        }
    }
}