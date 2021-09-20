package com.diamond.remote.interceptor

import com.diamond.remote.BuildConfig
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Chain): Response {
        val newRequest = chain.request().newBuilder()
            .removeHeader("Authorization")
            .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
        return chain.proceed(newRequest.build())
    }
}