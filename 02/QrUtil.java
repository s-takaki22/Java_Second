import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrUtil {
	private static final int OUTPUT_SIZE = 100;
	private static final String CHARSET ="UTF-8";

	public static void generateQR(String url, String outputFilePath) {
		//QRコードに格納する文字列
//		String url = "https://morijyobi.ac.jp";

		//QRコードの生成先とファイル名
//		String path = "./src/qr/code.png";
		
		try {
			//プロパティ生成
			ConcurrentHashMap hints = new ConcurrentHashMap();
			
			//エラー訂正レベル指定
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			//エンコーディング指定
			hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
			//マージン指定
			hints.put(EncodeHintType.MARGIN, 0);

			//ライターの生成
			QRCodeWriter writer = new QRCodeWriter();

			//QRコード生成
			//第1引数：格納文字列
			//第2引数：生成バーコードタイプ
			//第3引数：幅(ピクセル)
			//第4引数：高さ(ピクセル)
			//第5引数：エラー訂正レベル等
			BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, OUTPUT_SIZE, OUTPUT_SIZE, hints);
			BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

			//ファイルへの保存処理
			//第1引数：イメージファイル
			//第2引数：拡張子
			//第3引数：ファイルパス
			ImageIO.write(image, "png", new File(outputFilePath));
			
			System.out.println("QRコード生成完了！");

		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
