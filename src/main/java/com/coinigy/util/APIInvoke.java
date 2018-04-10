package com.coinigy.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

public class APIInvoke {
	private APIInvoke() {
	}

	static Logger logger = Logger.getLogger(APIInvoke.class);

	public static String callApiURL(String url, String postParam) {
		// String compURL =
		// "https://private-anon-1e1cf1ecb1-coinigy.apiary-mock.com/api/v1/" +
		// url;
		String compURL = "https://api.coinigy.com/api/v1/" + url;

		Client client = ClientBuilder.newClient();
		logger.info("Params is " + postParam);
		Response response = client.target(compURL).request(MediaType.APPLICATION_JSON_TYPE)
				.header("X-API-KEY", "e28fd41b46bf5cace3b9cd4b7dbf7f56")
				.header("X-API-SECRET", "99cbe8974eae98b4095d2788e4560310").post(Entity.json(postParam));
		String data = response.readEntity(String.class);
		if (!data.contains("err_num")) {
			if (!StringUtils.isEmpty(data)) {
				JSONObject jsonObject = null;
				try {
					if (data.startsWith("{")) {
						jsonObject = new JSONObject(data);
					} else if (data.startsWith("[")) {
						JSONArray arr = new JSONArray(data);

						if (arr.length() > 0)
							jsonObject = arr.getJSONObject(0);

					}
					logger.info("data Object for " + url + " is >>>> " + jsonObject);
					if (jsonObject != null)
						return jsonObject.toString();
					else
						return "";
				} catch (JSONException e) {
					logger.error("Exception from Convert API response into JSONObject : ", e);

				}
			}
		}
		return null;
	}
}
