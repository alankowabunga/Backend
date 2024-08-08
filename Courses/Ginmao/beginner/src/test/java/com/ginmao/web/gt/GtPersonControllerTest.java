package com.ginmao.web.gt;

import com.ginmao.domain.Gender;
import com.ginmao.domain.GtPerson;
import com.ginmao.service.impl.GtPersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class GtPersonControllerTest {

    /*
    Controller needs GtPersonServiceImpl.class as dependency
    => @Mock: GtPersonServiceImpl , @InjectMocks: GtPersonController
    * */
    @Mock
    GtPersonServiceImpl gtPersonService;

    @InjectMocks
    GtPersonController gtPersonController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        // init mockito annotaion
        MockitoAnnotations.openMocks(this);

        // init MockMvc's controller
        mockMvc = MockMvcBuilders
            .standaloneSetup(gtPersonController)
            .build();
    }

    /*
    *  BaseEntityController.class 中，刪除會回傳 Object.nonNull() 的布林值
    * 行為設置: 回傳內容為非 null 的任意資料即可
    * */
    @DisplayName("刪除測試")
    @Test
    void delete() throws Exception {

        // arrange
        when(gtPersonService.delete(anyString())).thenReturn(new GtPerson());

        //act
        String returnContent = mockMvc.perform(
            MockMvcRequestBuilders.get("/gt/gt-person/delete/"+ UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON)

        ).andExpect(status().isOk())
            .andExpect(jsonPath("$").isBoolean())
            .andReturn()
            .getResponse()
            .getContentAsString();

        //assert
        assertEquals("true", returnContent);
    }

    /*
    * update & add 在 BaseEntityController.class 中，回傳的內容為轉址到 "index" 的 url
    * =>andExpect():  stats().is3xxRedirection() / redirectUrl("index")
    * */
    @DisplayName("更新測試")
    @Test
    void update() throws Exception {
        //Arrange
        GtPerson gtPerson = new GtPerson();
        String id = UUID.randomUUID().toString();
        gtPerson.setId(id);
        gtPerson.setName("Name2");

        when(gtPersonService.update(any(GtPerson.class))).thenReturn(gtPerson);

        //act & assert
        mockMvc.perform(
            MockMvcRequestBuilders.post("/gt/gt-person/update/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name","Name2")
                .param("id",id)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("index"));
    }

    @DisplayName("新增測試")
    @Test
    void add() throws Exception {
        //arrange
        GtPerson gtPerson = new GtPerson("Namex", LocalDate.now().minusYears(20) , Gender.MALE,"Z123456789","address");

        when(gtPersonService.save(any(GtPerson.class))).thenReturn(gtPerson);

        // act & assert
        mockMvc.perform(
            MockMvcRequestBuilders.post("/gt/gt-person/add")
                .param("name","Namex")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("index"));
    }

    @DisplayName("更新錯誤測試")
    @Test
    void updateValidationError() throws Exception {
        //arrange
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);

        //act & assert
        mockMvc.perform(
            MockMvcRequestBuilders.post("/gt/gt-person/update")
                .param("id","")
                .param("name","")
        ).andExpect(status().isOk())
            .andExpect(result ->{
//                String viewName = result.getModelAndView().getViewName();
                String viewName = result.getResponse().getForwardedUrl();
                if (viewName != null) {
                    assertNotEquals("index",viewName);
                }
            });
    }
}
