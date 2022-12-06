package com.suraia.andela.vitrine.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.suraia.andela.vitrine.data.model.AnoLectivo
import org.json.JSONObject
import java.lang.reflect.Type
import java.util.*
import javax.xml.transform.Source
import kotlin.reflect.typeOf

class LectiveTypeConverter {
        @TypeConverter
        fun fromSource(source: AnoLectivo): String {
            return JSONObject().apply {
                put("id", source.id)
                put("descricao", source.abertura)
            }.toString()
        }

        @TypeConverter
        fun toSource(source: String): AnoLectivo {
            val json = JSONObject(source)
            return AnoLectivo(json.get("id").toString(), json.getString("descricao").toString(),
                json.get("abertura").toString(), json.getString("encerramento").toString(),json.getBoolean("atual"))
        }
    }