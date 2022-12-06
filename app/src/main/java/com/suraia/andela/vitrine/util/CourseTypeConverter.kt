package com.suraia.andela.vitrine.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.suraia.andela.vitrine.data.model.AnoLectivo
import com.suraia.andela.vitrine.data.model.Curso
import com.suraia.andela.vitrine.data.model.Nivel
import org.json.JSONObject
import java.lang.reflect.Type
import java.util.*
import javax.xml.transform.Source
import kotlin.reflect.typeOf

class CourseTypeConverter {
        @TypeConverter
        fun fromSource(source: Curso): String {
            return JSONObject().apply {
                put("id", source.id)
                put("nome", source.nome)
            }.toString()
        }

        @TypeConverter
        fun toSource(source: String): Curso {
            val json = JSONObject(source)
            return Curso(json.get("id").toString(), json.getString("nome").toString(),
                json.get("descricao").toString(), json.getString("duracao").toString(),
                json.getString("codigo").toString(), nivel = Nivel.Mestrado,json.getString("coordenador"))
        }
    }