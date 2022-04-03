package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

	/**
	 * Test when the edge case when the both supported and enabled protocols are
	 * null.
	 */
	@Test
	public void preparedSocket_NullProtocols() {
		TLSSocketFactory f = new TLSSocketFactory();						
		SSLSocket mock = mock(SSLSocket.class);								// create mock
		when(mock.getSupportedProtocols()).thenReturn(null);				// customize methods behaviours
		when(mock.getEnabledProtocols()).thenReturn(null);					//
		Mockito.doAnswer(fail()).when(mock).setEnabledProtocols(any());		// call fail() when setEnabledProtocols() is called
		f.prepareSocket(mock);
	}
	
    @Test
    public void typical()  {
        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket mock = mock(SSLSocket.class);
        when(mock.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(mock.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
        Mockito.doAnswer(invocation -> {
        	String[] arg = invocation.getArgument(0);
        	assertTrue(Arrays.equals(arg, new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
        	return null;
        }).when(mock).setEnabledProtocols(any(String[].class));
    }
    
    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}