package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

public class TLSSocketFactoryTest {
    
    @Test
    public void preparedSocket_NullProtocols_Mock() {
    	SSLSocket socket = mock(SSLSocket.class);
    	
    	when(socket.getSupportedProtocols()).thenReturn(null);
    	when(socket.getEnabledProtocols()).thenReturn(null);
    	verify(socket, times(0)).setEnabledProtocols(any());

    	TLSSocketFactory f = new TLSSocketFactory();
    	f.prepareSocket(socket);
    }

    @Test
    public void typical_Mock() {
    	SSLSocket socket = mock(SSLSocket.class);
    	when(socket.getSupportedProtocols()).thenReturn(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
    	when(socket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
    	
    	TLSSocketFactory f = new TLSSocketFactory();
    	f.prepareSocket(socket);
    	
    	verify(socket, times(1)).setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" });
    }
    
    
    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}
