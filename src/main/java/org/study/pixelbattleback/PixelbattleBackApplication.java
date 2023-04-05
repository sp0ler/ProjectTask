package org.study.pixelbattleback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PixelbattleBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixelbattleBackApplication.class, args);
    }

}
