package br.edu.ifg.tads.mtp.eventif.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.*;

public class GeraQRcode {
	
	public static void GeraImagemQRcode(String idOUMatricula) throws IOException{
		String textodoCodigo = idOUMatricula;// tem de passar como parametro o id ou a matricula da pessoa no qual se quer gerar o qrcode
		String caminho = "/"+idOUMatricula+".png";// caminho para gerar a imagem
		int tam = 125;
		String tipoArquivo = "png";
		File myFile = new File(caminho);
		try {
			Hashtable hintMap = new Hashtable();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(textodoCodigo,
					BarcodeFormat.QR_CODE, tam, tam, hintMap);
			int tamanho = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(tamanho, tamanho,
					BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, tamanho, tamanho);
			graphics.setColor(Color.BLACK);

			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			
			ImageIO.write(image, tipoArquivo, myFile);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		System.out.println("\nQR-Code gerado com sucesso!\n\n");
	}
}