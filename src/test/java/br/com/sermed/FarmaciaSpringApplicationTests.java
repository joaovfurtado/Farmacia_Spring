package br.com.sermed;

import br.com.sermed.repositories.ProdutoRepository;
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
    private ProdutoRepository cxRepo;
    @Test
    public void test(){
        System.out.println(cxRepo.findByCodigo(1));
    }
}
