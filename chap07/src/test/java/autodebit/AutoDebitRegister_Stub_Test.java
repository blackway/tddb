package autodebit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static autodebit.CardValidity.INVALID;
import static autodebit.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Stub_Test {
	private AutoDebitRegister register;
	private StubCardNumberValidator stubValidator;
	private StubAutoDebitInfoRepository stubRepository;

	@BeforeEach
	void setUp() {
		stubValidator = new StubCardNumberValidator();
		stubRepository = new StubAutoDebitInfoRepository();
		register = new AutoDebitRegister(stubValidator, stubRepository);
		System.out.println("@BeforeEach");
	}

	@Test
	void invalidCard() {
		// 유효하지 않을 번호 설정.
		if(active.equals("local")){

			stubValidator.setInvalidNo("111122223333");
		}else {
			//진짜 카드사에서 받은 번호
호		}

		AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
		RegisterResult result = this.register.register(req);

		assertEquals(INVALID, result.getValidity());
	}

	@Test
	void theftCard() {
		// 도난 카드 번호 설정.
		stubValidator.setTheftNo("1234567890123456");

		AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
		RegisterResult result = this.register.register(req);

		assertEquals(CardValidity.THEFT, result.getValidity());
	}

	@Test
	void validCard() {
		AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
		RegisterResult result = this.register.register(req);
		assertEquals(VALID, result.getValidity());
	}
}
