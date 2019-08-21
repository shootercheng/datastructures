package com.scd.code1.ex.three;

/**
 * @author chengdu
 * @date 2019/8/21.
 */
public class Complex {

    private double real;
    private double imag;

    public Complex(){}

    public Complex(double real){
        this.real = real;
        imag = 0;
    }

    public Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public Complex sub(Complex other){
        return new Complex(real - other.real, imag - other.imag);
    }

    public Complex multi(Complex other){
        return new Complex(real*other.real  - imag*other.real, real* other.imag + imag * other.real);
    }
}
