package rsa;

public class Main {
	public static void main(String[] args) {
		RSA rsa = new RSA();
		// Tạo key
		rsa.taoKhoa(1024);
		String thongDiepDauVao = "Nguyen Tan Loc";
                System.out.println("Input: " +thongDiepDauVao);
		String kqMaHoa = rsa.maHoa(thongDiepDauVao);
		System.out.println("Encrypt: " +kqMaHoa);
		String kqGiaiMa = rsa.giaiMa(kqMaHoa);
		System.out.println("Output: " +kqGiaiMa);
	}
}
