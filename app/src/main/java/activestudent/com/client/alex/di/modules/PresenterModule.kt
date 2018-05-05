package activestudent.com.client.alex.di.modules

import activestudent.com.client.alex.presentation.mvp.presenter.student.*
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.*
import dagger.Module
import dagger.Provides

/**
 * Created by alex on 03.05.2018.
 */

@Module
class PresenterModule {

    @Provides
    fun providesAuthPresenter(presenterImpl: MainActivityPresenterImpl): MainActivityPresenter = presenterImpl

    @Provides
    fun providesAccountPresenter(presenterImpl: AccountPresenterImpl): AccountPresenter = presenterImpl

    @Provides
    fun providesViolationsPresenter(presenterImpl: CreatureViolationsPresenterImpl): CreatureViolationsPresenter = presenterImpl

    @Provides
    fun providesDetailPresenter(presenterImpl: DetailMessagePresenterImpl): DetailMessagePresenter = presenterImpl

    @Provides
    fun providesEditMessagePresenter(presenterImpl: EditMessagePresenterImpl): EditMessagePresenter = presenterImpl

    @Provides
    fun providesMyMessagePresenter(presenterImpl: MyMessagesPresenterImpl): MyMessagesPresenter = presenterImpl

    @Provides
    fun providesSchendulePresenter(presenterImpl: SchenduleLessonsPresenterImpl): SchendulePresenter = presenterImpl
}