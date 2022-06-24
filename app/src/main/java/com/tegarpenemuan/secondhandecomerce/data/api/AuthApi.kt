package com.tegarpenemuan.secondhandecomerce.data.api

import com.tegarpenemuan.secondhandecomerce.data.api.getProfile.GetProfileResponse
import com.tegarpenemuan.secondhandecomerce.data.api.login.LoginRequest
import com.tegarpenemuan.secondhandecomerce.data.api.login.LoginResponse
import com.tegarpenemuan.secondhandecomerce.data.api.register.response.SuccessRegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface AuthApi {

    @Multipart
    @POST("auth/register")
    suspend fun register(
        @Part("full_name") full_name: RequestBody? = null,
        @Part("email") email: RequestBody? = null,
        @Part("password") password: RequestBody? = null,
        @Part("phone_number") phone_number : RequestBody? = null,
        @Part("address") address  : RequestBody? = null,
        @Part image : MultipartBody.Part? = null,
        @Part("city") city  : RequestBody? = null,
    ): Response<SuccessRegisterResponse>

    @POST("auth/login")
    suspend fun login (@Body request: LoginRequest): Response<LoginResponse>

    @GET("auth/user")
    suspend fun getProfile(
        @Header("access_token") access_token: String
    ): Response<GetProfileResponse>
}