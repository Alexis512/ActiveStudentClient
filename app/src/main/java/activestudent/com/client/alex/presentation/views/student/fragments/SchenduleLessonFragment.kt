package activestudent.com.client.alex.presentation.views.student.fragments

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Schendule
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.SchenduleLessonsPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.SchenduleView
import activestudent.com.client.alex.presentation.views.recyclerView.adapters.SchenduleAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schendule_lesson.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


class SchenduleLessonFragment : Fragment(), SchenduleView {

    @Inject
    lateinit var shenduleLessnonsLessonsPresenter: SchenduleLessonsPresenterImpl

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        App.component.inject(this)
        shenduleLessnonsLessonsPresenter.attachView(this)
        shenduleLessnonsLessonsPresenter.loadSchendule()
        return inflater!!.inflate(R.layout.fragment_schendule_lesson, container, false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        shenduleLessnonsLessonsPresenter.detachView()
    }

    override fun onSuccessLoadSchendule(schendule: Schendule) {
        pbLoadinSchendule.visibility = View.GONE
        tvGroup.text = schendule.group
        rvSchendule.layoutManager = LinearLayoutManager(context)
        rvSchendule.hasFixedSize()
        rvSchendule.adapter = SchenduleAdapter(schendule,
                activity.getString(R.string.schenduleLessons))
    }


    override fun onFailureLoadSchendule() {
        pbLoadinSchendule.visibility = View.GONE
        toast("Не удалось загрузить расписание")
    }


}
