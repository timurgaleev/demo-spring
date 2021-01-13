package com.timzu.spring.service;

import com.timzu.spring.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceJPATest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Before
    public void cleanTestData() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "delete from users where email not like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%@cappucino.com");
            ps.executeUpdate();
        }
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userService.findAll(1, 20);
        assertNotNull(users);
        assertTrue(users.size() == 6);
        for (User user : users) {
            assertNotNull(user.getId());
            assertNotNull(user.getName());
            assertNotNull(user.getEmail());
        }
    }

    @Test
    public void testSaveUpdateDeleteUser() throws Exception{
        User u = new User();
        u.setName("Charlize Theron");
        u.setEmail("charlize@mocha.com");

        userService.save(u);
        assertNotNull(u.getId());

        User findUser = userService.findById(u.getId());
        assertEquals(u.getName(), findUser.getName());
        assertEquals(u.getEmail(), findUser.getEmail());

        // update record
        u.setEmail("charlize@latte.net");
        userService.update(u);

        // test after update
        findUser = userService.findById(u.getId());
        assertEquals(u.getEmail(), findUser.getEmail());

        // test delete
        userService.deleteById(u.getId());

        // query after delete
        User uDel = userService.findById(u.getId());
        assertNull(uDel);
    }
}
