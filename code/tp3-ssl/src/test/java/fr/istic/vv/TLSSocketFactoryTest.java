package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TLSSocketFactoryTest {

    /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {
        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(new SSLSocket() {

            public String[] getSupportedProtocols() {
                return null;
            }

            public String[] getEnabledProtocols() {
                return null;
            }
            public void setEnabledProtocols(String[] protocols) {
                fail();
            }
        });
     }


    @Test
    public void preparedSocket_NullProtocolsMock()  {
        SSLSocket socketMock = mock(SSLSocket.class);
        when(socketMock.getSupportedProtocols()).thenReturn(null);
        when(socketMock.getEnabledProtocols()).thenReturn(null);
        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(socketMock);

        verify(socketMock, atLeastOnce()).getSupportedProtocols();
        verify(socketMock, atLeastOnce()).getEnabledProtocols();
        verify(socketMock, never()).setEnabledProtocols(any());
    }

            
    @Test
    public void typical()  {
        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(new SSLSocket() {
            @Override
            public String[] getSupportedProtocols() {
                return shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
            }
            @Override
            public String[] getEnabledProtocols() {
                return shuffle(new String[]{"SSLv3", "TLSv1"});
            }
            @Override
            public void setEnabledProtocols(String[] protocols) {
                assertTrue(Arrays.equals(protocols, new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
            }
        });
    }

    @Test
    public void typicalMock()  {
        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socketMock2 = mock(SSLSocket.class);
        String[] protocols = {"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        String[] protocols2 = {"SSLv3", "TLSv1"};
        when(socketMock2.getSupportedProtocols()).thenReturn(protocols);
        when(socketMock2.getEnabledProtocols()).thenReturn(protocols2);
        f.prepareSocket(socketMock2);

        verify(socketMock2, atLeastOnce()).getSupportedProtocols();
        verify(socketMock2, atLeastOnce()).getEnabledProtocols();
        String[] expected = {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"};
        verify(socketMock2, atLeastOnce()).setEnabledProtocols(expected);
    }


    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}
