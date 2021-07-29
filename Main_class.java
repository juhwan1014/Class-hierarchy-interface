package practise_3;

import java.util.Scanner;


interface Encode_inter
{
	public String Encode(byte[] in);
}




abstract class Encode implements Encode_inter  {
	
	 abstract public byte [] CodeWord(byte[] in);
	 
	 
	static String symbol_map;
	
	public String toString(int value) {
		return symbol_map.substring(value,value+1);
	}
	
    public String Encode(byte[] in) {
		
		byte[] word = CodeWord(in);
		
		String result = "";
		
		for(int i = 0; i < word.length; i++)
	      result += toString((int)word[i]);
		
		return result;
	}
}


class base64 extends Encode {
	
	public base64()
	{
		this.symbol_map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
	}
	
	public byte[] CodeWord(byte[] in)
	{
		byte[] word = new byte[(in.length + 2) / 3 * 4];
		 int count = 0;
	        for (int i = 0; i < in.length; i += 3) {
	        	
	            int b = ((in[i]) << 16);
	            
	            if (i + 1 < in.length) {
	                b |= (in[i+1]) << 8;
	            } else {
	            	count++;
	            }
	            if (i + 2 < in.length) {
	                b |= (in[i+2]);
	            } else {
	            	count++;
	            }
                 
	            for (int j = 0; j < 4 - count; j++) {
	                int c = (b & 0xFC0000) >> 18;
	            word[i*4/3+j]=(byte)c;
	                b <<= 6;   
	            }
	            for (int j = 0; j < count; j++) {
	            	   if(count == 1)
	            	   word[i*4/3+j+count+2]=(byte)64;
	            	   else
	                   word[i*4/3+j+count]=(byte)64;   
	               }
	        }
	        return word;
	        
	}
	
}


 class ASCII extends Encode 
{
	
	 
	 public byte[] CodeWord(byte[] in)
	   {
	      return in;
	   }
	   
	   
	 public String toString(int value) {
			return Character.toString((char)value);
		}



}

class Hex extends Encode implements Encode_inter
{
	public Hex()
	{
		this.symbol_map = "0123456789ABCDEF";
	}
	
	
	public byte[] CodeWord(byte[] in)
	{
		byte[] word = new byte[in.length * 2];
		for(int i = 0; i <in.length; i++)
		{
			word[i*2] = (byte)(in[i] >> 4);
			word[i*2 + 1] = (byte)(in[i] & 0x0F);
		}
		return word;
	}
	
	
	public String Encode(byte[] in)
	{
		String result = "";
		byte[] word = CodeWord(in);
		
		for(int i = 0; i < word.length; i++) {
			if(i % 2 == 0)
					result += " 0x";
			
			result += toString((int)word[i]);
		}
		
		return result;
	}
}


class Binary extends Encode implements Encode_inter
{
	public Binary()
	{
		this.symbol_map = "01";
	}
	
	public byte[] CodeWord(byte[] in)
	{
		byte[] word = new byte[in.length * 8];
		  for(int i = 0; i < in.length; i++) {
			  int temp = in[i];
		      for(int j = 7; j >= 0; j--)  
		      {
		    	  if(temp == 0)
		        	{word[i*8 + j] = 0;
		        	} 	
		    	  else if(temp != 0 && temp % 2 == 0){
		    		  word[i*8 + j] = 0;
		        	  temp = temp / 2;
			  }
		    	  else if(temp != 0 && temp % 2 == 1)
		        	{word[i*8 + j] = 1;
		        	  temp = temp / 2;
		        	} 
		      }
	}	
	return word;
	}
	
	public String Encode(byte[] in)
	{
		String result = "";
		byte[] word = CodeWord(in);
		for(int i = 0; i < word.length; i++) {
			result += toString((int)word[i]);
			if(i % 8 == 7)
				result += "  ";
		}
		return result;
	}
}



class Decimal extends Encode implements Encode_inter
{
	public Decimal()
	{
		this.symbol_map = "0123456789";
	}
	
	
	public byte[] CodeWord(byte[] in)
	{
		byte[] word = new byte[in.length * 3];
		for(int i = 0; i < in.length; i++)
		{
			word[i * 3] = (byte)(in[i] / 100);
			word[i * 3 + 1] = (byte)(in[i] / 10 % 10);
			word[i * 3 + 2] = (byte)(in[i] % 10);
		}
				
		return word; 
	}
	
	public String Encode(byte[] in)
	{
		String result = "";
		
		byte[] word = CodeWord(in);
		
		for(int i = 0; i < word.length; i++) {

			result += toString((int)word[i]);
		
			if(i % 3 == 2)
				result += "  ";
		
		
	}
		return result;
}
}

public class Main_class {

	public static void main(String[] args) {
		
		
		
		byte[] in = { 0x12, 0x34, 0x56, 65, 66, 67};
		base64 Object1 = new base64();
		String out1 = Object1.Encode(in);
		System.out.println("Base64 Encoding  :   " + out1);
		
		ASCII Object2 = new ASCII();
		String out2 = Object2.Encode(in);
		System.out.println("ASCII  Encoding  :   " + out2);
		
		Hex Object3 = new Hex();
		String out3 = Object3.Encode(in);
		System.out.println("Hex    Encoding  :   " + out3);
		
		Binary Object4 = new Binary();
		String out4 = Object4.Encode(in);
		System.out.println("Binary Encoding  :   " + out4);
		
		Decimal Object5 = new Decimal();
		String out5 = Object5.Encode(in);
		System.out.println("Decimal Encoding  :   " + out5);
		return;
		

	}

}


