package br.android.iddog.di.module

import br.android.iddog.data.DogsRepository
import br.android.iddog.data.remote.DogAPIService
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module(includes = [
    NetModule::class,
    AppModule::class
])

class RepositoryModule {
    @Provides
    @Singleton
    fun provideAPIRepository(
        apiService: DogAPIService,
        executor: Executor
    ): DogsRepository {
        return DogsRepository(apiService, executor)
    }
}