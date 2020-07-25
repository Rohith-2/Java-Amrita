package primitives;

public class Real {
 
	public static void main(String[] args) 
	  {
	
		float f = -3.75f;     //f with the no. is syntax..
		
		/*
		 * A quick recap on converting decimal to binary for decimals..
		 * e.g convert 0.75 to binary
		 * 0.75*2 -> (1).5
		 * 0.5*2 -> (1).0
		 * ====>(0.11) base 2
		 * Then 3.75 = (11.11) base 2; Radix is the base no. in this case its 2 For decimal its 10 for hex its 16......
		 * 1.111 * 2^(1)  ==> E = 128  ..... 2^(E-127) where 2 is used as its the Radix.
		 * And no is stored as 2^(E-127)
		 * 0 00000000 00000000000000000000000        --This is how binary gets saved.. 
		 * The first 0 indicates its positive...    
		 * -> Flops are floating point operations per second are also the measurement of computers capability..
		 * 3.57 -> 11.11 -> 0 10000000 11100000000000000000000...
		 * If -3.75  -> 1 10000000 11100000000000000000000...
		 */
		
		int i = Float.floatToIntBits(f);
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
     }
}
