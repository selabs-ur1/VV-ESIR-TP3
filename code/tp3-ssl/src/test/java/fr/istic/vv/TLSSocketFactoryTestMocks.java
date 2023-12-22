package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TLSSocketFactoryTestMocks {

    @Mock
    SSLSocket mockSocket;

    @Captor
    private ArgumentCaptor<String[]> enabled;

    @Test
    public void preparedSocket_NullProtocols() {
        //on paramètre le mock
        when(mockSocket.getSupportedProtocols()).thenReturn(null);
        when(mockSocket.getEnabledProtocols()).thenReturn(null);
        TLSSocketFactory f = new TLSSocketFactory();
        f.prepareSocket(mockSocket);

        //on vérifie que la fonction n'a jamais été appelée
        Mockito.verify(mockSocket, never()).setEnabledProtocols(null);
    }

    @Test
    public void typical() {
        when(mockSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
        when(mockSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));

        TLSSocketFactory f =new TLSSocketFactory();
        f.prepareSocket(mockSocket);

        //lorsque la fonction est appelée, on récupère la valeur de ce qui a été passé en paramètre
        verify(mockSocket).setEnabledProtocols(enabled.capture());
        //on récupère la valeur du paramètre
        String[] test= enabled.getValue();
        //on vérifie que le paramètre soit égal à ce qu'on veut
        assertArrayEquals(test, new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}
