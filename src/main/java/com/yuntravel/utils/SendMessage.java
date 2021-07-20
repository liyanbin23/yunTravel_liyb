package com.yuntravel.utils;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendMessage {

	public static void send(String PhoneNumbers,String code) {
		String accessKeyId="your accessKeyId";
		String accessSecret="your accessSecret";
		 DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
	        IAcsClient client = new DefaultAcsClient(profile);
	        CommonRequest request = new CommonRequest();
	        request.setSysMethod(MethodType.POST);
	        request.setSysDomain("dysmsapi.aliyuncs.com");
	        request.setSysVersion("2017-05-25");
	        request.setSysAction("SendSms");
	        request.putQueryParameter("RegionId", "cn-hangzhou");
	        request.putQueryParameter("SignName", "your sigName");
	        request.putQueryParameter("TemplateCode", "SMS_199791075");
	        request.putQueryParameter("TemplateParam", "{'code':'"+code+"\'}");
	        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            System.out.println(response.getData());
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	        }
	}

}
