package com.example.jrest.resources


import com.example.jrest.MvcTest
import com.example.jrest.interactors.todo.TodoInteractor
import com.example.jrest.persistance.data.Account
import com.example.jrest.persistance.data.Status
import com.example.jrest.persistance.data.Tag
import com.example.jrest.persistance.data.Todo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "docs")
class TodosTest : MvcTest() {
    private val doneTodo = Todo(1, "Buy some milk", mutableSetOf(Tag("chores")), Account("user@example.com"), Status.Done)
    private val todo = Todo(1, "Buy some milk", mutableSetOf(Tag("chores")), Account("user@example.com"))

    @MockBean
    lateinit var todoInteractor: TodoInteractor

    @BeforeEach
    fun setUp() {
        `when`(todoInteractor.done(1)).thenReturn(doneTodo)
    }

    @Test
    fun `should update todo`() {
        perform(put("/todos/1/done"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.text").value(todo.text))
                .andExpect(jsonPath("$.status").value(todo.status.toString()))
                .andDo(document("get_todo", responseFields(
                        fieldWithPath("text").description("Todo text (what to do)"),
                        fieldWithPath("status").description("Todo status: New, Done or Overdue")
                )))
    }
}
