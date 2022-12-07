
public class Main {

	public static void main(String[] args) {
		
		/********************************** 
		 * QRコード生成メソッドの呼び出し *
		 **********************************/
		
		QrUtil.generateQR("https://morijyobi.ac.jp", "morijyobi.png");

		//相対パスでファイルパスを渡す場合はプロジェクトフォルダをカレントディレクトリとして扱う
		QrUtil.generateQR("https://atcoder.jp/", "./src/img/AtCoder.png");

		
		/***************************** 
		 * PDF生成メソッドの呼び出し *
		 *****************************/

		PdfUtil.generatePDF("morijyobi.pdf", "morijyobi.png");

		//
		PdfUtil.generatePDF("./src/pdf/AtCoder.pdf", "./src/img/AtCoder.png");
		
		
	}

}
