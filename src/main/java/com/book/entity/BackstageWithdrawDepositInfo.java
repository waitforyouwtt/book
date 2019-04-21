package com.book.entity;

import com.book.utils.ExcelVOAttribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 一点点
 * @Date: 2019/4/18 11:37
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BackstageWithdrawDepositInfo {

    @ExcelVOAttribute(name = "钱包详情id", column = "A")
    private Long walletDetailsId;

    @ExcelVOAttribute(name = "用户id", column = "B")
    private Long userId;

    @ExcelVOAttribute(name = "申请时间", column = "C")
    private String createDate;

    @ExcelVOAttribute(name = "用户昵称", column = "D")
    private String nickName;

    @ExcelVOAttribute(name = "用户头像", column = "E")
    private String headImageUrl;

    @ExcelVOAttribute(name = "用户电话", column = "F")
    private String phoneNumber;

    @ExcelVOAttribute(name = "用户截止当日总提现次数", column = "G")
    private Long withdrawCount;

    @ExcelVOAttribute(name = "用户成功提现总金额（分）", column = "H")
    private Long withdrawSum;

    @ExcelVOAttribute(name = "本次提现金额（分）", column = "I")
    private Long count;

    @ExcelVOAttribute(name = "批复状态", column = "J", combo = {"提现审核", "提现成功", "提现失败"})
    private String status;

    @ExcelVOAttribute(name = "拒绝原因", column = "K", combo = {"抱歉，活动已结束，更多精彩活动正在筹备中，敬请期待……",
            "抱歉，今日平台提现金额已达上线，明天早点来哦", "抱歉，平台显示账户异常，如有疑问，请联系小轻老师咨询（微信号：qingtiku）",
            "其他原因，详情可联系小轻老师咨询（微信号：qingtiku）"})
    private String note;

}
