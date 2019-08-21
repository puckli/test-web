package web.util;

import lombok.extern.slf4j.Slf4j;
import web.domain.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author lwz
 * @Description
 * @Date: 15:18 2017-12-21
 */
@Slf4j
public class SerializeUtil {
	public static byte[] serialize(Object object){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e){
			e.printStackTrace();
			log.error("SerializeUtil.serialize error,e={}", e);
			return null;
		}
	}

	public static Object deSerialize(byte[] bytes){
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e){
			e.printStackTrace();
			log.error("SerializeUtil.unSerialize error,e={}", e);
			return null;
		}
	}

	public static void main(String[] args){
		User user = User.builder().name("aa").build();
		byte[] by = serialize(user);
		System.out.println();
	}
}
