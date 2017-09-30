package br.com.fiap.client;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TesteDownload {

	public static void main(String[] args) {
		
		ArquivoWeb port = new ArquivoWebService().getArquivoWebPort();
		
		try {
			byte[] fileBytes = port.download("hilux.jpg");
			
			FileOutputStream fos = new FileOutputStream("C:Temp/download.jpg");
			BufferedOutputStream outputStream = new BufferedOutputStream(fos);
			outputStream.write(fileBytes);
			outputStream.close();
			
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
