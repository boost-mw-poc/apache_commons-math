/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.math4.legacy.ml.distance;

import org.apache.commons.math4.core.jdkmath.JdkMath;
import org.apache.commons.math4.legacy.core.MathArrays;

/**
 * Calculates the Earth Mover's distance (also known as Wasserstein metric) between two distributions.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Earth_mover's_distance">Earth Mover's distance (Wikipedia)</a>
 *
 * @since 3.3
 */
public class EarthMoversDistance implements DistanceMeasure {
    /** {@inheritDoc} */
    @Override
    public double compute(double[] a, double[] b) {
        MathArrays.checkEqualLength(a, b);
        double lastDistance = 0;
        double totalDistance = 0;
        for (int i = 0; i < a.length; i++) {
            final double currentDistance = (a[i] + lastDistance) - b[i];
            totalDistance += JdkMath.abs(currentDistance);
            lastDistance = currentDistance;
        }
        return totalDistance;
    }
}
