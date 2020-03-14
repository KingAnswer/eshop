package com.qingshixun.project.eshop.module.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.qingshixun.project.eshop.module.order.pojo.AlipayBean;
import com.qingshixun.project.eshop.module.order.service.PayService;
import com.qingshixun.project.eshop.util.AlipayProperties;

@Service
public class PayServiceImpl implements PayService {
	 /*
     * @Autowired private Alipay alipay;
     */
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return pay(alipayBean);
    }
    
    /**
     * 支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    public static String pay(AlipayBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient
        String serverUrl = AlipayProperties.getGatewayUrl();
        String appId = AlipayProperties.getAppId();
        String privateKey = AlipayProperties.getPrivateKey();
        String format = "json";
        String charset = AlipayProperties.getCharset();
        String alipayPublicKey = AlipayProperties.getPublicKey();
        String signType = AlipayProperties.getSignType();
        String returnUrl = AlipayProperties.getReturnUrl();
        String notifyUrl = AlipayProperties.getNotifyUrl();
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        // 返回付款信息
        return result;
    }
}
