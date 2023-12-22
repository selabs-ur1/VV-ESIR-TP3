package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TLSSocketFactoryTestMocks {

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

        // Ajouts pour capturer et vérifier les effets du code à l'intérieur de prepareSocket
        ArgumentCaptor<String[]> protocolsCaptor = ArgumentCaptor.forClass(String[].class);
        verify(mockSocket).setEnabledProtocols(protocolsCaptor.capture());
        assertArrayEquals(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"}, protocolsCaptor.getValue());
    }

    private String[] shuffle(String[] in) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}
