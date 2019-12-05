package com.cos.crud.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cos.crud.model.User;
import com.cos.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Value("${file.path}")
	private String resourcePath;

	public int join(User user, MultipartFile file) {
		String fname = file.getOriginalFilename();
		try {
			if (fname.equals("")) {
				user.setUserProfile("/userProfile/default.jpg");
			} else {
				UUID uuid = UUID.randomUUID();
				String uuidFileName = uuid + "_" + file.getOriginalFilename();
				Path filePath = Paths.get(resourcePath + uuidFileName);
				Files.write(filePath, file.getBytes());
				user.setUserProfile("/userProfile/" + uuidFileName);
			}
			userRepo.join(user);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public User login(User user) {
		try {
			User u = userRepo.login(user.getUsername(), user.getPassword());
			if (u != null) {
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User updateForm(int id) {
		try {
			User user = userRepo.findById(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int update(User user, MultipartFile file) {
		String fname = file.getOriginalFilename();
		try {
			if (fname.equals("")) {
				user.setUserProfile(user.getUserProfile());
			} else {
				UUID uuid = UUID.randomUUID();
				String uuidFileName = uuid + "_" + file.getOriginalFilename();
				Path filePath = Paths.get(resourcePath + uuidFileName);
				Files.write(filePath, file.getBytes());
				user.setUserProfile("/userProfile/" + uuidFileName);
			}
			userRepo.update(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(int id) {
		try {
			userRepo.delete(id);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

}
