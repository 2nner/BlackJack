package com.inner.blackjack.gameserver

import com.inner.blackjack.gameserver.service.BlackJackSocketService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SocketModule {

    @Singleton
    @Provides
    fun provideSocketService(): BlackJackSocketService = BlackJackSocketService()
}