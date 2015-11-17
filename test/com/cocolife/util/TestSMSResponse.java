package com.cocolife.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ph.com.globelabs.api.Sms;
import ph.com.globelabs.api.exception.GlobeApiException;
import ph.com.globelabs.api.exception.ParameterRequiredException;
import ph.com.globelabs.api.response.InboundSmsMessage;
import ph.com.globelabs.api.response.Response;
import ph.com.globelabs.api.response.SmsResponse;

public class TestSMSResponse extends Response {

	private String message;
	private String address;
	private List<String> deliveryInfo;
	private String senderAddress;
	private String clientCorrelator;
	private String notifyURL;
	private String callbackData;
	private String senderName;
	private String resourceURL;
	private String error;

	public TestSMSResponse(HttpResponse httpResponse)
			throws IllegalStateException, JSONException, IOException {
		super(httpResponse);

		JSONObject responseContent = new JSONObject(super.getContent());

		JSONObject outboundSMSMessageRequest = responseContent
				.has("outboundSMSMessageRequest") ? responseContent
				.getJSONObject("outboundSMSMessageRequest") : null;
		if (outboundSMSMessageRequest != null) {
			this.address = outboundSMSMessageRequest.has("address") ? outboundSMSMessageRequest
					.getString("address") : null;

			JSONObject deliveryInfo = outboundSMSMessageRequest
					.has("deliveryInfoList") ? outboundSMSMessageRequest
					.getJSONObject("deliveryInfoList") : null;
			this.deliveryInfo = new ArrayList<String>();
			if (deliveryInfo != null) {
				JSONArray deliveryInfoList = deliveryInfo.has("deliveryInfo") ? deliveryInfo
						.getJSONArray("deliveryInfo") : null;
				for (int i = 0; i < deliveryInfoList.length(); i++) {
					this.deliveryInfo.add(deliveryInfoList.getString(i));
				}
			}

			JSONObject outboundSMSTextMessage = outboundSMSMessageRequest
					.has("outboundSMSTextMessage") ? outboundSMSMessageRequest
					.getJSONObject("outboundSMSTextMessage") : null;
			if (outboundSMSTextMessage != null) {
				this.message = outboundSMSTextMessage.has("message") ? outboundSMSTextMessage
						.getString("message") : null;
			}

			this.senderAddress = outboundSMSMessageRequest.has("senderAddress") ? outboundSMSMessageRequest
					.getString("senderAddress") : null;
			this.clientCorrelator = outboundSMSMessageRequest
					.has("clientCorrelator") ? outboundSMSMessageRequest
					.getString("clientCorrelator") : null;

			JSONObject receiptRequest = outboundSMSMessageRequest
					.has("reciptRequest") ? outboundSMSMessageRequest
					.getJSONObject("reciptRequest") : null;
			if (receiptRequest != null) {
				this.notifyURL = receiptRequest.has("notifyURL") ? receiptRequest
						.getString("notifyURL") : null;
				this.callbackData = receiptRequest.has("callbackData") ? receiptRequest
						.getString("callbackData") : null;
				this.senderName = receiptRequest.has("senderName") ? receiptRequest
						.getString("senderName") : null;
				this.resourceURL = receiptRequest.has("resourceURL") ? receiptRequest
						.getString("resourceURL") : null;
			}
		}

		if (responseContent.has("error")) {
			this.error = responseContent.getString("error");
		}
	}

	public static void main(String[] args) throws GlobeApiException,
			ParameterRequiredException {
		String shortCode = "9999";
		Sms sms = new Sms(shortCode);

		String subscriberNumber = "9173849494";
		String accessToken = "_Ak28sdfl32r908sdf0q843qjlkjdf90234jlkasd98";
		String message = "Hello World";
		String clientCorrelator = "9999" + System.currentTimeMillis();

		System.out.println(sms.sendMessage(subscriberNumber, accessToken, message));
		System.out.println(sms.sendMessage(subscriberNumber, accessToken, message, clientCorrelator));

		String rawBody = "{\"inboundSMSMessageList\":{\""
				+ "inboundSMSMessage\":[{\"dateTime\""
				+ ":\"Fri Nov 29 2013 00:16:17 GMT+0000 (UTC)\","
				+ "\"destinationAddress\":\"tel:21589999\","
				+ "\"messageId\":\"5297dcd17b8a4ead5f000032\","
				+ "\"message\":\"A B C D .E\",\"resourceURL\":null,"
				+ "\"senderAddress\":\"tel:+639173849494\"}],"
				+ "\"numberOfMessagesInThisBatch\":1,"
				+ "\"resourceURL\":null,"
				+ "\"totalNumberOfPendingMessages\":0}}";
		
		SmsResponse response = sms.getMessage(rawBody);
		List<InboundSmsMessage> messages = response.getInboundSmsMessages();
		InboundSmsMessage inboundMessage = messages.get(0);

		System.out.println(inboundMessage.getMessage());
	}

	public TestSMSResponse(int statusCode, String reasonPhrase) {
		super(statusCode, reasonPhrase);
	}

	public String getMessage() {
		return message;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getDeliveryInfo() {
		return deliveryInfo;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getClientCorrelator() {
		return clientCorrelator;
	}

	public String getNotifyURL() {
		return notifyURL;
	}

	public String getCallbackData() {
		return callbackData;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getResourceURL() {
		return resourceURL;
	}

	public String getError() {
		return error;
	}

	@Override
	public String toString() {
		if (error == null) {
			return "SendSmsResponse [message=\"" + message + "\", address="
					+ address + ", deliveryInfo=" + deliveryInfo
					+ ", senderAddress=" + senderAddress
					+ ", clientCorrelator=" + clientCorrelator + ", notifyURL="
					+ notifyURL + ", callbackData=" + callbackData
					+ ", senderName=" + senderName + ", resourceURL="
					+ resourceURL + "] " + super.toString();
		} else {
			return "SendSmsResponse [error=\"" + error + "\"] "
					+ super.toString();
		}
	}
}
