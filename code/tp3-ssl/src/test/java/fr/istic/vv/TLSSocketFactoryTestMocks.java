package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

	@Test
    public void preparedSocket_NullProtocols()
    {
		TLSSocketFactory f = new TLSSocketFactory();
		//création du mock
		SSLSocket ssl_socket_mock = mock(SSLSocket.class);
		
		when( ssl_socket_mock.getSupportedProtocols()).thenReturn( null );
		when( ssl_socket_mock.getEnabledProtocols()).thenReturn( null );
		
		//appel de prepareSocket sur le mock
		f.prepareSocket(ssl_socket_mock);
		
		//si la méthode est appelé on fail
		verify( ssl_socket_mock, times(0)).setEnabledProtocols(any());

		
    }
	
	@Test
    public void typical() 
	{		
		TLSSocketFactory f = new TLSSocketFactory();
		
		//création du mock
		SSLSocket ssl_socket_mock = mock(SSLSocket.class);
		
		
		String [] resSupported = shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
		when( ssl_socket_mock.getSupportedProtocols()).thenReturn( resSupported);
		
		String [] resEnabled = shuffle(new String[]{"SSLv3", "TLSv1"});
		when( ssl_socket_mock.getEnabledProtocols()).thenReturn( resEnabled );
		
		//réalise l'assertion nécessaire à l'appel de setEnabledProtocols()
		doAnswer(invocation -> { 
	        String [] protocols = invocation.getArgument(0);
	        assertTrue(Arrays.equals(protocols, new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
	        return null;
	    }).when( ssl_socket_mock).setEnabledProtocols(any());
		
		//appel de prepareSocket sur le mock
		f.prepareSocket(ssl_socket_mock);
		
		//vérifie qu'on a bien appelé une fois setEnabledProtocols()
		verify( ssl_socket_mock).setEnabledProtocols(any());
	}
	
	private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

	
}