package activestudent.com.client.alex

import activestudent.com.client.alex.utils.TimeUtils
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by alex on 15.04.2018.
 */
class TimeUtilTest {

    private var timeUtil: TimeUtils? = null

    @Before
    fun setUp() {
        timeUtil = TimeUtils()
    }

    @Test
    fun testCorrectFormatData() {
        val time = SimpleDateFormat("dd MMM yyyy").format(Date())
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Date())
        assertEquals(time, timeUtil?.formatData(date))
    }


    @Test
    fun testCorrectConvertTimeSchendule() {
        var time = SimpleDateFormat("ddMMyyyy").format(Date())
        var correctTime = SimpleDateFormat("EEEE (dd.MM.YYYY)").format(Date())
        assertEquals(correctTime, timeUtil?.convertDataSchendule(time, 0))

    }

    @After
    fun destroy() {
        timeUtil = null
    }
}