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
			 * \ tek de�il de \\ kullanman�z�n sebebi \ kullan�m " karakterini
			 * tan�mlamak i�in kullan�l�r.
			 * \\ yerine /
			 */
			FileOutputStream file = new FileOutputStream("C:\\LogDosyasi\\log.txt");
			ObjectOutputStream write = new ObjectOutputStream(file);
			write.writeObject(log);
			write.close();
		}catch (Exception e) {
			System.out.println("Dosya ��leme hatas�...: "+ e.toString());
		}
	}

	public Optional<Log> getLogFile() throws IOException, ClassNotFoundException {
	
			// MACOS /users/muhammehoca/logfile/log.txt
			// e�er dosya yolu belirtmez iseniz. uygulaman�z hangi dizinde 
			// �al��yor ise oraya kay�t eder.
			// D�KKAT!!!! dosyolu �nemlidir.
			FileInputStream file = new FileInputStream("C:/LogDosyasi/log.txt");
			ObjectInputStream read = new ObjectInputStream(file);
			/**
			 * Yazarken de okurken de Object olarak de�er verir ve al�rs�n�z
			 * ama i�eride verdi�iniz bilgi o �ekilde kay�t edilir.
			 */
			Log log = (Log)read.readObject();
			return Optional.of(log);
		
	}
}
