package seol.study.DI.pay.infrastructure.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import seol.study.DI.pay.domain.PayMethod;

@Slf4j
@Component
@RequiredArgsConstructor
public class KakaoPayApiCaller implements PaymentApiCaller {

	@Override
	public boolean support(PayMethod payMethod) {
		return PayMethod.KAKAO_PAY == payMethod;
	}

	@Override
	public void pay(long amount) {
		log.info("카카오페이로 {}원 결제.", amount);
	}
}
