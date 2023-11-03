package rsa;

import java.math.BigInteger;
import java.security.SecureRandom;

public class AlgorithmRSA {
	private BigInteger n, d, e;

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}
	
	public void createKey(int bits) {
		SecureRandom r = new SecureRandom(); // Tạo 1 số random
		BigInteger p = new BigInteger(bits, 100, r); // p có độ chính xác 100 bit và độ dài là bits
		BigInteger q = new BigInteger(bits, 100, r);
		// Tính n
		n = p.multiply(q);
		// Tính ph(n)đặt là t = (p-1)*(q-1)
		BigInteger t = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
		boolean check = false;
		do {
			// Kiểm tra t và e có UCLN là 1 và e < t thì e là số cùng nguyên tố với t
			if(t.gcd(e).equals(BigInteger.ONE) && e.compareTo(t)<0) {
				check = true;
			}
		}while(check == true);
		// Ta có (e*d) % t = 1 => d
		d = e.modInverse(t);
		
	}
	public static void main(String[] args) {
		
	}
}
