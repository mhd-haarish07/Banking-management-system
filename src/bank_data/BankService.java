package bank_data;

import java.util.Random;

public class BankService {

	protected long accNumGen() {

		String std = "250610";

		Random r = new Random();

		StringBuilder randomSuffix = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			int digit = r.nextInt(10);
			randomSuffix.append(digit);
		}

		String accNum = std + randomSuffix;

		return Long.parseLong(accNum);
	}
	
}
