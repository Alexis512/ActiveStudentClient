package activestudent.com.client.alex.presentation.mvp.presenterImpls.student

import activestudent.com.client.alex.domain.SchenduleLisctenerInteractor
import activestudent.com.client.alex.domain.student.SchenduleInteracor
import activestudent.com.client.alex.model.Schendule
import activestudent.com.client.alex.presentation.mvp.presenter.student.SchendulePresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.SchenduleView
import javax.inject.Inject

/**
 * Created by alex on 28.03.2018.
 */
class SchenduleLessonsPresenterImpl @Inject constructor(val schenduleInteractor: SchenduleInteracor) :
        BaseMvpPresenterImpl<SchenduleView>(), SchendulePresenter, SchenduleLisctenerInteractor {

    init {
        schenduleInteractor.setPresenterListener(this)
    }

    override fun loadSchendule() {
        schenduleInteractor.getSchendule("7520", "spring")
    }

    override fun onSuccessLoadSchendule(schendule: Schendule) {
        mView?.onSuccessLoadSchendule(schendule)
    }

    override fun onFailureLoadSchendule() {
        mView?.onFailureLoadSchendule()
    }

}