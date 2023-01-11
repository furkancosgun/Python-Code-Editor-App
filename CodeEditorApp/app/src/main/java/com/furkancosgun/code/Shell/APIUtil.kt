package com.furkancosgun.code.Shell

class APIUtil {
    companion object {
        private const val baseUrl = "http://192.168.1.93:8080"

        fun sendCodeDAOInterface(): CodeDAOInterface {
            return Client.getClient(baseUrl).create(CodeDAOInterface::class.java)
        }
    }
}