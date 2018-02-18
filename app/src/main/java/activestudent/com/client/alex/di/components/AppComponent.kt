package activestudent.com.client.alex.di.components

import activestudent.com.client.alex.di.modules.AppModule
import activestudent.com.client.alex.di.modules.DataModule
import activestudent.com.client.alex.di.modules.StudentRoleModule
import activestudent.com.client.alex.presentation.views.CreatureViolationsActivity
import activestudent.com.client.alex.presentation.views.MainActivity
import activestudent.com.client.alex.presentation.views.StudentRoleActivity
import activestudent.com.client.alex.presentation.views.ViolationsActivity
import android.app.Application
import dagger.Component
import javax.inject.Singleton

/**
 * Created by alex on 08.02.2018.
 */
@Singleton
@Component (modules = arrayOf(AppModule :: class,
        StudentRoleModule :: class,
        DataModule :: class))

interface AppComponent {

    fun inject(app: Application)
    fun inject(studentRoleActivity: StudentRoleActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(violationsActivity: ViolationsActivity)
    fun inject(creatureViolationsActivity: CreatureViolationsActivity)
}
