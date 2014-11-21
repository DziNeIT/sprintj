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
package pw.ollie.dzlib.reflect;

/**
 * Settings for sprintj reflection.
 */
public final class ReflectionSettings {
    /**
     * Whether sprintj's sun-based reflection utilities should attempt to avoid
     * the usage of {@link sun.misc.Unsafe}. Generally, this should be set to
     * {@code true}.
     */
    private static boolean avoidUnsafe = true;

    /**
     * Get whether sprintj's sun-based reflection should attempt to avoid using
     * {@link sun.misc.Unsafe}.
     *
     * @return whether sun-based reflection should avoid using Unsafe
     */
    public static boolean isAvoidUnsafe() {
        return avoidUnsafe;
    }

    /**
     * Set whether sprintj's sun-based reflection should attempt to avoid using
     * {@link sun.misc.Unsafe}.
     *
     * @param avoidUnsafe whether to avoid usage of Unsafe
     */
    public static void setAvoidUnsafe(boolean avoidUnsafe) {
        ReflectionSettings.avoidUnsafe = avoidUnsafe;
    }

    // do not instantiate pls
    private ReflectionSettings() {
        throw new UnsupportedOperationException();
    }
}
