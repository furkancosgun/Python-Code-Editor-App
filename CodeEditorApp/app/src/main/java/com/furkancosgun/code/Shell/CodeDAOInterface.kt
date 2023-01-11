package com.furkancosgun.code.Shell

import com.furkancosgun.code.Model.Code
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CodeDAOInterface {
    @POST("/compile")
    fun sendCode(
        @Body body: Code
    ): Call<Code>
}