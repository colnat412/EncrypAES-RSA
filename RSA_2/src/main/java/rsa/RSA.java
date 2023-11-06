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
		BigInteger p = new BigInteger(bits, 100, new SecureRandom()); // p độ dài là bits
		BigInteger q = new BigInteger(bits, 100, new SecureRandom());
		// Tính n = p*q
		n = p.multiply(q);
		// Tính ph(n)đặt là t = (p-1)*(q-1)
		BigInteger fiN = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
		boolean check = false;
		// Thường chọn e = 65537
		
		do {
                        this.e = new BigInteger(bits, 50, new SecureRandom());
			// Kiểm tra [ t và e có UCLN là 1 ] và [ e < t ] thì e là số cùng nguyên tố với t
			if(fiN.gcd(e).equals(BigInteger.ONE) && e.compareTo(fiN)<0) {
				check = true;
			}
		}while(!check);
		// Ta có (e*d) % t = 1 => d
		d = e.modInverse(fiN);
	}
	
	// Tạo khóa công khai để mã hóa
	public String maHoa(String thongDiep) {
		// Chuyển chuỗi thongDiep thành mảng byte, mỗi byte dựa trên mã hóa ASCII 
		BigInteger khoaCongKhai = new BigInteger(1, thongDiep.getBytes());
		// Khóa CK được tính bằng công thức sau: khoaCK = thongDiep ^ e mod n
		return khoaCongKhai.modPow(e, n).toString();
	}
	
//	public String giaiMa(String thongDiep) {
//		BigInteger khoaBM = new BigInteger(thongDiep);
//		return khoaBM.modPow(d, n).toByteArray().toString();
//	}
	
	public String giaiMa(String thongDiep) {
	    BigInteger khoaBM = new BigInteger(thongDiep);
	    return new String(khoaBM.modPow(d, n).toByteArray());
	}

}
