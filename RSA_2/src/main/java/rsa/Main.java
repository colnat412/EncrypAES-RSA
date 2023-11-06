package rsa;

public class Main {
        private static final int bits = 1024;
	public static void main(String[] args) {
		RSA rsa = new RSA();
		// Tạo key
		rsa.taoKhoa(bits);
		String thongDiepDauVao = "Nguyen Tan Loc";
                System.out.println("Input: " +thongDiepDauVao);
		String kqMaHoa = rsa.maHoa(thongDiepDauVao);
		System.out.println("Encrypt: " +kqMaHoa);
		String kqGiaiMa = rsa.giaiMa(kqMaHoa);
		System.out.println("Output: " +kqGiaiMa);
	}
}
