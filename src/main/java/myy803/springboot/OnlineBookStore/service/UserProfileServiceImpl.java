package myy803.springboot.OnlineBookStore.service;

import java.util.Optional;


import myy803.springboot.OnlineBookStore.dao.UserProfileMapper;
import myy803.springboot.OnlineBookStore.forms.UserProfileFormData;
import myy803.springboot.OnlineBookStore.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	
	
	 @Autowired
	 private UserProfileMapper userProfileMapper;


	 /* @Autowired
	 private BookAuthorMapper bookAuthorMapper;

	 @Autowired
	 private BookCategoryMapper bookCategoryMapper;

	 @Autowired
	 private BookMapper bookMapper;


	 @Autowired
	 private SearchFactory searchFactory; 

	 @Autowired
	 private RecommendationsFactory  recommendationsFactory; */
	 
	 

	
	
	
	
	public UserProfileFormData retrieveProfile(String username, UserProfileFormData userProfileFormData) {

		// Call userProfileMapper.findByUsername to retrieve the UserProfile
		Optional<UserProfile> userProfileOptional = userProfileMapper.findByUsername(username);
		//User user = userService.getUserByUsername(username);


		if (userProfileOptional.isPresent()) {
			UserProfile userProfile = userProfileOptional.get();
			userProfileFormData.setFullName(userProfile.getFullName());
			userProfileFormData.setAddress(userProfile.getAddress());
			userProfileFormData.setAge(userProfile.getAge());
			userProfileFormData.setPhoneNumber(userProfile.getPhoneNumber());
			// Map other fields as needed

			return userProfileFormData;
		} else {
			return null;
		}



		// Check if the UserProfile exists


			// If a profile exists, update it with the new data
			//UserProfile existingProfile = userProfileOptional.get();
			//return updateProfileData(existingProfile, userProfileFormData);
			//userProfileMapper.save(existingProfile); // Save the updated profile




}

	private UserProfile updateProfileData(UserProfile profile, UserProfileFormData formData) {
		// Update the profile data with the form data
		profile.setFullName(formData.getFullName());
		profile.setAddress(formData.getAddress());
		profile.setAge(formData.getAge());
		profile.setPhoneNumber(formData.getPhoneNumber());
		// Update other profile fields as needed
		return profile;
	}

	private UserProfileFormData convertToUserProfileFormData(UserProfile userProfile) {
		UserProfileFormData formData = new UserProfileFormData();
		formData.setFullName(userProfile.getFullName());
		formData.setAddress(userProfile.getAddress());
		formData.setAge(userProfile.getAge());
		formData.setPhoneNumber(userProfile.getPhoneNumber());
		// Set other properties as needed
		return formData;



	}


	/*public UserProfileFormData mapToUserProfileFormData(Optional<UserProfile> userProfile) {
			UserProfile profile = userProfile.get();
			UserProfileFormData formData = new UserProfileFormData();
			formData.setFullName(profile.getFullName());
			formData.setAddress(profile.getAddress());
			formData.setAge(profile.getAge());
			formData.setPhoneNumber(profile.getPhoneNumber());
			// Set other fields as needed
			return formData;
	}*/


	public void save(UserProfileFormData userProfileFormData , UserProfile userProfile) {
		Optional<UserProfile> userProfileOptional = userProfileMapper.findByUsername(userProfile.getUsername());
		if (userProfileOptional.isPresent()) {

			// If a profile exists, update it with the new data
			UserProfile existingProfile = userProfileOptional.get();
			updateProfileData(existingProfile, userProfileFormData);
			userProfileMapper.save(updateProfileData(existingProfile, userProfileFormData));
		} else {
			userProfile.setFullName(userProfileFormData.getFullName());
			userProfile.setAddress(userProfileFormData.getAddress());
			userProfile.setAge(userProfileFormData.getAge());
			userProfile.setPhoneNumber(userProfileFormData.getPhoneNumber());
			//userProfileFormData.setPreferredBookCategories(userProfileFormData.getPreferredBookCategories());
			//userProfileFormData.setFavoriteAuthors(userProfileFormData.getFavoriteAuthors());
			userProfileMapper.save(userProfile);

		}

		// Set other properties based on the form data

		    // Save the new UserProfile to the database using userProfileMapper
		//userProfileFormData.saveProfile(userProfileFormData);

	}
	
	/*public List<BookFormData> retrieveBookOffers(String username){
		return null;
		
	}

	public void addBookOffer(String username, BookFormData bookFormData) {
		
	}

	public List <BookFormData> searchBooks (SearchFormData searchFormData){
		return null;
		
	}

	public List<BookFormData> recommendBooks(String username, RecommendationsFormData recomFormData){
		return null;
		
	}

	public void requestBook(int bookld, String username) {
		
	}

	public List<BookFormData> retrieveBookRequests(String username){
		return null;
		
	}
	
	public List<UserProfileFormData> retrieveRequestingUsers(int bookid){
		return null;
		
	}

	public void deleteBookOffer (String username, int bookld) {
		
	}

	public void deleteBookRequest(String username, int bookld) {
		
	}*/

}
