package kz.iitu.itse1903.birlikbai.model;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    private Admin admin = new Admin(1, "login", "password");
    private Admin admin_without_id = new Admin("login", "password");
    private Admin empty_admin = new Admin();

    @Test
    void getId() {
        ReflectionTestUtils.setField(empty_admin, "id", 1);

        assertEquals(empty_admin.getId(), 1);
    }

    @Test
    void getLogin() {
        ReflectionTestUtils.setField(empty_admin, "login", "login");

        assertEquals(empty_admin.getLogin(), "login");
    }

    @Test
    void getPassword() {
        ReflectionTestUtils.setField(empty_admin, "password", "password");

        assertEquals(empty_admin.getPassword(), "password");
    }

    @Test
    void setId() {
        empty_admin.setId(2);
    }

    @Test
    void setLogin() {
        empty_admin.setLogin("2");
    }

    @Test
    void setPassword() {
        empty_admin.setPassword("2");
    }
}