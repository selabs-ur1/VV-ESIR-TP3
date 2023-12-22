package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTest {

    /**
     * Test when the edge case when the both supported and enabled protocols are null.
     */

    @Test
    void preparedSocket_NullProtocols() {
        TLSSocketFactory tlSSocketFactory = new TLSSocketFactory();
        SSLSocket mockSocket = mock(SSLSocket.class);
        when(mockSocket.getSupportedProtocols()).thenReturn(null);
        when(mockSocket.getEnabledProtocols()).thenReturn(null);

        assertDoesNotThrow(() -> tlSSocketFactory.prepareSocket(mockSocket));

        verify(mockSocket, never()).setEnabledProtocols(any());
    }

    @Test
    void typical() {
        TLSSocketFactory tlSSocketFactory = new TLSSocketFactory();
        SSLSocket mockSocket = mock(SSLSocket.class);
        when(mockSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(mockSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));

        assertDoesNotThrow(() -> tlSSocketFactory.prepareSocket(mockSocket));

        verify(mockSocket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}