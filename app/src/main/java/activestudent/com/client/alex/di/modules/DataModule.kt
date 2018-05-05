package activestudent.com.client.alex.di.modules

import activestudent.com.client.alex.data.Violations
import activestudent.com.client.alex.model.Message
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by alex on 18.02.2018.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    fun providesViolations() = Violations()

    @Singleton
    @Provides
    fun providesRetrofit() = Retrofit.Builder()
            .baseUrl("https://smart-student-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    @Named("RetrofitForSchendule")
    fun providesRetrifitSchedule() = Retrofit.Builder()
            .baseUrl("http://vyatsuscheduleapi.herokuapp.com/vyatsu/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}

