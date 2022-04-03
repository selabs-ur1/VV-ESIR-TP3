package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class TLSSocketFactoryTestMocks {
	
	private TLSSocketFactory f;
	private SSLSocket mock_socket;
	
	@BeforeEach
	public void init() {
		// Mock creation
		f = new TLSSocketFactory();
		mock_socket = mock(SSLSocket.class);
	}
	
	
	@Test
	public void preparedSocket_NullProtocols() {
		//return methods
		when(mock_socket.getSupportedProtocols()).thenReturn(null);
        when(mock_socket.getEnabledProtocols()).thenReturn(null);
        f.prepareSocket(mock_socket);
        
        //Verify if setEnabledProtocols isn't launched
        verify( mock_socket, times(0)).setEnabledProtocols(any());
	}
	
	@Test
	public void typical()  {
		//return methods
		when(mock_socket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(mock_socket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
        
        //Assert true for any when call setEnabledProtocols
        doAnswer(
    		func -> {
    			assertTrue(Arrays.equals(func.getArgument(0), new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
    			return null;
    		}
        ).when(mock_socket).setEnabledProtocols(any());
        
        f.prepareSocket(mock_socket);
        verify( mock_socket, atLeast(1)).setEnabledProtocols(any());
	}
	
	
	
	private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}