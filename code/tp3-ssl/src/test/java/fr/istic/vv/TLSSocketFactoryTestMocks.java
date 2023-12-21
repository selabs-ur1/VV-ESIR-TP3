package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
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

        SSLSocket sslSocket = mock(SSLSocket.class);

        when(sslSocket.getSupportedProtocols()).thenReturn(null);
        when(sslSocket.getEnabledProtocols()).thenReturn(null);

        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(sslSocket);


        verify(sslSocket,atLeastOnce()).getSupportedProtocols();
        verify(sslSocket,atLeastOnce()).getEnabledProtocols();
        verify(sslSocket,never()).setEnabledProtocols(any(String[].class));
    }

    @Test
    public void typical()  {
        TLSSocketFactory f = new TLSSocketFactory();

        SSLSocket sock = mock(SSLSocket.class);

        when(sock.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(sock.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));

        f.prepareSocket(sock);


        verify(sock).setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }) ;

    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}