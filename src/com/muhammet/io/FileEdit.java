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
			 * \ tek de�il de \\ kullanman�z�n sebebi \ kullan�m " karakterini
			 * tan�mlamak i�in kullan�l�r.
			 * \\ yerine /
			 */
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream write = new ObjectOutputStream(file);
			write.writeObject(log);
			write.close();
		}catch (Exception e) {
			System.out.println("Dosya ��leme hatas�...: "+ e.toString());
		}
	}

	public Optional<T> read(String filename) {
		try {
			// MACOS /users/muhammehoca/logfile/log.txt
			// e�er dosya yolu belirtmez iseniz. uygulaman�z hangi dizinde 
			// �al��yor ise oraya kay�t eder.
			// D�KKAT!!!! dosyolu �nemlidir.
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream read = new ObjectInputStream(file);
			/**
			 * Yazarken de okurken de Object olarak de�er verir ve al�rs�n�z
			 * ama i�eride verdi�iniz bilgi o �ekilde kay�t edilir.
			 */
			T log = (T)read.readObject();
			return Optional.of(log);
		}catch (Exception e) {
			System.out.println("Dosya ��leme hatas�...: "+ e.toString());
			return Optional.empty();
		}
	}
}
