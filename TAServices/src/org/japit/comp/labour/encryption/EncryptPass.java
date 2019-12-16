package org.japit.comp.labour.encryption;

import java.nio.charset.Charset;
import org.japit.comp.labour.utility.UtilityFunction;

import org.jasypt.digest.StandardStringDigester;
import org.jasypt.salt.StringFixedSaltGenerator;

public class EncryptPass {
	public static String encryptPassword(String pass) {
		StandardStringDigester digester = new StandardStringDigester();
		StringFixedSaltGenerator saltGenerator = new StringFixedSaltGenerator("DCLMELTS", "UTF-8");
		digester.setAlgorithm("SHA-512");
		digester.setSaltGenerator(saltGenerator);
		digester.setIterations(50000);
		digester.setSuffix("CS" + UtilityFunction.createCheckSumDigit(UtilityFunction.getNumbersOfText(pass)));
		return new sun.misc.BASE64Encoder().encode(digester.digest(pass).getBytes(Charset.forName("UTF-8")));
	}
}
