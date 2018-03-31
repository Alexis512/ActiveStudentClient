package activestudent.com.client.alex.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by alex on 16.03.2018.
 */
class TimeUtils {

    fun formatData(date: String?): String {
        var oldFormatDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var newFormatDate = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        return newFormatDate.format(oldFormatDate.parse(date))
    }

    fun convertDataSchendule(date: String, position: Int): String {
        val formatter = SimpleDateFormat("ddMMyyyy")
        val dataFormat = SimpleDateFormat("EEEE (dd.MM.YYYY)")
        var calendar = Calendar.getInstance()
        calendar.time = formatter.parse(date)
        if (position < 6)
            calendar.add(Calendar.DATE, position)
        else calendar.add(Calendar.DATE, position + 1)
        var newTime = formatter.format(calendar.time)
        return dataFormat.format(formatter.parse(newTime.toString()))
    }
}