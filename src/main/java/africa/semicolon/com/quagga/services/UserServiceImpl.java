package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.*;
import africa.semicolon.com.quagga.data.repositories.OtpRepository;
import africa.semicolon.com.quagga.data.repositories.UserRepository;
import africa.semicolon.com.quagga.dtos.request.*;
import africa.semicolon.com.quagga.dtos.response.*;
import africa.semicolon.com.quagga.exceptions.*;
import africa.semicolon.com.quagga.utils.JwtUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ClientService clientService;
    private final SpecialistService specialistService;
    private final SupplierService supplierService;
    private final ProfessionalService professionalService;
    private final AdminService adminService;
    private final EmailService emailService;
    private final OtpRepository otpRepository;
//    private final TokenService tokenService;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        String email = request.getEmail().toLowerCase();
        validate(email);
        validateRegistration(request);
        User newUser = modelMapper.map(request, User.class);
        User savedUser = userRepository.save(newUser);

        switch (savedUser.getRole()) {
            case SPECIALIST -> specialistService.createSpecialist(savedUser, request);
            case ADMIN -> adminService.createAdmin(savedUser, request);
            case CLIENT -> clientService.createClient(savedUser);
            case SUPPLIER -> supplierService.createSupplier(savedUser, request);
            case PROFESSIONAL -> professionalService.createProfessional(savedUser);
        }
        RegisterResponse response = modelMapper.map(savedUser, RegisterResponse.class);
        response.setMessage("Registration successful");
        response.setUser(savedUser);
        return response;
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User does not exist"));
    }

    @Override
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()->new UserNotFoundException("User not found"));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllSpecialist() {
        List<User> userList = userRepository.findAll();
        List<User> specialists = new ArrayList<>();
        for (User user : userList) {
            if (user.getRole().equals(Role.SPECIALIST)){
                specialists.add(user);
            }
        }
        return specialists;
    }


    @Override
    public List<User> getAllSupplier() {
        List<User> userList = userRepository.findAll();
        List<User> suppliers = new ArrayList<>();
        for (User user : userList) {
            if (user.getRole().equals(Role.SUPPLIER)){
                suppliers.add(user);
            }
        }
        return suppliers;
    }


    @Override
    public UpdateClientResponse update(UpdateClientRequest updateClientRequest) {
        Client client = clientService.findById(updateClientRequest.getClientId());
        User user = getById(client.getUser().getId());
        if (updateClientRequest.getFirstName() != null){
            user.setFirstName(updateClientRequest.getFirstName());
        }
        if (updateClientRequest.getLastName() != null){
            user.setLastName(updateClientRequest.getLastName());
        }
        if (updateClientRequest.getAddress() != null){
            user.setAddress(updateClientRequest.getAddress());
        }
        if (updateClientRequest.getPhoneNumber() != null){
            user.setPhoneNumber(updateClientRequest.getPhoneNumber());
        }
        if (updateClientRequest.getPassword() != null){
            user.setPassword(updateClientRequest.getPassword());
        }
        userRepository.save(user);
        clientService.update(client);

        UpdateClientResponse response = new UpdateClientResponse();
        response.setMessage("Client updated successfully");
        return response;
    }

    @Override
    public DeleteUserResponse deleteById(long id) {
        User user = getById(id);
        switch (user.getRole()){
            case SPECIALIST -> specialistService.delete(id);
//            case ADMIN -> adminService.deleteById(id);
            case CLIENT -> clientService.deleteById(id);

//            case SUPPLIER -> supplierService.deleteById(id);
//            case PROFESSIONAL -> professionalService.deleteById(id);

        }
        userRepository.deleteById(id);
        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage(user.getRole() + " successfully deleted");
        return response;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User does not exist"));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        return checkLoginDetail(email, password);
    }

    private LoginResponse checkLoginDetail(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return loginResponseMapper(user);
            } else {
                throw new InvalidCredentialException("Invalid username or password");
            }
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }

    private LoginResponse loginResponseMapper(User user) {
        LoginResponse loginResponse = new LoginResponse();
        String accessToken = JwtUtils.generateAccessToken(user.getId());
        BeanUtils.copyProperties(user, loginResponse);
        loginResponse.setJwtToken(accessToken);
        loginResponse.setMessage("Login Successful");
        loginResponse.setRole(user.getRole().toString());
        return loginResponse;
    }

    @Override
    public Client findClientById(Long id) {
        return clientService.findById(id);
    }

    @Override
    public List<Client> findAllClient() {
        return clientService.findAll();
    }

    @Override
    public Specialist findSpecialistById(Long id) {
        return specialistService.findById(id);
    }

    @Override
    public List<Specialist> getAllSpecialists() {
        return specialistService.findAllSpecialist();
    }

    @Override
    public DeleteUserResponse deleteSpecialistById(Long id) {
        Specialist specialist = findSpecialistById(id);
        Long userId = specialist.getUser().getId();
        User user = findUserById(userId);
        specialistService.delete(id);
        userRepository.deleteById(user.getId());

        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("Specialist successfully deleted");
        return response;
    }

    @Override
    public DeleteUserResponse deleteClientById(long id) {
        Client client = clientService.findById(id);
        User user = findUserById(client.getUser().getId());
        clientService.deleteById(id);
        userRepository.deleteById(user.getId());

        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("Client successfully deleted");
        return response;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public LogoutResponse logout(LogoutRequest logoutRequest) {
        return null;
    }

    @Override
    public List<Specialist> findAllSpecialist() {
        List<Specialist> specialists = specialistService.findAllSpecialist();
        if (specialists.isEmpty()) throw new NoSpecialistFoundException("No special found");
        return specialists;
    }

    @Override
    public OtpResponse generateOtp(String email) {
        Random random = new Random();
        String number = "";
        for (int i = 0; i < 4; i++){
            number += random.nextInt(10);
        }

        Otp newOtp = new Otp();
        newOtp.setEmail(email);
        newOtp.setNumber(number);
        otpRepository.save(newOtp);

        emailService.sendEmail(email,"One Time Password", "Here is you otp ------> " + number);
        OtpResponse response = new OtpResponse();
        response.setMessage("Otp sent successfully");

        return response;
    }

    @Override
    public ForgetPasswordResponse changeForgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
        Otp otp = otpRepository.findByNumber(forgetPasswordRequest.getOtp());
        if (otp == null){
            throw new OtpNotFoundException("Invalid Otp");
        }
        Optional<User> user = userRepository.findByEmail(otp.getEmail());
        if (user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        User foundUser = user.get();
        foundUser.setPassword(forgetPasswordRequest.getNewPassword());
        userRepository.save(foundUser);
        otpRepository.delete(otp);
        ForgetPasswordResponse response = new ForgetPasswordResponse();
        response.setMessage("Password changed successfully");
        return response;
    }

    private void validate (String email){
            for (User user : userRepository.findAll()) {
                if (user.getEmail().equals(email.toLowerCase())) {
                    throw new UserAlreadyExistException("email already exist");
                }
            }
        }
        private static void validateRegistration (RegisterRequest request){
            if (!request.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
                throw new UserAlreadyExistException("Invalid Input");
            if (request.getPassword().isEmpty())
                throw new IncorrectPasswordException("Invalid Password provide a Password");
        }


    }


