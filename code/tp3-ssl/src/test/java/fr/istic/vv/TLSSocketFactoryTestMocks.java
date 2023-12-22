package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

    @Test
    public void testPrepareSocketWithMockedSSLSocket() {
        TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();
        SSLSocket socketMock = Mockito.mock(SSLSocket.class);

        // Define behavior for getSupportedProtocols and getEnabledProtocols
        when(socketMock.getSupportedProtocols()).thenReturn(shuffle(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(socketMock.getEnabledProtocols()).thenReturn(shuffle(new String[]{"TLSv1"}));

        tlsSocketFactory.prepareSocket(socketMock);

        // Verify that setEnabledProtocols was called with the expected array
        verify(socketMock).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1"});
    }

    private String[] shuffle(String[] in) {
        List<String> list = Arrays.asList(in);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}
