import {
    validateCarEngineVolume,
    validateEmail,
    validateManufactureYear,
    validatePassport,
    validatePassword,
    validatePhoneNumber
} from "./validation.js";

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

export function setCarEngineVolumeEventListeners() {
    const carEngineVolumeInput = document.querySelector('.car_engine_volume');
    const carEngineVolumeError = document.querySelector('.error-car-engine-volume');
    carEngineVolumeInput.addEventListener('input', function (event) {
        const carEngineVolume = event.target.value;
        if (!validateCarEngineVolume(carEngineVolume)) {
            carEngineVolumeError.classList.remove('hidden');
        } else {
            carEngineVolumeError.classList.add('hidden');
        }
    });
}

export function setCarManufactureYearEventListeners() {
    const carManufactureYearInput = document.querySelector('.car_manufacture_year');
    const carManufactureYearError = document.querySelector('.error-car-manufacture-year');
    carManufactureYearInput.addEventListener('input', function (event) {
        const carManufactureYear = event.target.value;
        if (!validateManufactureYear(carManufactureYear)) {
            carManufactureYearError.classList.remove('hidden');
        } else {
            carManufactureYearError.classList.add('hidden');
        }
    });
}

export function setMedicalManufactureYearEventListeners() {
    const medicalManufactureYearInput = document.querySelector('.medical-equipment-manufacture-year');
    const medicalManufactureYearError = document.querySelector('.error-medical-manufacture-year');
    medicalManufactureYearInput.addEventListener('input', function (event) {
        const medicalManufactureYear = event.target.value;
        if (!validateManufactureYear(medicalManufactureYear)) {
            medicalManufactureYearError.classList.remove('hidden');
        } else {
            medicalManufactureYearError.classList.add('hidden');
        }
    });
}

export function setRoomAmountEventListeners() {
    const roomAmountInput = document.querySelector('.room-amount');
    const roomAmountError = document.querySelector('.error-room-amount');

    roomAmountInput.addEventListener('input', function (event) {
        const roomAmount = event.target.value;
        if (!(roomAmount <= 12)) {
            roomAmountError.classList.remove('hidden');
        } else {
            roomAmountError.classList.add('hidden');
        }
    });
}

export function setLivingSpaceEventListeners() {
    const livingSpaceInput = document.querySelector('.living-space');
    const livingSpaceError = document.querySelector('.error-living-space');
    livingSpaceInput.addEventListener('input', function (event) {
        const livingSpace = event.target.value;
        if (!(livingSpace <= 15000)) {
            livingSpaceError.classList.remove('hidden');
        } else {
            livingSpaceError.classList.add('hidden');
        }
    });
}