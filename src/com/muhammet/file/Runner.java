package com.muhammet.file;

import java.io.File;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {

	public static void main(String[] args) throws Exception {

		File file = new  File("C:\\LogDosyasi\\hata.log");
		Path path = Path.of("C:\\LogDosyasi\\hata.log");
		Path path2 = Path.of("C:\\LogDosyasi\\tasinanlar\\hata.log");
		
		System.out.println("Dosya mevcut mu...........: "+file.exists());
		System.out.println("Tam dosya yolu............: "+file.getAbsolutePath());
		System.out.println("Dosya ad�.................: "+file.getName());
		System.out.println("dosyan�n bulundu�u konum..: "+file.getParent());
		System.out.println("bir dosya m�..............: "+file.isFile());
		System.out.println("byte cinsinden boyut......: "+file.length());
		System.out.println("son de�i�tirilen zaman....: "+file.lastModified());
		
		System.out.println("Files ile dosya var m�....: "+ Files.exists(path2));
		System.out.println("Dosya silme...: ");
		//Files.delete(path2); // belirtilen dosyay� direkt silmeye �al���r dosya yoksa hata verir.
		Files.deleteIfExists(path2); // dosya varsa siler. hata vermez
		/**
		 * Bir dosyay� ba�ka bir yere kopyalama i�lemi yapar. 
		 * E�er kopyalad���n�z yerde ayn� isimde bir dosya var ise �zerinde yazd�rmak i�in REPLACE_EXISTING
		 * kullanmak zorundas�n�z.
		 */
		Files.copy(path, Path.of("c:\\LogDosyasi\\kopyahata.log"),REPLACE_EXISTING);
		/**
		 * bir dosyay� bir yerden di�er bir yere ta��r. 
		 */
		Files.move(path, path2);

	}

}
