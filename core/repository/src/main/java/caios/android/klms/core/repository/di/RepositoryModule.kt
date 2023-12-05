package caios.android.klms.core.repository.di

import caios.android.klms.core.repository.UserDataRepository
import caios.android.klms.core.repository.UserDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindUserDataRepository(userDataRepository: UserDataRepositoryImpl): UserDataRepository
}
