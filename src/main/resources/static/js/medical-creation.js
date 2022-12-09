import {
    validateManufactureYear,
} from "./validation.js";

import {
    setMedicalManufactureYearEventListeners,
} from "./common.js";

setEventListeners();

function setEventListeners() {
    setMedicalManufactureYearEventListeners();
    setSubmitEventListeners();
}

function setSubmitEventListeners() {
    const submitButton = document.querySelector('.create-lot-button');
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        if (validateAllInputs()) {
            const form = document.querySelector('.create-lot-form');
            form.submit();
        }
    });
}

function validateAllInputs() {
    const medicalManufactureYear = document.querySelector('.medical-equipment-manufacture-year').value;

    const medicalManufactureYearValid = validateManufactureYear(medicalManufactureYear);

    if (medicalManufactureYearValid) {
        return true;
    }

    if (!medicalManufactureYearValid) {
        document.querySelector('.error-medical-manufacture-year').classList.remove('hidden');
    }
    else {
        document.querySelector('.error-medical-manufacture-year').classList.add('hidden');
    }

    return false;
}