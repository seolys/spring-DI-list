package seol.study.DI.pay.domain;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seol.study.DI.pay.infrastructure.payment.PaymentApiCaller;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

	private final List<PaymentApiCaller> paymentApiCallerList;

	@Override
	public void pay(final PayMethod payMethod, final long amount) {
		PaymentApiCaller payApiCaller = routingApiCaller(payMethod);
		payApiCaller.pay(amount);
	}

	private PaymentApiCaller routingApiCaller(PayMethod payMethod) {
		return paymentApiCallerList.stream()
				.filter(paymentApiCaller -> paymentApiCaller.support(payMethod))
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}

}
