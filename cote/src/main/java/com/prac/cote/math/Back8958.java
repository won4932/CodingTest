package com.prac.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		sc.nextLine();
		String[] TestCase;
		int[] Result = new int[C];
		String Temp;

		for (int i = 0; i < C; i++) {
			Temp= sc.next();
			TestCase = Temp.split("");
			int Sum=0; int count=1;
			for (int j = 0; j < TestCase.length; j++) {
				if(TestCase[j].equals("O")) {
					Sum+=count;
					count++;
				} else count=1;
				Result[i]=Sum;

			}
			System.out.println(Result[i]);
		}
	}
}