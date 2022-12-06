package com.suraia.andela.vitrine.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.suraia.andela.vitrine.data.model.*
import org.json.JSONObject
import java.util.*

class TimeTableTypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<Horario> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Horario>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<Horario>): String {
        return gson.toJson(someObjects)
    }
}
