import {setEmailEventListeners, setPasswordEventListeners} from "./common.js";
import {validateEmail, validatePassword} from "./validation.js";

setEventListeners();

function setEventListeners() {
    setEmailEventListeners();
    setPasswordEventListeners();
    setSubmitListeners();
}

function setSubmitListeners() {
    const submitButton = document.querySelector('.login-button');
    submitButton.addEventListener('click', (event) => {
        event.preventDefault();
        if (validateAllInputs()) {
            const form = document.querySelector('.log-form');
            form.submit();
        }
    });
}

function validateAllInputs() {
    const email = document.querySelector('.email-field').value;
    const password = document.querySelector('.password-field').value;

    const emailValid = validateEmail(email);
    const passwordValid = validatePassword(password);

    if (emailValid && passwordValid) {
        return true;
    }

    if (!emailValid) {
        document.querySelector('.error-email').classList.remove('hidden');
    } else {
        document.getElementById('emailInput').style.border = "2px solid red";
        document.querySelector('.error-email').classList.add('hidden');

    }
    if (!passwordValid) {
        document.querySelector('.error-password').classList.remove('hidden');
    } else {
        document.getElementById('passwordInput').style.border = "2px solid red";
        document.querySelector('.error-password').classList.add('hidden');

    }
    return false;
}