package com.improve777.imagesearch.data.remote.util

import com.google.gson.annotations.SerializedName
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class EnumConverterFactory : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<Enum<*>, String>? {
        return if (type is Class<*> && type.isEnum) {
            Converter<Enum<*>, String> { enum ->
                try {
                    enum.javaClass
                        .getField(enum.name)
                        .getAnnotation(SerializedName::class.java)?.value
                } catch (e: Exception) {
                    null
                } ?: enum.toString()
            }
        } else {
            null
        }
    }
}