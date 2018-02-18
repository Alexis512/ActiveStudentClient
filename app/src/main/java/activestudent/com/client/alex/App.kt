package activestudent.com.client.alex

import activestudent.com.client.alex.di.components.AppComponent
import activestudent.com.client.alex.di.components.DaggerAppComponent
import activestudent.com.client.alex.di.modules.AppModule
import android.app.Application

/**
 * Created by alex on 08.02.2018.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        component.inject(this)
    }

  companion object {
        lateinit var component : AppComponent
   }




}