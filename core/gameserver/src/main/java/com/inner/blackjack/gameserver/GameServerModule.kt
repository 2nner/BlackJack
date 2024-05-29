package com.inner.blackjack.gameserver

import com.inner.blackjack.gameserver.repository.GameServerRepository
import com.inner.blackjack.gameserver.repository.GameServerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GameServerModule {

    @Singleton
    @Binds
    abstract fun bindGameServerRepository(
        gameServerRepositoryImpl: GameServerRepositoryImpl
    ): GameServerRepository
}