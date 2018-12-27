package com.book.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author${罗显}
 * @date 2018/12/27
 * @time 15:31
 */
public class BatchParams extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String loanId;
    @ExcelProperty(index = 1)
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
}
