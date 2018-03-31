package activestudent.com.client.alex.presentation.views.recyclerView.adapters

import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Schendule
import activestudent.com.client.alex.presentation.views.recyclerView.holders.SchenduleHolder
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by alex on 28.03.2018.
 */
class SchenduleAdapter(var schendule: Schendule, var templateString: String) : RecyclerView.Adapter<SchenduleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SchenduleHolder = SchenduleHolder(LayoutInflater
            .from(parent?.context)
            .inflate(R.layout.items_schendule, parent, false))

    override fun getItemCount(): Int {
        convertSchenduleOnArray()
        return schendule.weeks[0].size * 2
    }

    override fun onBindViewHolder(holder: SchenduleHolder?, position: Int) = holder?.bind(convertSchenduleOnArray()[position],
            schendule.date_range[0], position, templateString)!!

    private fun convertSchenduleOnArray(): ArrayList<ArrayList<String>> {
        var dayOfWeek = ArrayList<ArrayList<String>>()
        for (week in 0..1)
            for (day in 0..5)
                dayOfWeek.add(schendule.weeks[week][day])
        return dayOfWeek
    }
}
