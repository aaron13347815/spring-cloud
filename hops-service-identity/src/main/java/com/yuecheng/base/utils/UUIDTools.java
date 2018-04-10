package com.yuecheng.base.utils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
public class UUIDTools {
	private static long lastTime;
	private static byte[] seed = new SecureRandom().generateSeed(1000);  
	private static final long leastSigBits = new BigInteger(seed).longValue();  
	private static final ReentrantLock lock = new ReentrantLock();   
	/** 
     * Create a new time-based UUID. 
     * 
     * @return the new UUID 
     */  
    public static UUID create() {  
        long timeMillis = (System.currentTimeMillis() * 10000) + 0x01B21DD213814000L;  
        lock.lock();  
        try {  
            if(timeMillis > lastTime) {  
                lastTime = timeMillis;  
            } else {  
                timeMillis = ++lastTime;  
            }  
        } finally {  
            lock.unlock();  
        }  
        // time low  
        long mostSigBits = timeMillis << 32;  
        // time mid  
        mostSigBits |= (timeMillis & 0xFFFF00000000L) >> 16;  
        // time hi and version  
        mostSigBits |= 0x1000 | ((timeMillis >> 48) & 0x0FFF); // version 1  
        return new UUID(mostSigBits, leastSigBits);  
    } 
//	
//	public static void main(String[] args) throws Exception {
//	    System.out.println(UUIDTools.create().toString().replace("-",""));	
//	}
}
