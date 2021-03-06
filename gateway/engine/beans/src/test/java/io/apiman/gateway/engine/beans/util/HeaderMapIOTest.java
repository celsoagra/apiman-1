/*
 * Copyright 2016 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apiman.gateway.engine.beans.util;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author eric.wittmann@gmail.com
 */
@SuppressWarnings("nls")
public class HeaderMapIOTest {

    /**
     * Test method for {@link io.apiman.gateway.engine.beans.util.CaseInsensitiveStringMultiMap#toString()}.
     */
    @Test
    public void testJsonMarshalling_SingleProperty() throws Exception {
        HeaderMap original = new HeaderMap();
        original.add("Header-1", "Value-1");
        
        ObjectMapper mapper = new ObjectMapper();
        String serializedHeaderMap = mapper.writer().writeValueAsString(original);
        
        HeaderMap deserializedMap = mapper.reader(HeaderMap.class).readValue(serializedHeaderMap);
        
        Assert.assertNotNull(deserializedMap.get("Header-1"));
        Assert.assertEquals("Value-1", deserializedMap.get("Header-1"));
    }

    /**
     * Test method for {@link io.apiman.gateway.engine.beans.util.CaseInsensitiveStringMultiMap#toString()}.
     */
    @Test
    public void testJsonMarshalling_MultiProperty() throws Exception {
        HeaderMap original = new HeaderMap();
        original.add("Header-1", "Value-1");
        original.add("Header-2", "Value-2");
        original.add("Header-3", "Value-3");
        original.add("Header-4", "Value-4");
        
        ObjectMapper mapper = new ObjectMapper();
        String serializedHeaderMap = mapper.writer().writeValueAsString(original);
        
        HeaderMap deserializedMap = mapper.reader(HeaderMap.class).readValue(serializedHeaderMap);
        System.out.println(deserializedMap);
        
        Assert.assertNotNull(deserializedMap.get("Header-1"));
        Assert.assertEquals("Value-1", deserializedMap.get("Header-1"));
        Assert.assertNotNull(deserializedMap.get("Header-2"));
        Assert.assertEquals("Value-2", deserializedMap.get("Header-2"));
        Assert.assertNotNull(deserializedMap.get("Header-3"));
        Assert.assertEquals("Value-3", deserializedMap.get("Header-3"));
        Assert.assertNotNull(deserializedMap.get("Header-4"));
        Assert.assertEquals("Value-4", deserializedMap.get("Header-4"));
    }

}
