package com.tien.common.constant;

/**
  *@ClassName: ProductConstant
  *@Author: Acme Tien
  *@Date: 2022/5/5 19:17
  *@Version: v1.0
  *@Description: 与商品模块有关的常量
 **/
public class ProductConstant {

    public enum AttrEnum{
        ATTR_TYPE_BASE(1, "基本属性"), ATTR_TYPE_SALE(0, "销售属性");

        private int code;
        private String msg;

        AttrEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
