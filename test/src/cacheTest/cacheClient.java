package cacheTest;

import com.meetup.memcached.SockIOPool;
import com.meetup.memcached.MemcachedClient;

//import java.util.*;


public class cacheClient {
	public static void main(String[] args)
	{
		String[] servers = {"marketsimplified.com:11211"};
        SockIOPool pool = SockIOPool.getInstance("BetaCache");
        
        pool.setServers( servers );
        pool.setFailover( true );
        pool.setInitConn( 10 );
        pool.setMinConn( 5 );
        pool.setMaxConn( 250 );
        pool.setMaintSleep( 30 );
        pool.setNagle( false );
        pool.setSocketTO( 3000 );
        pool.setAliveCheck( true );
        pool.initialize();
        
        MemcachedClient mcc = new MemcachedClient("BetaCache");        
        
        System.out.println("add status:"+mcc.add("1", "Original"));
        System.out.println("Get from Cache:"+mcc.get("1"));

	}
}
