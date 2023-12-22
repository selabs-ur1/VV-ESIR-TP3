package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class TLSSocketFactoryTestMocks {
    /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {
        TLSSocketFactory f =  new TLSSocketFactory();

        SSLSocket s = mock(SSLSocket.class);
        when(s.getSupportedProtocols()).thenReturn(null);
        when(s.getEnabledProtocols()).thenReturn(null);

        f.prepareSocket(s);

        verify(s, atLeastOnce()).getEnabledProtocols();
        verify(s, atLeastOnce()).getSupportedProtocols();
        verify(s, times(0)).setEnabledProtocols(any(String[].class)); //On vérifie que set n'est pas appelé
    }

    @Test
    public void typical() {
        TLSSocketFactory f = new TLSSocketFactory();

        SSLSocket s = mock(SSLSocket.class);
        when(s.getSupportedProtocols()).thenReturn(shuffle(new String[] { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" }));
        when(s.getEnabledProtocols()).thenReturn(shuffle(new String[] { "SSLv3", "TLSv1" }));

        f.prepareSocket(s);

        verify(s, atLeastOnce()).getEnabledProtocols();
        verify(s, atLeastOnce()).getSupportedProtocols();
        verify(s, times(1)).setEnabledProtocols(new String[] { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }); //On vérifie que set est appelé une fois
    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}