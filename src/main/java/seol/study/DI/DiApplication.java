package seol.study.DI;

import java.util.Random;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import seol.study.DI.pay.domain.PayMethod;
import seol.study.DI.pay.domain.PayService;

@SpringBootApplication
public class DiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(PayService payService) {
		return args -> {
			Random random = new Random();
			for (final PayMethod payMethod : PayMethod.values()) {
				payService.pay(payMethod, random.nextInt(100_000));
			}
		};
	}

}
