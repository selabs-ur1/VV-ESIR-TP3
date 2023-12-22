import fr.istic.vv.SSLSocket;
import fr.istic.vv.TLSSocketFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

    @Test
    public void prepareSocket_NullSupportedProtocols() {
        // Création de l'instance de TLSSocketFactory
        TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();
        
        // Création du mock pour SSLSocket
        SSLSocket sslSocketMock = mock(SSLSocket.class);

        // Stubbing de getSupportedProtocols() avec null
        when(sslSocketMock.getSupportedProtocols()).thenReturn(null);

        // Appel de la méthode à tester
        tlsSocketFactory.prepareSocket(sslSocketMock);

        // Vérification que setEnabledProtocols n'est pas appelée lorsque les protocoles supportés sont null
        verify(sslSocketMock, never()).setEnabledProtocols(any());
    }

    @Test
    public void prepareSocket_EmptyEnabledProtocols() {
        // Création de l'instance de TLSSocketFactory
        TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();
        
        // Création du mock pour SSLSocket
        SSLSocket sslSocketMock = mock(SSLSocket.class);

        // Stubbing de getSupportedProtocols() avec des données de test
        when(sslSocketMock.getSupportedProtocols()).thenReturn(new String[]{"TLSv1.2", "TLSv1.1"});
        
        // Stubbing de getEnabledProtocols() avec un tableau vide
        when(sslSocketMock.getEnabledProtocols()).thenReturn(new String[0]);

        // Appel de la méthode à tester
        tlsSocketFactory.prepareSocket(sslSocketMock);

        // Vérification que setEnabledProtocols est appelée avec les protocoles supportés
        verify(sslSocketMock).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1"});
    }

    @Test
    public void prepareSocket_SupportedAndEnabledProtocols() {
        // Création de l'instance de TLSSocketFactory
        TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();
        
        // Création du mock pour SSLSocket
        SSLSocket sslSocketMock = mock(SSLSocket.class);

        // Stubbing de getSupportedProtocols() et getEnabledProtocols() avec des données de test
        when(sslSocketMock.getSupportedProtocols()).thenReturn(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "TLS"});
        when(sslSocketMock.getEnabledProtocols()).thenReturn(new String[]{"TLSv1"});

        // Appel de la méthode à tester
        tlsSocketFactory.prepareSocket(sslSocketMock);

        // Vérification que setEnabledProtocols est appelée avec les arguments attendus
        verify(sslSocketMock).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "TLS"});
    }
}
