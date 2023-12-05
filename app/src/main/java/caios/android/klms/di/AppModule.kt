package caios.android.klms.di

import caios.android.klms.BuildConfig
import caios.android.klms.core.common.KlmsConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKlmsConfig(): KlmsConfig {
        return KlmsConfig(
            applicationId = BuildConfig.APPLICATION_ID,
            buildType = BuildConfig.BUILD_TYPE,
            versionCode = BuildConfig.VERSION_CODE,
            versionName = BuildConfig.VERSION_NAME,
            isDebug = BuildConfig.DEBUG,
            developerPassword = BuildConfig.DEVELOPER_PASSWORD,
        )
    }
}
