package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {
    /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {
        SSLSocket socket  = mock(SSLSocket.class);
        TLSSocketFactory f = new TLSSocketFactory();

        when(socket .getSupportedProtocols()).thenReturn(null);
        when(socket .getEnabledProtocols()).thenReturn(null);

        f.prepareSocket(socket);

        verify(socket, never()).setEnabledProtocols(any(String[].class));
    }

    @Test
    public void typical()  {
        TLSSocketFactory f = new TLSSocketFactory();

        SSLSocket socket = mock(SSLSocket.class);
        when(socket.getSupportedProtocols()).thenReturn(
                shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"})
        );
        when(socket.getEnabledProtocols()).thenReturn(
                shuffle(new String[]{"SSLv3", "TLSv1"})
        );

        f.prepareSocket(socket);

        verify(socket).setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" });
    }


    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}