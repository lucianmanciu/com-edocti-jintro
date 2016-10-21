package com.edocti.jintro.lab07;

import java.io.*;

/**
 * Simplest case: copy file byte by byte
 *
 * @author pianas
 */
class SimpleByteCopy {

	public static void main(String... args) {
		if (args.length < 2) {
			System.err.println("Usage: java SimpleByteCopy source destination");
			System.exit(-1);
		}
		try {
			copyByteByByte(args[0], args[1]);
		} catch (IOException e) {
			System.err.println("Cannot copy: " + e.getMessage());
			System.exit(-1);
		}
		System.out.println("Ok");
	}

	private static void copyByteByByte(String pathIn, String pathOut) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(pathIn);
			out = new FileOutputStream(pathOut);
			int b;
			while ((b = in.read()) != -1) {
				System.out.println('A');
				out.write(b);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
