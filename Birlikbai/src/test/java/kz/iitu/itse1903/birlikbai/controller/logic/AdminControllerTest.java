package kz.iitu.itse1903.birlikbai.controller.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1903.birlikbai.model.Admin;
import kz.iitu.itse1903.birlikbai.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    AdminService adminService;

    @Test
    void setAdminService() {
    }

    @Test
    void truncateTable() {
    }

    @Test
    void add() throws Exception {
        Admin admin_add = new Admin(3,"test","test");

        Mockito.when(adminService.save(admin_add)).thenReturn(admin_add);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("http://localhost:0/postman/admin/save")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(admin_add));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        Admin admin_delete = new Admin(3,"test","test");

        Mockito.when(adminService.findById(admin_delete.getId())).thenReturn(admin_delete);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("http://localhost:0/postman/admin/delete/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("http://localhost:0/postman/admin/get/byId/1");

        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("http://localhost:0/postman/admin/get/all");

        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    void update() {
    }
}