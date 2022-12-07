import {validateEmail, validatePassport, validatePassword, validatePhoneNumber} from "./validation.js";
import {
    setEmailEventListeners,
    setPassportEventListeners,
    setPasswordEventListeners,
    setPhoneNumberEventListeners
} from "./common.js";

setEventListeners();

function setEventListeners() {
    setEmailEventListeners();
    setPasswordEventListeners();
    setPhoneNumberEventListeners();
    setPassportEventListeners();
    setSubmitEventListeners();
}

function setSubmitEventListeners() {
    const submitButton = document.querySelector('.signup-button');
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        if (validateAllInputs()) {
            const form = document.querySelector('.sign-form');
            form.submit();
        }
    });
}

function validateAllInputs() {
    const email = document.querySelector('.email-field').value;
    const password = document.querySelector('.password-field').value;
    const phoneNumber = document.querySelector('.phone-number-field').value;
    const passport = document.querySelector('.passport-id-field').value;

    const emailValid = validateEmail(email);
    const passwordValid = validatePassword(password);
    const phoneNumberValid = validatePhoneNumber(phoneNumber);
    const passportValid = validatePassport(passport);


    if (emailValid && passwordValid && phoneNumberValid && passportValid) {
        return true;
    }

    if (!emailValid) {
        document.querySelector('.error-email').classList.remove('hidden');
    }
    else {
        document.querySelector('.error-email').classList.add('hidden');
    }

    if (!passwordValid) {
        document.querySelector('.error-password').classList.remove('hidden');
    }
    else {
        document.querySelector('.error-password').classList.add('hidden');
    }

    if (!phoneNumberValid) {
        document.querySelector('.error-signup-phone').classList.remove('hidden');
    }
    else {
        document.querySelector('.error-signup-phone').classList.add('hidden');
    }

    if (!passportValid) {
        document.querySelector('.error-signup-passport').classList.remove('hidden');
    }
    else {
        document.querySelector('.error-signup-passport').classList.add('hidden');
    }
    return false;
}