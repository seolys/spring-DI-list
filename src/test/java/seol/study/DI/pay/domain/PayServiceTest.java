package seol.study.DI.pay.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PayServiceTest {

	@Autowired
	private PayService payService;

	@EnumSource(PayMethod.class)
	@ParameterizedTest
	void pay(PayMethod payMethod) {
		payService.pay(payMethod, 10_000);
	}

}