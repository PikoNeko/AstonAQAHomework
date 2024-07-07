package com.dataForTests;

import java.math.BigInteger;

public class DataOutOfBounds {

    private static final BigInteger MIN_VALUE = new BigInteger("1");

    private static final BigInteger ABOVE_MIN_VALUE = new BigInteger("1");

    private static final BigInteger BELOW_MAX_VALUE = new BigInteger(
            "933262154439441526816992388562667004907159682643816214685929638952175999932299156089414639761565182862536979208272237582511852109168640000000000000000000000");

    private static final BigInteger MAX_VALUE = new BigInteger(
            "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");


    public static BigInteger getMIN_VALUE() {
        return MIN_VALUE;
    }

    public static BigInteger getABOVE_MIN_VALUE() {
        return ABOVE_MIN_VALUE;
    }

    public static BigInteger getBELOW_MAX_VALUE() {
        return BELOW_MAX_VALUE;
    }

    public static BigInteger getMAX_VALUE() {
        return MAX_VALUE;
    }

}