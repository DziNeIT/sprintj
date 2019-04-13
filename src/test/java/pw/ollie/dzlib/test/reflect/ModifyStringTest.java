/*
 * This file is part of dzlib, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 Oliver Stanley <http://ollie.pw>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pw.ollie.dzlib.test.reflect;

import org.junit.Assert;
import org.junit.Test;

import pw.ollie.dzlib.reflect.sun.UnsafeReflection;

public class ModifyStringTest {
    @Test
    public void runTest() {
        char[] charArray = { 'g', 'o', 'o', 'd', 'b', 'y', 'e' };
        UnsafeReflection.modifyString("hello", "goodbye");
        check("hello".toCharArray(), charArray);
    }

    private void check(char[] one, char[] two) {
        if (one.length != two.length) {
            Assert.fail("length (" + one.length + " vs " + two.length + ")");
        }

        for (int i = 0; i < one.length; i++) {
            if (!(one[i] == two[i])) {
                Assert.fail(one[i] + " vs " + two[i] + " @ " + i);
            }
        }
    }
}