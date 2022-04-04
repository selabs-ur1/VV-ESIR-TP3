package fr.istic.vv;

import fr.istic.vv.StringUtils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestNull {

    @Test
    public void null_string() {
    	assertTrue(StringUtils.isBalanced(""));
    }
}
