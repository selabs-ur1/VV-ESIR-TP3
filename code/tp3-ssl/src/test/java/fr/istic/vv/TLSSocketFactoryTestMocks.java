package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

import org.mockito.Mockito;

public class TLSSocketFactoryTestMocks {

    /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */
    @Test
    public void preparedSocket_NullProtocols()  {
        SSLSocket s = Mockito.mock(SSLSocket.class);
        Mockito.when(s.getSupportedProtocols()).thenReturn(null);
        Mockito.when(s.getEnabledProtocols()).thenReturn(null);
        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(s);
        // Checking if we actually use our protocol lists
        Mockito.verify(s, atLeastOnce()).getEnabledProtocols();
        Mockito.verify(s, atLeastOnce()).getSupportedProtocols();
        Mockito.verify(s, times(0)).setEnabledProtocols(any());
    }

    @Test
    public void typical()  {
        SSLSocket s = Mockito.mock(SSLSocket.class);
        Mockito.when(s.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        Mockito.when(s.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(s);
        // Checking if we actually use our protocol lists
        Mockito.verify(s, atLeastOnce()).getEnabledProtocols();
        Mockito.verify(s, atLeastOnce()).getSupportedProtocols();
        Mockito.verify(s).setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" });
    }


    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}