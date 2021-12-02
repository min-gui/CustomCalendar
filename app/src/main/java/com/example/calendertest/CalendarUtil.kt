package com.example.calendertest

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class CalendarUtil {
    val TAG = javaClass.simpleName

    companion object {
        const val DAYS_OF_WEEK = 7
        const val LOW_OF_CALENDAR = 6
    }


    var mCalendar = Calendar.getInstance()
    var preMonthEndDays = 0
    var nextMonthStartDays = 0
    var currentMonthDate = 0

    var data = arrayListOf<CalendarData>()


    //month 구하기.
    fun setCalender() {

        mCalendar.time = Date()
        //달은 0부터 시작 한다.
        mCalendar.set(2021, 1, 12)
//        cal.set(2021, 5,12)


        //makeMonthDate(mCalendar)
        moveToPrevMonth(mCalendar)
    }

    fun moveToNextMonth(calendar: Calendar) {
        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1)
            calendar.set(Calendar.MONTH, 0)
        } else {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1)
        }

        makeMonthDate(calendar)
    }

    fun moveToPrevMonth(calendar: Calendar) {
        if (calendar.get(Calendar.MONTH) == 0) {
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1)
            calendar.set(Calendar.MONTH, Calendar.DECEMBER)
        } else {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1)
        }
        makeMonthDate(calendar)
    }

    fun makeMonthDate(calendar: Calendar): ArrayList<CalendarData> {
        data.clear()

        //현재 month 첫날.
        calendar.set(Calendar.DATE, 1)

        //현재 month 날짜수 구하기
        currentMonthDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        //이전달 현재달력에서 표시에 줄 숫자 갯
        preMonthEndDays = calendar.get(Calendar.DAY_OF_WEEK) - 1


        makePreMonthTail(calendar.clone() as Calendar)
        makeCurrentMonth(calendar)
        // 다음달 날짜 현재 달력에 표시.
        nextMonthStartDays = LOW_OF_CALENDAR * DAYS_OF_WEEK - (preMonthEndDays + currentMonthDate)
        makeNextMonthHead(calendar.clone() as Calendar)


        /*for (i in 0 until data.size) {
            Log.e(TAG, "data : " + data.get(i))
        }*/
        return data
    }

    //month 날짜수 구하는 메소드.
    private fun makeCurrentMonth(calendar: Calendar) {
        for (i in 1..calendar.getActualMaximum(Calendar.DATE)) {

            var calendarData = CalendarData(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                i
            )
            data.add(calendarData)
        }
    }

    //현재 달에서 이전 달 날짜 표현 해주는 함수.
    private fun makePreMonthTail(calendar: Calendar) {
        //이전달로 fix 예)현재 5월달 이전달 4 .
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1)

        //이전달 날짜수
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        var maxOffsetDate = maxDate - preMonthEndDays

        for (i in 1..preMonthEndDays) {
            var calendarData = CalendarData(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                ++maxOffsetDate
            )
            data.add(calendarData)
        }


    }

    private fun makeNextMonthHead(calendar: Calendar) {
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1)

        var date = 1
        for (i in 1..nextMonthStartDays) {
            var calendarData = CalendarData(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                date++
            )
            data.add(calendarData)
        }
    }

}