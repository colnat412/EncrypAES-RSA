package rsa;

public class Main {
	public static void main(String[] args) {
		RSA rsa = new RSA();
		// Tạo key
		rsa.taoKhoa(1024);
		String thongDiepDauVao = "NguyenTanLocDepTrai";
		String kqMaHoa = rsa.maHoa(thongDiepDauVao);
		System.out.println("Kết quả mã hóa: " +kqMaHoa);
		String kqGiaiMa = rsa.giaiMa(kqMaHoa);
		System.out.println("Kết quả đoạn giải mã: " +kqGiaiMa);
	}
}
