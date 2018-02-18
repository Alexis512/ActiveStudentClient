package activestudent.com.client.alex.di.modules

import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.utils.PhotoUtils
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by alex on 09.02.2018.
 */
@Module
class StudentRoleModule {

   @Provides
    fun providesFileUtils(context: Context) = PhotoUtils(context)

    @Provides
    fun providesSharedPref(context: Context) = UserData(context)
}