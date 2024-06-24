package com.example.sporkingapp.di


import com.example.sporkingapp.data.AppConstrants
import com.example.sporkingapp.data.api.APIService
import com.example.sporkingapp.data.datasource.NewsRepositoryImpl
import com.example.sporkingapp.data.firebase.AuthRepository
import com.example.sporkingapp.data.firebase.AuthRepositoryImpl
import com.example.sporkingapp.repository.NewsRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun profideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: APIService): NewsRepository{
        return NewsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): APIService {
        return Retrofit.Builder()
            .baseUrl(AppConstrants.APP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }



}