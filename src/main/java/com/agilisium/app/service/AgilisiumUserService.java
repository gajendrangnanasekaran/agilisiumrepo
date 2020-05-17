package com.agilisium.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.agilisium.app.model.entity.AgilisiumUserDetails;
import com.agilisium.app.model.entity.User;
import com.agilisium.app.repositories.UserRepository;


@Service
public class AgilisiumUserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByUserName(username);

		user.orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

		return user.map(AgilisiumUserDetails::new).get();
	}

}
