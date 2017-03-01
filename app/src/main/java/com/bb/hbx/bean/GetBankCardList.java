package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/3/1.
 */

public class GetBankCardList {


    /**
     * output : {"cardType":"","lastDigits":"","bankName":""}
     * respCode : 000000
     * respMsg : 获取用户银行卡列表成功
     * success : true
     */

        /**
         * cardType :
         * lastDigits :
         * bankName :
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
