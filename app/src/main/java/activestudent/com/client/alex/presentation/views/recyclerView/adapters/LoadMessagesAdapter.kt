package activestudent.com.client.alex.presentation.views.recyclerView.adapters

import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.views.recyclerView.holders.LoadMessagesHolder
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by alex on 12.03.2018.
 */
class LoadMessagesAdapter(val messages: ArrayList<Message>, val listener: (Message) -> Unit) : RecyclerView.Adapter<LoadMessagesHolder>() {

    override fun onBindViewHolder(holder: LoadMessagesHolder, position: Int) = holder.bind(messages[position], listener)

    override fun getItemCount() = messages.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LoadMessagesHolder = LoadMessagesHolder(LayoutInflater
            .from(parent?.context)
            .inflate(R.layout.items_messages, parent, false))
}