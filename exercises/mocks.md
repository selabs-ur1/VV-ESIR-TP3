# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.

# Answer

You can find the solution in the code folder.

The main issue with the base code is that the test will pass even if the setter ``setEnabledProtocols`` is never called. This is because the original test only verifies the parameters if the method is called, but does not ensure that the method itself is invoked at all.

For example, in the test below:

```java
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

        // verify the value, if the method is called, but if it is never called, it won't throw an error
        @Override
        public void setEnabledProtocols(String[] protocols) {
            assertArrayEquals(protocols, new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
        }
    });
}
```

That is why if we completely remove the code inside the prepareSocket method, no test case will fail. That is a problem.

To resolve this issue, we used Mockito's verify method. This ensures that ``setEnabledProtocols`` is actually called, and with the correct parameters. By doing this, we add a check to our test case : if the method is never invoked, the test will fail, which is what we want.