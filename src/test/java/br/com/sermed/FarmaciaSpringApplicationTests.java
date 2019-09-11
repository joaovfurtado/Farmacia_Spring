package br.com.sermed;

import br.com.sermed.model.Users;
import br.com.sermed.repositories.ProdutoRepository;
import br.com.sermed.repositories.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmaciaSpringApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private UsersRepository cxRepo;
    //@Test
    public void test(){
        cxRepo.save(new Users(1l, "JOAO", "123", "a"));
    }
}
