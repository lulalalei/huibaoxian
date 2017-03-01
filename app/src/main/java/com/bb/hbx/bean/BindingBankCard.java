package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/3/1.
 */

public class BindingBankCard {

    /**
     * output : {"cardType":"储蓄卡","lastDigits":"8247","bankName":"中国工商银行"}
     * respCode : 000000
     * respMsg : 添加银行卡成功
     * success : true
     */

        /**
         * cardType : 储蓄卡
         * lastDigits : 8247
         * bankName : 中国工商银行
         */

        private String cardType;
        private String lastDigits;
        private String bankName;

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getLastDigits() {
            return lastDigits;
        }

        public void setLastDigits(String lastDigits) {
            this.lastDigits = lastDigits;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }
}
