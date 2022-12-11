import {setMinBetEventListeners} from "./common";

setEventListeners();

function setEventListeners() {
    setMinBetEventListeners();
    setSubmitEventListeners();
}

function setSubmitEventListeners() {
    const submitButton = document.querySelector('.place-bet-button');
    const betPrice = document.getElementById('betPrice');
    const auctionStep = document.getElementById('auction-step');
    let newMinBet = auctionStep.value;
    betPrice.setAttribute('min', newMinBet);
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        if (validateAllInputs()) {
            const form = document.querySelector('.lot-place-bet-form');
            form.submit();
        }
    });
}


function validateAllInputs() {
    const step = document.querySelector('.auction-step').value;
    const newCurrentBet = document.querySelector('.bet-field').value;

    if (newCurrentBet > step) {
        return true;
    }

    if (!(newCurrentBet > step)) {
        document.querySelector('.error-new-bet').classList.remove('hidden');
    }
    else {
        document.querySelector('.error-new-bet').classList.add('hidden');
    }

    return false;
}