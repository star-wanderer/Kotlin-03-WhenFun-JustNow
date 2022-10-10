package ru.netology

    val secondsInAMinute = 60L
    val secondsInAnHour = secondsInAMinute * 60L
    val secondsInADay = secondsInAnHour * 24L

fun main (){

    var secondsAgo = 300L
    var userName = "Ф.Крюгер"

    println("Некто $userName был поблизости ${agoToText(secondsAgo)} ")
}

fun agoToText (seconds: Long): String {
    var value = "только что"
    when {
        seconds >= 3 * secondsInADay -> value = "давно"
        seconds in (2 * secondsInADay) until(3 * secondsInADay) -> value = "позавчера"
        seconds in (1 * secondsInADay) until(2 * secondsInADay) -> value = "вчера"
        seconds in (1 * secondsInAnHour) until(24 * secondsInAnHour) -> value = "${getHours(seconds)} ${getHourWordEnding(getHours(seconds))} назад"
        seconds in (1 * secondsInAMinute + 1) until(secondsInAnHour) -> value = "${getMinutes(seconds)} ${getMinuteWordEnding(getMinutes(seconds))} назад"
    }
    return value
}

fun getHourWordEnding(value: Long): String {
    when (value){
        2L,3L,4L, in 22..23 -> return "часа"
        in 5L..20L -> return "часов"
    }
    return "час"
}

fun getMinuteWordEnding(value: Long): String {
    when (value % 10){
        2L,3L,4L -> return "минуты"
        0L, in 5L..9L -> return "минут"
    }
    return "минуту"
}

fun getDays(seconds: Long): Long {
    return seconds / secondsInADay }

fun getHours(seconds: Long): Long {
    return (seconds - secondsInADay * getDays(seconds)) / secondsInAnHour
}

fun getMinutes(seconds: Long) : Long {
    return (seconds - secondsInAnHour * getHours(seconds)
                    - secondsInADay * getDays(seconds)) / secondsInAMinute
}
