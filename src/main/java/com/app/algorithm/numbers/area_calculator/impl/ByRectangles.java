package com.app.algorithm.numbers.area_calculator.impl;

import com.app.algorithm.numbers.area_calculator.IntegralAreaCalculator;

import java.util.function.ToDoubleFunction;

/**
 * The ByRectangles class implements the AreaCalculator interface to calculate the area using the method of rectangles.
 */

public class ByRectangles implements IntegralAreaCalculator<Double> {
    @Override
    public double calculate(double a, double b, int quantity, ToDoubleFunction<Double> function) {
        var absA = Math.abs(a);
        var absB = Math.abs(b);
        var sum = 0.0;
        var height = (b - a) / quantity;
        for (int i = 0; i < quantity; i++) {
            var x = (absA < absB) ? absA + i * height : absB + i * height;
            var fax = function.applyAsDouble(x);
            sum += fax * height;
        }
        return (double) Math.round(sum * 100) / 100;
    }
}
