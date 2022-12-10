import {validateCarEngineVolume, validateManufactureYear,} from "./validation.js";

import {setCarEngineVolumeEventListeners, setCarManufactureYearEventListeners} from "./common.js";

setEventListeners();

function setEventListeners() {
    setCarEngineVolumeEventListeners();
    setCarManufactureYearEventListeners();
    setSubmitCreationEventListeners();
}

function setSubmitCreationEventListeners() {
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
    const carEngineVolume = document.querySelector('.car_engine_volume').value;
    const carManufactureYear = document.querySelector('.car_manufacture_year').value;

    const carEngineVolumeValid = validateCarEngineVolume(carEngineVolume);
    const carManufactureYearValid = validateManufactureYear(carManufactureYear);

    if (carEngineVolumeValid && carManufactureYearValid) {
        return true;
    }

    if (!carEngineVolumeValid) {
        document.querySelector('.error-car-engine-volume').classList.remove('hidden');
    } else {
        document.querySelector('.error-car-engine-volume').classList.add('hidden');
    }

    if (!carManufactureYearValid) {
        document.querySelector('.error-car-manufacture-year').classList.remove('hidden');
    } else {
        document.querySelector('.error-car-manufacture-year').classList.add('hidden');
    }

    return false;
}