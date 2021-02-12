package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if(payload.length > 128)
		throw new IllegalArgumentException("Payload is too long");
		this.payload = payload;
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[128];
		encoded[0] = (byte) payload.length;

		for (int i=0; i < payload.length; i++)
			encoded[i+1] = payload[i];
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format

		return encoded;
		
	}

	public void decapsulate(byte[] received) {
		
		int length = received[0];

		payload = new byte[length];
		
		for (int i = 0; i < length; i++)
			payload[i] = received[i+1];
		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
	}
}
