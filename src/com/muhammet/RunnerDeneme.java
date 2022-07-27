package com.muhammet;

import java.util.Optional;

import com.muhammet.entity.Ogrenci;
import com.muhammet.io.FileEdit;

public class RunnerDeneme {

	public static void main(String[] args) {
		FileEdit<Ogrenci> fileOgrenci = new FileEdit<>(); 
		fileOgrenci.write(new Ogrenci("dneeme"), "C:\\Ornek\\ogrenci1.txt");
		
		Optional<Ogrenci> ogrenci = fileOgrenci.read("C:\\Ornek\\ogrenci1.txt");
		if(ogrenci.isPresent())
			System.out.println(ogrenci.get().getAd());
	}
}
