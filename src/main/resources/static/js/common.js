import {validateEmail, validatePassport, validatePassword, validatePhoneNumber} from "./validation.js";

export function setEmailEventListeners() {
    const emailInput = document.querySelector('.email-field');
    const emailError = document.querySelector('.error-email');
    emailInput.addEventListener('input', function (event) {
        const email = event.target.value;
        if (!validateEmail(email)) {
            emailError.classList.remove('hidden');

        } else {
            emailError.classList.add('hidden');
        }
    });
}

export function setPasswordEventListeners() {
    const passwordInput = document.querySelector('.password-field');
    const passwordError = document.querySelector('.error-password');
    passwordInput.addEventListener('input', function (event) {
        const password = event.target.value;
        if (password === '') {
            passwordError.classList.remove('hidden');
            return;
        }
        if (!validatePassword(password)) {
            passwordError.classList.remove('hidden');
        } else {
            passwordError.classList.add('hidden');
        }
    });
}

export function setPhoneNumberEventListeners() {
    const phoneNumberInput = document.querySelector('.phone-number-field');
    const phoneNumberError = document.querySelector('.error-signup-phone');
    phoneNumberInput.addEventListener('input', function (event) {
        const phoneNumber = event.target.value;
        if (!validatePhoneNumber(phoneNumber)) {
            phoneNumberError.classList.remove('hidden');
        } else {
            phoneNumberError.classList.add('hidden');
        }
    });
}

export function setPassportEventListeners() {
    const passportInput = document.querySelector('.passport-id-field');
    const passportError = document.querySelector('.error-signup-passport');
    passportInput.addEventListener('input', function (event) {
        const passport = event.target.value;
        if (!validatePassport(passport)) {
            passportError.classList.remove('hidden');
        } else {
            passportError.classList.add('hidden');
        }
    });
}