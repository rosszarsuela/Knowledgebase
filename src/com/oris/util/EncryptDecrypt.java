package com.oris.util;


public class EncryptDecrypt {

	public static void main(String[] args) {
		String test = "4297f44b13955235245b2497399d7a93";
//		String encrypted = EncryptionUtil.getInstance().encrypt(new Users(test), null);
//		System.out.println(encrypted);
		System.out.println(EncryptionUtil.getInstance().decrypt(test));
	}
}
