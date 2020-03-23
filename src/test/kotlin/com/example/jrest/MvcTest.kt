package com.example.jrest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.RequestBuilder

@Component
open class MvcTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    fun perform(request: RequestBuilder) = mockMvc.perform(request)
}
