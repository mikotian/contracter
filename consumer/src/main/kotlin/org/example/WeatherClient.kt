package org.example

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result


class WeatherClient(val baseURL:String) {

    fun getById(id:Int): Result<String,FuelError> =
        "$baseURL/weather/$id"
                .httpGet()
                .responseString()
                .third
}