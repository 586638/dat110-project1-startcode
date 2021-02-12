package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;

public class RPCUtils {

	// Utility methods for marshalling and unmarshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length()+1];
		encoded[0] = rpcid;

		for (int i = 0; i < str.length(); i++)
			encoded[i+1] = (byte) str.charAt(i);

		return encoded;

		// TODO: marshall RPC identifier and string into byte array

	}

	public static String unmarshallString(byte[] data) {

		byte[] temp = new byte[data.length-1];

		for (int i = 0; i < temp.length; i++)
			temp[i] = data[i+1];

		String decoded = new String(temp);

		// TODO: unmarshall String contained in data into decoded

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] =  rpcid;

		return encoded;
		// TODO: marshall RPC identifier in case of void type


	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];

		encoded[0] = rpcid;

		byte[] temp = ByteBuffer.allocate(4).putInt(x).array();
		
		for (int i=0;i<4;i++) {
			encoded[i+1] = temp[i];
		}

		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		byte[] temp = new byte[4];

		for (int i = 1; i < data.length; i++)
			temp[i-1] = data[i];
		
		decoded = ByteBuffer.wrap(temp).getInt();

		// TODO: unmarshall integer contained in data

		return decoded;

	}
}
