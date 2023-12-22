package fr.istic.vv;
/*

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

*/


public class TLSSocketFactoryTestMocks {
    //@Mock
    private SSLSocket sslSocket;

    //@InjectMocks
    private TLSSocketFactory f;

    /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    /*@Test
    void preparedSocket_NullProtocols() {
        MockitoAnnotations.initMocks(this);
        when(sslSocket.getSupportedProtocols()).thenReturn(null);
        when(sslSocket.getEnabledProtocols()).thenReturn(null);
        doThrow(new AssertionError()).when(sslSocket).setEnabledProtocols(any(String[].class));
        f.prepareSocket(sslSocket);
    }*/

    /*@Test
    public void typical() {
        MockitoAnnotations.initMocks(this);
        when(sslSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(sslSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
        f.prepareSocket(sslSocket);
        verify(sslSocket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
    }*/

    /*private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<StringArrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }*/
}
