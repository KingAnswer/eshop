package com.qingshixun.project.eshop.module.order.service;




import com.alipay.api.AlipayApiException;
import com.qingshixun.project.eshop.module.order.pojo.AlipayBean;


public interface PayService {
	/**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
