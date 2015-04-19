package ma.esoftech.esoftrade.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.model.MetaObject;
import ma.esoftech.esoftrade.model.User;

public class ServiceUtils {

	public static final String TMP_REF="TMP_REF";
	public static MetaObject buildEntityModel(UserDTO creator, MetaObject object) {
		System.out.println("createur:"+creator.getId());
		object.setCreateDate(new Date());
		object.setLastEdit(new Date());
		User user = new User();
		user.setId(creator.getId());
		object.setCreator(user);
		object.setModifier(user);
		return object;
	}

	public static MetaObject EditEntityModel(UserDTO modifier, MetaObject object) {
		object.setLastEdit(new Date());
		User user = new User();
		user.setId(modifier.getId());
		object.setModifier(user);
		return object;
	}
	public static MetaObject buildEntityModel(User creator, MetaObject object) {
		object.setCreateDate(new Date());
		object.setLastEdit(new Date());
		object.setCreator(creator);
		object.setModifier(creator);
		return object;
	}

	public static MetaObject EditEntityModel(User modifier, MetaObject object) {
		object.setLastEdit(new Date());
		object.setModifier(modifier);
		return object;
	}
	public static String getHashedPasswordBySHA(String key) {

		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;

		try {
			hash = MessageDigest.getInstance("SHA-1").digest(uniqueKey); // MD2,
																			// MD5,
																			// SHA-1,
																			// SHA-256,
																			// SHA-384,
																			// SHA-512

		} catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}

}
