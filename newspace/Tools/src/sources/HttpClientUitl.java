package sources;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;

public class HttpClientUitl {

	protected static final Logger LOGGER = LoggerFactory
			.getLogger(HttpClientUitl.class);

	public static String get(String url) {
		HttpClient client = null;
		try {
			client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);// 连接时间3s
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					5000);// 数据传输时间(读取超时)5s
			// 建立HttpGet对象
			HttpGet httpGet = new HttpGet(url);
			httpGet.addHeader("Accept", "application/json;charset=utf-8");
			httpGet.addHeader("Content-Type", "application/json;charset=utf-8");
			HttpResponse response = client.execute(httpGet);

			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			if (entity == null
					|| response.getStatusLine().getStatusCode() != 200) {
				LOGGER.error(EntityUtils.toString(entity));
				return null;
			}
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		} finally {
			if (client != null && client.getConnectionManager() != null) {
				client.getConnectionManager().shutdown();
			}
		}
	}

	/**
	 * @param
	 * @return
	 */
	public static String post(String url,String jsonBody) {
		HttpClient client = null;
		try {
			client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 8000);// 连接时间8s
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					8000);// 数据传输时间(读取超时)8s
			// 建立HttpPost对象
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; rv:25.0) Gecko/20100101 Firefox/25.0");
			httpPost.addHeader("Accept", "application/json;charset=utf-8"); 
			httpPost.setEntity(new StringEntity(jsonBody, "utf-8")); 
			// Execute the request
			HttpResponse response = client.execute(httpPost);
			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			if (entity == null
					|| response.getStatusLine().getStatusCode() != 200) {
				LOGGER.error(EntityUtils.toString(entity));
				return null;
			}
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		} finally {
			if (client != null && client.getConnectionManager() != null) {
				client.getConnectionManager().shutdown();
			}
		}
	}

	/**
	 * @param
	 * @return
	 */
	public static String post(String url, Map<String, String> parameters) {
		HttpClient client = null;
		try {
			client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 8000);// 连接时间8s
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					8000);// 数据传输时间(读取超时)8s
			// 建立HttpPost对象
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; rv:25.0) Gecko/20100101 Firefox/25.0");
			// httpPost.addHeader("Accept", "application/json;charset=utf-8");
			// 建立一个NameValuePair数组，用于存储欲传送的参数
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			for (Entry<String, String> entry : parameters.entrySet()) {
				// 添加参数
				params.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
			// 设置编码
			httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			// Execute the request
			HttpResponse response = client.execute(httpPost);
			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			if (entity == null
					|| response.getStatusLine().getStatusCode() != 200) {
				LOGGER.error(EntityUtils.toString(entity));
				return null;
			}
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		} finally {
			if (client != null && client.getConnectionManager() != null) {
				client.getConnectionManager().shutdown();
			}
		}
	}
}

