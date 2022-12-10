import {setLivingSpaceEventListeners, setRoomAmountEventListeners,} from "./common.js";

setEventListeners();

function setEventListeners() {
    setRoomAmountEventListeners();
    setLivingSpaceEventListeners();
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
    const roomAmount = document.querySelector('.room-amount').value;
    const livingSpace = document.querySelector('.living-space').value;

    const roomAmountValid = (roomAmount <= 12);
    const livingSpaceValid = (livingSpace <= 15000);

    if (roomAmountValid && livingSpaceValid) {
        return true;
    }

    if (!roomAmountValid) {
        document.querySelector('.error-room-amount').classList.remove('hidden');
    } else {
        document.querySelector('.error-room-amount').classList.add('hidden');
    }

    if (!livingSpaceValid) {
        document.querySelector('.error-living-space').classList.remove('hidden');
    } else {
        document.querySelector('.error-living-space').classList.add('hidden');
    }

    return false;
}