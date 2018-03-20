package activestudent.com.client.alex.di.components

import activestudent.com.client.alex.di.modules.*
import activestudent.com.client.alex.presentation.views.*
import android.app.Application
import dagger.Component
import javax.inject.Singleton

/**
 * Created by alex on 08.02.2018.
 */
@Singleton
@Component (modules = arrayOf(AppModule :: class,
        StudentRoleModule :: class,
        UtilsModule :: class,
        DataModule :: class))

interface AppComponent {

    fun inject(app: Application)
    fun inject(studentRoleActivity: StudentRoleActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(violationsActivity: ViolationsActivity)
    fun inject(creatureViolationsActivity: CreatureViolationsActivity)
    fun inject(accountStudent: AccountStudent)
    fun inject(messagesActivity: MyMessagesActivity)
    fun inject(detailMessageActivity: DetailMessageActivity)
    fun inject(editMessageActivity: EditMessageActivity)
}
