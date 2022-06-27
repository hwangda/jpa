package com.hdy.jpa;

import com.hdy.jpa.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void userTest(){
        Users users = new Users();
        users.setLastName("hwang");
        users.setFirstName("da");
        System.out.println(users.getLastName() + users.getFirstName());
    }

}
