# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.

# Answer

You can find the solution in the code folder.

The main issue with the base code is that if the setter is never called, it won't throw an error in this test

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

That's why if we remove all the code in the prepareSocket method, the test run well.

My solution is to use the verify method provided by mockito, which will check if setEnabledProtocols is called, with the right parameters.