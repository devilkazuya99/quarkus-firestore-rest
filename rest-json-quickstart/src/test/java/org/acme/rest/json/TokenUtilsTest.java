package org.acme.rest.json;

import java.util.HashMap;

import org.eclipse.microprofile.jwt.Claims;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.test.junit.DisabledOnNativeImage;

@DisabledOnNativeImage
class TokenUtilsTest {

    private final Logger logger = LoggerFactory.getLogger(TokenUtilsTest.class);
    
    @Test
    void testGenerateTokenStringStringMapOfStringLong() throws Exception {
        
        String kid = "XXXXXXXXXXXXXXXXXXXXXXXXXXX";
        
        HashMap<String, Long> timeClaims = new HashMap<>();
        long duration = 1800l;
        long exp = TokenUtils.currentTimeInSecs() + duration;
        timeClaims.put(Claims.exp.name(), exp);
        
        String token = TokenUtils.generateTokenString(kid, timeClaims);
        logger.info(token);
    }

}
