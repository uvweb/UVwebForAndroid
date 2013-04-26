package fr.utc.assos.uvweb.util;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class CacheHelper {
	public static JSONArray loadJSON(File cacheFile) throws JSONException, IOException {
		final FileInputStream stream = new FileInputStream(cacheFile);
		final FileChannel fc = stream.getChannel();
		final MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		/* Instead of using default, pass in a decoder. */
		return new JSONArray(Charset.defaultCharset().decode(bb).toString());
	}

	public static void writeToCache(File cacheFile, String JSONData) throws IOException {
		new OutputStreamWriter(new FileOutputStream(cacheFile)).write(JSONData);
	}
}
