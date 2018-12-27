package com.book.entity;

/**
 * @author${罗显}
 * @date 2018/12/19
 * @time 14:26
 */
public class BatchReductionParams {
    /**订单编号*/
    private String loanId;
    /**期次*/
    private Integer term;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "BatchReductionParams{" +
                "loanId='" + loanId + '\'' +
                ", term=" + term +
                '}';
    }
}
