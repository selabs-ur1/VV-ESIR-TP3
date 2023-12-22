package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TLSSocketFactoryTestMocks {

        /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {
        //mock SSLSocket
        SSLSocket mockSocket = mock(SSLSocket.class);
        //mock SSLsocket getters
        when(mockSocket.getSupportedProtocols()).thenReturn(null);
        when(mockSocket.getEnabledProtocols()).thenReturn(null);
        

        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(mockSocket);

        // Verify that setEnabledProtocols method is not called
        verify(mockSocket, never()).setEnabledProtocols(any(String[].class));
    }

    // DETECT IF THE TESTED METHOD IS EMPTY
    /**
     * Test the case when the protocols are not null.
     */
    @Test
    public void typical()  {
        //mock SSLSocket
        SSLSocket mockSocket = mock(SSLSocket.class);
        //mock SSLsocket getters
        when(mockSocket.getSupportedProtocols()).thenReturn(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
        when(mockSocket.getEnabledProtocols()).thenReturn(new String[]{"SSLv3", "TLSv1"});
        

        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(mockSocket);

        // Verify that setEnabledProtocols method is called
        verify(mockSocket).setEnabledProtocols(any(String[].class));
    }

    
    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}