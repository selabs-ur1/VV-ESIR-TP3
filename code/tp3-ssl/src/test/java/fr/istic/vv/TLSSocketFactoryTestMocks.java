package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TLSSocketFactoryTestMocks {


	/**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {
        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket mock = Mockito.mock(SSLSocket.class);
        Mockito.when(mock.getSupportedProtocols()).thenReturn(null);
        Mockito.when(mock.getEnabledProtocols()).thenReturn(null);
        f.prepareSocket(mock);
        Mockito.verify(mock,Mockito.times(0)).setEnabledProtocols(Mockito.any());
    }
	
	@Test
	public void typical()  {
		TLSSocketFactory f = new TLSSocketFactory();
		SSLSocket mock = Mockito.mock(SSLSocket.class);
		Mockito.when(mock.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        Mockito.when(mock.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
		f.prepareSocket(mock);
		Mockito.verify(mock,Mockito.times(1)).setEnabledProtocols(Mockito.any());
		Mockito.doAnswer(
	            func -> {
	                assertTrue(Arrays.equals(func.getArgument(0), new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
	                return null;
	            }
	        ).when(mock).setEnabledProtocols(Mockito.any());

	}

	private String[] shuffle(String[] in) {
		List<String> list = new ArrayList<String>(Arrays.asList(in));
		Collections.shuffle(list);
		return list.toArray(new String[0]);
	}
}