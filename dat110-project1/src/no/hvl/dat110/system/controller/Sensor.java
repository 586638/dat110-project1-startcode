package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;

		byte[] bytearray = RPCUtils.marshallVoid(RPCID);

		byte[] response = rpcclient.call(bytearray);

		temp = RPCUtils.unmarshallInteger(response);
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		return temp;
	}
	
}
