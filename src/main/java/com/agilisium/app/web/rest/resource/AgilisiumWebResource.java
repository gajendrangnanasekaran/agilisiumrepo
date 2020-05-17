package com.agilisium.app.web.rest.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agilisium.app.service.AgilisiumUserService;
import com.agilisium.app.service.dto.AuthenticationRequest;
import com.agilisium.app.service.dto.AuthenticationResponse;
import com.agilisium.app.service.dto.ConfigDetailsDto;
import com.agilisium.app.service.dto.ConfigsDto;
import com.agilisium.app.service.dto.ProductDto;
import com.agilisium.app.service.dto.ProductDetailsDto;
import com.agilisium.app.util.JwtUtil;


@RestController
@RequestMapping("/agilisium/api")
public class AgilisiumWebResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AgilisiumUserService userDetailsService;

	@GetMapping("/getProductDetails")
	public ProductDetailsDto getProductDetails() {
		
        List<ProductDto> produts = Arrays.asList(
                new ProductDto(1, "cpu"),
                new ProductDto(2, "ram"),
                new ProductDto(3, "modem"),
                new ProductDto(4, "key-board")
        );
		
		return new ProductDetailsDto(produts);
		
	}
	
	@GetMapping("/getConfigDetails")
	public ConfigDetailsDto getConfigDetails() {

        List<ConfigsDto> configs = Arrays.asList(
                new ConfigsDto("l1xcr10"),
                new ConfigsDto("l1xcr12"),
                new ConfigsDto("l1xcr13"),
                new ConfigsDto("l1xcr14")
        );
		
		return new ConfigDetailsDto(configs);
		
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}

	


