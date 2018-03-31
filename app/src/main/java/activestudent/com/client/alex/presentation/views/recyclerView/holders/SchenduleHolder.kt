package activestudent.com.client.alex.presentation.views.recyclerView.holders

import activestudent.com.client.alex.utils.TimeUtils
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import kotlinx.android.synthetic.main.items_schendule.view.*
import java.util.*

@Suppress("DEPRECATION")
class SchenduleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ArrayList<String>, data: String, position: Int, templateString: String) {
        val converterTime = TimeUtils()
        var dateSchendule = converterTime.convertDataSchendule(data, position)
        itemView.tvDayWeek.text = dateSchendule.substring(0, 1).toUpperCase() + dateSchendule.substring(1)
        for (lesson in 0..6)
            if (item[lesson] == "")
                item[lesson] = "----"
        val lessonsSchendule = String.format(templateString, item[0], item[1], item[2], item[3], item[4], item[5], item[6])
        itemView.tvLessons.text = Html.fromHtml(lessonsSchendule)
    }


}