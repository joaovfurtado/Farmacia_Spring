package br.com.sermed;

import br.com.sermed.model.Users;
import br.com.sermed.modelDao.UsersService;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmaciaSpringApplicationTests {

    @Test
    public void contextLoads() {
    }
    //@Autowired
    private UsersService cxRepo;
    //@Test
    public void test(){
        cxRepo.save(new Users(1l, "JOAO", "123", "a",Arrays.asList(new SimpleGrantedAuthority("ADMIN"))));
    }
}
