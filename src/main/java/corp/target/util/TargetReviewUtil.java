package corp.target.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TargetReviewUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static Map<String, Object> getObjectionableContent(String file) {

		String data = getFileData(file);
		return toMap(data);
	}

	public static Map<String, Object> toMap(String json) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map = mapper.readValue(json, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	private static String getFileData(String dataFilename) {
		BufferedReader br = null;
		FileReader fr = null;

		StringBuffer sb = new StringBuffer();
		List<String> data = new ArrayList<String>();
		try {

			fr = new FileReader(dataFilename);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				// data.add(sCurrentLine.trim());
				sb.append(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return sb.toString();
	}
}
