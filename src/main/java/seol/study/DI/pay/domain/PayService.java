package seol.study.DI.pay.domain;

public interface PayService {

	void pay(PayMethod payMethod, final long amount);

}
