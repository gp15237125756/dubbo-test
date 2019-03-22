## 运行环境
JDK1.8

## 依赖

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.39</version>
</dependency>

## 签名流程

1. 取出请求报文中所有属性，如果值不是基本类型，转换成json字符串后按升序排序,得到键值对集合A
2. 按参数名的字典顺序（升序），对A、appId（B）、appCode(C)、timestamp(D)的参数名进行排序
3. 使用等号=连接各个请求参数名和参数值
4. 使用与号&连接各个请求参数,参数排序与步骤 2 的排序一致
5. 使用步骤 3 得到的字符串计算签名 HMAC 值(HMacSHA1算法)
6. 按照 Base64 编码规则把步骤 4 中的 HMAC 值编码成字符串
