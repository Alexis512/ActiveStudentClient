package activestudent.com.client.alex.presentation.views.recyclerView.adapters

import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.ViolationsItems
import activestudent.com.client.alex.presentation.views.recyclerView.holders.ViolationsHolder
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by alex on 14.02.2018.
 */
class ViolationsAdapter(val items: ArrayList<ViolationsItems>, val listener : (ViolationsItems) -> Unit)
    : RecyclerView.Adapter<ViolationsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViolationsHolder(LayoutInflater
            .from(parent?.context)
            .inflate(R.layout.items_layout, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViolationsHolder, position: Int) = holder.bind(items[position], listener)

}