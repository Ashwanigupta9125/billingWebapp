//package com.example.billingbackend.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.example.billingbackend.dao.SecurityRepository;
//import com.example.billingbackend.entities.UserDetail;
// 
//
//public class UserDeatilsServiceImpl implements  UserDetailsService {
//
//	@Autowired
//	private SecurityRepository securityRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	
//		UserDetail user=securityRepository.getUserByUserName(username);
//		
//		if(user== null) {
//			throw new UsernameNotFoundException("User not Found !!!!!!!!!");
//			
//		}
//		CustomUserDetails customUserDetails =new CustomUserDetails(user);
//		
//		return customUserDetails;
//		
//	}
//
//}
