package com.websystique.springmvc.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.model.Act;
import com.websystique.springmvc.model.Bank;
import com.websystique.springmvc.model.Contragent;
import com.websystique.springmvc.model.Credit;
import com.websystique.springmvc.model.Currency;
import com.websystique.springmvc.model.Debit;
import com.websystique.springmvc.model.Dodovor;
import com.websystique.springmvc.model.Phone;
import com.websystique.springmvc.model.Rekvizity;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.ActService;
import com.websystique.springmvc.service.BankService;
import com.websystique.springmvc.service.ContragentService;
import com.websystique.springmvc.service.CurrencyService;
import com.websystique.springmvc.service.DebitService;
import com.websystique.springmvc.service.DogovorService;
import com.websystique.springmvc.service.PhoneService;
import com.websystique.springmvc.service.RekvizityService;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.UserService;
import com.websystique.springmvc.util.CreateExcel;



@Controller
@RequestMapping("/")
@SessionAttributes("roles, currences, contragentnames, contracts")
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	CurrencyService currencyService;
	
	@Autowired
	DebitService debitService;
	
	@Autowired
	ContragentService contragentService;
	
	@Autowired
	DogovorService dogovorService;
	
	@Autowired
	BankService bankServise;
	
	@Autowired
	RekvizityService rekvizityService;
	
	@Autowired
	ActService actService;


	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	@ModelAttribute("currences")
	public List<Currency> initializeCurrences() { 
		return currencyService.findAll();
	}
	
	@ModelAttribute("contracts")
	public List<Dodovor> initializeContracts() {
		return dogovorService.findAllDogovors();
	}
	
	@ModelAttribute("banks")
	public List<Bank> initializeBanks() {
		return bankServise.findAllBanks();
	}
	
	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public String getContactInformation(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		
		model.addAttribute("loggedinuser", getPrincipal());
		return "contact";
	}
	
	
	@RequestMapping(value = { "/show-phones" }, method = RequestMethod.GET)
	public String showPhones(ModelMap model) {

		List<Phone> phones = phoneService.findAllPhones();
		model.addAttribute("phones", phones);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfPhones";
	}
	
	
	@RequestMapping(value = { "/show-phone-{ownerID}" }, method = RequestMethod.GET)
	public String showPhoneByOwner(@PathVariable int ownerID, ModelMap model) {	
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		List<Phone> phones = phoneService.findByOwner(ownerID);
		model.addAttribute("phones", phones);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfPhones";
	}
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		
		model.addAttribute("loggedinuser", getPrincipal());
		
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		
		return "home";
	}
	
	@RequestMapping(value = { "/personal-{id}" }, method = RequestMethod.GET)
	public String showPersonalAreaByOwner(@PathVariable int id,ModelMap model) {
		
		Currency currency = new Currency();
		Debit debit = new Debit();
		Act act = new Act();
		Credit credit = new Credit();
		Rekvizity rekvizity = new Rekvizity();
		User user = userService.findById(id);
		model.addAttribute("user", user);
		//model.addAttribute("ssoId", ssoId);
		model.addAttribute("debit", debit);
		model.addAttribute("act", act);
		model.addAttribute("credit", credit);
		model.addAttribute("currency", currency);
		model.addAttribute("rekvizity", rekvizity);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "cabinet";
	}
	
	@RequestMapping(value = { "/personal" }, method = RequestMethod.GET)
	public String showPersonalArea(ModelMap model) {
		Currency currency = new Currency();
		Debit debit = new Debit();
		Credit credit = new Credit();
		model.addAttribute("debit", debit);
		model.addAttribute("credit", credit);
		model.addAttribute("currency", currency);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "cabinet";
	}
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		User user = userService.findBySSO(getPrincipal());
		return "userslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		
		userService.saveUser(user);
		

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userregistration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "userregistration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		userService.updateUser(user);

		model.addAttribute("success", "Данные пользователя " + user.getFirstName() + " "+ user.getLastName() + " обновлены.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "successAdded";
	}
	
	
	@RequestMapping(value = { "/edit-useritself-{ssoId}" }, method = RequestMethod.GET)
	public String editUserItself(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "successAdded";
	}
	
	@RequestMapping(value = { "/edit-useritself-{ssoId}" }, method = RequestMethod.POST)
	public String updateUserItself(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {
		user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "userregistration";
		}

		userService.updateUser(user);
		model.addAttribute("success", "Данные пользователя обновлены!");
		model.addAttribute("loggedinuser", getPrincipal());
		return "successAdded";
	}
	

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	

	
	

	
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		User user = userService.findBySSO(getPrincipal());
		return "home";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/cabinet";  
	    }
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPageP() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/list";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	@RequestMapping(value = { "/newphone-{ownerID}" }, method = RequestMethod.GET)
	public String newPhone(@PathVariable int ownerID, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Phone phone = new Phone();
		model.addAttribute("phone", phone);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("loggedinuser", getPrincipal());
		return "newphone";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newphone-{ownerID}" }, method = RequestMethod.POST)
	public String savePhone(@Valid Phone phone, BindingResult result,
			ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "newphone";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		
		
		phoneService.save(phone);

		model.addAttribute("success", "Телефон " + phone.getAreaCode() + " "+ phone.getPhoneNumber() + " успешно добавлен.");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}
	
	
	@RequestMapping(value = { "/delete-phone-{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id, Model model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		phoneService.deleteById(id);
		return "successDeleted";
		
	}
	
	@RequestMapping(value = { "/edit-phone-{id}" }, method = RequestMethod.GET)
	public String editPhone(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Phone phone = phoneService.findById(id);
		model.addAttribute("phone", phone);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "newphone";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-phone-{id}" }, method = RequestMethod.POST)
	public String editPhone(@Valid Phone phone, BindingResult result, ModelMap model, @PathVariable int id) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "newphone";
		}
		 phoneService.updatePhone(phone);
		model.addAttribute("success",
				"Телефон " + phone.getAreaCode() + " " + phone.getPhoneNumber() + " успешно сохранен.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";

	}
	
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String newUserRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userregistration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String saveNewUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "userregistration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "userregistration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}

	@RequestMapping(value = { "/add-debit-{ownerID}" }, method = RequestMethod.POST)
	public String saveDebit(@Valid Debit debit, BindingResult result,
			ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("debit", debit);
		model.addAttribute("loggedinuser", getPrincipal());
		if (result.hasErrors()) {
			return "add-debit";
		}
		
		debitService.saveDebit(debit);

		model.addAttribute("success", "Поступление добавлено!");
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "successAdded";
	}

	@RequestMapping(value = { "/add-debit-{ownerID}" }, method = RequestMethod.GET)
	public String newDebit(@PathVariable int ownerID,  ModelMap model, HttpServletRequest request) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Debit debit = new Debit();
		
		List<Contragent> contragents = contragentService.findAllContragents(new Long (ownerID));
		model.addAttribute("contragents", contragents);
		
		Contragent contragent = new Contragent();
		
		//String contragentID = request.getParameter("123");
		//List<Act> acts1 = actService.findAllActsByContragentId(contragent.getId());
		//model.addAttribute("acts1", acts1);
		//model.addAttribute("123", contragentID);
		//List<Act> acts1 = actService.findAllActsByContragentId(contragentID);
		List<Act> acts = actService.findAllActsByOwner(ownerID);
		model.addAttribute("acts", acts);
		model.addAttribute("debit", debit);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "add-debit";
	}
	
	@RequestMapping(value = { "/add-credit" }, method = RequestMethod.GET)
	public String newCredit(ModelMap model) {
		Credit credit = new Credit();
		model.addAttribute("credit", credit);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "add-credit";
	}
	
	@RequestMapping(value = { "/show-debits-{ownerID}" }, method = RequestMethod.GET)
	public String showDebitByOwner(@PathVariable int ownerID, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		List<Debit> debits = debitService.findAllDebitsByOwner(ownerID);
		model.addAttribute("debits", debits);
		Act act = new Act();
		model.addAttribute("act", act);
		List<Act> acts = actService.findAllActsByOwner(ownerID);
		model.addAttribute("acts", acts);
		Contragent contragent = new Contragent ();
		List <Contragent> contragents = contragentService.findAllContragents(new Long(ownerID));
		model.addAttribute("contragent", contragent);
		model.addAttribute("contragents", contragents);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfDebitsAll";
	}
	
	@RequestMapping(value = { "/edit-debit-{id}" }, method = RequestMethod.GET)
	public String editDebit(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		Debit debit = debitService.findById(id);
		List<Act> acts = actService.findAllActsByOwner(user.getId());
		model.addAttribute("acts", acts);
		List<Contragent> contragents = contragentService.findAllContragents(new Long (user.getId()));
		model.addAttribute("contragents", contragents);
		model.addAttribute("debit", debit);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "add-debit";
	}
	
	
	@RequestMapping(value = { "/edit-debit-{id}" }, method = RequestMethod.POST)
	public String editDebit(@Valid Debit debit, BindingResult result, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);

		if (result.hasErrors()) {
			return "add-debit";
		}
		 debitService.updateDebit(debit);
		 model.addAttribute("success", "Данные о платеже обновлены!");
		model.addAttribute("loggedinuser", getPrincipal());
		return "successAdded";

	}
	
	@RequestMapping(value = { "/delete-debit-{id}" }, method = RequestMethod.GET)
	public String deleteDebit(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		Debit debit = debitService.findById(id);
		model.addAttribute("debit", debit);
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		debitService.deleteDebitById(id);
		return "successRecordDeleted";
		
	}
	
	
	
	@RequestMapping(value = { "/add-contragent-{ownerID}" }, method = RequestMethod.POST)
	public String saveContragent(@Valid Contragent contragent, BindingResult result,
			ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("contragent", contragent);
		model.addAttribute("loggedinuser", getPrincipal());
		if (result.hasErrors()) {
			return "add-contragent";
		}
	
		contragentService.saveContragent(contragent);

		model.addAttribute("success", "Контрагент добавлен!");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "successAdded";
	}

	@RequestMapping(value = { "/add-contragent-{ownerID}" }, method = RequestMethod.GET)
	public String newContragent(@PathVariable int ownerID, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Contragent contragent = new Contragent();
		
		model.addAttribute("contragent", contragent);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "add-contragent";
	}
	
	@RequestMapping(value = { "/show-contragents-{ownerID}" }, method = RequestMethod.GET)
	public String showContragentsByOwner(@PathVariable Long ownerID, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		List<Contragent> contragents = contragentService.findAllContragents(ownerID); 
		model.addAttribute("contragents", contragents);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfContragents";
	}
	
	
	@RequestMapping(value = { "/delete-contragent-{id}" }, method = RequestMethod.GET)
	public String deleteContragent(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		Contragent contragent = contragentService.findById(id);
		model.addAttribute("contragent", contragent);
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		contragentService.deleteContragentById(id);
		return "successDeleted";
		
	}
	
	@RequestMapping(value = { "/edit-contragent-{id}" }, method = RequestMethod.GET)
	public String editContragent(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		Contragent contragent = contragentService.findById(id);
		model.addAttribute("contragent", contragent);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "add-contragent";
	}
	
	@RequestMapping(value = { "/edit-contragent-{id}" }, method = RequestMethod.POST)
	public String editDebit(@Valid Contragent contragent, BindingResult result, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);

		if (result.hasErrors()) {
			return "add-contragent";
		}
		 contragentService.updateContragent(contragent);
		 model.addAttribute("success", "Данные контрагента успешно обновлены!");
		model.addAttribute("loggedinuser", getPrincipal());
		return "successAdded";

	}
	
	@RequestMapping(value = { "/add-dogovor-{ownerID}" }, method = RequestMethod.POST)
	public String saveDogovor(@Valid Dodovor dogovor, BindingResult result,
			ModelMap model, @PathVariable Long ownerID) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user); 
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("dogovor", dogovor);
		model.addAttribute("loggedinuser", getPrincipal());
		if (result.hasErrors()) {
			return "add-dogovor";
		}
	
		dogovorService.saveDogovor(dogovor);

		
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("success", "Договор добавлен!");
		//return "success";
		return "successAdded";
	}

	@RequestMapping(value = { "/add-dogovor-{ownerID}" }, method = RequestMethod.GET)
	public String newDogovor(@PathVariable Long ownerID,  ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Dodovor dogovor = new Dodovor();
		Contragent contragent = new Contragent();
		List<Contragent> contragents = contragentService.findAllContragents(ownerID);
		model.addAttribute("contragents", contragents);
		
		model.addAttribute("dogovor", dogovor);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "add-dogovor";
	}
	
	@RequestMapping(value = { "/show-dogovors-{ownerID}" }, method = RequestMethod.GET)
	public String showDogovorsByOwner(@PathVariable Long ownerID, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Contragent contragent = new Contragent();
		model.addAttribute("contragent", contragent);
		List<Dodovor> dogovors = dogovorService.findAllDogovorsByOwner(ownerID);
		List<Contragent> contragents = contragentService.findAllContragents(ownerID);
		model.addAttribute("dogovors", dogovors);
		model.addAttribute("contragents", contragents);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfDogovors";
	}
	
	@RequestMapping(value = { "/edit-dogovor-{id}" }, method = RequestMethod.GET)
	public String editDogovor(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		Contragent contragent = new Contragent();
		List<Contragent> contragents = contragentService.findAllContragents(new Long (user.getId()));
		model.addAttribute("contragents", contragents);
		Dodovor dogovor = dogovorService.findById(id);
		model.addAttribute("dogovor", dogovor);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "add-dogovor";
	}
	
	@RequestMapping(value = { "/edit-dogovor-{id}" }, method = RequestMethod.POST)
	public String editDogovor(@Valid Dodovor dogovor, BindingResult result, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);

		if (result.hasErrors()) {
			return "add-dogovor";
		}
		 dogovorService.updateDogovor(dogovor);
		 model.addAttribute("success", "Данные договора изменены!");
		model.addAttribute("loggedinuser", getPrincipal());
		return "successAdded";

	}
	
	@RequestMapping(value = { "/delete-dogovor-{id}" }, method = RequestMethod.GET)
	public String deleteDogovor(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		Dodovor dogovor = dogovorService.findById(id);
		model.addAttribute("dogovor", dogovor);
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		contragentService.deleteContragentById(id);
		return "successDeleted";
		
	}
	
	
	
	@RequestMapping(value = { "/newbank" }, method = RequestMethod.POST)
	public String saveBank(@Valid Bank bank, BindingResult result,
			ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user); 
		
		model.addAttribute("bank", bank);
		model.addAttribute("loggedinuser", getPrincipal());
		if (result.hasErrors()) {
			return "newbank";
		}
	
		bankServise.save(bank);
		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "successAdded";
	}

	@RequestMapping(value = { "/newbank" }, method = RequestMethod.GET)
	public String newBank( ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Bank bank = new Bank();
		Contragent contragent = new Contragent();
		model.addAttribute("contragent", contragent);
		model.addAttribute("bank", bank);
		
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "newbank";
	}
	
	@RequestMapping(value = { "/add-rekvizity-{ownerID}" }, method = RequestMethod.POST)
	public String saveRekvizity(@Valid Rekvizity rekvizity, BindingResult result,
			ModelMap model, @PathVariable int ownerID, @Valid Bank bank) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user); 
		model.addAttribute("rekvizity", rekvizity);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("bank", bank);
		model.addAttribute("loggedinuser", getPrincipal());
		if (result.hasErrors()) {
			return "add-rekvizity";
		}
	
		rekvizityService.save(rekvizity);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "successAdded";
	}

	@RequestMapping(value = { "/add-rekvizity-{ownerID}" }, method = RequestMethod.GET)
	public String editRekvizity(@PathVariable int ownerID, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Rekvizity rekvizity = new Rekvizity();
		
		model.addAttribute("rekvizity", rekvizity);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("loggedinuser", getPrincipal());
		return "add-rekvizity";
	}
	
	@RequestMapping(value = { "/rekvizits-{ownerID}" }, method = RequestMethod.GET)
	public String showRekvizitsByOwner(@PathVariable int ownerID, ModelMap model) {	
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		List<Rekvizity> rekvizity = rekvizityService.findByOwner(ownerID);
		model.addAttribute("rekvizity", rekvizity);
		Bank bank = new Bank();
		model.addAttribute("bank", bank);
		model.addAttribute("loggedinuser", getPrincipal());
		return "rekvizits";
	}
	
	@RequestMapping(value = { "/add-act-{ownerID}" }, method = RequestMethod.GET)
	public String newAct(@PathVariable Long ownerID,  ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Act act = new Act();
		Contragent contragent = new Contragent();
		Dodovor dogovor = new Dodovor();
		List<Dodovor> dogovors = dogovorService.findAllDogovorsByOwner(ownerID);
		List <Contragent> contragents = contragentService.findAllContragents(ownerID);
		model.addAttribute("contragent", contragent);
		model.addAttribute("contragents", contragents);
		model.addAttribute("act", act);
		model.addAttribute("dogovor", dogovor);
		model.addAttribute("dogovors", dogovors);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "add-act";
	}
	
	@RequestMapping(value = { "/add-act-{ownerID}" }, method = RequestMethod.POST)
	public String saveAct(@Valid Act act, BindingResult result,
			ModelMap model, @PathVariable int ownerID) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user); 
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("act", act);
		model.addAttribute("loggedinuser", getPrincipal());
		if (result.hasErrors()) {
			return "successRecordAdded";
		}
	
		actService.saveAct(act);

		model.addAttribute("success", "Акт добавлен!");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "successAdded";
	}
	
	@RequestMapping(value = { "/show-acts-{ownerID}" }, method = RequestMethod.GET)
	public String showActsByOwner(@PathVariable int ownerID, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		Contragent contragent = new Contragent();
		List<Contragent> contragents = contragentService.findAllContragents(new Long (ownerID));
		model.addAttribute("contragents", contragents);
		model.addAttribute("contragent", contragent);
		Dodovor dogovor = new Dodovor();
		List<Dodovor> dogovors = dogovorService.findAllDogovorsByOwner(ownerID);
		model.addAttribute("dogovors", dogovors);
		List<Act> acts = actService.findAllActsByOwner(ownerID);
		model.addAttribute("acts", acts);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfActs";
	}
	@RequestMapping(value = { "/edit-act-{actId}" }, method = RequestMethod.GET)
	public String editAct(@PathVariable int actId, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		List<Contragent> contragents = contragentService.findAllContragents(new Long(user.getId()));
		model.addAttribute("contragents", contragents);
		List<Dodovor> dogovors = dogovorService.findAllDogovorsByOwner(user.getId());
		model.addAttribute("dogovors", dogovors);
		Act act = actService.findById(actId);
		model.addAttribute("act", act);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "add-act";
	}
	
	@RequestMapping(value = { "/edit-act-{actId}" }, method = RequestMethod.POST)
	public String editAct(@Valid Act act, BindingResult result, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("user", user);

		if (result.hasErrors()) {
			return "add-act";
		}
		 actService.updateAct(act);;
		 model.addAttribute("success", "Акт изменен!");
		model.addAttribute("loggedinuser", getPrincipal());
		return "successAdded";

	}
	
	@RequestMapping(value = { "/delete-act-{id}" }, method = RequestMethod.GET)
	public String deleteAct(@PathVariable int id, ModelMap model) {
		User user = userService.findBySSO(getPrincipal());
		Act act = actService.findById(id);
		model.addAttribute("act", act);
		model.addAttribute("user", user);
		model.addAttribute("ownerID", user.getId());
		actService.deleteActById(id);
		return "successDeleted";
		
	}
	
	 @RequestMapping(value = { "/listOfDebits-{ownerID}" }, method = RequestMethod.GET)
	public String showDebitFromPeriod(@PathVariable int ownerID, ModelMap model, @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) throws ParseException {
		//Object obj1 = request.getAttribute("startDate");
		//Object obj2 = request.getAttribute("endDate");
		//HttpServletRequest request
		//, @RequestParam(value= "startDate") Date startDate, @RequestParam(value= "endDate") Date endDate,
		User user = userService.findBySSO(getPrincipal());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String startDate1 = df.format(startDate.getTime());
		Date dateStart = df.parse(startDate1);
		String endDate1 = df.format(endDate.getTime());
		Date dateEnd = df.parse(endDate1);
		model.addAttribute("startDate1", startDate1);
		model.addAttribute("endDate1", endDate1);
		
		Debit debit = new Debit();
		model.addAttribute("user", user);
		model.addAttribute("ownerID", ownerID);
		List<Debit> debits = debitService.findAllDebitsByPeriod(ownerID, startDate, endDate);
		model.addAttribute("debits", debits);
		model.addAttribute("debit", debit);
		Act act = new Act();
		model.addAttribute("act", act);
		List<Act> acts = actService.findAllActsByOwner(ownerID);
		model.addAttribute("acts", acts);
		Contragent contragent = new Contragent ();
		List <Contragent> contragents = contragentService.findAllContragents(new Long(ownerID));
		model.addAttribute("contragent", contragent);
		model.addAttribute("contragents", contragents);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfDebits";
	}
	
	 @RequestMapping(value = "/downloadExcel-{ownerID}", method = RequestMethod.GET)
		public String downloadExcel(@PathVariable int ownerID, Model model) throws IOException {
			User user = userService.findBySSO(getPrincipal());
			model.addAttribute("user", user);
			List<Debit> debits = debitService.findAllDebitsByOwner(ownerID);
			model.addAttribute("debits", debits);
			model.addAttribute("loggedinuser", getPrincipal());
			model.addAttribute("ownerID", ownerID);
			String excelFilePath = "/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms"+user.getPath1();
			CreateExcel createExcel = new CreateExcel();
			createExcel.writeExcel(debits, excelFilePath);
			model.addAttribute("success",
					"Файл успешно сохранен.");
		    return "fileSaved";
		    }
	 
	 @RequestMapping(value = "/downloadExcelPeriod-{ownerID}", method = RequestMethod.GET)
		public String downloadExcelForTheDates(@PathVariable int ownerID, Model model,
				@RequestParam("startDate1") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate1, @RequestParam("endDate1") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate1) throws IOException, ParseException {
			User user = userService.findBySSO(getPrincipal());
			Debit debit = new Debit();
			model.addAttribute("user", user);
			model.addAttribute("debit", debit);
			
			List<Debit> debits = debitService.findAllDebitsByPeriod(ownerID, startDate1, endDate1);
			
			model.addAttribute("debits", debits);
			model.addAttribute("ownerID", ownerID);
			model.addAttribute("loggedinuser", getPrincipal());
			String excelFilePath = "/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms"+user.getPath1();
			CreateExcel createExcel = new CreateExcel();
			createExcel.writeExcel(debits, excelFilePath);
			model.addAttribute("success",
					"Файл успешно сохранен.");
		    return "fileSaved";
		    }
	 
	 @RequestMapping(value = { "/listOfActs-{ownerID}" }, method = RequestMethod.GET)
		public String showActsFromPeriod(@PathVariable int ownerID, ModelMap model, @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) throws ParseException {
			
			User user = userService.findBySSO(getPrincipal());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			String startDate1 = df.format(startDate.getTime());
			Date dateStart = df.parse(startDate1);
			String endDate1 = df.format(endDate.getTime());
			Date dateEnd = df.parse(endDate1);
			model.addAttribute("startDate1", startDate1);
			model.addAttribute("endDate1", endDate1);
			Contragent contragent = new Contragent();
			List<Contragent> contragents = contragentService.findAllContragents(new Long (ownerID));
			model.addAttribute("contragents", contragents);
			model.addAttribute("contragent", contragent);
			Dodovor dogovor = new Dodovor();
			List<Dodovor> dogovors = dogovorService.findAllDogovorsByOwner(ownerID);
			model.addAttribute("dogovors", dogovors);
			Act act = new Act();
			model.addAttribute("user", user);
			model.addAttribute("ownerID", ownerID);
			List<Act> acts = actService.findAllActsByPeriod(ownerID, startDate, endDate);
			model.addAttribute("acts", acts);
			model.addAttribute("act", act);
			
			model.addAttribute("loggedinuser", getPrincipal());
			return "listOfActs";
		}
	 
	 @RequestMapping(value = "/downloadExcel2-{ownerID}", method = RequestMethod.GET)
		public String downloadExcel2(@PathVariable int ownerID, Model model) throws IOException {
			User user = userService.findBySSO(getPrincipal());
			model.addAttribute("user", user);
			List<Debit> debits = debitService.findAllDebitsByOwner(ownerID);
			model.addAttribute("debits", debits);
			List<Contragent> contragents = contragentService.findAllContragents(new Long(ownerID));
			model.addAttribute("contragents", contragents);
			List<Act> acts = actService.findAllActsByOwner(ownerID);
			model.addAttribute("acts", acts);
			model.addAttribute("loggedinuser", getPrincipal());
			model.addAttribute("ownerID", ownerID);
			String excelFilePath = "/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms"+user.getPath1();
			CreateExcel createExcel = new CreateExcel();
			createExcel.writeExcel2(debits, contragents, acts, excelFilePath);
			model.addAttribute("success",
					"Файл успешно сохранен.");
		    return "fileSaved";
		    }
	 
	 @RequestMapping(value = "/downloadExcelPeriod2-{ownerID}", method = RequestMethod.GET)
		public String downloadExcelForTheDates2(@PathVariable int ownerID, Model model,
				@RequestParam("startDate1") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate1, @RequestParam("endDate1") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate1) throws IOException, ParseException {
			User user = userService.findBySSO(getPrincipal());
			Debit debit = new Debit();
			model.addAttribute("user", user);
			model.addAttribute("debit", debit);
			
			List<Debit> debits = debitService.findAllDebitsByPeriod(ownerID, startDate1, endDate1);
			List<Contragent> contragents = contragentService.findAllContragents(new Long(ownerID));
			model.addAttribute("contragents", contragents);
			List<Act> acts = actService.findAllActsByOwner(ownerID);
			model.addAttribute("acts", acts);
			model.addAttribute("debits", debits);
			model.addAttribute("ownerID", ownerID);
			model.addAttribute("loggedinuser", getPrincipal());
			String excelFilePath = "/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms"+user.getPath1();
			CreateExcel createExcel = new CreateExcel();
			createExcel.writeExcel2(debits, contragents, acts, excelFilePath);
			model.addAttribute("success",
					"Файл успешно сохранен.");
		    return "fileSaved";
		    }
	
	
}