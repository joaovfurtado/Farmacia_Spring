package br.com.sermed;

import br.com.sermed.view.TelaLogin;
import javax.swing.SwingUtilities;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FarmaciaSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FarmaciaSpringApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .bannerMode(Banner.Mode.OFF)
                .build();
    }

    @Override
    public void run(String... args) {
        System.setProperty("java.awt.headless", "false");
        SwingUtilities.invokeLater(() -> {
            try {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
