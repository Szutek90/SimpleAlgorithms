package com.app.algorithm.numbers.area_calculator.impl;

import com.app.algorithm.numbers.area_calculator.IntegralAreaCalculator;

import java.util.function.ToDoubleFunction;

/**
 * The ByTrapezoids class implements the AreaCalculator interface to calculate the area using the method of trapezoids.
 */

public class ByTrapezoids implements IntegralAreaCalculator<Double> {
    @Override
    public double calculate(double a, double b, int quantity, ToDoubleFunction<Double> function) {
        var height = (b - a) / quantity;
        var sum = 0.0;
        for (int i = 0; i < quantity; i++) {
            var fa = function.applyAsDouble(a + i * height);
            var fax = function.applyAsDouble(a + (i + 1) * height);
            sum += (fa + fax) * height / 2.0;
        }
        return (double) Math.round(Math.abs(sum) * 100) / 100;
    }
}
