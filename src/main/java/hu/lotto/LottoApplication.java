package hu.lotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LottoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = Sprin
		SpringApplication.run(LottoApplication.class, args);
		System.out.println(args[0]);
	}

}
