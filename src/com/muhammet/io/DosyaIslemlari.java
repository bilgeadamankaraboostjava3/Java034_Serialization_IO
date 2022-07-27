package com.muhammet.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import com.muhammet.entity.Log;

public class DosyaIslemlari {
	
	public void logKaydet(Log log) {
		try {
			/**
			 * \ tek deðil de \\ kullanmanýzýn sebebi \ kullaným " karakterini
			 * tanýmlamak için kullanýlýr.
			 * \\ yerine /
			 */
			FileOutputStream file = new FileOutputStream("C:\\LogDosyasi\\log.txt");
			ObjectOutputStream write = new ObjectOutputStream(file);
			write.writeObject(log);
			write.close();
		}catch (Exception e) {
			System.out.println("Dosya ÝÞleme hatasý...: "+ e.toString());
		}
	}

	public Optional<Log> getLogFile() throws IOException, ClassNotFoundException {
	
			// MACOS /users/muhammehoca/logfile/log.txt
			// eðer dosya yolu belirtmez iseniz. uygulamanýz hangi dizinde 
			// çalýýyor ise oraya kayýt eder.
			// DÝKKAT!!!! dosyolu önemlidir.
			FileInputStream file = new FileInputStream("C:/LogDosyasi/log.txt");
			ObjectInputStream read = new ObjectInputStream(file);
			/**
			 * Yazarken de okurken de Object olarak deðer verir ve alýrsýnýz
			 * ama içeride verdiðiniz bilgi o þekilde kayýt edilir.
			 */
			Log log = (Log)read.readObject();
			return Optional.of(log);
		
	}
}
