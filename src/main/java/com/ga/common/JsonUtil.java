package com.ga.common;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class JsonUtil {

	// This File returns JSON string excluding the fields with @Expose
	// Annotation

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JsonUtil.class);

	public static String getJson(ClientErrorCodes clientCode, Object obj) {

		Response response = new Response();

		response.setClientCode(clientCode.getErrorCode());
		response.setMessage(clientCode.getDescription());
		response.setData(obj);
		try {
			final GsonBuilder builder = new GsonBuilder();

			/* null values are not included in return data */
			// builder.serializeNulls();
			builder.setDateFormat("dd-MM-yyyy");
			final Gson g = builder.create();
			return g.toJson(response);
		} catch (Exception e) {
			LOGGER.error("Parsing Error: ", e.toString());
			return "It's hard to say but something went wrong!";
		}
	}

	public static String getJson(ServerCodes error, String message, Object obj) {
		Response response = new Response();
		response.setClientCode(error.getErrorCode());
		response.setMessage(message);
		response.setData(obj);
		try {
			final GsonBuilder builder = new GsonBuilder();
			// builder.serializeNulls();
			builder.setDateFormat("dd-MM-yyyy");
			final Gson g = builder.create();
			return g.toJson(response);
		} catch (Exception e) {
			LOGGER.info(e.toString());
			return "ERROR";
		}
	}

	public static String getJson(Integer clientCode, String message) {
		Response response = new Response();
		response.setClientCode(clientCode);
		response.setMessage(message);
		try {
			final GsonBuilder builder = new GsonBuilder();
			// builder.excludeFieldsWithoutExposeAnnotation();
			// builder.serializeNulls();
			builder.setDateFormat("dd-MM-yyyy");
			final Gson g = builder.create();
			return g.toJson(response);
		} catch (Exception e) {
			LOGGER.info(e.toString());
			return "ERROR";
		}
	}

	public static String getJson(Integer status, String message, Object obj) {
		Response response = new Response();

		response.setClientCode(status);
		response.setMessage(message);
		response.setData(obj);
		try {
			final GsonBuilder builder = new GsonBuilder();
			// builder.excludeFieldsWithoutExposeAnnotation();
			// builder.serializeNulls();
			builder.setDateFormat("dd-MM-yyyy");
			final Gson g = builder.create();
			return g.toJson(response);
		} catch (Exception e) {
			LOGGER.info(e.toString());
			return "ERROR";
		}
	}

	public static String getJsonWithDateFormat(Object obj, String dateFormat) {
		try {
			final GsonBuilder builder = new GsonBuilder();
			builder.excludeFieldsWithoutExposeAnnotation();
			builder.setDateFormat(dateFormat);
			final Gson g = builder.create();
			return g.toJson(obj);
		} catch (Exception e) {
			LOGGER.info(e.toString());
			return "ERROR";
		}
	}

	public static Object getJsonOfType(String obj, Type type) {
		try {
			final GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(Date.class,
					new JsonDeserializer<Date>() {
						// Year in 4, month in 2, day in 2
						final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

						public Date deserialize(JsonElement json, Type typeOfT,
								JsonDeserializationContext context)
								throws JsonParseException {
							try {
								return df.parse(json.getAsString());
							} catch (final java.text.ParseException e) {
								return null;
							}
						}
					});
			// this code for get transion variable in json to ..
			builder.excludeFieldsWithModifiers(Modifier.STATIC);

			final Gson g = builder.create();
			return g.fromJson(obj, type);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info(e.toString());
			return "";
		}
	}

	public static String getJsonexcludeTransient(Object obj) {
		try {
			Gson gson = new GsonBuilder().excludeFieldsWithModifiers(
					Modifier.STATIC).create();
			return gson.toJson(obj);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info(e.toString());
			return "";
		}
	}
}
