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
		System.out.println("Dosya adý.................: "+file.getName());
		System.out.println("dosyanýn bulunduðu konum..: "+file.getParent());
		System.out.println("bir dosya mý..............: "+file.isFile());
		System.out.println("byte cinsinden boyut......: "+file.length());
		System.out.println("son deðiþtirilen zaman....: "+file.lastModified());
		
		System.out.println("Files ile dosya var mý....: "+ Files.exists(path2));
		System.out.println("Dosya silme...: ");
		//Files.delete(path2); // belirtilen dosyayý direkt silmeye çalýþýr dosya yoksa hata verir.
		Files.deleteIfExists(path2); // dosya varsa siler. hata vermez
		/**
		 * Bir dosyayý baþka bir yere kopyalama iþlemi yapar. 
		 * Eðer kopyaladýðýnýz yerde ayný isimde bir dosya var ise üzerinde yazdýrmak için REPLACE_EXISTING
		 * kullanmak zorundasýnýz.
		 */
		Files.copy(path, Path.of("c:\\LogDosyasi\\kopyahata.log"),REPLACE_EXISTING);
		/**
		 * bir dosyayý bir yerden diðer bir yere taþýr. 
		 */
		Files.move(path, path2);

	}

}
