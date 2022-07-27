package com.muhammet.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class FileEdit<T> {

	public void write(T log,String filename) {
		try {
			/**
			 * \ tek deðil de \\ kullanmanýzýn sebebi \ kullaným " karakterini
			 * tanýmlamak için kullanýlýr.
			 * \\ yerine /
			 */
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream write = new ObjectOutputStream(file);
			write.writeObject(log);
			write.close();
		}catch (Exception e) {
			System.out.println("Dosya ÝÞleme hatasý...: "+ e.toString());
		}
	}

	public Optional<T> read(String filename) {
		try {
			// MACOS /users/muhammehoca/logfile/log.txt
			// eðer dosya yolu belirtmez iseniz. uygulamanýz hangi dizinde 
			// çalýýyor ise oraya kayýt eder.
			// DÝKKAT!!!! dosyolu önemlidir.
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream read = new ObjectInputStream(file);
			/**
			 * Yazarken de okurken de Object olarak deðer verir ve alýrsýnýz
			 * ama içeride verdiðiniz bilgi o þekilde kayýt edilir.
			 */
			T log = (T)read.readObject();
			return Optional.of(log);
		}catch (Exception e) {
			System.out.println("Dosya ÝÞleme hatasý...: "+ e.toString());
			return Optional.empty();
		}
	}
}
