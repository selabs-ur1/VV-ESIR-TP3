# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

For this exercise, we used the common-math project and we applied the rule JUnitTestContainsTooManyAsserts with PMD. as a result, we obtained a lot of tests which were not respecting this rule. In fact, this rule is verifying that in one test, there isn't more than one assert because having too much asserts in one test is indicative of a complex test where it is hard to verify it's correctness. To fix that, we can simply break down one test into many other tests. For example, we can see one of the tests that don't pass the pmd rule :

``` java  

    @Test
    public void testPremultiply() {
        FieldMatrix<Dfp> m3 = createSparseMatrix(d3);
        FieldMatrix<Dfp> m4 = createSparseMatrix(d4);
        FieldMatrix<Dfp> m5 = createSparseMatrix(d5);
        assertClose("m3*m4=m5", m4.preMultiply(m3), m5, entryTolerance);

        SparseFieldMatrix<Dfp> m = createSparseMatrix(testData);
        SparseFieldMatrix<Dfp> mInv = createSparseMatrix(testDataInv);
        SparseFieldMatrix<Dfp> identity = createSparseMatrix(id);
        assertClose("inverse multiply", m.preMultiply(mInv), identity,
                entryTolerance);
        assertClose("inverse multiply", mInv.preMultiply(m), identity,
                entryTolerance);
        assertClose("identity multiply", m.preMultiply(identity), m,
                entryTolerance);
        assertClose("identity multiply", identity.preMultiply(mInv), mInv,
                entryTolerance);
        try {
            m.preMultiply(createSparseMatrix(bigSingular));
            Assert.fail("Expecting illegalArgumentException");
        } catch (MathIllegalArgumentException ex) {
            // ignored
        }
    }

```

As we can observe, there are many assertions in this test. So to fix that, we can transform it into :

``` java  

    @Test
    public void testPremultiply1() {
        FieldMatrix<Dfp> m3 = createSparseMatrix(d3);
        FieldMatrix<Dfp> m4 = createSparseMatrix(d4);
        FieldMatrix<Dfp> m5 = createSparseMatrix(d5);
        assertClose("m3*m4=m5", m4.preMultiply(m3), m5, entryTolerance);
    }
    
    @Test
     public void testPremultiply2() {
        SparseFieldMatrix<Dfp> m = createSparseMatrix(testData);
        assertClose("inverse multiply", m.preMultiply(mInv), identity,
                entryTolerance);
        SparseFieldMatrix<Dfp> mInv = createSparseMatrix(testDataInv);
        assertClose("inverse multiply", mInv.preMultiply(m), identity,
                entryTolerance);
        SparseFieldMatrix<Dfp> identity = createSparseMatrix(id);
        
        assertClose("inverse multiply", mInv.preMultiply(m), identity,
                entryTolerance);
        assertClose("identity multiply", m.preMultiply(identity), m,
                entryTolerance);
        assertClose("identity multiply", identity.preMultiply(mInv), mInv,
                entryTolerance);
    }
    
    @Test
     public void testPremultiplyFail() {
        SparseFieldMatrix<Dfp> m = createSparseMatrix(testData);
        try {
            m.preMultiply(createSparseMatrix(bigSingular));
            Assert.fail("Expecting illegalArgumentException");
        } catch (MathIllegalArgumentException ex) {
            // ignored
        }
    }

```

One of the limits of this rule is that it can't detect that there are many assertions if they are in an assertAll.
