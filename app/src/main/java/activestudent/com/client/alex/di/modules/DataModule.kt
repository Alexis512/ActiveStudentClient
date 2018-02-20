package activestudent.com.client.alex.di.modules

import activestudent.com.client.alex.data.Violations
import activestudent.com.client.alex.model.Messages
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by alex on 18.02.2018.
 */
@Module
class DataModule {

    @Provides
    fun providesViolations() = Violations()

    @Singleton
    @Provides
    fun providesMessages() = Messages(null, null, null, null, null,
            null, null)


    @Singleton
    @Provides
    fun providesRetrofit() = Retrofit.Builder()
            .baseUrl("https://smartstud.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

