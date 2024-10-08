package cn.rentaotao.arthas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rtt
 * @date 2024/9/27 09:20
 */
@SpringBootApplication
public class ArthasApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ArthasApplication.class, args);
        System.out.println(ArthasApplication.class.getPackage().getImplementationVersion());
    }
}
