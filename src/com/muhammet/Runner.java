package com.muhammet;

import java.io.IOException;
import java.util.Optional;

import com.muhammet.entity.Log;
import com.muhammet.entity.Ogrenci;
import com.muhammet.io.DosyaIslemlari;
import com.muhammet.io.FileEdit;


public class Runner {

	static DosyaIslemlari dosya = new DosyaIslemlari();
	static FileEdit<Ogrenci> dosyaIO = new FileEdit<>();
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		try {
			String ifade = null;
			String kesitdeger = ifade.substring(5);
		} catch (NullPointerException e) {			
			Log log = new Log(e.toString(), "Runner", "main", System.currentTimeMillis(),
					"Runner sýnýfýnda 15. satýrda hatayý yakaladým. Hata null deðer gelmesi ile alakalý");
			dosya.logKaydet(log);
		}catch (Exception e) {
			System.out.println("Hata oldu..:"+ e.toString());
		}

		Optional<Log> log = dosya.getLogFile();
		if(log.isPresent()) {
			System.out.println(log.get().toString());
		}else
			System.out.println("Log kaydý bulunmamaktadýr.");
		
		dosyaIO.write(new Ogrenci("Ahmet"), "deneme.txt");
		dosyaIO.read("deneme.txt");
	}//
}//
