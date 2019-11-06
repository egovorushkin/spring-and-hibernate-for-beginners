package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MyFortuneService implements FortuneService {

	private String fileName = "C:/fortunes.txt";

	private List<String> theFortunes;

	private Random myRandom = new Random();

	public MyFortuneService() {
		System.out.println(">> MyFortuneService: inside default constructor");
	}

	@PostConstruct
	private void loadTheFortunesFile() {
		System.out.println(">> MyFortuneService: inside method loadTheFortunesFile()");

		File theFile = new File(fileName);

		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());

		// initialize array list
		theFortunes = new ArrayList<String>();

		// read fortunes from file
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {

			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(theFortunes.size());

		String theFortune = theFortunes.get(index);

		return theFortune;
	}

}
