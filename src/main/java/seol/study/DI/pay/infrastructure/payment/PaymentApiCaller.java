package seol.study.DI.pay.infrastructure.payment;

import seol.study.DI.pay.domain.PayMethod;

public interface PaymentApiCaller {

	boolean support(PayMethod payMethod);

	void pay(long amount);
}
