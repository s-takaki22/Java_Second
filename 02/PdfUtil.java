import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfUtil {

	public static void generatePDF(String outputFileName, String imgFileName) {
		try{
			//pdfファイル作成
			PDDocument document = new PDDocument();

			//pdfのページ作成
			PDPage page = new PDPage();
			document.addPage(page);

			//編集の準備
			//第1引数：書き込み対象ファイル
			//第2引数：書き込み対象ページ
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			//フォントの指定
			PDFont font = PDType0Font.load(document, new File("C:/Windows/Fonts/HGRSMP.TTF"));
//			PDFont font = PDType1Font.HELVETICA;	//日本語を使用しない場合はこちらでOK

			/*ここから文字の書き込み方法*/

			//文字入力開始
			contentStream.beginText();

			//フォントの指定
			contentStream.setFont(font, 12);

			//位置の指定(左下が0,0座標となる)
			contentStream.newLineAtOffset(10, 10);

			//文字の書き込み
			contentStream.showText("はじめてのPDF");

			//もう1度文字の書き込み
			contentStream.newLineAtOffset(100, 100);
			contentStream.showText("はじめてのPDF2");

			//文字入力終了
			contentStream.endText();
			
			/*ここまで文字の書き込み方法*/

			//画像ファイルの読み込み
			PDImageXObject qrImage = PDImageXObject.createFromFile(imgFileName, document);

			//画像ファイルの書き込み
			//第1引数：画像ファイル
			//第2,3引数：書き込み位置
			//第4,5引数：画像ファイルの書き込みサイズ(元のままの場合はサンプルの通り)
			contentStream.drawImage(qrImage, 300, 100, qrImage.getWidth(), qrImage.getHeight());

			/*ここまで画像の書き込み方法*/

			/*ここから罫線の書き込み方法*/

			//始点の設定
			contentStream.moveTo(90, 90);

			//終点の設定
			contentStream.lineTo(90, 200);

			//色と太さの設定
			contentStream.setStrokingColor(Color.RED);
			contentStream.setLineWidth(2);

			//書き込み
			contentStream.stroke();

			//もう1本書き込み ※色と太さを変えない場合は座標のみでOK
			contentStream.moveTo(90, 200);
			contentStream.lineTo(200, 200);

			contentStream.stroke();

			/*ここまで罫線の書き込み方法*/
			
			
			contentStream.close();
			document.save(outputFileName);
			
			System.out.println("PDF生成完了！");
			document.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
