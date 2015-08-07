/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.service;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Lenovo
 */
public class Test {

    private String nAssigment;
    private String nQuizz;

    public Test(String nAssigment, String nQuizz) {
        this.nAssigment = nAssigment;
        this.nQuizz = nQuizz;
    }

    public String getnAssigment() {
        return nAssigment;
    }

    public void setnAssigment(String nAssigment) {
        this.nAssigment = nAssigment;
    }

    public String getnQuizz() {
        return nQuizz;
    }

    public void setnQuizz(String nQuizz) {
        this.nQuizz = nQuizz;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Test)) {
            return false;
        }
        Test castOther = (Test) other;
        return new EqualsBuilder().append(nAssigment,
                castOther.nAssigment).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(1450207409, -1692382659).append(nAssigment).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("balance", nAssigment).toString();
    }

}
