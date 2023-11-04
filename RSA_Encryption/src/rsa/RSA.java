package rsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RSA {
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
	
	public void taoKhoa(int bits) {
		SecureRandom r = new SecureRandom(); // Tạo 1 số random
		BigInteger p = new BigInteger(bits, new Random()); // p độ dài là bits
		BigInteger q = new BigInteger(bits, new Random());
		// Tính n = p*q
		n = p.multiply(q);
		// Tính ph(n)đặt là t = (p-1)*(q-1)
		BigInteger t = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
		boolean check = false;
		// Thường chọn e = 65537
		BigInteger e = new BigInteger("65537");
		do {
			// Kiểm tra [ t và e có UCLN là 1 ] và [ e < t ] thì e là số cùng nguyên tố với t
			if(t.gcd(e).equals(BigInteger.ONE) && e.compareTo(t)<0) {
				check = true;
			}
		}while(check == true);
		// Ta có (e*d) % t = 1 => d
		d = e.modInverse(t);
	}
	
	// Tạo khóa công khai để mã hóa
	public synchronized String maHoa(String thongDiep) {
		// Chuyển chuỗi thongDiep thành mảng byte, mỗi byte dựa trên mã hóa ASCII 
		BigInteger khoaCongKhai = new BigInteger(thongDiep.getBytes());
		// Khóa CK được tính bằng công thức sau: khoaCK = thongDiep ^ e mod n
		return khoaCongKhai.modPow(e, getN()).toString();
	}
	
	public synchronized String giaiMa(String thongDiep) {
		 BigInteger khoaBiMat = new BigInteger(thongDiep.getBytes());
		 // A giải mã bằng cách tính sau: khoaCongKhai ^ d mod n
		return khoaBiMat.modPow(d, n).toString();
	}

}
