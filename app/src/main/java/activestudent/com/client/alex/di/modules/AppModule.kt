package activestudent.com.client.alex.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by alex on 08.02.2018.
 */

@Module
class AppModule(private val app : Application) {

    @Provides
    fun providesApp() = app

    @Provides
    fun providesContext(): Context = app
}